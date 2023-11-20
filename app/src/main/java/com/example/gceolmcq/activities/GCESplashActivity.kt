package com.example.gceolmcq.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.R
import com.example.gceolmcq.viewmodels.SplashActivityViewModel
import kotlinx.coroutines.*
import java.io.IOException
import java.nio.charset.Charset

class GCESplashActivity : AppCompatActivity() {
    private val SERVER_RETRY_LIMIT = 2
    private lateinit var viewModel: SplashActivityViewModel
    private lateinit var pref: SharedPreferences
    private var termsOfServiceDialog: AlertDialog? = null
    private var initializingAppDialog: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        pref = getSharedPreferences("SplashActivity", MODE_PRIVATE)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        supportActionBar?.hide()
        setupViewModel()
        setServerRetryCount()
        setupObservers()
        checkIsTermsOfServiceAccepted()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[SplashActivityViewModel::class.java]
        viewModel.setSubjectAndFileNameDataListModel(getJsonFromAssets())
        viewModel.setRepositoryLink(this, getMobileID())
    }


    private fun setupObservers(){
        viewModel.remoteRepoErrorExceptionRaised().observe(this){isException ->
            isException?.let {
                cancelInitializingAppDialog()
                if(it){
                    decrementServerRetryCount()
                    checkRetryCount()
                }
            }
        }

        viewModel.getAreSubjectsPackagesAvailable().observe(this){subjectPackagesAvailable ->
            subjectPackagesAvailable?.let{
                gotoMainActivity()
            }
        }

    }

    private fun checkRetryCount(){
        if (viewModel.getServerRetryCountsLeft() > 0){
            displayInitializingAppDialog()
        }else{
            resetServerRetryCount()
            displayServerTimeOutDialog()
        }
    }

    private fun setServerRetryCount(){
        viewModel.setServerRetryCountsLeft(SERVER_RETRY_LIMIT)
    }

    private fun decrementServerRetryCount(){
        viewModel.decrementServerRetryCount()
    }

    private fun resetServerRetryCount(){
        viewModel.resetServerRetryCount(SERVER_RETRY_LIMIT)

    }

    private fun checkIsTermsOfServiceAccepted(){
        val termsAccepted = pref.getBoolean(MCQConstants.TERMS_ACCEPTED, false)
        if (termsAccepted){
            cancelInitializingAppDialog()
            syncSubjectsPackages()
//            gotoMainActivity()
        }else{
            displayTermsOfServiceDialog()
        }

    }

    private fun displayTermsOfServiceDialog(){
        val view = LayoutInflater.from(this).inflate(R.layout.terms_of_use_layout, null)
        val webView: WebView = view.findViewById(R.id.webView)
        webView.loadUrl(MCQConstants.TERMS_URL)
        termsOfServiceDialog = AlertDialog.Builder(this).create()
        termsOfServiceDialog?.setView(view)
        termsOfServiceDialog?.setButton(AlertDialog.BUTTON_POSITIVE, resources.getString(R.string.accept)) { _, _ ->
            saveTermsOfServiceAcceptedStatus(true)
            displayInitializingAppDialog()
            checkIsTermsOfServiceAccepted()

        }
        termsOfServiceDialog?.setButton(AlertDialog.BUTTON_NEGATIVE, resources.getString(R.string.decline)) { _, _ ->
            finish()
        }
        termsOfServiceDialog?.show()
    }



    private fun displayInitializingAppDialog(){
        initializingAppDialog = AlertDialog.Builder(this).create()
        initializingAppDialog?.apply {
            setMessage("Initializing GCE OL MCQs...")
            setCancelable(false)
        }
        initializingAppDialog?.show()

    }

    private fun displayServerTimeOutDialog(){
        val timeoutDialog = AlertDialog.Builder(this).apply {
            setTitle("Failed to Initialize")
            setMessage("server timeout")
            setPositiveButton("Retry"){_, _ ->
                checkRetryCount()
            }
            setNegativeButton("Exit"){_, _ ->
                finish()
            }
        }.create()
        timeoutDialog.show()
    }

    private fun cancelInitializingAppDialog(){
        if (initializingAppDialog != null){
            initializingAppDialog?.dismiss()
        }

    }

    private fun gotoMainActivity(){
        CoroutineScope(Dispatchers.IO).launch{
            delay(3000L)
            withContext(Dispatchers.Main){
                val intent = Intent(this@GCESplashActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
//
            }
        }
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

    private fun saveTermsOfServiceAcceptedStatus(state: Boolean){
        pref.edit().apply {
            putBoolean(MCQConstants.TERMS_ACCEPTED, state)
            apply()
        }
    }

    @SuppressLint("HardwareIds")
    fun getMobileID(): String {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }

    private fun syncSubjectsPackages(){
        viewModel.synchronizeSubjectsPackageData()
    }
}