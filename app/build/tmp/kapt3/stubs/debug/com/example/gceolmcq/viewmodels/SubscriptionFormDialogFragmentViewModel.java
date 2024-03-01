package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007J\b\u0010\u001f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/gceolmcq/viewmodels/SubscriptionFormDialogFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_isSubscriptionFormFilled", "Landroidx/lifecycle/MutableLiveData;", "", "dialogTitle", "", "isSubscriptionFormFilled", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "getDialogTitle", "getSubscriptionFormData", "setMomoNumber", "", "momoNumber", "setMomoPartner", "momoPartner", "setPackageDuration", "packageDuration", "", "setPackagePrice", "packagePrice", "setPackageType", "packageName", "setSubjectPosition", "position", "updateDialogTitle", "title", "updateIsSubscriptionFormFilled", "app_debug"})
public final class SubscriptionFormDialogFragmentViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData = null;
    private java.lang.String dialogTitle = "";
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isSubscriptionFormFilled = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isSubscriptionFormFilled = null;
    
    public SubscriptionFormDialogFragmentViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isSubscriptionFormFilled() {
        return null;
    }
    
    public final void setPackageType(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
    }
    
    public final void setPackagePrice(@org.jetbrains.annotations.NotNull()
    java.lang.String packagePrice) {
    }
    
    public final void setMomoPartner(@org.jetbrains.annotations.NotNull()
    java.lang.String momoPartner) {
    }
    
    public final void setMomoNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String momoNumber) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubscriptionFormData getSubscriptionFormData() {
        return null;
    }
    
    public final void setSubjectPosition(int position) {
    }
    
    public final void updateDialogTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDialogTitle() {
        return null;
    }
    
    public final void setPackageDuration(int packageDuration) {
    }
    
    private final void updateIsSubscriptionFormFilled() {
    }
}