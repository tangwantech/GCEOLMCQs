package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/gceolmcq/fragments/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "homeFragmentViewModel", "Lcom/example/gceolmcq/viewmodels/HomeFragmentViewModel;", "homeRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "homeRecyclerViewAdapter", "Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter;", "onActivateTrialButtonClickListener", "Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnActivateTrialButtonClickListener;", "onHomeRecyclerItemClickListener", "Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnHomeRecyclerItemClickListener;", "onPackageActivatedListener", "Lcom/example/gceolmcq/fragments/HomeFragment$OnPackageActivatedListener;", "initHomeFragmentViews", "", "view", "Landroid/view/View;", "initViewModel", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "setupHomeFragmentAdapter", "setupHomeFragmentRecyclerView", "setupHomeFragmentViewObservers", "Companion", "OnPackageActivatedListener", "app_release"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView homeRecyclerView;
    private com.example.gceolmcq.viewmodels.HomeFragmentViewModel homeFragmentViewModel;
    private com.example.gceolmcq.fragments.HomeFragment.OnPackageActivatedListener onPackageActivatedListener;
    private com.example.gceolmcq.adapters.HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener onHomeRecyclerItemClickListener;
    private com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.OnActivateTrialButtonClickListener onActivateTrialButtonClickListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.HomeFragment.Companion Companion = null;
    
    public HomeFragment() {
        super();
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
    
    private final void initViewModel() {
    }
    
    private final void initHomeFragmentViews(android.view.View view) {
    }
    
    private final void setupHomeFragmentAdapter() {
    }
    
    private final void setupHomeFragmentRecyclerView() {
    }
    
    private final void setupHomeFragmentViewObservers() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/gceolmcq/fragments/HomeFragment$OnPackageActivatedListener;", "", "onPackageActivated", "Landroidx/lifecycle/LiveData;", "", "app_release"})
    public static abstract interface OnPackageActivatedListener {
        
        @org.jetbrains.annotations.NotNull()
        public abstract androidx.lifecycle.LiveData<java.lang.Integer> onPackageActivated();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/gceolmcq/fragments/HomeFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.Fragment newInstance() {
            return null;
        }
    }
}