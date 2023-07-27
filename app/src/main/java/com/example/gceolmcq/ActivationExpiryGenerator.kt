package com.example.gceolmcq

import com.example.gceolmcq.datamodels.ActivationExpiryDates
import java.util.*

class ActivationExpiryDatesGenerator() {

   fun checkExpiry(activatedOn: String, expiresOn: String): Boolean{
        val currentDate = Date()
        val activationDate = Date(Date.parse(activatedOn))
        val expiryDate = Date(Date.parse(expiresOn))
        return currentDate > activationDate && currentDate < expiryDate
    }

    companion object {
        const val SECONDS = "seconds"
        const val MINUTES = "minutes"
        const val HOURS = "hours"
        const val DAYS = "days"
        fun generateTrialActivationExpiryDates(timeType: String=MINUTES, duration: Int): ActivationExpiryDates {

            val activationDate = Date()
            val expiry = Date()

            when(timeType){
                SECONDS -> {
                    expiry.seconds = expiry.seconds.plus(duration)
                }
                MINUTES -> {
                    expiry.minutes = expiry.minutes.plus(duration)
                }

                HOURS -> {
                    expiry.hours = expiry.hours.plus(duration)
                }

            }

            return ActivationExpiryDates( activationDate.toLocaleString(), expiry.toLocaleString())
        }

    }


}