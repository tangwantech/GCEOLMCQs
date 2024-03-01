package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000bB\u0005\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010\'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001bH\u0017J\b\u0010+\u001a\u00020)H\u0016J\u0012\u0010,\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\"04H\u0016J\b\u00105\u001a\u00020\"H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020)07H\u0016J\u0018\u00108\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\"H\u0016J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J\b\u0010A\u001a\u00020\u001bH\u0014J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010C\u001a\u00020\u001bH\u0016J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010E\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"H\u0016J\u0018\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\"H\u0002J\b\u0010J\u001a\u00020\u001bH\u0002J\b\u0010K\u001a\u00020\u001bH\u0002J\b\u0010L\u001a\u00020\u001bH\u0002J\u0010\u0010M\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0002J\b\u0010N\u001a\u00020\u001bH\u0016J\b\u0010O\u001a\u00020\u001bH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006P"}, d2 = {"Lcom/example/gceolmcq/activities/PaperActivity;", "Lcom/example/gceolmcq/activities/SubscriptionActivity;", "Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$OnRecyclerItemClickListener;", "Lcom/example/gceolmcq/activities/OnCheckPackageExpiredListener;", "Lcom/example/gceolmcq/activities/OnRetrySectionListener;", "Lcom/example/gceolmcq/activities/OnNextSectionListener;", "Lcom/example/gceolmcq/activities/OnGetNumberOfSectionsListener;", "Lcom/example/gceolmcq/activities/OnGotoSectionCorrectionListener;", "Lcom/example/gceolmcq/activities/OnRequestToGoToResultListener;", "Lcom/example/gceolmcq/activities/OnPaperScoreListener;", "Lcom/example/gceolmcq/activities/OnIsSectionAnsweredListener;", "Lcom/example/gceolmcq/adapters/SectionRecyclerAdapter$ExplanationClickListener;", "()V", "_viewModel", "Lcom/example/gceolmcq/viewmodels/PaperActivityViewModel;", "checkBox", "Landroid/widget/CheckBox;", "currentSectionFragment", "Landroidx/fragment/app/Fragment;", "paperDataJsonString", "", "pref", "Landroid/content/SharedPreferences;", "subjectName", "tvInstruction", "Landroid/widget/TextView;", "displayPaperInstructionDialog", "", "finish", "gotoResult", "sectionResultData", "Lcom/example/gceolmcq/datamodels/SectionResultData;", "gotoSection", "sectionIndex", "", "gotoSectionCorrection", "userMarkedAnswersSheetData", "Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;", "gotoSectionNavigationFragment", "loadFragment", "onAllSectionsAnswered", "", "onBackPressed", "onCheckPackageExpired", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDecrementCurrentSectionRetryCount", "onExplanationClicked", "questionData", "Lcom/example/gceolmcq/datamodels/QuestionWithUserAnswerMarkedData;", "onGetCurrentSectionRetryCount", "Landroidx/lifecycle/LiveData;", "onGetNumberOfSections", "onGetSectionsAnswered", "", "onGotoSectionCorrection", "onNextSection", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRecyclerItemClick", "position", "onRequestToGoToResult", "onResetCurrentSectionRetryCount", "onResume", "onRetrySection", "onShowPackageExpiredDialog", "onUpdateIsSectionAnswered", "onUpdatePaperScore", "numberOfCorrectAnswers", "replaceFragment", "fragment", "fragmentIndex", "resetCurrentSectionFragment", "resetPaperRepository", "setupViewModel", "showExplanationDialog", "showPackageActivatedDialog", "showPackageExpiredDialog", "app_release"})
public final class PaperActivity extends com.example.gceolmcq.activities.SubscriptionActivity implements com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener, com.example.gceolmcq.activities.OnCheckPackageExpiredListener, com.example.gceolmcq.activities.OnRetrySectionListener, com.example.gceolmcq.activities.OnNextSectionListener, com.example.gceolmcq.activities.OnGetNumberOfSectionsListener, com.example.gceolmcq.activities.OnGotoSectionCorrectionListener, com.example.gceolmcq.activities.OnRequestToGoToResultListener, com.example.gceolmcq.activities.OnPaperScoreListener, com.example.gceolmcq.activities.OnIsSectionAnsweredListener, com.example.gceolmcq.adapters.SectionRecyclerAdapter.ExplanationClickListener {
    private com.example.gceolmcq.viewmodels.PaperActivityViewModel _viewModel;
    private android.content.SharedPreferences pref;
    private android.widget.CheckBox checkBox;
    private android.widget.TextView tvInstruction;
    private androidx.fragment.app.Fragment currentSectionFragment;
    private java.lang.String subjectName;
    private java.lang.String paperDataJsonString;
    
    public PaperActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewModel() {
    }
    
    private final void gotoSectionNavigationFragment() {
    }
    
    private final void gotoSection(int sectionIndex) {
    }
    
    private final void gotoResult(com.example.gceolmcq.datamodels.SectionResultData sectionResultData) {
    }
    
    private final void gotoSectionCorrection(int sectionIndex, com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheetData) {
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragment, int fragmentIndex) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void loadFragment() {
    }
    
    private final void resetCurrentSectionFragment() {
    }
    
    @java.lang.Override()
    public void onRecyclerItemClick(int position) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void finish() {
    }
    
    private final void resetPaperRepository() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestToGoToResult(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SectionResultData sectionResultData) {
    }
    
    @java.lang.Override()
    public void onRetrySection(int sectionIndex) {
    }
    
    @java.lang.Override()
    public void onNextSection(int sectionIndex) {
    }
    
    @java.lang.Override()
    public int onGetNumberOfSections() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean onAllSectionsAnswered() {
        return false;
    }
    
    @java.lang.Override()
    public void onGotoSectionCorrection(int sectionIndex, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheetData) {
    }
    
    @java.lang.Override()
    public void onUpdatePaperScore(int sectionIndex, int numberOfCorrectAnswers) {
    }
    
    @java.lang.Override()
    public void onUpdateIsSectionAnswered(int sectionIndex) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<java.lang.Boolean> onGetSectionsAnswered() {
        return null;
    }
    
    @java.lang.Override()
    public void showPackageExpiredDialog() {
    }
    
    @java.lang.Override()
    public void showPackageActivatedDialog() {
    }
    
    @java.lang.Override()
    public void onDecrementCurrentSectionRetryCount() {
    }
    
    @java.lang.Override()
    public void onResetCurrentSectionRetryCount() {
    }
    
    @java.lang.Override()
    public boolean onCheckPackageExpired() {
        return false;
    }
    
    @java.lang.Override()
    public void onShowPackageExpiredDialog() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.lang.Integer> onGetCurrentSectionRetryCount() {
        return null;
    }
    
    private final void displayPaperInstructionDialog() {
    }
    
    private final void showExplanationDialog(com.example.gceolmcq.datamodels.QuestionWithUserAnswerMarkedData questionData) {
    }
    
    @java.lang.Override()
    public void onExplanationClicked(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.QuestionWithUserAnswerMarkedData questionData) {
    }
}