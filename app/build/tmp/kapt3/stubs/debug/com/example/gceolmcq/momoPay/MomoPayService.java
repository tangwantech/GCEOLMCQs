package com.example.gceolmcq.momoPay;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014J\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014J\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0014J\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0014J\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0014J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/gceolmcq/momoPay/MomoPayService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "requestToPay", "Lcom/example/gceolmcq/momoPay/RequestToPay;", "token", "Landroidx/lifecycle/MutableLiveData;", "", "tokenGenerator", "Lcom/example/gceolmcq/momoPay/TokenGenerator;", "transactionId", "transactionStatusChanged", "transactionStatusChecker", "Lcom/example/gceolmcq/momoPay/TransactionStatusChecker;", "checkTransactionStatus", "", "generateToken", "getIsTokenAvailable", "Landroidx/lifecycle/LiveData;", "", "getIsTransactionIdAvailable", "getToken", "getTransactionId", "getTransactionStatusChanged", "pay", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "testPaySuccessful", "app_debug"})
public final class MomoPayService {
    private final android.content.Context context = null;
    private final com.example.gceolmcq.momoPay.TokenGenerator tokenGenerator = null;
    private final com.example.gceolmcq.momoPay.RequestToPay requestToPay = null;
    private final com.example.gceolmcq.momoPay.TransactionStatusChecker transactionStatusChecker = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> token = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> transactionId = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> transactionStatusChanged = null;
    
    public MomoPayService(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void generateToken() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTokenAvailable() {
        return null;
    }
    
    public final void testPaySuccessful() {
    }
    
    public final void pay(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTransactionIdAvailable() {
        return null;
    }
    
    public final void checkTransactionStatus() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTransactionStatusChanged() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTransactionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getToken() {
        return null;
    }
}