package com.example.gceolmcq

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter

class BarChartStyle(private val context: Context, private val  barChart: BarChart) {
    fun styleBarChart() = barChart.apply{
        axisRight.isEnabled = false
        description.isEnabled = false
        legend.isEnabled = false
        xAxis.apply {
            axisMinimum = 0f
            isGranularityEnabled = true
            granularity = 1f
            setDrawGridLines(false)
            position = XAxis.XAxisPosition.BOTTOM
        }
        axisLeft.apply {
            axisMinimum = 0f
            axisMaximum = 50f
            isGranularityEnabled = true
            granularity = 1f

        }
    }

    fun styleBarDataSet(barDataSet: BarDataSet) = barDataSet.apply{
        valueTextSize = 12f
        valueFormatter = BarChartValueFormatter()
    }

    fun styleBarLegend(legend: TextView){
        legend.textSize = 10f
        legend.setTextColor(context.resources.getColor(R.color.black))
    }

    inner class BarChartValueFormatter: ValueFormatter(){
        override fun getFormattedValue(value: Float): String {

            return value.toInt().toString()
        }
    }

}