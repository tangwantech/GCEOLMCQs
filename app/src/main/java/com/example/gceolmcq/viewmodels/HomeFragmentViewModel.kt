package com.example.gceolmcq.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.datamodels.SubjectPackageExpiryStatusData
import kotlinx.coroutines.*

class HomeFragmentViewModel: ViewModel() {
    private var subjectPackageExpiryStatusDataList: ArrayList<SubjectPackageExpiryStatusData> = ArrayList()
    private val subjectPackageExpiredIndexAndStatusBundle = MutableLiveData<Bundle>()

    fun checkPackageExpiry(position: Int, expiresOn: String){

        viewModelScope.launch(Dispatchers.IO) {
            var notExpired = ActivationExpiryDatesGenerator().checkExpiry(expiresOn)
            while (notExpired){
//                delay(1000)
                notExpired = ActivationExpiryDatesGenerator().checkExpiry(expiresOn)
            }

            withContext(Dispatchers.Main){
                this@HomeFragmentViewModel.subjectPackageExpiryStatusDataList[position].status = notExpired
                val subjectIndexExpiredStatusBundle = Bundle()
                subjectIndexExpiredStatusBundle.putBoolean("status", notExpired)
                subjectIndexExpiredStatusBundle.putInt("position", position)
                subjectPackageExpiredIndexAndStatusBundle.value = subjectIndexExpiredStatusBundle

            }

        }
    }

    fun subjectPackageExpiredIndexAndStatusBundle(): LiveData<Bundle>{
        return subjectPackageExpiredIndexAndStatusBundle
    }

    fun packagesInitialExpiryCheck() {
        subjectPackageExpiryStatusDataList.forEachIndexed { index, subjectExpiryStatusData ->
            checkPackageExpiry(index, subjectExpiryStatusData.expiryDate)
        }
    }

    fun setSubjectPackageExpiryStatusDataList(data: ArrayList<SubjectPackageExpiryStatusData>) {
        subjectPackageExpiryStatusDataList = data

    }

}