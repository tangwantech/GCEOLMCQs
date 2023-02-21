package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubjectItemFragmentViewModel : ViewModel() {
    private val isSubjectPackageActive = MutableLiveData<Boolean>()
    private var subjectName: String? = null
    private var expiresOn = MutableLiveData<String>()
    private var subjectPosition: Int? = null

    init {
        isSubjectPackageActive.value = false
    }

    fun setSubjectName(subjectName: String) {
        this.subjectName= subjectName
    }

    fun getSubjectName(): String {
        return subjectName!!
    }

    fun updateSubjectPosition(position: Int){
        subjectPosition = position
    }


    fun checkSubjectPackageExpiry() {

        viewModelScope.launch(Dispatchers.IO) {
            val packageState =
                ActivationExpiryDatesGenerator().checkExpiry(expiresOn.value!!)
//            delay(100)
            withContext(Dispatchers.Main) {
                isSubjectPackageActive.value = packageState
            }
        }
    }

    fun getIsSubjectPackageActive(): LiveData<Boolean> {
        return isSubjectPackageActive
    }

    fun getSubjectPosition(): Int {
        return subjectPosition!!
    }

    fun updateExpiresOn(expiresOn: String){
        this.expiresOn.value = expiresOn
    }


}