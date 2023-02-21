package com.example.gceolmcq.viewmodels

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.StatisticsData
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlin.math.roundToInt

class StatisticsDataViewModel: ViewModel() {
    private var statisticsData: StatisticsData? = null
    var scores = ArrayList<Int>()
    val test  = ArrayList<Int>()
    private val barEntries = ArrayList<BarEntry>()
    private lateinit var barDataSet: BarDataSet
    private val barDataSetLiveData = MutableLiveData<BarDataSet>()
    private val _barLegend = MutableLiveData<String>()
    val barLegend: LiveData<String> = _barLegend

    fun setStatisticsData(statisticsData: StatisticsData){
        this.statisticsData = statisticsData
        if(scores.isEmpty()){
            this.statisticsData?.scores!!.forEach {
                scores.add(it.score)
            }
        }

    }



    fun getTitle(): String{
        return statisticsData?.customId!![0] + (statisticsData?.customId!!.substring(1, statisticsData?.customId!!.length)).lowercase()
    }

    fun getLowestScore(): Int{
        return scores.min()
    }

    fun getHighestScore(): Int{
//        println("Highest score: ${scores.max()}")
        return scores.max()
    }

    fun getAverageScore(): Int{
        return scores.average().roundToInt()
    }

    fun getLastScore(): Int{
        return scores.last()
    }

    fun getAttempts(): Int{
        return statisticsData?.attemptsCount!!
    }

    fun getGrade(context: Context, score: Int): Bundle{
        val bundle = Bundle()
        when(score * 2){
            in 75..100 -> {
                bundle.putString("grade", "A")
                bundle.putInt("gradeColor", context.resources.getColor(R.color.correct_answer))
            }
            in 65..74 -> {
                bundle.putString("grade", "B")
                bundle.putInt("gradeColor", context.resources.getColor(R.color.correct_answer))
            }
            in 50.. 64 -> {
                bundle.putString("grade", "C")
                bundle.putInt("gradeColor", context.resources.getColor(R.color.correct_answer))
            }
            in 40..49 -> {
                bundle.putString("grade", "D")
                bundle.putInt("gradeColor", context.resources.getColor(R.color.wrong_answer))
            }
            in 30..39 -> {
                bundle.putString("grade", "E")
                bundle.putInt("gradeColor", context.resources.getColor(R.color.wrong_answer))
            }
            else->{
                bundle.putString("grade", "U")
                bundle.putInt("gradeColor", context.resources.getColor(R.color.wrong_answer))
            }
        }
        return bundle
    }

    fun getBarDataSetLiveData(): LiveData<BarDataSet>{
        return barDataSetLiveData
    }

    fun getBarData(context: Context): BarData{
        val label = "${getTitle()}: Score Vs Attempt barchart"
        _barLegend.value = label
        barDataSet = BarDataSet(getBarEntries(), label)
//        barDataSet.valueTextSize = 16f
        barDataSet.colors = getBarColors(context)
        barDataSetLiveData.value = barDataSet
        return BarData(barDataSet)
    }

    private fun getBarEntries(): ArrayList<BarEntry>{
        val barEntries = ArrayList<BarEntry>()
        scores.forEachIndexed { index, score ->
            barEntries.add(BarEntry((index + 1).toFloat(), score.toFloat()))
        }
        return barEntries
    }

    private fun getBarColors(context: Context): ArrayList<Int>{
        val barColors = ArrayList<Int>()
        scores.forEachIndexed { _, score ->
            if(score >= 25){
               barColors.add(context.resources.getColor(R.color.correct_answer))
            }else{
                barColors.add(context.resources.getColor(R.color.wrong_answer))
            }
        }
        return barColors
    }

//    private fun getPieEntries(): ArrayList<PieEntry>{
//
//        val lastScorePieEntries = ArrayList<PieEntry>()
//        lastScorePieEntries.add(PieEntry(getLastScore().toFloat(), "Correct answers"))
//        lastScorePieEntries.add(PieEntry((statisticsData?.numberOfQuestions!! - getLastScore()).toFloat(), "Wrong answers"))
//
//        return lastScorePieEntries
//    }
//
//    private fun getPieColors(context: Context): ArrayList<Int>{
//        val pieColors = ArrayList<Int>()
//        pieColors.add(context.resources.getColor(R.color.correct_answer))
//        pieColors.add(context.resources.getColor(R.color.wrong_answer))
//        return pieColors
//    }
//
//    fun getPieData(context: Context):PieData {
//        pieDataSet = PieDataSet(getPieEntries(), "Last Performance pie chart")
//        pieDataSet.colors = getPieColors(context)
//        return PieData(pieDataSet)
//    }
}