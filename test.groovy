// @Grapes(
//     @Grab(group='io.github.dphiggs01', module='gldataframe', version='0.1.0')
// )

import io.github.dphiggs01.gldataframe.GLDataframe

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



