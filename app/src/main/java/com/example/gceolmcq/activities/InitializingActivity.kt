package com.example.gceolmcq.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.animation.Animation
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.R
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.InitializingActivityViewModel
import kotlinx.coroutines.*
import java.io.IOException
import java.nio.charset.Charset

private const val SUBJECT_NAMES = "subjectNames"
private const val SUBJECT_EXPIRY_LIST = "subjectExpiryList"
private const val SUBJECT_PACKAGE_DATA_LIST = "subjectPackageDataList"
private const val INIT_DATA_BUNDLE = "initDataBundle"
private const val MOBILE_ID = "mobileID"
private const val SUBJECT_FILENAME_LIST = "subjectAndFileNameList"
val TAG = "InitializingActivity"
class InitializingActivity : AppCompatActivity() {

    private lateinit var initializingActivityViewModel: InitializingActivityViewModel
    private var fadeOut: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initializing)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        supportActionBar?.hide()

        initializingActivityViewModel =
            ViewModelProvider(this)[InitializingActivityViewModel::class.java]
        initializingActivityViewModel.initAppDataBase(GceOLMcqDatabase.getDatabase(this))

        initializingActivityViewModel.setMobileId(getMobileID())
        getJsonFromAssets()?.let {

            initializingActivityViewModel.initialiseApp(it).observe(this, Observer{isInitialised ->

                if (isInitialised == null || isInitialised == false) {
                    val indeterminateProgress: ProgressBar =
                        findViewById(R.id.indeterminateProgressBar)
                    indeterminateProgress.visibility = View.GONE
                    val alertDialog = AlertDialog.Builder(this@InitializingActivity)
                    alertDialog.apply {
                        setTitle("Error")
                        setMessage("Application failed to initialize. Please verify that you have an active internet connection and try again")
                        setPositiveButton("Ok") { _, _ ->
                            initializingActivityViewModel.nullifyIsAppInitialised()
                            finish()

                        }
                        setCancelable(false)
                    }.create().show()
                } else {
                    val intent = Intent(this@InitializingActivity, MainActivity::class.java)
                    val bundle = Bundle()
                    bundle.apply {
                        putString(MOBILE_ID, getMobileID())
                        putStringArrayList(
                            SUBJECT_NAMES,
                            initializingActivityViewModel.getSubjectNames()
                        )
                        putStringArrayList(
                            SUBJECT_EXPIRY_LIST,
                            initializingActivityViewModel.getSubjectExpiryList()
                        )
                        putStringArrayList(
                            SUBJECT_FILENAME_LIST,
                            initializingActivityViewModel.getSubjectFileNameList()
                        )
                        putSerializable(
                            SUBJECT_PACKAGE_DATA_LIST,
                            initializingActivityViewModel.getSubjectPackageDataList()
                        )
                    }

                    intent.putExtra(INIT_DATA_BUNDLE, bundle)
                    CoroutineScope(Dispatchers.IO).launch{
                        delay(3000L)
                        withContext(Dispatchers.Main){
                            startActivity(intent)
                            finish()
                        }
                    }

                }
            })

        }
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
            //            println("Exception")
            null
        }
    }
}