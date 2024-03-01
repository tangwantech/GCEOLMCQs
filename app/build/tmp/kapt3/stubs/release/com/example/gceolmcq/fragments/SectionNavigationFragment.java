package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\u001a\u0010\'\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u0016H\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/gceolmcq/fragments/SectionNavigationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "fadeInOut", "Landroid/view/animation/Animation;", "onRecyclerItemClickListener", "Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$OnRecyclerItemClickListener;", "paperGradeLayout", "Landroid/widget/LinearLayout;", "restartPaperBtn", "Landroid/widget/Button;", "rvSectionNav", "Landroidx/recyclerview/widget/RecyclerView;", "sectionNavigationRecyclerViewAdapter", "Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter;", "tvPaperGrade", "Landroid/widget/TextView;", "tvScore", "tvSectionsAnswered", "viewModel", "Lcom/example/gceolmcq/viewmodels/SectionNavigationFragmentViewModel;", "displayRestartDialog", "", "initHelperListeners", "context", "Landroid/content/Context;", "initViews", "view", "Landroid/view/View;", "onAttach", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", "resetPaperRepository", "setupAdapters", "setupViewListeners", "setupViewModel", "setupViewObservers", "Companion", "app_release"})
public final class SectionNavigationFragment extends androidx.fragment.app.Fragment {
    private com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener onRecyclerItemClickListener;
    private com.example.gceolmcq.viewmodels.SectionNavigationFragmentViewModel viewModel;
    private android.widget.TextView tvSectionsAnswered;
    private android.widget.TextView tvScore;
    private android.widget.TextView tvPaperGrade;
    private android.widget.LinearLayout paperGradeLayout;
    private androidx.recyclerview.widget.RecyclerView rvSectionNav;
    private android.widget.Button restartPaperBtn;
    private com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter sectionNavigationRecyclerViewAdapter;
    private android.view.animation.Animation fadeInOut;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.SectionNavigationFragment.Companion Companion = null;
    
    public SectionNavigationFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initHelperListeners(android.content.Context context) {
    }
    
    private final void initViews(android.view.View view) {
    }
    
    private final void setupViewModel() {
    }
    
    private final void setupAdapters() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setupViewObservers() {
    }
    
    private final void setupViewListeners() {
    }
    
    private final void resetPaperRepository() {
    }
    
    private final void displayRestartDialog() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/gceolmcq/fragments/SectionNavigationFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "app_release"})
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