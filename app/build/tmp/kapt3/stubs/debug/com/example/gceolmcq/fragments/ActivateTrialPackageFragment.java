package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \'2\u00020\u0001:\u0003\'()B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activateBtn", "Landroid/widget/Button;", "onActivateTrialButtonClickListener", "Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment$OnActivateTrialButtonClickListener;", "onSubjectsPackagesAvailableListener", "Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment$OnSubjectsPackagesAvailableListener;", "packageDurationTV", "Landroid/widget/TextView;", "subjects", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subjectsAvailableTv", "viewModel", "Lcom/example/gceolmcq/viewmodels/ActivateTrialPackageFragmentViewModel;", "initViewModel", "", "initViews", "view", "Landroid/view/View;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "setRepository", "setSubjects", "setViewObservers", "setupViewsListeners", "Companion", "OnActivateTrialButtonClickListener", "OnSubjectsPackagesAvailableListener", "app_debug"})
public final class ActivateTrialPackageFragment extends androidx.fragment.app.Fragment {
    private com.example.gceolmcq.viewmodels.ActivateTrialPackageFragmentViewModel viewModel;
    private java.util.ArrayList<java.lang.String> subjects;
    private com.example.gceolmcq.fragments.ActivateTrialPackageFragment.OnSubjectsPackagesAvailableListener onSubjectsPackagesAvailableListener;
    private com.example.gceolmcq.fragments.ActivateTrialPackageFragment.OnActivateTrialButtonClickListener onActivateTrialButtonClickListener;
    private android.widget.TextView subjectsAvailableTv;
    private android.widget.TextView packageDurationTV;
    private android.widget.Button activateBtn;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.ActivateTrialPackageFragment.Companion Companion = null;
    
    public ActivateTrialPackageFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setSubjects() {
    }
    
    private final void initViewModel() {
    }
    
    private final void setRepository() {
    }
    
    private final void initViews(android.view.View view) {
    }
    
    private final void setupViewsListeners() {
    }
    
    private final void setViewObservers() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.example.gceolmcq.fragments.ActivateTrialPackageFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> subjects, @org.jetbrains.annotations.NotNull()
    java.lang.String mobileId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment$OnSubjectsPackagesAvailableListener;", "", "onSubjectsPackagesAvailable", "", "isAvailable", "", "app_debug"})
    public static abstract interface OnSubjectsPackagesAvailableListener {
        
        public abstract void onSubjectsPackagesAvailable(boolean isAvailable);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment$OnActivateTrialButtonClickListener;", "", "onActivateTrialButtonClicked", "", "app_debug"})
    public static abstract interface OnActivateTrialButtonClickListener {
        
        public abstract void onActivateTrialButtonClicked();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\u0007H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment$Companion;", "", "()V", "newInstance", "Lcom/example/gceolmcq/fragments/ActivateTrialPackageFragment;", "subjects", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mobileId", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.example.gceolmcq.fragments.ActivateTrialPackageFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> subjects, @org.jetbrains.annotations.NotNull()
        java.lang.String mobileId) {
            return null;
        }
    }
}