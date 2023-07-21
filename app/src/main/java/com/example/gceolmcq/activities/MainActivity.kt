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
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.HomeRecyclerViewAdapter
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.fragments.*
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.MainActivityViewModel
import kotlinx.coroutines.*
import java.io.IOException
import java.nio.charset.Charset

//private const val SUBJECT_NAMES = "subjectNames"
//private const val INIT_DATA_BUNDLE = "initDataBundle"
//private const val MOBILE_ID = "mobileID"
//private const val SUBJECT_FILENAME_LIST = "subjectAndFileNameList"
//private const val TYPE = "text/plain"
//private const val APP_URL = "https://google.com"
//private const val PRIVACY_POLICY = "https://gceolmcqs.w3spaces.com/Gceolmcqs_Privacy-Policy.pdf"

class MainActivity : AppCompatActivity(),
    SubscriptionFormDialogFragment.OnActivateButtonClickListener,
    RequestToPayDialogFragment.RequestToPayTransactionStatusListener,
    HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener,
    HomeFragment.OnPackageActivatedListener,
    ActivateTrialPackageFragment.OnSubjectsPackagesAvailableListener
{

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var header: LinearLayout

    private var currentFragmentIndex: Int? = null
    private lateinit var activatingPackageAlertDialog: AlertDialog
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences("Main", MODE_PRIVATE)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

        activatingPackageAlertDialog = AlertDialog.Builder(this).create()
        activatingPackageAlertDialog.apply {
            setMessage(resources.getString(R.string.be_patient))
            setCancelable(false)
        }
        setupViewModel()
        initViews()
        setupViewObservers()


    }

    private fun areSubjectsPackagesAvailable(): Boolean{
        return pref.getBoolean(MCQConstants.AVAILABLE, false)
    }

    private fun saveSubjectsPackagesAvailabilityState(state: Boolean){
        val editor = pref.edit()
        editor.apply {
            putBoolean(MCQConstants.AVAILABLE, state)
        }.apply()
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.initSubjectDataBase(GceOLMcqDatabase.getDatabase(this))
//
        viewModel.setMobileId(getMobileID())
//        println(getJsonFromAssets())
        viewModel.setSubjectAndFileNameDataListModel(getJsonFromAssets())
//
    }

    private fun initViews(){
        header = findViewById(R.id.header)
//        bottomNavView = findViewById(R.id.bottomNav)
    }

    private fun setupViewObservers(){
        viewModel.activatedPackageIndex.observe(this, Observer{
            hideActivatingPackageActivatedDialog(it)
        })

        viewModel.subjectsPackageDataList.observe(this){

        }
    }

    private fun gotoHomeFragment(){
        title = resources.getString(R.string.app_name)
//        header.visibility = View.VISIBLE
        val homeFragment = HomeFragment.newInstance()
        replaceFragment(homeFragment, 1)
    }

    private fun gotoActivateTrialPackageFragment(){
        val subjects = viewModel.liveSubjectsAvailable.value!!
//        println(subjects)
        val activateTrialFragment = ActivateTrialPackageFragment.newInstance(subjects, getMobileID())
        replaceFragment(activateTrialFragment, 0)
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
        displayView()

    }

    private fun displayView(){
        if(!areSubjectsPackagesAvailable()){
            gotoActivateTrialPackageFragment()
        }else{
//            viewModel.readSubjectsPackageDataFromLocalDb()
            gotoHomeFragment()

        }
    }


    private fun gotoSubjectContentTableActivity(position: Int){
        val intent = Intent(this, SubjectContentTableActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(
            "subject_and_file_name_data",
            viewModel.getSubjectAndFileNameDataAt(position)

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
        val appMsg = "Check out this awesome GCE OL MCQs app. Link: ${MCQConstants.APP_URL}"
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = MCQConstants.TYPE
        intent.putExtra(Intent.EXTRA_TEXT, appMsg)
        startActivity(intent)
    }

    private fun rateUs(){
        val uri = Uri.parse(MCQConstants.APP_URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

        try{
            startActivity(intent)
        }catch (e: ActivityNotFoundException){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(MCQConstants.APP_URL)))
        }
    }

    private fun privacyPolicy(){
        val uri = Uri.parse(MCQConstants.PRIVACY_POLICY)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

        try{
            startActivity(intent)
        }catch (e: ActivityNotFoundException){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(MCQConstants.PRIVACY_POLICY)))
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
            viewModel.getSubjectNameAt(position)
        )
        subscriptionFormDialogFragment.isCancelable = false
        subscriptionFormDialogFragment.show(supportFragmentManager, "subscription_form_dialog")
    }

//    override fun onPackageDetailsButtonClicked(position: Int) {
//
//        val subjectPackageDetailsDialogFragment = SubjectPackageDetailsDialogFragment.newInstance(
//            viewModel.getSubjectPackageDataAt(position)
//        )
//        subjectPackageDetailsDialogFragment.show(supportFragmentManager, "package_details_dialog")
//    }

    override fun onActivateButtonClicked(subscriptionFormData: SubscriptionFormData) {

        val requestToPayDialogFragment =
            RequestToPayDialogFragment.newInstance(subscriptionFormData)
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
        return viewModel.activatedPackageIndexChangedAt
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
        viewModel.activateSubjectPackageAt(subjectIndex, packageType, packageDuration)
    }

    private fun hideActivatingPackageActivatedDialog(position: Int){
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            withContext(Dispatchers.Main){
                activatingPackageAlertDialog.hide()
                viewModel.updateActivatedPackageIndexChangedAt(position)
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
            "${viewModel.getActivatedPackageName(position)} ${resources.getString(R.string.activated_successfully)}"
        alertDialog.apply {
            setView(view)
            setPositiveButton("Ok") { _, _ ->
            }
        }.create().show()
    }

    @SuppressLint("HardwareIds")
    private fun getMobileID(): String {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }

    private fun getJsonFromAssets(): String? {
        val charset: Charset = Charsets.UTF_8

        return try {
            val jsonFile = assets.open("subject_data.json")
            val size = jsonFile.available()
            val buffer = ByteArray(size)

            jsonFile.read(buffer)
            jsonFile.close()
            String(buffer, charset)

        } catch (e: IOException) {
            null
        }
    }

    override fun onSubjectsPackagesAvailable(isAvailable: Boolean) {
        println("is available $isAvailable")
        saveSubjectsPackagesAvailabilityState(isAvailable)
        displayView()

    }

}
