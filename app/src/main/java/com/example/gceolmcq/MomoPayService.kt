package com.example.gceolmcq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gceolmcq.datamodels.SubscriptionFormDataModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MomoPayService{
    private lateinit var subscriptionFormData: SubscriptionFormDataModel
    private var _isTransactionSuccessful = MutableLiveData<Boolean>()
    val isTransactionSuccessful: LiveData<Boolean> = _isTransactionSuccessful
    private var transactionId = MutableLiveData<String>()
    private var ussDCode = MutableLiveData<String>()
    private var transactionStatus = MutableLiveData<String>()

    init {
        transactionStatus.value = "PENDING"
    }
    fun initiatePayment(subscriptionFormDataModel: SubscriptionFormDataModel) {
        this.subscriptionFormData = subscriptionFormDataModel
//        setAccessToken()
        testUpdateTransactionSuccessful(true)

    }

    fun getUssdCode(): LiveData<String> {
        return ussDCode
    }

    fun getTransactionId(): LiveData<String> {
        return transactionId
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
                _isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val json = JSONObject(responseBody!!)
//                accessToken.postValue(json["token"].toString())
                val accessToken = json["token"].toString()
                requestToPay(accessToken, subscriptionFormData.packagePrice,subscriptionFormData.momoNumber)
            }

        })
    }

    private fun requestToPay(token: String, amountToPay: String?, momoNumber: String?) {
        val client = OkHttpClient().newBuilder()
            .build()
        val mediaType = "application/json".toMediaTypeOrNull()
        val requestBody: RequestBody = RequestBody.create(
            mediaType,
            "{\"amount\":\"${amountToPay}\",\"from\":\"237${momoNumber}\",\"description\":\"${subscriptionFormData.subject} ${subscriptionFormData.packageType} subscription\",\"external_reference\": \"\"}"
        )
        val request: Request = Request.Builder()
            .url("https://demo.campay.net/api/collect/")
            .method("POST", requestBody)
            .addHeader("Authorization", "Token ${token}")
            .addHeader("Content-Type", "application/json")
            .build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                _isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {

//                println(responseBody)
                try {
                    val responseBody = response.body?.string()
                    val json = JSONObject(responseBody!!)
                    ussDCode.postValue(json["ussd_code"].toString())
                    val referenceId = json["reference"].toString()
                    CoroutineScope(Dispatchers.Main).launch {
//                        delay(1000)
                        checkTransactionStatus(token, referenceId)
                        while(transactionStatus.value == "PENDING"){
                            delay(1000)
                            checkTransactionStatus(token, referenceId)
//
                        }
                        when (transactionStatus.value) {
                            "SUCCESSFUL" -> {
                                _isTransactionSuccessful.postValue(true)
                            }
                            "FAILED" -> {
                                _isTransactionSuccessful.postValue(false)
                            }
                        }
                    }
                }catch (e: JSONException){
                    println("Exception $e")
                    _isTransactionSuccessful.postValue(false)
                }

            }

        })
    }

    fun checkTransactionStatus(token: String, referenceId: String){
        val client = OkHttpClient().newBuilder()
            .build()
        val mediaType = "".toMediaTypeOrNull()
        val body: RequestBody = RequestBody.create(mediaType, "")
        val request: Request = Request.Builder()
            .url("https://demo.campay.net/api/transaction/$referenceId/")

            .addHeader("Authorization", "Token $token")
            .addHeader("Content-Type", "application/json")
            .build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                _isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val jsonResponse = JSONObject(responseBody!!)
                println("transaction status: $responseBody")
                transactionId.postValue(jsonResponse["operator_reference"].toString())
                transactionStatus.postValue(jsonResponse["status"].toString())

            }

        })

    }



    private fun testUpdateTransactionSuccessful(status: Boolean){
        _isTransactionSuccessful.postValue(status)
    }

    fun getSubjectName(): String {
        return subscriptionFormData.subject!!
    }

}