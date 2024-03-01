package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0002!\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/gceolmcq/fragments/PackagesDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter$ItemSelectListener;", "()V", "btnNext", "Landroid/widget/Button;", "packageDialogListener", "Lcom/example/gceolmcq/fragments/PackagesDialogFragment$PackageDialogListener;", "rvAdapter", "Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter;", "viewModel", "Lcom/example/gceolmcq/viewmodels/PackageDialogViewModel;", "initViewModel", "", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onItemSelected", "position", "", "isChecked", "", "onViewCreated", "view", "Landroid/view/View;", "setupRecyclerView", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "PackageDialogListener", "app_release"})
public final class PackagesDialogFragment extends androidx.fragment.app.DialogFragment implements com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter.ItemSelectListener {
    private com.example.gceolmcq.fragments.PackagesDialogFragment.PackageDialogListener packageDialogListener;
    private com.example.gceolmcq.viewmodels.PackageDialogViewModel viewModel;
    private com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter rvAdapter;
    private android.widget.Button btnNext;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.PackagesDialogFragment.Companion Companion = null;
    
    public PackagesDialogFragment() {
        super();
    }
    
    private final void initViewModel() {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView(androidx.recyclerview.widget.RecyclerView rv) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final androidx.fragment.app.DialogFragment newInstance() {
        return null;
    }
    
    @java.lang.Override()
    public void onItemSelected(int position, boolean isChecked) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/fragments/PackagesDialogFragment$PackageDialogListener;", "", "onPackageDialogCancelButtonClicked", "", "onPackageDialogNextButtonClicked", "packageData", "Lcom/example/gceolmcq/datamodels/PackageData;", "app_release"})
    public static abstract interface PackageDialogListener {
        
        public abstract void onPackageDialogNextButtonClicked(@org.jetbrains.annotations.Nullable()
        com.example.gceolmcq.datamodels.PackageData packageData);
        
        public abstract void onPackageDialogCancelButtonClicked();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/example/gceolmcq/fragments/PackagesDialogFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/DialogFragment;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final androidx.fragment.app.DialogFragment newInstance() {
            return null;
        }
    }
}