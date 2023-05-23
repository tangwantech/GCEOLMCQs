package com.example.gceolmcq

import android.os.CountDownTimer
import android.text.format.Time
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyNetworkTimeout {

    val timeout: MutableLiveData<Boolean> = MutableLiveData()
    private lateinit var timer: CountDownTimer

    fun startTimer(networkTimeoutDuration: Long, countDownInterval: Long=1000L) {
        timer = object : CountDownTimer(networkTimeoutDuration, countDownInterval) {
            override fun onTick(p0: Long) {
                val t = Time()
                t.set(p0)
            }

            override fun onFinish() {
                timeout.value = true
            }

        }.start()
    }

    fun cancelTimer(){
        timer.cancel()
    }
}
