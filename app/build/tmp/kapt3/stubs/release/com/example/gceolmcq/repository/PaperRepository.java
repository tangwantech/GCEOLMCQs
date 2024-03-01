package com.example.gceolmcq.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/gceolmcq/repository/PaperRepository;", "", "()V", "Companion", "app_release"})
public final class PaperRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.repository.PaperRepository.Companion Companion = null;
    private static com.example.gceolmcq.datamodels.PaperDataModel paperDataModel;
    private static int currentSectionIndex = 0;
    private static java.util.ArrayList<java.lang.Boolean> sectionsAnsweredData;
    private static androidx.lifecycle.MutableLiveData<java.lang.Integer> paperScore;
    private static androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.Integer>> sectionsScores;
    private static androidx.lifecycle.MutableLiveData<java.lang.Integer> sectionsAnsweredCount;
    private static androidx.lifecycle.MutableLiveData<java.lang.Integer> currentSectionRetryCount;
    private static java.util.ArrayList<java.lang.Integer> unAnsweredSectionIndexes;
    private static com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheetData;
    private static com.example.gceolmcq.datamodels.SectionResultData sectionResultData;
    private static final androidx.lifecycle.MutableLiveData<java.lang.String> paperGrade = null;
    private static final androidx.lifecycle.MutableLiveData<java.lang.Integer> paperPercentage = null;
    private static final androidx.lifecycle.MutableLiveData<java.lang.Boolean> areAllSectionsAnswered = null;
    
    public PaperRepository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\u0006\u0010\u001d\u001a\u00020\u0007J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u0006\u0010\u001f\u001a\u00020\u0007J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001cJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\'2\u0006\u0010%\u001a\u00020\u0007J\u0013\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)\u00a2\u0006\u0002\u0010+J\u0013\u0010,\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)\u00a2\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020\u0010J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000501J\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0013j\b\u0012\u0004\u0012\u00020\u0007`\u0014J\u0006\u00103\u001a\u00020\u0007J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000701J\u0006\u00105\u001a\u00020\u0018J\u0010\u00106\u001a\u00020\u001a2\b\u00107\u001a\u0004\u0018\u00010\fJ\b\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u001aH\u0002J\u0006\u0010:\u001a\u00020\u001aJ\u0006\u0010;\u001a\u00020\u001aJ\u000e\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010@\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010A\u001a\u00020\u001aH\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J\u0016\u0010C\u001a\u00020\u001a2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000701H\u0002J\u0016\u0010E\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010G\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0007J\b\u0010H\u001a\u00020\u001aH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0013j\b\u0012\u0004\u0012\u00020\u0005`\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0013j\b\u0012\u0004\u0012\u00020\u0007`\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/example/gceolmcq/repository/PaperRepository$Companion;", "", "()V", "areAllSectionsAnswered", "Landroidx/lifecycle/MutableLiveData;", "", "currentSectionIndex", "", "currentSectionRetryCount", "paperDataModel", "Lcom/example/gceolmcq/datamodels/PaperDataModel;", "paperGrade", "", "paperPercentage", "paperScore", "sectionResultData", "Lcom/example/gceolmcq/datamodels/SectionResultData;", "sectionsAnsweredCount", "sectionsAnsweredData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sectionsScores", "unAnsweredSectionIndexes", "userMarkedAnswersSheetData", "Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;", "decrementCurrentSectionRetryCount", "", "getAreAllSectionsAnswered", "Landroidx/lifecycle/LiveData;", "getCurrentSectionIndex", "getCurrentSectionRetryCount", "getNumberOfSections", "getNumberOfSectionsAnswered", "getPaperGrade", "getPaperPercentage", "getPaperScore", "getSectionAnsweredAt", "position", "getSectionDataAt", "Lcom/example/gceolmcq/datamodels/SectionDataModel;", "getSectionNameBundleList", "", "Landroid/os/Bundle;", "()[Landroid/os/Bundle;", "getSectionNames", "()[Ljava/lang/String;", "getSectionNumberAt", "getSectionResultData", "getSectionsAnswered", "", "getSectionsScores", "getTotalNumberOfQuestions", "getUnAnsweredSectionIndexes", "getUserMarkedAnswerSheet", "initPaperData", "paperDataJsonString", "initSectionScores", "initSectionsAnswered", "resetCurrentSectionRetryCount", "resetPaperRepo", "resetSectionScoreAt", "sectionIndex", "setCurrentSectionIndex", "setSectionResultData", "setUserMarkedAnswerSheet", "updateAreAllSectionsAnswered", "updateGrade", "updatePaperScore", "sectionScores", "updateSectionScoreAt", "score", "updateSectionsAnsweredAt", "updateSectionsAnsweredCount", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
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
        
        public final void resetPaperRepo() {
        }
        
        private final void initSectionScores() {
        }
        
        private final void initSectionsAnswered() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gceolmcq.datamodels.SectionDataModel getSectionDataAt(int position) {
            return null;
        }
        
        public final int getNumberOfSections() {
            return 0;
        }
        
        public final void updateSectionScoreAt(int sectionIndex, int score) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<java.lang.Integer> getSectionsScores() {
            return null;
        }
        
        public final void resetSectionScoreAt(int sectionIndex) {
        }
        
        private final void updatePaperScore(java.util.List<java.lang.Integer> sectionScores) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<java.lang.Integer> getPaperScore() {
            return null;
        }
        
        public final void updateSectionsAnsweredAt(int sectionIndex) {
        }
        
        private final void updateSectionsAnsweredCount() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.Boolean> getSectionsAnswered() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSectionNumberAt(int position) {
            return null;
        }
        
        public final boolean getSectionAnsweredAt(int position) {
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
        
        public final int getTotalNumberOfQuestions() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<java.lang.Integer> getNumberOfSectionsAnswered() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String[] getSectionNames() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.os.Bundle[] getSectionNameBundleList() {
            return null;
        }
        
        private final void updateGrade() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<java.lang.String> getPaperGrade() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<java.lang.Integer> getPaperPercentage() {
            return null;
        }
        
        private final void updateAreAllSectionsAnswered() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<java.lang.Boolean> getAreAllSectionsAnswered() {
            return null;
        }
    }
}