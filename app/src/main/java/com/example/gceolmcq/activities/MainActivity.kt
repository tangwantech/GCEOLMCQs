package com.example.gceolmcq.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.HomeRecyclerViewAdapter
import com.example.gceolmcq.adapters.SubjectListFragmentRecyclerAdapter
import com.example.gceolmcq.datamodels.SubjectAndFileNameData
import com.example.gceolmcq.datamodels.SubscriptionFormDataModel
import com.example.gceolmcq.fragments.*
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.MainActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.*

private const val SUBJECT_NAMES = "subjectNames"
private const val INIT_DATA_BUNDLE = "initDataBundle"
private const val MOBILE_ID = "mobileID"
private const val SUBJECT_FILENAME_LIST = "subjectAndFileNameList"
private const val TYPE = "text/plain"
private const val APP_URL = "https://google.com"
private const val PRIVACY_POLICY = "https://gceolmcqs.w3spaces.com/Gceolmcqs_Privacy-Policy.pdf"

class MainActivity : AppCompatActivity(),
    SubscriptionFormDialogFragment.OnActivateButtonClickListener,
    RequestToPayDialogFragment.RequestToPayTransactionStatusListener,
//    SubjectListFragmentRecyclerAdapter.OnRecyclerViewItemClick,
    HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener,
//    HomeFragment.OnRequestSubjectPackageExpiryStatusDataListListener,
    HomeFragment.OnPackageActivatedListener
{

    private lateinit var mainActivityViewModel: MainActivityViewModel
//    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var header: LinearLayout

    private var currentFragmentIndex: Int? = null
    private lateinit var activatingPackageAlertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

        activatingPackageAlertDialog = AlertDialog.Builder(this).create()
        activatingPackageAlertDialog.apply {
            setMessage(resources.getString(R.string.be_patient))
            setCancelable(false)
        }

        setupViewModel()
        initViews()
        setupViewObservers()
//        setViewListeners()

//        gotoHomeFragment()
    }

    private fun setupViewModel(){
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityViewModel.initSubjectDataBase(GceOLMcqDatabase.getDatabase(this))
        mainActivityViewModel.initializeSubjectPackageDataFromLocalDb()

        val bundle = intent.getBundleExtra(INIT_DATA_BUNDLE)
        bundle.apply {
            this?.let {
                mainActivityViewModel.setMobileId(it.getString(MOBILE_ID)!!)
                mainActivityViewModel.setSubjectNameList(it.getStringArrayList(SUBJECT_NAMES)!!)

                mainActivityViewModel.setSubjectFileNameList(
                    it.getStringArrayList(
                        SUBJECT_FILENAME_LIST
                    )!!
                )

            }

        }
    }

    private fun initViews(){
        header = findViewById(R.id.header)
//        bottomNavView = findViewById(R.id.bottomNav)
    }

    private fun setupViewObservers(){
        mainActivityViewModel.activatedPackageIndex.observe(this, Observer{
            hideActivatingPackageActivatedDialog(it)
        })
    }

    private fun gotoHomeFragment(){
        title = resources.getString(R.string.app_name)
//        header.visibility = View.VISIBLE
        val homeFragment = HomeFragment.newInstance()
        replaceFragment(homeFragment, 0)
    }

    private fun replaceFragment(fragment: Fragment, currentFragmentIndex: Int){
        this.currentFragmentIndex = currentFragmentIndex
        val transaction = supportFragmentManager.beginTransaction()

        transaction.apply {
            replace(R.id.mainActivityFragmentHolder, fragment)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        mainActivityViewModel.initializeSubjectPackageDataFromLocalDb()
        gotoHomeFragment()

    }


    private fun gotoSubjectContentTableActivity(position: Int){
        val intent = Intent(this, SubjectContentTableActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(
            "subject_and_file_name_data",
            mainActivityViewModel.getSubjectAndFileNameDataAt(position)

        )
        intent.apply {
            putExtra("subject_and_file_name_bundle", bundle)

        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.share ->{
//                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
//                shareApp()
            }
            R.id.rateUs ->{
//                rateUs()
            }

            R.id.privacyPolicy ->{
                privacyPolicy()
            }
            R.id.about -> {
//                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareApp(){
//        val uri = Uri.parse(APP_URL)
        val appMsg = "Check out this awesome GCE OL MCQs app. Link: $APP_URL"
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = TYPE
        intent.putExtra(Intent.EXTRA_TEXT, appMsg)
        startActivity(intent)
    }

    private fun rateUs(){
        val uri = Uri.parse(APP_URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

        try{
            startActivity(intent)
        }catch (e: ActivityNotFoundException){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL)))
        }
    }

    private fun privacyPolicy(){
        val uri = Uri.parse(PRIVACY_POLICY)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

        try{
            startActivity(intent)
        }catch (e: ActivityNotFoundException){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(PRIVACY_POLICY)))
        }
    }

    private fun showExitDialog(){
        val dialogExit = AlertDialog.Builder(this)
        dialogExit.apply {
            setMessage(resources.getString(R.string.exit_message))
            setNegativeButton(resources.getString(R.string.cancel)){p, _ ->
                p.dismiss()
            }
            setPositiveButton("OK") { _, _ ->
                this@MainActivity.finish()
            }
            setCancelable(false)
        }.create().show()
    }

    override fun onBackPressed() {
        showExitDialog()

    }

    override fun onSubjectItemClicked(position: Int, isPackageActive: Boolean) {
        if (isPackageActive) {
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

    override fun onSubscribeButtonClicked(position: Int) {
        val subscriptionFormDialogFragment = SubscriptionFormDialogFragment.newInstance(
            position,
            mainActivityViewModel.getSubjectNameAt(position)
        )
        subscriptionFormDialogFragment.isCancelable = false
        subscriptionFormDialogFragment.show(supportFragmentManager, "subscription_form_dialog")
    }

    override fun onPackageDetailsButtonClicked(position: Int) {

        val subjectPackageDetailsDialogFragment = SubjectPackageDetailsDialogFragment.newInstance(
            mainActivityViewModel.getSubjectPackageDataAt(position)
        )
        subjectPackageDetailsDialogFragment.show(supportFragmentManager, "package_details_dialog")
    }

    override fun onActivateButtonClicked(subscriptionFormDataModel: SubscriptionFormDataModel) {

        val requestToPayDialogFragment =
            RequestToPayDialogFragment.newInstance(subscriptionFormDataModel)
        requestToPayDialogFragment.show(supportFragmentManager, "Request_to_pay")
    }


    override fun onTransactionSuccessful(
        subjectIndex: Int,
        packageType: String,
        packageDuration: Int
    ) {

        showPaymentReceivedDialog(subjectIndex, packageType, packageDuration)

    }

    override fun onTransactionFailed(packageType: String) {
        val alertDialog = AlertDialog.Builder(this)
        val view = this.layoutInflater.inflate(R.layout.package_activation_failed_dialog, null)
        val tvFailedMessage: TextView = view.findViewById(R.id.tvPackageActivationFailed)
        tvFailedMessage.text = "${resources.getString(R.string.failed_to_activate_package)} $packageType "
        alertDialog.apply {
            setView(view)
            setPositiveButton("Ok") { _, _ ->
            }
        }.create().show()
    }

    override fun onPackageActivated(): LiveData<Int> {
        return mainActivityViewModel.activatedPackageIndexChangedAt
    }

    private fun showPaymentReceivedDialog(subjectIndex: Int, packageType: String, packageDuration: Int){
        Toast.makeText(this, R.string.payment_received, Toast.LENGTH_LONG).show()

        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            withContext(Dispatchers.Main){
                activatingPackageAlertDialog.show()
                activatePackage(subjectIndex, packageType, packageDuration)
            }
        }

    }

    private fun activatePackage(subjectIndex: Int, packageType: String, packageDuration: Int){
        mainActivityViewModel.activatePackage(subjectIndex, packageType, packageDuration)
    }

    private fun hideActivatingPackageActivatedDialog(position: Int){
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            withContext(Dispatchers.Main){
                activatingPackageAlertDialog.hide()
                mainActivityViewModel.updateActivatedPackageIndexChangedAt(position)
                showPackageActivatedDialog(position)
            }

        }

    }

    private fun showPackageActivatedDialog(position: Int){
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        val view = this@MainActivity.layoutInflater.inflate(R.layout.package_activation_successful_dialog, null)
        val tvPackageActivationSuccessful: TextView =
            view.findViewById(R.id.tvPackageActivationSuccessful)
        tvPackageActivationSuccessful.text =
            "${mainActivityViewModel.getActivatedPackageName(position)} ${resources.getString(R.string.activated_successfully)}"
        alertDialog.apply {
            setView(view)
            setPositiveButton("Ok") { _, _ ->
            }
        }.create().show()
    }

}
