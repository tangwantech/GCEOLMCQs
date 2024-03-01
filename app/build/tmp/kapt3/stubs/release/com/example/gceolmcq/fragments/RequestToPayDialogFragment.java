package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/gceolmcq/fragments/RequestToPayDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "onRequestToPayTransactionStatusListener", "Lcom/example/gceolmcq/fragments/RequestToPayDialogFragment$RequestToPayTransactionStatusListener;", "requestToPayViewModel", "Lcom/example/gceolmcq/viewmodels/RequestToPayViewModel;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "Companion", "RequestToPayTransactionStatusListener", "app_release"})
public final class RequestToPayDialogFragment extends androidx.fragment.app.DialogFragment {
    private com.example.gceolmcq.viewmodels.RequestToPayViewModel requestToPayViewModel;
    private com.example.gceolmcq.fragments.RequestToPayDialogFragment.RequestToPayTransactionStatusListener onRequestToPayTransactionStatusListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.RequestToPayDialogFragment.Companion Companion = null;
    
    public RequestToPayDialogFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/gceolmcq/fragments/RequestToPayDialogFragment$RequestToPayTransactionStatusListener;", "", "onTransactionFailed", "", "packageType", "", "onTransactionSuccessful", "subjectIndex", "", "packageDuration", "app_release"})
    public static abstract interface RequestToPayTransactionStatusListener {
        
        public abstract void onTransactionSuccessful(int subjectIndex, @org.jetbrains.annotations.NotNull()
        java.lang.String packageType, int packageDuration);
        
        public abstract void onTransactionFailed(@org.jetbrains.annotations.NotNull()
        java.lang.String packageType);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/fragments/RequestToPayDialogFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/DialogFragment;", "subscriptionFormData", "Lcom/example/gceolmcq/datamodels/SubscriptionFormData;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.DialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.example.gceolmcq.datamodels.SubscriptionFormData subscriptionFormData) {
            return null;
        }
    }
}