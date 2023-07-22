package com.example.gceolmcq

import android.content.Context
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException
import net.compay.android.CamPay
import net.compay.android.models.requests.CollectionRequest
import java.util.*
import java.util.concurrent.TimeUnit

class MomoPay2{
//    val camPay = CamPay.getInstance()
    private var camPay: CamPay = CamPay.getInstance()

    fun requestToPay(){
        camPay.collect(
            CollectionRequest.CollectionRequestBuilder
                .aCollectionRequest()
                .withAmount("50")
                .withFrom("237676307742")
                .withDescription("some reason")
                .withExternalReference(UUID.randomUUID().toString())
                .withCurrency("XAF")
                .build()
        ).delay(10, TimeUnit.SECONDS) // delay for a minute before checking the transaction status
            .switchMap { collectResponse ->
                println(collectResponse)
                return@switchMap camPay.transactionStatus(collectResponse.reference) //  check the transaction status
            }.subscribe { transactionStatusResponse ->
                try {
                    println(transactionStatusResponse)
                }catch (e: OnErrorNotImplementedException){
                    println(e.localizedMessage)
                }

            }
    }
}