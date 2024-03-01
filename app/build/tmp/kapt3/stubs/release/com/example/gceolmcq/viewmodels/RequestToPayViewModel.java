package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0007J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\"\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/gceolmcq/viewmodels/RequestToPayViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isTransactionSuccessful", "Landroidx/lifecycle/MutableLiveData;", "", "momoPartner", "", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "transactionId", "transactionStatus", "ussDCode", "checkTransactionStatus", "", "token", "referenceId", "getIsTransactionSuccessful", "Landroidx/lifecycle/LiveData;", "getMomoPartner", "getPackageDuration", "", "getPackagePrice", "getPackageType", "getSubjectIndex", "getSubjectName", "getTransactionId", "getUssdCode", "requestToPay", "amountToPay", "momoNumber", "setAccessToken", "setMoMoPartner", "setSubscriptionFormData", "testUpdateTransactionSuccessful", "status", "app_release"})
public final class RequestToPayViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData;
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTransactionSuccessful;
    private androidx.lifecycle.MutableLiveData<java.lang.String> transactionId;
    private androidx.lifecycle.MutableLiveData<java.lang.String> momoPartner;
    private androidx.lifecycle.MutableLiveData<java.lang.String> ussDCode;
    private androidx.lifecycle.MutableLiveData<java.lang.String> transactionStatus;
    
    public RequestToPayViewModel() {
        super();
    }
    
    public final void setSubscriptionFormData(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
    }
    
    private final void setMoMoPartner() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPackageType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPackagePrice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTransactionSuccessful() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getMomoPartner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getUssdCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTransactionId() {
        return null;
    }
    
    public final int getSubjectIndex() {
        return 0;
    }
    
    public final int getPackageDuration() {
        return 0;
    }
    
    private final void setAccessToken() {
    }
    
    public final void requestToPay(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    java.lang.String amountToPay, @org.jetbrains.annotations.Nullable()
    java.lang.String momoNumber) {
    }
    
    public final void checkTransactionStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String referenceId) {
    }
    
    private final void testUpdateTransactionSuccessful(boolean status) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubjectName() {
        return null;
    }
}