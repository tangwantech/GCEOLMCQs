package com.example.gceolmcq.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.SubjectContentTableViewPagerAdapter
import com.example.gceolmcq.datamodels.SubjectAndFileNameData
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.fragments.ExamTypeFragment
import com.example.gceolmcq.viewmodels.SubjectContentTableViewModel
import com.google.android.material.tabs.TabLayout
import java.io.IOException
import java.nio.charset.Charset

class SubjectContentTableActivity : AppCompatActivity(), ExamTypeFragment.OnPackageExpiredListener, ExamTypeFragment.OnContentAccessDeniedListener{

    private lateinit var subjectContentTableViewModel: SubjectContentTableViewModel
    private var subjectTitle: String? = null
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var alertDialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_content_table)

        setAlertDialog()
        initActivityViews()
        initViewModel()
        setupViewObservers()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
    private fun initActivityViews(){
        tab = findViewById(R.id.homeTab)
        viewPager = findViewById(R.id.homeViewPager)
    }

    private fun initViewModel(){
        val subjectAndFileNameData = intent.getBundleExtra("subject_and_file_name_bundle")!!
            .getSerializable("subject_and_file_name_data")!! as SubjectAndFileNameData

        subjectTitle = subjectAndFileNameData.subject

        subjectContentTableViewModel =
            ViewModelProvider(this)[SubjectContentTableViewModel::class.java]

        subjectContentTableViewModel.setSubjectName(subjectTitle!!)

        subjectContentTableViewModel.initDatabase(this)

        getJsonFromAssets(subjectAndFileNameData.fileName)?.let {
            subjectContentTableViewModel.initSubjectContentsData(it)
        }

    }

    private fun setupViewObservers(){
        subjectContentTableViewModel.getIsPackageActive().observe(this, Observer {
            if (!it) {
                showAlertDialog()
            }
        })

        subjectContentTableViewModel.subjectPackageData.observe(this, Observer{subjectPackageData ->
            setUpSubjectContentTab(subjectPackageData)
        })
    }

    private fun setAlertDialog(){
        alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setMessage(resources.getString(R.string.package_expired_message))
            setPositiveButton("Ok") { _, _ ->
                exitActivity()
            }
            setCancelable(false)
        }.create()
    }

    private fun showAlertDialog(){
        alertDialog.show()
    }

    private fun exitActivity() {
        this.finish()
    }

    private fun setUpSubjectContentTab(subjectPackageData: SubjectPackageData) {

        val tabFragments: ArrayList<Fragment> = ArrayList()

        for (fragmentIndex in 0 until subjectContentTableViewModel.getExamTypesCount()) {
            val fragment =
                ExamTypeFragment.newInstance(
                    subjectContentTableViewModel.getExamTypeDataAt(
                        fragmentIndex
                    ),
                    subjectTitle!!,
                    subjectPackageData.expiresOn!!,
                    subjectPackageData.packageName!!,

                )
            tabFragments.add(fragment)
        }

        val viewPagerAdapter = SubjectContentTableViewPagerAdapter(
            this.supportFragmentManager,
            tabFragments,
            subjectContentTableViewModel.getExamTitles()
        )
        viewPager.adapter = viewPagerAdapter
//
        tab.setupWithViewPager(viewPager)
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

    override fun onResume() {
        super.onResume()
        title = subjectTitle
        subjectContentTableViewModel.querySubjectPackageDataFromLocalDatabaseAtSubjectName(subjectTitle!!)

    }

    private fun getJsonFromAssets(fileName: String): String? {
        val charset: Charset = Charsets.UTF_8

        return try {
            val jsonFile = assets.open(fileName)
            val size = jsonFile.available()
            val buffer = ByteArray(size)

            jsonFile.read(buffer)
            jsonFile.close()
            String(buffer, charset)

        } catch (e: IOException) {
            null
        }
    }

    override fun onShowPackageExpired() {
        showAlertDialog()
    }

    override fun onCheckIfPackageHasExpired(): Boolean {
        return subjectContentTableViewModel.getPackageStatus()
    }

    override fun onContentAccessDenied() {
        val contentAccessDeniedDialog = AlertDialog.Builder(this)
        contentAccessDeniedDialog.apply {
            setMessage(resources.getString(R.string.content_access_denied_Message))
            setPositiveButton("Ok") { d, _->
                d.dismiss()
            }
        }.create().show()
    }

}

