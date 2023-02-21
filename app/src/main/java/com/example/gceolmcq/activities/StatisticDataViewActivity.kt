package com.example.gceolmcq.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.BarChartStyle
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.StatisticsData
import com.example.gceolmcq.viewmodels.StatisticsDataViewModel
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarData

class StatisticDataViewActivity : AppCompatActivity() {
    private lateinit var statisticsDataViewModel: StatisticsDataViewModel
    private lateinit var tvLowestScore: TextView
    private lateinit var tvHighestScore: TextView
    private lateinit var tvAverageScore: TextView
    private lateinit var tvLastScore: TextView

    private lateinit var tvLowestGrade: TextView
    private lateinit var tvHighestGrade: TextView
    private lateinit var tvAverageGrade: TextView
    private lateinit var tvLastGrade: TextView

    private lateinit var tvAttemptsCount: TextView

    private lateinit var barChart: BarChart
    private lateinit var barChartStyle: BarChartStyle

    private lateinit var tvBarLegend: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic_data_view)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        statisticsDataViewModel = ViewModelProvider(this)[StatisticsDataViewModel::class.java]
        statisticsDataViewModel.setStatisticsData(intent.getSerializableExtra("statisticsData") as StatisticsData)

        title = statisticsDataViewModel.getTitle()
        initViews()

        setBarChart()
//        setPieChart()

        tvAttemptsCount.text = statisticsDataViewModel.getAttempts().toString()

        statisticsDataViewModel.getGrade(this, statisticsDataViewModel.getLowestScore()).apply {
            tvLowestScore.text = statisticsDataViewModel.getLowestScore().toString()
            tvLowestScore.setTextColor(getInt("gradeColor"))
            tvLowestGrade.text = getString("grade")
            tvLowestGrade.setTextColor(getInt("gradeColor"))
        }

        statisticsDataViewModel.getGrade(this, statisticsDataViewModel.getHighestScore()).apply {
            tvHighestScore.text = statisticsDataViewModel.getHighestScore().toString()
            tvHighestScore.setTextColor(getInt("gradeColor"))
            tvHighestGrade.text = getString("grade")
            tvHighestGrade.setTextColor(getInt("gradeColor"))
        }

        statisticsDataViewModel.getGrade(this, statisticsDataViewModel.getAverageScore()).apply {
            tvAverageScore.text = statisticsDataViewModel.getAverageScore().toString()
            tvAverageScore.setTextColor(getInt("gradeColor"))
            tvAverageGrade.text = getString("grade")
            tvAverageGrade.setTextColor(getInt("gradeColor"))
        }

        statisticsDataViewModel.getGrade(this, statisticsDataViewModel.getLastScore()).apply {
            tvLastScore.text = statisticsDataViewModel.getLastScore().toString()
            tvLastScore.setTextColor(getInt("gradeColor"))
            tvLastGrade.text = getString("grade")
            tvLastGrade.setTextColor(getInt("gradeColor"))
        }

    }

    private fun initViews(){


//        lastScorePerformancePieChart = findViewById(R.id.pieChart)

        tvAttemptsCount = findViewById(R.id.tvAttemptsCount)

        tvLowestScore = findViewById(R.id.tvLowestScore)
        tvHighestScore = findViewById(R.id.tvHighestScore)
        tvAverageScore = findViewById(R.id.tvAverageScore)
        tvLastScore = findViewById(R.id.tvLastScore)

        tvLowestGrade = findViewById(R.id.tvLowestGrade)
        tvHighestGrade = findViewById(R.id.tvHighestGrade)
        tvAverageGrade = findViewById(R.id.tvAverageGrade)
        tvLastGrade = findViewById(R.id.tvLastGrade)

    }

//    fun setPieChart(){
//       lastScorePerformancePieChart.data = statisticsDataViewModel.getPieData(this)
//        lastScorePerformancePieChart.invalidate()
//    }

    private fun setBarChart(){
        barChart = findViewById(R.id.barChart)
        tvBarLegend = findViewById(R.id.tvLegend)
        barChart.data = statisticsDataViewModel.getBarData(this)

        statisticsDataViewModel.barLegend.observe(this, Observer {
            tvBarLegend.text = it
        })
        barChartStyle = BarChartStyle(this, barChart)
        barChartStyle.styleBarChart()
        barChartStyle.styleBarLegend(tvBarLegend)
        statisticsDataViewModel.getBarDataSetLiveData().observe(this, Observer {
            barChartStyle.styleBarDataSet(it)
        })
        barChart.invalidate()
        barChart.animateY(1300)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
//                return true
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        this.finish()

    }
}