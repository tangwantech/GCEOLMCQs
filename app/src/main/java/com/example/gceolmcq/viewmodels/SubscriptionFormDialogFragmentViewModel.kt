package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.SubscriptionFormDataModel

class SubscriptionFormDialogFragmentViewModel : ViewModel() {
    private val packageTypes = arrayOf("MCQ 1H", "MCQ 2H", "MCQ 3H", "MCQ 4H", "MCQ 5H", "MCQ 6H")
    private val prices = arrayOf("50", "100", "150", "200", "225", "275")
    private val momoPartners = arrayOf("MTN", "ORANGE")
    private val subscriptionFormData = SubscriptionFormDataModel()
    private var dialogTitle = ""
    private var packageDurations = arrayOf(1, 2, 3, 4, 5, 6)
//    private var packageDurations = arrayOf(1, 2, 3, 4, 5, 6, 12, 24, 24 * 7, 24 * 30)

    private val isPackageSelected = MutableLiveData<Boolean>()

    private val _isSubscriptionFormFilled = MutableLiveData<Boolean>()
    val isSubscriptionFormFilled: LiveData<Boolean> = _isSubscriptionFormFilled

    init {
        isPackageSelected.value = false
        _isSubscriptionFormFilled.value = false
//        packagePrice.value = ""
    }

    fun setPackageType(position: Int) {
        subscriptionFormData.packageType = packageTypes[position]
        setPackagePrice(position)
        setPackageDuration(position)
        isPackageSelected.value = true
        updateIsSubscriptionFormFilled()
    }

    fun getIsPackageSelected(): LiveData<Boolean> {
        return isPackageSelected
    }

    fun getPackageTypes(): Array<String> {
        return packageTypes
    }

    fun getMoMoPartners(): Array<String> {
        return momoPartners
    }

    private fun setPackagePrice(position: Int) {
        subscriptionFormData.packagePrice = prices[position]
//        packagePrice = subscriptionFormData.packagePrice!!
    }

    fun getPackagePrice(): String {
        return subscriptionFormData.packagePrice!!
    }

    fun setMomoPartner(position: Int) {
        subscriptionFormData.momoPartner = momoPartners[position]
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

    private fun setPackageDuration(position: Int) {
        subscriptionFormData.packageDuration = packageDurations[position]
    }

    private fun updateIsSubscriptionFormFilled() {
//
        _isSubscriptionFormFilled.value = subscriptionFormData.packageType != null && subscriptionFormData.momoPartner != null && subscriptionFormData.momoNumber != null && subscriptionFormData.momoNumber!!.length == 9
    }

}