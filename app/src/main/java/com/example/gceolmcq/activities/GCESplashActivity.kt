package com.example.gceolmcq.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
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
                saveTermsOfServiceAcceptedStatus(it)
                checkIsTermsOfServiceAccepted()
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
            gotoMainActivity()
        }else{
            displayTermsOfServiceDialog()
        }

    }

    private fun displayTermsOfServiceDialog(){
        termsOfServiceDialog = AlertDialog.Builder(this).create()
        termsOfServiceDialog?.setTitle("Terms of use of service")
        termsOfServiceDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "Accept") { _, _ ->
            displayInitializingAppDialog()

        }
        termsOfServiceDialog?.setButton(AlertDialog.BUTTON_NEGATIVE, "Decline") { _, _ ->
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
        viewModel.readSubjectsPackagesByMobileIdFromRemoteRepo()

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
            delay(2000L)
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



}