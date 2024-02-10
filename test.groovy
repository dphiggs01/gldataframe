// @Grapes(
//     @Grab(group='io.github.dphiggs01', module='gldataframe', version='0.1.0')
// )

import io.github.dphiggs01.gldataframe.GLDataframe
import io.github.dphiggs01.gldataframe.utils.GLLogger


//def dataframe = new GLDataframe(data: [[1, 2, 3], [4, 5, 6]])
//def dataframe = new GLDataframe([],[1,2,3])
//def dataframe = new GLDataframe([[true, 1, 2.2,"test"]], [1, 2, 3,4])
//def dataframe = new GLDataframe([[true, 1, 2.2,"test"]], [])

// def dataframe = GLDataframe.readCSV("src/test/resources/has_data.csv")
// dataframe = dataframe.colStats()
// println(dataframe)
// println(dataframe.isEmpty())

/**
GLDataframe chart_mean_488 = GLDataframe.readCSV("Chart_Mean_3d_OC_488.csv")
//println(chart_mean_488)
def title = "Mean 488"
def closureAddTitle = {title}
chart_mean_488 = chart_mean_488.addCol('chart', closureAddTitle)
//println(chart_mean_488)
def GLDataframe wormBarChartStats = new GLDataframe([],['name', 'mean', 'stdDev', 'chart'])
wormBarChartStats = wormBarChartStats.concat(chart_mean_488)
wormBarChartStats = wormBarChartStats.concat(chart_mean_488)
println(wormBarChartStats)
*/

def logger = GLLogger.getLogger()
println(logger.getLevel())
logger.log("Test1")
logger.log("Test2")
logger
def dataframe = new GLDataframe()
print(dataframe.isEmpty()) //True