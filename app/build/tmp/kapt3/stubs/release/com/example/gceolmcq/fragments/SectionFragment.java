package com.example.gceolmcq.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000203H\u0002J\b\u00107\u001a\u000203H\u0002J\u0018\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000203H\u0002J\b\u0010>\u001a\u000203H\u0002J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u00020\u0010H\u0002J\b\u0010A\u001a\u000203H\u0002J\u0010\u0010B\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0002J\b\u0010C\u001a\u000203H\u0002J\u0010\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u0002032\b\u0010H\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010I\u001a\u0002032\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J&\u0010L\u001a\u0004\u0018\u00010:2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010Q\u001a\u000203H\u0016J\u001a\u0010R\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010J\u001a\u0004\u0018\u00010KH\u0017J\b\u0010S\u001a\u000203H\u0002J\u0010\u0010T\u001a\u0002032\u0006\u0010U\u001a\u00020\u0010H\u0002J\b\u0010V\u001a\u000203H\u0002J\b\u0010W\u001a\u000203H\u0002J\b\u0010X\u001a\u000203H\u0003J\b\u0010Y\u001a\u000203H\u0002J\u0018\u0010Z\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0017j\b\u0012\u0004\u0012\u00020\u0012`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\\"}, d2 = {"Lcom/example/gceolmcq/fragments/SectionFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "btnNextQuestion", "Landroid/widget/Button;", "btnResult", "fadeInOut", "Landroid/view/animation/Animation;", "fadeScale", "fadeTransition", "imageLo", "Landroidx/cardview/widget/CardView;", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "isPositiveBtnClicked", "", "layoutOption1", "Landroid/widget/LinearLayout;", "layoutOption2", "layoutOption3", "layoutOption4", "nonSelectableOptions", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "nonSelectableOptionsLo", "onRequestToGoToResultListener", "Lcom/example/gceolmcq/activities/OnRequestToGoToResultListener;", "optionsLayouts", "questionLayout", "selectableOptions", "svQuestion", "Landroid/widget/ScrollView;", "tvCurrentQuestionNumberOfTotal", "tvFirstStatement", "tvNonSelectableOption1", "tvNonSelectableOption2", "tvNonSelectableOption3", "tvQuestion", "tvSecondStatement", "tvSelectableOption1", "tvSelectableOption2", "tvSelectableOption3", "tvSelectableOption4", "tvTimer", "twoStatementLo", "twoStatements", "viewModel", "Lcom/example/gceolmcq/viewmodels/SectionFragmentViewModel;", "animateImageLo", "", "animateNonSelectableOptionsLo", "animateQuestionLo", "animateSelectableOptionsLo", "animateTwoStatementsLo", "changeSelectedQuestionOptionBackground", "view", "Landroid/view/View;", "optionSelectedIndex", "", "disableSelectableOptions", "displayDirections", "displayDirectionsDialog", "getDirectionsCheckBoxState", "initTransitions", "initViews", "nextQuestion", "onAttach", "context", "Landroid/content/Context;", "onClick", "p0", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", "resetSelectedQuestionOptionBackground", "saveDirectionsCheckBoxState", "state", "setAnimationOnQuestionViewItems", "setupViewModel", "setupViewObservers", "startTimer", "updateOptionSelected", "Companion", "app_release"})
public final class SectionFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private com.example.gceolmcq.activities.OnRequestToGoToResultListener onRequestToGoToResultListener;
    private com.example.gceolmcq.viewmodels.SectionFragmentViewModel viewModel;
    private android.widget.ScrollView svQuestion;
    private android.widget.TextView tvTimer;
    private android.widget.TextView tvCurrentQuestionNumberOfTotal;
    private android.widget.Button btnNextQuestion;
    private android.widget.Button btnResult;
    private androidx.cardview.widget.CardView imageLo;
    private android.widget.LinearLayout twoStatementLo;
    private android.widget.LinearLayout nonSelectableOptionsLo;
    private android.widget.TextView tvQuestion;
    private android.widget.LinearLayout questionLayout;
    private androidx.appcompat.widget.AppCompatImageView imageView;
    private android.widget.TextView tvFirstStatement;
    private android.widget.TextView tvSecondStatement;
    private final java.util.ArrayList<android.widget.TextView> twoStatements = null;
    private android.widget.TextView tvNonSelectableOption1;
    private android.widget.TextView tvNonSelectableOption2;
    private android.widget.TextView tvNonSelectableOption3;
    private final java.util.ArrayList<android.widget.TextView> nonSelectableOptions = null;
    private android.widget.TextView tvSelectableOption1;
    private android.widget.TextView tvSelectableOption2;
    private android.widget.TextView tvSelectableOption3;
    private android.widget.TextView tvSelectableOption4;
    private final java.util.ArrayList<android.widget.TextView> selectableOptions = null;
    private android.widget.LinearLayout layoutOption1;
    private android.widget.LinearLayout layoutOption2;
    private android.widget.LinearLayout layoutOption3;
    private android.widget.LinearLayout layoutOption4;
    private final java.util.ArrayList<android.widget.LinearLayout> optionsLayouts = null;
    private android.view.animation.Animation fadeInOut;
    private android.view.animation.Animation fadeTransition;
    private android.view.animation.Animation fadeScale;
    private boolean isPositiveBtnClicked = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.fragments.SectionFragment.Companion Companion = null;
    
    public SectionFragment() {
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
    
    private final void displayDirections() {
    }
    
    private final void saveDirectionsCheckBoxState(boolean state) {
    }
    
    private final boolean getDirectionsCheckBoxState() {
        return false;
    }
    
    private final void initTransitions() {
    }
    
    private final void setupViewModel() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setupViewObservers() {
    }
    
    private final void startTimer() {
    }
    
    private final void nextQuestion() {
    }
    
    private final void initViews(android.view.View view) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void displayDirectionsDialog() {
    }
    
    private final void setAnimationOnQuestionViewItems() {
    }
    
    private final void animateQuestionLo() {
    }
    
    private final void animateImageLo() {
    }
    
    private final void animateTwoStatementsLo() {
    }
    
    private final void animateNonSelectableOptionsLo() {
    }
    
    private final void animateSelectableOptionsLo() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final androidx.fragment.app.Fragment newInstance(int sectionIndex, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SectionDataModel sectionData) {
        return null;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    private final void disableSelectableOptions() {
    }
    
    private final void updateOptionSelected(android.view.View view, int optionSelectedIndex) {
    }
    
    private final void changeSelectedQuestionOptionBackground(android.view.View view, int optionSelectedIndex) {
    }
    
    private final void resetSelectedQuestionOptionBackground() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/gceolmcq/fragments/SectionFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "sectionIndex", "", "sectionData", "Lcom/example/gceolmcq/datamodels/SectionDataModel;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final androidx.fragment.app.Fragment newInstance(int sectionIndex, @org.jetbrains.annotations.NotNull()
        com.example.gceolmcq.datamodels.SectionDataModel sectionData) {
            return null;
        }
    }
}