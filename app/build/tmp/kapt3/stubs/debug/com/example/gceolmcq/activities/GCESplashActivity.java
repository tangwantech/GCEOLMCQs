package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/gceolmcq/activities/GCESplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "SERVER_RETRY_LIMIT", "", "initializingAppDialog", "Landroidx/appcompat/app/AlertDialog;", "pref", "Landroid/content/SharedPreferences;", "termsOfServiceDialog", "viewModel", "Lcom/example/gceolmcq/viewmodels/SplashActivityViewModel;", "cancelInitializingAppDialog", "", "checkIsTermsOfServiceAccepted", "checkRetryCount", "decrementServerRetryCount", "displayInitializingAppDialog", "displayInternetConnectionDialog", "displayServerTimeOutDialog", "displayTermsOfServiceDialog", "getJsonFromAssets", "", "getMobileID", "gotoMainActivity", "gotoTermsOfServiceActivity", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "resetServerRetryCount", "saveTermsOfServiceAcceptedStatus", "state", "", "setServerRetryCount", "setupObservers", "setupViewModel", "syncSubjectsPackages", "app_debug"})
public final class GCESplashActivity extends androidx.appcompat.app.AppCompatActivity {
    private final int SERVER_RETRY_LIMIT = 2;
    private com.example.gceolmcq.viewmodels.SplashActivityViewModel viewModel;
    private android.content.SharedPreferences pref;
    private androidx.appcompat.app.AlertDialog termsOfServiceDialog;
    private androidx.appcompat.app.AlertDialog initializingAppDialog;
    
    public GCESplashActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewModel() {
    }
    
    private final void setupObservers() {
    }
    
    private final void checkRetryCount() {
    }
    
    private final void setServerRetryCount() {
    }
    
    private final void decrementServerRetryCount() {
    }
    
    private final void resetServerRetryCount() {
    }
    
    private final void checkIsTermsOfServiceAccepted() {
    }
    
    private final void displayInternetConnectionDialog() {
    }
    
    private final void displayTermsOfServiceDialog() {
    }
    
    private final void gotoTermsOfServiceActivity() {
    }
    
    private final void displayInitializingAppDialog() {
    }
    
    private final void displayServerTimeOutDialog() {
    }
    
    private final void cancelInitializingAppDialog() {
    }
    
    private final void gotoMainActivity() {
    }
    
    private final java.lang.String getJsonFromAssets() {
        return null;
    }
    
    private final void saveTermsOfServiceAcceptedStatus(boolean state) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    public final java.lang.String getMobileID() {
        return null;
    }
    
    private final void syncSubjectsPackages() {
    }
}