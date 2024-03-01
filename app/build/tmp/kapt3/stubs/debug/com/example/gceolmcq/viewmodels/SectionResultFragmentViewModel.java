package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0012J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/gceolmcq/viewmodels/SectionResultFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_nextButtonState", "Landroidx/lifecycle/MutableLiveData;", "", "correctionData", "Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;", "hasPerfectScore", "nextButtonState", "Landroidx/lifecycle/LiveData;", "getNextButtonState", "()Landroidx/lifecycle/LiveData;", "nextSectionIndex", "", "sectionResultData", "Lcom/example/gceolmcq/datamodels/SectionResultData;", "checkForPerfectScore", "", "getHasPerfectScore", "getNextSectionIndex", "getNumberOfCorrectAnswers", "getNumberOfQuestions", "getQuestionsWithCorrectAnswer", "getScorePercentage", "getSectionIndex", "getUserMarkedAnswersSheet", "setResultData", "updateNextBtnState", "updateSectionAnsweredAt", "sectionIndex", "updateSectionScoreAt", "sectionScore", "app_debug"})
public final class SectionResultFragmentViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.datamodels.SectionResultData sectionResultData;
    private com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData correctionData;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> hasPerfectScore = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _nextButtonState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> nextButtonState = null;
    private int nextSectionIndex = 0;
    
    public SectionResultFragmentViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getNextButtonState() {
        return null;
    }
    
    public final void updateNextBtnState() {
    }
    
    public final int getNextSectionIndex() {
        return 0;
    }
    
    public final void setResultData(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SectionResultData sectionResultData) {
    }
    
    public final int getNumberOfCorrectAnswers() {
        return 0;
    }
    
    public final int getNumberOfQuestions() {
        return 0;
    }
    
    public final int getScorePercentage() {
        return 0;
    }
    
    private final void updateSectionScoreAt(int sectionIndex, int sectionScore) {
    }
    
    private final void updateSectionAnsweredAt(int sectionIndex) {
    }
    
    private final void checkForPerfectScore() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getHasPerfectScore() {
        return null;
    }
    
    public final int getSectionIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData getUserMarkedAnswersSheet() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData getQuestionsWithCorrectAnswer() {
        return null;
    }
}