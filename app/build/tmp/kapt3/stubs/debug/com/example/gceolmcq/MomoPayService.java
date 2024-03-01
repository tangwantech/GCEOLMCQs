package com.example.gceolmcq;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ*\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0013J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/gceolmcq/MomoPayService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_isPaymentSystemAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "client", "Lokhttp3/OkHttpClient;", "isPaymentSystemAvailable", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isTransactionSuccessful", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "transactionStatus", "Lcom/example/gceolmcq/datamodels/TransactionStatus;", "checkTransactionStatus", "", "transaction", "transactionStatusListener", "Lcom/example/gceolmcq/MomoPayService$TransactionStatusListener;", "generateAccessToken", "initiatePayment", "tokenTransactionIdBundle", "Landroid/os/Bundle;", "requestToPay", "amountToPay", "", "momoNumber", "reset", "testUpdateTransactionSuccessful", "Companion", "TransactionStatusListener", "app_debug"})
public final class MomoPayService {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.MomoPayService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REFERENCE_ID = "reference";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOKEN = "token";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS = "status";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PENDING = "PENDING";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUCCESSFUL = "SUCCESSFUL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FAILED = "FAILED";
    private final okhttp3.OkHttpClient client = null;
    private com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData;
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTransactionSuccessful;
    private androidx.lifecycle.MutableLiveData<com.example.gceolmcq.datamodels.TransactionStatus> transactionStatus;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isPaymentSystemAvailable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isPaymentSystemAvailable = null;
    
    public MomoPayService(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isPaymentSystemAvailable() {
        return null;
    }
    
    public final void initiatePayment(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.MomoPayService.TransactionStatusListener transactionStatusListener, @org.jetbrains.annotations.Nullable()
    android.os.Bundle tokenTransactionIdBundle) {
    }
    
    private final void generateAccessToken(com.example.gceolmcq.MomoPayService.TransactionStatusListener transactionStatusListener) {
    }
    
    public final void requestToPay(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.TransactionStatus transaction, @org.jetbrains.annotations.Nullable()
    java.lang.String amountToPay, @org.jetbrains.annotations.Nullable()
    java.lang.String momoNumber, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.MomoPayService.TransactionStatusListener transactionStatusListener) {
    }
    
    public final void checkTransactionStatus(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.TransactionStatus transaction, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.MomoPayService.TransactionStatusListener transactionStatusListener) {
    }
    
    private final void testUpdateTransactionSuccessful(com.example.gceolmcq.MomoPayService.TransactionStatusListener transactionStatusListener) {
    }
    
    public final void reset() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/gceolmcq/MomoPayService$TransactionStatusListener;", "", "onTransactionFailed", "", "onTransactionIdAvailable", "transactionId", "", "onTransactionPending", "onTransactionSuccessful", "onTransactionTokenAvailable", "token", "app_debug"})
    public static abstract interface TransactionStatusListener {
        
        public abstract void onTransactionTokenAvailable(@org.jetbrains.annotations.Nullable()
        java.lang.String token);
        
        public abstract void onTransactionIdAvailable(@org.jetbrains.annotations.Nullable()
        java.lang.String transactionId);
        
        public abstract void onTransactionPending();
        
        public abstract void onTransactionFailed();
        
        public abstract void onTransactionSuccessful();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/gceolmcq/MomoPayService$Companion;", "", "()V", "FAILED", "", "PENDING", "REFERENCE_ID", "STATUS", "SUCCESSFUL", "TOKEN", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}