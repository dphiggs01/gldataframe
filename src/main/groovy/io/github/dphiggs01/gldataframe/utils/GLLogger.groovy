package io.github.dphiggs01.gldataframe.utils

import java.util.concurrent.ConcurrentHashMap

///************************************************************************************************************
// *  GLLogger - Simple Logger Class
// */
class GLLogger {
   private static final Map<String, GLLogger> instanceMap = new ConcurrentHashMap<>()

   private String loggerName
   private File logFile

   private GLLogger(String directoryRoot, String loggerName) {
		def timestamp = new Date().format('yyyy-MM-dd_HH-mm-ss')
       def logFileNm = directoryRoot + "/"+loggerName+"-" + timestamp + ".txt"
       this.loggerName = loggerName
       this.logFile = new File(logFileNm)

   }

   static GLLogger getLogger(String directoryRoot, String loggerName = "log") {
       String key = "${loggerName}"
       instanceMap.computeIfAbsent(key) { new GLLogger(directoryRoot, loggerName) }
   }

   void log(String message) {
       logFile << "$message\n"
   }
   
   void log(String step, String message) {
   	def logStep = "Step: $step ".padRight(32, ' ')
       logFile << "$logStep | $message\n"
   }
   
   void logDuration(Date startTime, Date endTime) {
	    
	    def long durationInMillis = endTime.time - startTime.time
	    def long durationInSeconds = durationInMillis / 1000
	
	    def hours = (durationInSeconds / 3600).toInteger()
	    def minutes = ((durationInSeconds % 3600) / 60).toInteger()
	    def seconds = (durationInSeconds % 60).toInteger()
	    def duration = String.format('%02d:%02d:%02d', hours, minutes, seconds)
	    log("Finished at: "+endTime.format('yyyy-MM-dd_HH:mm:ss')+" | Duration: "+duration) 
	}
}



