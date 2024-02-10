#!/bin/bash
VERSION=`cat ./build.gradle |grep version|grep =|grep -v project`
VERSION="${VERSION#*\'}"  # Remove everything before the first single quote
VERSION="${VERSION%\'*}"  # Remove everything after the last single quote
echo "$VERSION"

PRJ_HOME="/Users/dan/Code/groovy/gldataframe"
BIULD_LIBS="${PRJ_HOME}/build/libs"
BIULD_EXT="${PRJ_HOME}/build/publications/mavenJava"

PUBLISH_DIR="${PRJ_HOME}/publish"
ARTIFACTS_DIR="${PUBLISH_DIR}/io/github/dphiggs01/gldataframe/${VERSION}/"

generate_md5_files() {
    local directory_path="$1"

    # Change to the specified directory
    cd "$directory_path" || return 1

    # Iterate through each file in the directory
    for file in *; do
        # Check if the item is a file (not a directory) and has a .pom or .jar extension
        if [ -f "$file" ] && ( [[ "$file" == *.pom ]] || [[ "$file" == *.jar ]] ); then
            # Generate the MD5 checksum and save it to a file with the same name and .md5 extension
            md5 -q "$file" > "$file.md5"
            hash_value=$(shasum "$file"|awk '{print $1}') 
            echo ${hash_value} > "$file.sha1"
            echo "MD5 file created for $file"
        fi
    done
}

zip_content() {
    local directory_path="$1"
    local output_zip="$2"

    # Check if both parameters are provided
    if [ -z "$directory_path" ] || [ -z "$output_zip" ]; then
        echo "Usage: zip_content <directory_path> <output_zip>"
        return 1
    fi

    # Navigate to the parent directory
    cd "$(dirname "$directory_path")" || exit 1

    # Zip the directory and its contents
    zip -r "$output_zip" "$(basename "$directory_path")"
}


find . -name .DS_Store -exec rm {} \;

# Delete any files if they already exist the the publish dir
rm -rf ${PUBLISH_DIR}/*
mkdir -p ${ARTIFACTS_DIR}

# Copy the files to be published
cp ${BIULD_LIBS}/* ${ARTIFACTS_DIR}
cp ${BIULD_EXT}/pom-default.xml  ${ARTIFACTS_DIR}/gldataframe-${VERSION}.pom
cp ${BIULD_EXT}/pom-default.xml.asc  ${ARTIFACTS_DIR}/gldataframe-${VERSION}.pom.asc

# Get MD5 for the files to be published
generate_md5_files  ${ARTIFACTS_DIR}

zip_content "${PUBLISH_DIR}/io" "gldataframe.zip"

