package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140%J\u0006\u0010&\u001a\u00020\'J\b\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0006H\u0007J\u0006\u0010-\u001a\u00020\'J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006J\u0012\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010)H\u0014J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u0012H\u0016J\u0012\u00105\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020\u0012H\u0002J\b\u0010<\u001a\u00020\u0012H\u0002J\u0012\u0010=\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010)H\u0002J\b\u0010>\u001a\u00020\u0012H\u0002J\u0016\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\'J\b\u0010A\u001a\u00020\u0012H\u0002J\b\u0010B\u001a\u00020\u0012H\u0002J\b\u0010C\u001a\u00020\u0012H\u0002J\u0006\u0010D\u001a\u00020\u0012J\b\u0010E\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020\u0012H\u0016J\b\u0010G\u001a\u00020\u0012H\u0002J\b\u0010H\u001a\u00020\u0012H\u0002J\b\u0010I\u001a\u00020\u0012H\u0002J\"\u0010J\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000107H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\"\u0010L\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010)2\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020+H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/example/gceolmcq/activities/SubscriptionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/gceolmcq/fragments/SubscriptionFormDialogFragment$SubscriptionFormButtonClickListener;", "Lcom/example/gceolmcq/fragments/PackagesDialogFragment$PackageDialogListener;", "()V", "SUBCRIPTION_ACTIVITY", "", "activatingPackageDialog", "Landroidx/appcompat/app/AlertDialog;", "activatingTrialPackageDialog", "failedToActivatePackageDialog", "packageActivatedDialog", "paymentReceivedDialog", "processingAlertDialog", "requestToPayDialog", "viewModel", "Lcom/example/gceolmcq/viewmodels/SubscriptionActivityViewModel;", "activateTrialPackage", "", "position", "", "subjectName", "activateUserPackage", "cancelActivatingPackageDialog", "cancelFailedToActivateDialog", "cancelPaymentReceivedDialog", "cancelProcessingAndRequestToPayDialogs", "cancelProcessingRequestDialog", "cancelRequestToPayDialog", "dismissActivatingTrialPackageDialog", "displayEnterMomoNumberDialog", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "displayInvoice", "subscriptionData", "displayPackagesDialog", "getActivatedPackageIndex", "Landroidx/lifecycle/LiveData;", "getActivatedSubjectPackageData", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "getCurrentTransactionFromSharedPref", "Landroid/os/Bundle;", "getIsPackageActive", "", "getMobileID", "getSubjectPackageData", "loadSubjectPackageDataFromLocalDbWhere", "onCreate", "savedInstanceState", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPackageDialogCancelButtonClicked", "onPackageDialogNextButtonClicked", "packageData", "Lcom/example/gceolmcq/datamodels/PackageData;", "onSubscriptionFormNextButtonClicked", "paymentBackup", "bundle", "resetMomoPayService", "resumeTransaction", "setCurrentTransactionSharedPref", "setMomoPayFlow", "setSubjectPackageDataToActivate", "subjectPackageData", "setupViewModel", "setupViewObservers", "showActivatingPackageDialog", "showActivatingTrialPackageDialog", "showPackageActivatedDialog", "showPackageExpiredDialog", "showPaymentReceivedDialog", "showProcessingRequestDialog", "showRequestUserToPayDialog", "showSubscriptionForm", "showTransactionFailedDialog", "updateCurrentTransactionSharedPref", "transactionStatus", "isPackageActive", "app_debug"})
public abstract class SubscriptionActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.gceolmcq.fragments.SubscriptionFormDialogFragment.SubscriptionFormButtonClickListener, com.example.gceolmcq.fragments.PackagesDialogFragment.PackageDialogListener {
    private final java.lang.String SUBCRIPTION_ACTIVITY = "subscriptionActivity";
    private androidx.appcompat.app.AlertDialog processingAlertDialog;
    private androidx.appcompat.app.AlertDialog requestToPayDialog;
    private androidx.appcompat.app.AlertDialog failedToActivatePackageDialog;
    private androidx.appcompat.app.AlertDialog activatingPackageDialog;
    private androidx.appcompat.app.AlertDialog packageActivatedDialog;
    private androidx.appcompat.app.AlertDialog paymentReceivedDialog;
    private androidx.appcompat.app.AlertDialog activatingTrialPackageDialog;
    private com.example.gceolmcq.viewmodels.SubscriptionActivityViewModel viewModel;
    
    public SubscriptionActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setupViewModel() {
    }
    
    private final void setupViewObservers() {
    }
    
    private final void setMomoPayFlow() {
    }
    
    public void showPackageExpiredDialog() {
    }
    
    private final void showProcessingRequestDialog() {
    }
    
    private final void cancelProcessingRequestDialog() {
    }
    
    private final void showActivatingPackageDialog() {
    }
    
    private final void cancelActivatingPackageDialog() {
    }
    
    private final void showSubscriptionForm(int position, java.lang.String subjectName, com.example.gceolmcq.datamodels.PackageData packageData) {
    }
    
    private final void showRequestUserToPayDialog() {
    }
    
    private final void cancelRequestToPayDialog() {
    }
    
    private final void cancelProcessingAndRequestToPayDialogs() {
    }
    
    public void showPackageActivatedDialog() {
    }
    
    private final void showTransactionFailedDialog() {
    }
    
    private final void cancelFailedToActivateDialog() {
    }
    
    private final void showPaymentReceivedDialog() {
    }
    
    private final void cancelPaymentReceivedDialog() {
    }
    
    public final void showActivatingTrialPackageDialog() {
    }
    
    public final void dismissActivatingTrialPackageDialog() {
    }
    
    private final void displayInvoice(com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionData) {
    }
    
    private final void displayPackagesDialog() {
    }
    
    private final void displayEnterMomoNumberDialog(com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
    }
    
    private final void activateUserPackage() {
    }
    
    public final void activateTrialPackage(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String subjectName) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getActivatedPackageIndex() {
        return null;
    }
    
    @java.lang.Override()
    public void onSubscriptionFormNextButtonClicked(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
    }
    
    private final void resetMomoPayService() {
    }
    
    public final void setSubjectPackageDataToActivate(int position, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubjectPackageData getActivatedSubjectPackageData() {
        return null;
    }
    
    public final void loadSubjectPackageDataFromLocalDbWhere(@org.jetbrains.annotations.NotNull()
    java.lang.String subjectName) {
    }
    
    public final boolean getIsPackageActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubjectPackageData getSubjectPackageData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    public final java.lang.String getMobileID() {
        return null;
    }
    
    private final void setCurrentTransactionSharedPref(android.os.Bundle bundle) {
    }
    
    private final void updateCurrentTransactionSharedPref(android.os.Bundle bundle, java.lang.String transactionStatus, boolean isPackageActive) {
    }
    
    private final android.os.Bundle getCurrentTransactionFromSharedPref() {
        return null;
    }
    
    private final void paymentBackup(android.os.Bundle bundle) {
    }
    
    private final void resumeTransaction() {
    }
    
    @java.lang.Override()
    public void onPackageDialogNextButtonClicked(@org.jetbrains.annotations.Nullable()
    com.example.gceolmcq.datamodels.PackageData packageData) {
    }
    
    @java.lang.Override()
    public void onPackageDialogCancelButtonClicked() {
    }
}