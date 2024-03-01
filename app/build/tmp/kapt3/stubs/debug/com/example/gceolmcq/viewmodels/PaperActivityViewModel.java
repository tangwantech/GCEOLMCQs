package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\r\u0010\f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0004J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017J\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\tJ\u0006\u0010$\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u001dJ\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020!J\u000e\u00101\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020\u0004J\u0016\u00102\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/example/gceolmcq/viewmodels/PaperActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "currentFragmentIndex", "", "Ljava/lang/Integer;", "examItemDataModel", "Lcom/example/gceolmcq/datamodels/ExamItemDataModel;", "subjectName", "", "decrementCurrentSectionRetryCount", "", "getCurrentFragmentIndex", "()Ljava/lang/Integer;", "getCurrentSectionIndex", "getCurrentSectionRetryCount", "Landroidx/lifecycle/LiveData;", "getExamFileName", "getExamTitle", "getIsSectionAnsweredAt", "", "position", "getIsSectionsAnswered", "", "getNumberOfSections", "getSectionData", "Lcom/example/gceolmcq/datamodels/SectionDataModel;", "getSectionNumberAt", "getSectionResultData", "Lcom/example/gceolmcq/datamodels/SectionResultData;", "getTotalNumberOfQuestions", "getUnAnsweredSectionIndexes", "getUserMarkedAnswerSheet", "Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;", "initPaperData", "paperDataJsonString", "resetCurrentSectionRetryCount", "resetPaperRepository", "resetSectionScore", "sectionIndex", "setCurrentFragmentIndex", "index", "setCurrentSectionIndex", "setExamItemData", "setSectionResultData", "sectionResultData", "setSubjectName", "setUserMarkedAnswerSheet", "userMarkedAnswersSheetData", "updateIsSectionsAnswered", "updateSectionsScore", "score", "app_debug"})
public final class PaperActivityViewModel extends androidx.lifecycle.ViewModel {
    private java.lang.Integer currentFragmentIndex;
    private java.lang.String subjectName;
    private com.example.gceolmcq.datamodels.ExamItemDataModel examItemDataModel;
    
    public PaperActivityViewModel() {
        super();
    }
    
    public final void setExamItemData(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.ExamItemDataModel examItemDataModel) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExamFileName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExamTitle() {
        return null;
    }
    
    public final void setCurrentFragmentIndex(int index) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCurrentFragmentIndex() {
        return null;
    }
    
    public final void setSubjectName(@org.jetbrains.annotations.NotNull()
    java.lang.String subjectName) {
    }
    
    public final void initPaperData(@org.jetbrains.annotations.Nullable()
    java.lang.String paperDataJsonString) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getUnAnsweredSectionIndexes() {
        return null;
    }
    
    public final void setCurrentSectionIndex(int sectionIndex) {
    }
    
    public final int getCurrentSectionIndex() {
        return 0;
    }
    
    public final int getTotalNumberOfQuestions() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SectionDataModel getSectionData(int position) {
        return null;
    }
    
    public final int getNumberOfSections() {
        return 0;
    }
    
    public final void updateSectionsScore(int sectionIndex, int score) {
    }
    
    public final void resetSectionScore(int sectionIndex) {
    }
    
    public final void updateIsSectionsAnswered(int sectionIndex) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Boolean> getIsSectionsAnswered() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSectionNumberAt(int position) {
        return null;
    }
    
    public final boolean getIsSectionAnsweredAt(int position) {
        return false;
    }
    
    public final void decrementCurrentSectionRetryCount() {
    }
    
    public final void resetCurrentSectionRetryCount() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCurrentSectionRetryCount() {
        return null;
    }
    
    public final void setUserMarkedAnswerSheet(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheetData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData getUserMarkedAnswerSheet() {
        return null;
    }
    
    public final void setSectionResultData(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SectionResultData sectionResultData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SectionResultData getSectionResultData() {
        return null;
    }
    
    public final void resetPaperRepository() {
    }
}