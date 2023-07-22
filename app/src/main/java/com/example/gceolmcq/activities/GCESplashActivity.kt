package com.example.gceolmcq.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gceolmcq.R
import kotlinx.coroutines.*

class GCESplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        supportActionBar?.hide()

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

}