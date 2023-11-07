package com.example.gceolmcq

import android.os.CountDownTimer
import android.text.format.Time
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CustomCountDownTimer {
    private lateinit var timer: CountDownTimer
    private val isTimeOut = MutableLiveData<Boolean>()

    private val timeRemaining = MutableLiveData<Time>()

    private val isTimeAlmostOut = MutableLiveData<Boolean>()
    fun startTimer(duration:Long) {
        timer = object : CountDownTimer(duration, MCQConstants.COUNT_DOWN_INTERVAL) {
            override fun onTick(p0: Long) {
                val t = Time()
                updateIsTimeAlmostOut(p0)
                t.set(p0)
                timeRemaining.value = t
            }

            override fun onFinish() {
                isTimeOut.value = true
            }

        }.start()
    }

    fun getTimeRemaining(): LiveData<Time> {
        return timeRemaining
    }

    fun updateIsTimeAlmostOut(timeLeft: Long){
        if(timeLeft < MCQConstants.TIME_TO_ANIMATE_TIMER){
            isTimeAlmostOut.value = true
        }
    }

    fun getIsTimeAlmostOut(): LiveData<Boolean>{
        return isTimeAlmostOut
    }

    fun getIsTimeOut(): LiveData<Boolean> {
        return isTimeOut
    }
}