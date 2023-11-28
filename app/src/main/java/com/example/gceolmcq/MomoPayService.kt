package com.example.gceolmcq

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.datamodels.TransactionStatus
import kotlinx.coroutines.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MomoPayService(private val context: Context) {
    companion object{
        const val REFERENCE_ID = "reference"
        const val TOKEN = "token"
        const val STATUS = "status"
        const val PENDING = "PENDING"
        const val SUCCESSFUL = "SUCCESSFUL"
        const val FAILED = "FAILED"
    }
    private val client = OkHttpClient().newBuilder().build()
    private var subscriptionFormData: SubscriptionFormData? = null
    private var isTransactionSuccessful = MutableLiveData<Boolean?>()
    private var transactionStatus = MutableLiveData<TransactionStatus>()
    private val _isPaymentSystemAvailable = MutableLiveData<Boolean?>(true)
    val isPaymentSystemAvailable: LiveData<Boolean?> = _isPaymentSystemAvailable


    fun initiatePayment(subscriptionFormData: SubscriptionFormData){

        println("Initiating payment")

        this.subscriptionFormData = subscriptionFormData
        generateAccessToken()
//        testUpdateTransactionSuccessful()

    }
    private fun generateAccessToken(){

        val requestBody = FormBody.Builder()
            .add(MCQConstants.USER_NAME, context.resources.getString(R.string.campay_app_user_name))
            .add(MCQConstants.PASS_WORD, context.resources.getString(R.string.campay_app_pass_word))
            .build()

        val request = Request.Builder()
            .url(context.resources.getString(R.string.campay_token_url))
            .post(requestBody)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("failed generating token due to ${e.message}")
//                isTransactionSuccessful.postValue(false)
                if(e.message.toString().contains("timed out")){
                    _isPaymentSystemAvailable.postValue(false)
                }else{
//                    isTransactionSuccessful.postValue(false)
                    transactionStatus.postValue(TransactionStatus(status = FAILED))
                }
                call.cancel()

            }

            override fun onResponse(call: Call, response: Response) {
                try{
                    val responseBody = response.body?.string()
                    println(responseBody)
                    val json = JSONObject(responseBody!!)
                    val transaction = TransactionStatus()
                    transaction.token = json[TOKEN].toString()
//                    println("Access token $transaction")

                    requestToPay(
                        transaction,
                        subscriptionFormData?.packagePrice,
                        subscriptionFormData?.momoNumber
                    )
                }catch (e:JSONException){
//                    isTransactionSuccessful.postValue(false)
                    transactionStatus.postValue(TransactionStatus(status = FAILED))
                    call.cancel()
//                    println("failed getting token from server due to ${e.message}")
                }

            }

        })
    }

    fun requestToPay(transaction: TransactionStatus, amountToPay: String?, momoNumber: String?){
        val requestBody = FormBody.Builder()
            .add(MCQConstants.AMOUNT, "$amountToPay")
            .add(MCQConstants.FROM, "${MCQConstants.COUNTRY_CODE}$momoNumber")
            .add(MCQConstants.DESCRIPTION, "${subscriptionFormData?.subject} ${subscriptionFormData?.packageType} ${MCQConstants.SUBSCRIPTION}")
            .add(MCQConstants.EXTERNAL_REFERENCE, "")
            .build()

        val request = Request.Builder()
            .url(context.resources.getString(R.string.campay_requestToPay_url))
            .post(requestBody)
            .addHeader(MCQConstants.AUTHORIZATION, "${MCQConstants.TOKEN} ${transaction.token}")
            .build()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("failed initiating request to pay ...... $transaction due to ${e.message}")
                if(e.message.toString().contains("timed out")){
                    _isPaymentSystemAvailable.postValue(false)
                }else{
//                    isTransactionSuccessful.postValue(false)
                    transactionStatus.postValue(TransactionStatus(status = FAILED))
                }

            }
            override fun onResponse(call: Call, response: Response) {
                try {
                    val responseBody = response.body?.string()
                    val json = JSONObject(responseBody!!)
                    transaction.refId = json[REFERENCE_ID].toString()

                    runBlocking {
                        transaction.status = MCQConstants.PENDING
                        while (transaction.status!! == MCQConstants.PENDING){
                            checkTransactionStatus(transaction)
                            delay(3000)
                        }
                    }

                }catch (e: JSONException){

                    transactionStatus.postValue(TransactionStatus(status = FAILED))
                }

            }

        })
    }

    fun checkTransactionStatus(transaction: TransactionStatus){

        val request: Request = Request.Builder()
            .url("${MCQConstants.TRANSACTION_STATUS_URL}${transaction.refId}/")
            .addHeader(MCQConstants.AUTHORIZATION, "${MCQConstants.TOKEN} ${transaction.token}")
            .addHeader(MCQConstants.CONTENT_TYPE, MCQConstants.APPLICATION_JSON)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
//
                transactionStatus.postValue(TransactionStatus(status = FAILED))
//
            }

            override fun onResponse(call: Call, response: Response) {
                try{
                    val responseBody = response.body?.string()
                    val jsonResponse = JSONObject(responseBody!!)
                    transaction.status = jsonResponse[STATUS].toString()
                    transactionStatus.postValue(TransactionStatus(status = transaction.status))

                    println(transaction.status)
                }catch (e: JSONException){
//                    isTransactionSuccessful.postValue(false)
                    transactionStatus.postValue(TransactionStatus(status = FAILED))
                    println("failed checking transaction status ...... $transaction due to ${e.message}")
                }
            }

        })
    }

    private fun testUpdateTransactionSuccessful() {
        isTransactionSuccessful.value = true
        transactionStatus.value = TransactionStatus(status = SUCCESSFUL)
    }

    fun getTransactionStatus(): LiveData<TransactionStatus> {
        return transactionStatus
    }

    fun getIsTransactionSuccessful(): LiveData<Boolean?>{
        return isTransactionSuccessful
    }

    fun reset() {
        isTransactionSuccessful.postValue(null)
        transactionStatus.postValue(TransactionStatus())
        subscriptionFormData = null
    }

    interface TransactionStatusListener{
        fun onTransactionPending()
        fun onTransactionFailed()
        fun onTransactionSuccessful()
    }


}