package com.example.gceolmcq.activities

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.AssertReader
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.HomeRecyclerViewAdapter
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.fragments.ActivateTrialPackageFragment
import com.example.gceolmcq.fragments.HomeFragment
import com.example.gceolmcq.fragments.RequestToPayDialogFragment
import com.example.gceolmcq.fragments.SubscriptionFormDialogFragment
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.MainActivityViewModel
import kotlinx.coroutines.*
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : SubscriptionActivity(),
    HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener,
    HomeFragment.OnPackageActivatedListener,
    ActivateTrialPackageFragment.OnSubjectsPackagesAvailableListener,
    HomeRecyclerViewAdapter.OnActivateTrialButtonClickListener
{

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var header: LinearLayout

    private var currentFragmentIndex: Int? = null
    private lateinit var pref: SharedPreferences

//    private lateinit var activatingTrialPackageDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences("Main", MODE_PRIVATE)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        setupViewModel()
        initViews()
//        syncSubjectsPackages()
    }

    private fun areSubjectsPackagesAvailable(): Boolean {
        return pref.getBoolean(MCQConstants.AVAILABLE, false)
    }

    private fun saveSubjectsPackagesAvailabilityState(state: Boolean) {
        val editor = pref.edit()
        editor.apply {
            putBoolean(MCQConstants.AVAILABLE, state)
        }.apply()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
//        viewModel.setSubjectAndFileNameDataListModel(getJsonFromAssets())
        viewModel.setSubjectAndFileNameDataListModel(AssertReader.getJsonFromAssets(this, MCQConstants.SUBJECT_FILE_DATA_NAME))
//
    }

    private fun initViews() {
        header = findViewById(R.id.header)
    }

    private fun gotoHomeFragment() {
        title = resources.getString(R.string.app_name)
        val homeFragment = HomeFragment.newInstance()
        replaceFragment(homeFragment, 1)
    }

    private fun gotoActivateTrialPackageFragment() {
        val subjects = viewModel.liveSubjectsAvailable.value!!
        val activateTrialFragment =
            ActivateTrialPackageFragment.newInstance(subjects, getMobileID())
        replaceFragment(activateTrialFragment, 0)
    }

    private fun replaceFragment(fragment: Fragment, currentFragmentIndex: Int) {
        this.currentFragmentIndex = currentFragmentIndex
        val transaction = supportFragmentManager.beginTransaction()

        transaction.apply {
            replace(R.id.mainActivityFragmentHolder, fragment)
            commit()
        }
    }

    private fun displayView() {
//        if (!areSubjectsPackagesAvailable()) {
//            gotoActivateTrialPackageFragment()
//        } else {
//            gotoHomeFragment()
//
//        }
        gotoHomeFragment()
    }


    private fun gotoSubjectContentTableActivity(position: Int) {
        val intent = Intent(this, SubjectContentTableActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(
            "subject_and_file_name_data",
            viewModel.getSubjectAndFileNameDataAt(position)

        )
        intent.apply {
            putExtra("subject_and_file_name_bundle", bundle)
            putExtra(MCQConstants.SUBJECT_INDEX, position)

        }
        startActivity(intent)
    }

    private fun shareApp() {
//        val uri = Uri.parse(APP_URL)
        val appMsg = "Check out this awesome GCE OL MCQs app. Link: ${MCQConstants.APP_URL}"
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = MCQConstants.TYPE
        intent.putExtra(Intent.EXTRA_TEXT, appMsg)
        startActivity(intent)
    }

    private fun rateUs() {
        val uri = Uri.parse(MCQConstants.APP_URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(MCQConstants.APP_URL)))
        }
    }

    private fun privacyPolicy() {
        val uri = Uri.parse(MCQConstants.PRIVACY_POLICY)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(MCQConstants.PRIVACY_POLICY)))
        }
    }


    override fun onResume() {
        super.onResume()
        displayView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.share -> {
//                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
//                shareApp()
            }
            R.id.rateUs -> {
//                rateUs()
            }

            R.id.privacyPolicy -> {
                privacyPolicy()
            }
            R.id.about -> {
//                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
        showExitDialog()

    }

    override fun onSubjectItemClicked(position: Int, isPackageActive: Boolean?, packageName: String?) {
        if(packageName == MCQConstants.NA){
            Toast.makeText(this, "Please activate your Trial Package", Toast.LENGTH_LONG).show()
        }else{
            isPackageActive?.let{
                if (it) {
                    gotoSubjectContentTableActivity(position)

                } else {
                    val alertDialog = AlertDialog.Builder(this)
                    alertDialog.apply {
                        setMessage(resources.getString(R.string.package_expired_message))
                        setPositiveButton("Ok") { _, _ ->

                        }
                    }.create().show()
                }
            }

        }

    }

    override fun onSubscribeButtonClicked(position: Int, subjectPackageData: SubjectPackageData) {
        setSubjectPackageDataToActivate(position, subjectPackageData)
    }

    override fun onPackageActivated(): LiveData<Int> {
        return getActivatedPackageIndex()
    }

    override fun onSubjectsPackagesAvailable(isAvailable: Boolean) {
//        println("is available $isAvailable")
        dismissActivatingTrialPackageDialog()
        saveSubjectsPackagesAvailabilityState(isAvailable)
        displayView()

    }
    private fun showExitDialog() {
        val dialogExit = AlertDialog.Builder(this)
        dialogExit.apply {
            setMessage(resources.getString(R.string.exit_message))
            setNegativeButton(resources.getString(R.string.cancel)) { p, _ ->
                p.dismiss()
            }
            setPositiveButton(resources.getString(R.string.exit)) { _, _ ->
                this@MainActivity.finish()
            }
            setCancelable(false)
        }.create().show()
    }

    override fun onActivateTrialButtonClicked(position: Int, subjectName: String) {
        showActivatingTrialPackageDialog()
        activateTrialPackage(position, subjectName)
    }


}
