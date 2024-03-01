package com.example.gceolmcq.momoPay;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tJ.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/gceolmcq/momoPay/RequestToPay;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isTransactionIdAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "getIsTransactionIdAvailable", "Landroidx/lifecycle/LiveData;", "pay", "", "token", "", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "transactionId", "transactionIdStatus", "Lcom/example/gceolmcq/momoPay/RequestToPay$TransactionIdStatus;", "TransactionIdStatus", "app_debug"})
public final class RequestToPay {
    private final android.content.Context context = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTransactionIdAvailable = null;
    
    public RequestToPay(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void pay(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> transactionId, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.momoPay.RequestToPay.TransactionIdStatus transactionIdStatus) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTransactionIdAvailable() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/momoPay/RequestToPay$TransactionIdStatus;", "", "onTransactionIdAvailable", "", "transactionId", "", "onTransactionIdFailed", "app_debug"})
    public static abstract interface TransactionIdStatus {
        
        public abstract void onTransactionIdAvailable(@org.jetbrains.annotations.NotNull()
        java.lang.String transactionId);
        
        public abstract void onTransactionIdFailed();
    }
}