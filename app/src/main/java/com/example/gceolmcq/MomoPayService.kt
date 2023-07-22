package com.example.gceolmcq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.datamodels.TransactionStatus
import kotlinx.coroutines.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MomoPayService {
//    companion object {
//
//
//    }
private var subscriptionFormData: SubscriptionFormData? = null
    private var isTransactionSuccessful = MutableLiveData<Boolean>()
    private var transactionId = MutableLiveData<String>()
    private var momoPartner = MutableLiveData<String>()
    private var ussDCode = MutableLiveData<String>()
    private var transactionStatus = MutableLiveData<TransactionStatus>()


    fun initiatePayment(subscriptionFormData: SubscriptionFormData) {
        this.subscriptionFormData = subscriptionFormData
//        setMoMoPartner()
//        setAccessToken()
        testUpdateTransactionSuccessful()
//        requestToPay()
    }

    private fun setMoMoPartner() {
        momoPartner.value = subscriptionFormData?.momoPartner!!
    }

    fun getPackageType(): String {
        return subscriptionFormData?.packageType!!
    }

    fun getPackagePrice(): String {
        return subscriptionFormData?.packagePrice!!
    }

    fun getMomoPartner(): LiveData<String> {
        return momoPartner
    }

    fun getUssdCode(): LiveData<String> {
        return ussDCode
    }

    fun getTransactionId(): LiveData<String> {
        return transactionId
    }

    fun getSubjectIndex(): Int {
        return subscriptionFormData?.subjectPosition!!
    }

    fun getPackageDuration(): Int {
        return subscriptionFormData?.packageDuration!!
    }


    private fun setAccessToken() {
        val client = OkHttpClient().newBuilder().build();
        val mediaType: MediaType? = "application/json".toMediaTypeOrNull()
        val requestBody: RequestBody = RequestBody.create(
            mediaType,
            "{\n    \"username\": \"GG0hAnE81DMQEXqANvG27hFkLmxf3PEhKh4UMSh5CFCOhlNBiwAQ2L9wWI3k3q0lvzZJH_p1CRIoQF7by-nApw\",\n    \"password\": \"jkMl4mmFSuBE2KGQAgjy1DuHPKNH6qUMWxpZ8LQIY-NzjuYwW1CzCccU0oIzMRxItd7RbjSWelmI7QuFTvfhSw\"\n}"
        );
        val request = Request.Builder()
            .url("https://demo.campay.net/api/token/")
            .method("POST", requestBody)
            .addHeader("Content-Type", "application/json")
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                call.cancel()
                isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val json = JSONObject(responseBody!!)
                val accessToken = json["token"].toString()
                requestToPay(
                    accessToken,
                    subscriptionFormData?.packagePrice,
                    subscriptionFormData?.momoNumber
                )
            }

        })
    }

    fun requestToPay(token: String, amountToPay: String?, momoNumber: String?) {
        val client = OkHttpClient().newBuilder()
            .build()
        val mediaType = "application/json".toMediaTypeOrNull()
        val requestBody: RequestBody = RequestBody.create(
            mediaType,
            "{\"amount\":\"${amountToPay}\",\"from\":\"237${momoNumber}\",\"description\":\"${subscriptionFormData?.subject} ${subscriptionFormData?.packageType} subscription\",\"external_reference\": \"\"}"
        )
        val request: Request = Request.Builder()
            .url("https://demo.campay.net/api/collect/")
            .method("POST", requestBody)
            .addHeader("Authorization", "Token ${token}")
            .addHeader("Content-Type", "application/json")
            .build()
        client.newCall(request).enqueue(object : Callback {
            val status = TransactionStatus(MCQConstants.PENDING)
            override fun onFailure(call: Call, e: IOException) {
//                    call.cancel()
                isTransactionSuccessful.postValue(false)
                call.cancel()

            }
            override fun onResponse(call: Call, response: Response) {

                try {
                    val responseBody = response.body?.string()
                    val json = JSONObject(responseBody!!)
                    ussDCode.postValue(json["ussd_code"].toString())
                    val referenceId = json["reference"].toString()

                    transactionStatus.postValue(status)

                    CoroutineScope(Dispatchers.IO).launch{
                        checkTransactionStatus(token, referenceId, status)
                        while (status.status == MCQConstants.PENDING){
                            delay(5000)
                            checkTransactionStatus(token, referenceId, status)
                            println(status)
                        }

                        when(status.status){
                            MCQConstants.SUCCESSFUL -> {
                                isTransactionSuccessful.postValue(true)
                            }
                            MCQConstants.FAILED -> {
                                isTransactionSuccessful.postValue(false)
                            }
                        }
                    }
                }catch (e: JSONException){
                    println("Exception $e")
                    isTransactionSuccessful.postValue(false)

                }

            }

        })
    }

    fun checkTransactionStatus(token: String, referenceId: String, status: TransactionStatus) {
        val client = OkHttpClient().newBuilder()
            .build()
        val mediaType = "".toMediaTypeOrNull()
        val body: RequestBody = RequestBody.create(mediaType, "")
        val request: Request = Request.Builder()
            .url("https://demo.campay.net/api/transaction/$referenceId/")

            .addHeader("Authorization", "Token $token")
            .addHeader("Content-Type", "application/json")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {

                val responseBody = response.body?.string()
                val jsonResponse = JSONObject(responseBody!!)
                status.status = jsonResponse["status"].toString()
            }

        })


    }


    private fun testUpdateTransactionSuccessful() {
        isTransactionSuccessful.value = true
    }

    fun getSubjectName(): String {
        return subscriptionFormData?.subject!!
    }

    fun getTransactionStatus(): LiveData<TransactionStatus> {
        return transactionStatus
    }

    fun getIsTransactionSuccessful(): LiveData<Boolean>{
        return isTransactionSuccessful
    }


    fun reset() {
        isTransactionSuccessful = MutableLiveData()
        transactionStatus = MutableLiveData()
        subscriptionFormData = null
    }



}