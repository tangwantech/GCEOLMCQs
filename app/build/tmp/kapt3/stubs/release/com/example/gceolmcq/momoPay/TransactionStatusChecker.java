package com.example.gceolmcq.momoPay;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fJ\u0006\u0010\u0010\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/gceolmcq/momoPay/TransactionStatusChecker;", "", "()V", "transactionStatusChanged", "Landroidx/lifecycle/MutableLiveData;", "", "checkTransactionStatus", "", "token", "transactionId", "paymentStatus", "Lcom/example/gceolmcq/momoPay/TransactionStatusChecker$PaymentStatus;", "delayBy", "", "getTransactionStatusChanged", "Landroidx/lifecycle/LiveData;", "testPaySuccessful", "PaymentStatus", "app_release"})
public final class TransactionStatusChecker {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> transactionStatusChanged = null;
    
    public TransactionStatusChecker() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTransactionStatusChanged() {
        return null;
    }
    
    public final void testPaySuccessful() {
    }
    
    public final void checkTransactionStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String transactionId, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> transactionStatusChanged, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.momoPay.TransactionStatusChecker.PaymentStatus paymentStatus, long delayBy) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/momoPay/TransactionStatusChecker$PaymentStatus;", "", "onPaymentFailed", "", "onPaymentStatusChanged", "status", "", "app_release"})
    public static abstract interface PaymentStatus {
        
        public abstract void onPaymentStatusChanged(@org.jetbrains.annotations.NotNull()
        java.lang.String status);
        
        public abstract void onPaymentFailed();
    }
}