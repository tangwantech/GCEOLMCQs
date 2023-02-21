package com.example.gceolmcq.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.SubjectContentTableViewPagerAdapter
import com.example.gceolmcq.datamodels.StatisticsData
import com.example.gceolmcq.datamodels.SubjectAndFileNameData
import com.example.gceolmcq.fragments.SubjectStatisticsTabContentFragment
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.SubjectStatisticsTabActivityViewModel
import com.google.android.material.tabs.TabLayout
import java.io.IOException
import java.nio.charset.Charset

class SubjectStatisticsTabActivity : AppCompatActivity(),
    SubjectStatisticsTabContentFragment.OnRecyclerItemClickListener {
    private lateinit var subjectStatisticsTabActivityViewModel: SubjectStatisticsTabActivityViewModel
    private var subjectTitle: String? = null
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var dialogTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_statistics_tab)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val subjectAndFileNameData = intent.getBundleExtra("bundle")!!
            .getSerializable("subject_and_file_name_data")!! as SubjectAndFileNameData

        subjectTitle = subjectAndFileNameData.subject

        subjectStatisticsTabActivityViewModel =
            ViewModelProvider(this)[SubjectStatisticsTabActivityViewModel::class.java]

        subjectStatisticsTabActivityViewModel.setDataBase(GceOLMcqDatabase.getDatabase(this))

        getJsonFromAssets(subjectAndFileNameData.fileName)?.let {
            subjectStatisticsTabActivityViewModel.initSubjectContentsData(it)
        }

        setUpSubjectContentTab()

        subjectStatisticsTabActivityViewModel.getStatisticsData().observe(this, Observer {

            if(it == null){
                Toast.makeText(this, resources.getString(R.string.no_data_message), Toast.LENGTH_LONG).show()
            }else{
                gotoStatisticsDataViewActivity(it)

            }
        })
    }

    private fun gotoStatisticsDataViewActivity(statisticsData: StatisticsData){
        val intent = Intent(this, StatisticDataViewActivity::class.java)
        intent.putExtra("statisticsData", statisticsData)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        title = "$subjectTitle Statistics"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {

                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        this.finish()

    }


    private fun setUpSubjectContentTab() {

        tab = findViewById(R.id.homeTab)
        viewPager = findViewById(R.id.homeViewPager)

        val tabFragments: ArrayList<Fragment> = ArrayList()


        for (fragmentIndex in 0 until subjectStatisticsTabActivityViewModel.getExamTypesCount()) {
            val fragment =
                SubjectStatisticsTabContentFragment.newInstance(
                    subjectStatisticsTabActivityViewModel.getExamTypeDataAt(
                        fragmentIndex
                    )
                )
            tabFragments.add(fragment)
        }

        val viewPagerAdapter = SubjectContentTableViewPagerAdapter(
            this.supportFragmentManager,
            tabFragments,
            subjectStatisticsTabActivityViewModel.getExamTitles()
        )
        viewPager.adapter = viewPagerAdapter
//
        tab.setupWithViewPager(viewPager)
    }

    private fun getJsonFromAssets(fileName: String): String? {
        lateinit var json: String
        val charset: Charset = Charsets.UTF_8

        try {
            val jsonFile = assets.open(fileName)
            val size = jsonFile.available()
            val buffer = ByteArray(size)

            jsonFile.read(buffer)
            jsonFile.close()
            json = String(buffer, charset)

        } catch (e: IOException) {
//            println("Exception")
            return null
        }
        return json
    }

    override fun onRecyclerItemClicked(value: String) {
        dialogTitle = value
        val customId = "$subjectTitle $value"
        subjectStatisticsTabActivityViewModel.queryStatisticsDataTableByCustomId(customId)
    }


}