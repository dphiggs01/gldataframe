
package io.github.dphiggs01.gldataframe

import spock.lang.Specification
import io.github.dphiggs01.gldataframe.GLDataframe

class GLDataframeTest extends Specification {

    // def "GLDataframe constructor should throw GLDataframeException for invalid data passed in"() {
    //     given:
    //     def invalidColHeader = null
    //     def validColHeader = ['A','B','C']
    //     def validData = [[1, 2, 3]]
    //     def invalidData = [[1, 2, 3], [4, 5]] // Invalid data with mismatched columns

    //     when:
    //     // Trying to create GLDataframe with null or empty column headers
    //     test = new GLDataframe(validData, invalidColHeader)
        
    //     then:
    //     def e = thrown(GLDataframeException)
    //     e.message == "Column headers cannot be null or empty."
                
    //     when:
    //     // Trying to create GLDataframe with data having mismatched columns
    //     test = new GLDataframe(invalidData, validColHeader)
        
    //     then:
    //     // GLDataframeException should be thrown
    //     e = thrown(GLDataframeException)
    //     e.message ==  "Invalid data format. Must be a List<List<Object>> with Apporpriate Datatypes and inner row size must align with colHeader size."
    // }

    // def "GLDataframe.readCSV should be able to load any correctly formated CSV file"(){
    //     given:
    //     println "Current Working Directory: ${System.getProperty('user.dir')}"
    //     def headerOnly = "./src/test/resources/header_only.csv"
    //     def hasData = "./src/test/resources/has_data.csv"

    //     when:
    //     def dataframe = GLDataframe.readCSV(headerOnly)

    //     then:
    //     dataframe.isEmpty()

    //     when:
    //     dataframe = GLDataframe.readCSV(hasData)

    //     then:
    //     !dataframe.isEmpty()
        
    // }

    // def "isEmpty should return true for an empty dataframe false if it has data"() {

    //     when:
    //     def dataframe = new GLDataframe()

    //     then:
    //     dataframe.isEmpty() //True

    //     when:
    //     dataframe = new GLDataframe([[null, null, null]], [1, 2, 3])

    //     then:
    //     dataframe.isEmpty() //True

    //     when:
    //     dataframe = new GLDataframe([[1, 2, 3]], [4, 5, 6])

    //     then:
    //     !dataframe.isEmpty() //False
    // }

}