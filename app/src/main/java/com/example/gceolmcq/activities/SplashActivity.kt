package com.example.gceolmcq.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.gceolmcq.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        supportActionBar?.hide()

        CoroutineScope(Dispatchers.IO).launch{
            delay(3000L)
            withContext(Dispatchers.Main){
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
//                exitActivity()
            }
        }
    }


    private fun displayNoConnectionDialog(){
//        indeterminateProgress.visibility = View.GONE
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle(resources.getString(R.string.error))
            setMessage(resources.getString(R.string.initialise_error_message))
            setPositiveButton(resources.getString(R.string.exit)) { _, _ ->
                exitActivity()
            }
            setCancelable(false)
        }.create().show()
    }
    private fun exitActivity(){
        finish()
    }

}