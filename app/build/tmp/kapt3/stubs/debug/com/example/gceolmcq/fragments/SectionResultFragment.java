package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\'\u001a\u00020\u0018H\u0016J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/example/gceolmcq/fragments/SectionResultFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnCorrection", "Landroid/widget/Button;", "btnNextSection", "btnRetry", "onCheckPackageExpiredListener", "Lcom/example/gceolmcq/activities/OnCheckPackageExpiredListener;", "onGetNumberOfSectionsListener", "Lcom/example/gceolmcq/activities/OnGetNumberOfSectionsListener;", "onGotoSectionCorrectionListener", "Lcom/example/gceolmcq/activities/OnGotoSectionCorrectionListener;", "onIsSectionAnsweredListener", "Lcom/example/gceolmcq/activities/OnIsSectionAnsweredListener;", "onNextSectionListener", "Lcom/example/gceolmcq/activities/OnNextSectionListener;", "onPaperScoreListener", "Lcom/example/gceolmcq/activities/OnPaperScoreListener;", "onRetrySectionListener", "Lcom/example/gceolmcq/activities/OnRetrySectionListener;", "sectionResultFragmentViewModel", "Lcom/example/gceolmcq/viewmodels/SectionResultFragmentViewModel;", "initViewModel", "", "initViews", "view", "Landroid/view/View;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", "retryDialog", "sectionIndex", "", "retrySection", "setupViewListeners", "setupViewObservers", "updateNextBtnState", "Companion", "app_debug"})
public final class SectionResultFragment extends androidx.fragment.app.Fragment {
    private com.example.gceolmcq.viewmodels.SectionResultFragmentViewModel sectionResultFragmentViewModel;
    private com.example.gceolmcq.activities.OnRetrySectionListener onRetrySectionListener;
    private com.example.gceolmcq.activities.OnGetNumberOfSectionsListener onGetNumberOfSectionsListener;
    private com.example.gceolmcq.activities.OnNextSectionListener onNextSectionListener;
    private com.example.gceolmcq.activities.OnGotoSectionCorrectionListener onGotoSectionCorrectionListener;
    private com.example.gceolmcq.activities.OnIsSectionAnsweredListener onIsSectionAnsweredListener;
    private com.example.gceolmcq.activities.OnPaperScoreListener onPaperScoreListener;
    private com.example.gceolmcq.activities.OnCheckPackageExpiredListener onCheckPackageExpiredListener;
    private android.widget.Button btnRetry;
    private android.widget.Button btnNextSection;
    private android.widget.Button btnCorrection;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.SectionResultFragment.Companion Companion = null;
    
    public SectionResultFragment() {
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
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateNextBtnState() {
    }
    
    private final void initViewModel() {
    }
    
    private final void initViews(android.view.View view) {
    }
    
    private final void retrySection() {
    }
    
    private final void setupViewListeners() {
    }
    
    private final void setupViewObservers() {
    }
    
    private final void retryDialog(int sectionIndex) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/gceolmcq/fragments/SectionResultFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "sectionResultData", "Lcom/example/gceolmcq/datamodels/SectionResultData;", "expiresOn", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.Fragment newInstance(@org.jetbrains.annotations.NotNull()
        com.example.gceolmcq.datamodels.SectionResultData sectionResultData, @org.jetbrains.annotations.NotNull()
        java.lang.String expiresOn) {
            return null;
        }
    }
}