package com.example.gceolmcq

import android.content.Context
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

class MomoPayService(private val context: Context) {

private var subscriptionFormData: SubscriptionFormData? = null
    private var isTransactionSuccessful = MutableLiveData<Boolean>()
    private var transactionStatus = MutableLiveData<TransactionStatus>()

    fun initiatePayment(subscriptionFormData: SubscriptionFormData) {
        this.subscriptionFormData = subscriptionFormData
        setAccessToken()
//        testUpdateTransactionSuccessful()
//        requestToPay()
    }
    private fun setAccessToken() {
        val client = OkHttpClient().newBuilder().build();
        val mediaType: MediaType? = MCQConstants.APPLICATION_JSON.toMediaTypeOrNull()
        val requestBody: RequestBody = RequestBody.create(
            mediaType,
            "{\n    \"${MCQConstants.USER_NAME}\": \"${context.resources.getString(R.string.campay_app_user_name)}\",\n    \"${MCQConstants.PASS_WORD}\": \"${context.resources.getString(R.string.campay_app_pass_word)}\"\n}"
        );
        val request = Request.Builder()
            .url(context.resources.getString(R.string.campay_token_url))
            .method(MCQConstants.POST, requestBody)
            .addHeader(MCQConstants.CONTENT_TYPE, MCQConstants.APPLICATION_JSON)
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
        val mediaType = MCQConstants.APPLICATION_JSON.toMediaTypeOrNull()
        val requestBody: RequestBody = RequestBody.create(
            mediaType,
            "{\"${MCQConstants.AMOUNT}\":\"${amountToPay}\",\"from\":\"237${momoNumber}\",\"${MCQConstants.DESCRIPTION}\":\"${subscriptionFormData?.subject} ${subscriptionFormData?.packageType} ${MCQConstants.SUBSCRIPTION}\",\"${MCQConstants.EXTERNAL_REFERENCE}\": \"\"}"
        )
        val request: Request = Request.Builder()
            .url(context.resources.getString(R.string.campay_requestToPay_url))
            .method(MCQConstants.POST, requestBody)
            .addHeader(MCQConstants.AUTHORIZATION, "${MCQConstants.TOKEN} $token")
            .addHeader(MCQConstants.CONTENT_TYPE, MCQConstants.APPLICATION_JSON)
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
//                    ussDCode.postValue(json["ussd_code"].toString())
                    val referenceId = json["reference"].toString()

                    transactionStatus.postValue(status)

                    CoroutineScope(Dispatchers.IO).launch{
                        checkTransactionStatus(token, referenceId, status)
                        while (status.status == MCQConstants.PENDING){
                            delay(3000)
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
        val request: Request = Request.Builder()
            .url("https://demo.campay.net/api/transaction/$referenceId/")

            .addHeader(MCQConstants.AUTHORIZATION, "${MCQConstants.TOKEN} $token")
            .addHeader(MCQConstants.CONTENT_TYPE, MCQConstants.APPLICATION_JSON)
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