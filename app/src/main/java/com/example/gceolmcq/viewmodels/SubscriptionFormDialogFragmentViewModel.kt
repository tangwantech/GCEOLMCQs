package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.SubscriptionFormDataModel

class SubscriptionFormDialogFragmentViewModel : ViewModel() {
    private val subscriptionFormData = SubscriptionFormDataModel()
    private var dialogTitle = ""

    private val _isSubscriptionFormFilled = MutableLiveData<Boolean>()
    val isSubscriptionFormFilled: LiveData<Boolean> = _isSubscriptionFormFilled

    init {
        _isSubscriptionFormFilled.value = false
    }

    fun setPackageType(packageName: String) {
        subscriptionFormData.packageType = packageName
        updateIsSubscriptionFormFilled()
    }

    fun setPackagePrice(packagePrice: String) {
        subscriptionFormData.packagePrice = packagePrice

    }

    fun setMomoPartner(momoPartner: String) {
        subscriptionFormData.momoPartner = momoPartner
        updateIsSubscriptionFormFilled()
    }

    fun setMomoNumber(momoNumber: String) {
        subscriptionFormData.momoNumber = momoNumber
        updateIsSubscriptionFormFilled()

    }

    fun getSubscriptionFormData(): SubscriptionFormDataModel {
        return subscriptionFormData
    }

    fun setSubjectPosition(position: Int) {
        subscriptionFormData.subjectPosition = position
    }

    fun updateDialogTitle(title: String) {
        dialogTitle = title
        subscriptionFormData.subject = title
    }

    fun getDialogTitle(): String {
        return dialogTitle
    }

    fun setPackageDuration(packageDuration: Int) {
        subscriptionFormData.packageDuration = packageDuration
    }

    private fun updateIsSubscriptionFormFilled() {
//
        _isSubscriptionFormFilled.value = subscriptionFormData.packageType != null && subscriptionFormData.momoPartner != null && subscriptionFormData.momoNumber != null && subscriptionFormData.momoNumber!!.length == 9
    }

}