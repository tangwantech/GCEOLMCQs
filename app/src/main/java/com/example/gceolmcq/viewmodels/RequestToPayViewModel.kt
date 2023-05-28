package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.datamodels.SubscriptionFormDataModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
//import net.compay.android.CamPay
//import net.compay.android.models.requests.CollectionRequest
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit


class RequestToPayViewModel : ViewModel() {
    private lateinit var subscriptionFormDataModel: SubscriptionFormDataModel
    private var isTransactionSuccessful = MutableLiveData<Boolean>()
    private var transactionId = MutableLiveData<String>()
    private var momoPartner = MutableLiveData<String>()
    private var ussDCode = MutableLiveData<String>()
    private var transactionStatus = MutableLiveData<String>()

    init {
        transactionStatus.value = "PENDING"
    }
    fun setSubscriptionFormData(subscriptionFormDataModel: SubscriptionFormDataModel) {
        this.subscriptionFormDataModel = subscriptionFormDataModel
        setMoMoPartner()
        setAccessToken()
//        testUpdateTransactionSuccessful(true)
//        requestToPay()
    }

    private fun setMoMoPartner(){
        momoPartner.value = subscriptionFormDataModel.momoPartner!!
    }

    fun getPackageType(): String {
        return subscriptionFormDataModel.packageType!!
    }

    fun getPackagePrice(): String {
        return subscriptionFormDataModel.packagePrice!!
    }

    fun getIsTransactionSuccessful(): LiveData<Boolean> {
        return isTransactionSuccessful
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
        return subscriptionFormDataModel.subjectPosition!!
    }

    fun getPackageDuration(): Int {
        return subscriptionFormDataModel.packageDuration!!
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
                isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val json = JSONObject(responseBody!!)
//                accessToken.postValue(json["token"].toString())
                val accessToken = json["token"].toString()
                requestToPay(accessToken, subscriptionFormDataModel.packagePrice,subscriptionFormDataModel.momoNumber)
            }

        })
    }

    fun requestToPay(token: String, amountToPay: String?, momoNumber: String?) {
        val client = OkHttpClient().newBuilder()
            .build()
        val mediaType = "application/json".toMediaTypeOrNull()
        val requestBody: RequestBody = RequestBody.create(
            mediaType,
            "{\"amount\":\"${amountToPay}\",\"from\":\"237${momoNumber}\",\"description\":\"${subscriptionFormDataModel.subject} ${subscriptionFormDataModel.packageType} subscription\",\"external_reference\": \"\"}"
        )
        val request: Request = Request.Builder()
            .url("https://demo.campay.net/api/collect/")
            .method("POST", requestBody)
            .addHeader("Authorization", "Token ${token}")
            .addHeader("Content-Type", "application/json")
            .build()
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                isTransactionSuccessful.postValue(false)
            }

            override fun onResponse(call: Call, response: Response) {

//                println(responseBody)
                try {
                    val responseBody = response.body?.string()
                    val json = JSONObject(responseBody!!)
                    ussDCode.postValue(json["ussd_code"].toString())
                    val referenceId = json["reference"].toString()
                    viewModelScope.launch {
//                        delay(1000)
                        checkTransactionStatus(token, referenceId)
                        while(transactionStatus.value == "PENDING"){
                            delay(1000)
                            checkTransactionStatus(token, referenceId)
//
                        }
                        when (transactionStatus.value) {
                            "SUCCESSFUL" -> {
                                isTransactionSuccessful.postValue(true)
                            }
                            "FAILED" -> {
                                isTransactionSuccessful.postValue(false)
                            }
                        }
                    }
                }catch (e: JSONException){
                    println("Exception $e")
                    isTransactionSuccessful.postValue(false)
                }


//                getTransactionStatus(token, referenceId)


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
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                isTransactionSuccessful.postValue(false)
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
        isTransactionSuccessful.value = status
    }

    fun getSubjectName(): String {
        return subscriptionFormDataModel.subject!!
    }

}