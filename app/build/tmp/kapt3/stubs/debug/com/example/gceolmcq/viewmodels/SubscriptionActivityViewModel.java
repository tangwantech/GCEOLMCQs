package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\rJ\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0010J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0010J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0\u0010J\u0006\u0010-\u001a\u00020\tJ\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000bH\u0002J\u0012\u00100\u001a\u00020#2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0007J\u000e\u00102\u001a\u00020#2\u0006\u0010&\u001a\u00020\rJ\u0006\u00103\u001a\u00020#J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\rJ\u000e\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u0017J\u0016\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020:2\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\tJ\u000e\u0010=\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000bJ\u0018\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012\u00a8\u0006E"}, d2 = {"Lcom/example/gceolmcq/viewmodels/SubscriptionActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_activatedPackageIndexChangedAt", "Landroidx/lifecycle/MutableLiveData;", "", "_currentTransaction", "Landroid/os/Bundle;", "_subjectPackageDataToActivated", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "_subscriptionData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "_transactionId", "", "_transactionStatus", "activatedPackageIndexChangedAt", "Landroidx/lifecycle/LiveData;", "getActivatedPackageIndexChangedAt", "()Landroidx/lifecycle/LiveData;", "currentTransaction", "getCurrentTransaction", "mobileId", "momoPay", "Lcom/example/gceolmcq/MomoPayService;", "repositoriesLinker", "Lcom/example/gceolmcq/repository/RepositoriesLinker;", "subjectPackageDataToActivated", "getSubjectPackageDataToActivated", "subscriptionData", "getSubscriptionData", "transactionId", "getTransactionId", "transactionStatus", "getTransactionStatus", "activateSubjectPackage", "", "activateSubjectTrialPackage", "subjectIndex", "subjectName", "checkSubjectPackageExpiry", "", "getAreSubjectsPackagesAvailable", "getIndexOfActivatedPackage", "getIsPaymentSystemAvailable", "getRemoteRepoErrorEncountered", "getSubjectPackageData", "initCurrentTransaction", "subscriptionFormData", "initiatePayment", "tokenTransactionIdBundle", "loadSubjectPackageDataFromLocalDbWhere", "restMomoPayService", "setMobileId", "mobileID", "setMomoPayService", "momoPayService", "setRepositoryLink", "context", "Landroid/content/Context;", "setSubjectPackageDataToActivate", "packageData", "setSubscriptionData", "updateActivatedPackageInRemoteRepo", "subjectPackageData", "position", "updateCurrentTransactionId", "updateCurrentTransactionStatus", "updateCurrentTransactionToken", "token", "app_debug"})
public final class SubscriptionActivityViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.MomoPayService momoPay;
    private java.lang.String mobileId;
    private final androidx.lifecycle.MutableLiveData<com.example.gceolmcq.datamodels.SubjectPackageData> _subjectPackageDataToActivated = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageDataToActivated = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _activatedPackageIndexChangedAt = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> activatedPackageIndexChangedAt = null;
    private final androidx.lifecycle.MutableLiveData<com.example.gceolmcq.datamodels.SubscriptionFormData> _subscriptionData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.gceolmcq.datamodels.SubscriptionFormData> subscriptionData = null;
    private com.example.gceolmcq.repository.RepositoriesLinker repositoriesLinker;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _transactionStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> transactionStatus = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _transactionId = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> transactionId = null;
    private final androidx.lifecycle.MutableLiveData<android.os.Bundle> _currentTransaction = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<android.os.Bundle> currentTransaction = null;
    
    public SubscriptionActivityViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.gceolmcq.datamodels.SubjectPackageData> getSubjectPackageDataToActivated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getActivatedPackageIndexChangedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.gceolmcq.datamodels.SubscriptionFormData> getSubscriptionData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTransactionStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTransactionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<android.os.Bundle> getCurrentTransaction() {
        return null;
    }
    
    public final void setSubjectPackageDataToActivate(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubjectPackageData packageData) {
    }
    
    public final void setRepositoryLink(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String mobileId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getAreSubjectsPackagesAvailable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getIndexOfActivatedPackage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getRemoteRepoErrorEncountered() {
        return null;
    }
    
    public final void setMomoPayService(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.MomoPayService momoPayService) {
    }
    
    public final void setMobileId(@org.jetbrains.annotations.NotNull()
    java.lang.String mobileID) {
    }
    
    public final void setSubscriptionData(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
    }
    
    private final void initCurrentTransaction(com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
    }
    
    private final void updateCurrentTransactionToken(java.lang.String token) {
    }
    
    private final void updateCurrentTransactionId(java.lang.String transactionId) {
    }
    
    private final void updateCurrentTransactionStatus(java.lang.String transactionStatus) {
    }
    
    public final void activateSubjectPackage() {
    }
    
    public final void activateSubjectTrialPackage(int subjectIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String subjectName) {
    }
    
    public final void initiatePayment(@org.jetbrains.annotations.Nullable()
    android.os.Bundle tokenTransactionIdBundle) {
    }
    
    public final void restMomoPayService() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsPaymentSystemAvailable() {
        return null;
    }
    
    private final void updateActivatedPackageInRemoteRepo(com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData, int position) {
    }
    
    public final void loadSubjectPackageDataFromLocalDbWhere(@org.jetbrains.annotations.NotNull()
    java.lang.String subjectName) {
    }
    
    public final boolean checkSubjectPackageExpiry() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubjectPackageData getSubjectPackageData() {
        return null;
    }
}