package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010\'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010(\u001a\u00020\u0004J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070*J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070*J\u0011\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010.J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110*J\u0006\u00100\u001a\u00020\u0011J\u0006\u00101\u001a\u000202J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110*J\u0006\u00104\u001a\u00020\u000eJ\u0006\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\u000eJ\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0*J\u0006\u0010:\u001a\u00020&J\u0010\u0010;\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0002J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002J\u000e\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020\u0011J\b\u0010E\u001a\u00020&H\u0002J\u0006\u0010F\u001a\u00020&J\b\u0010G\u001a\u00020&H\u0002J\u0010\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020\u0011H\u0002J\b\u0010J\u001a\u00020&H\u0002J\u000e\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020\nJ\b\u0010M\u001a\u00020&H\u0002J\b\u0010N\u001a\u00020&H\u0002J\u000e\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0019j\b\u0012\u0004\u0012\u00020\"`\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/example/gceolmcq/viewmodels/SectionFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "indexPreviousAndCurrentSelectedOptionOfQuestion", "Lcom/example/gceolmcq/datamodels/IndexPreviousAndCurrentSelectedOptionOfQuestion;", "isQuestionAnswered", "Landroidx/lifecycle/MutableLiveData;", "", "isTimeAlmostOut", "isTimeAlmostOutStartTime", "", "isTimeOut", "letters", "", "", "[Ljava/lang/String;", "numberOfQuestionsAnswered", "", "questionIndex", "sectionDataModel", "Lcom/example/gceolmcq/datamodels/SectionDataModel;", "sectionDuration", "sectionIndex", "Ljava/lang/Integer;", "sectionQuestionsScores", "Ljava/util/ArrayList;", "Lcom/example/gceolmcq/datamodels/QuestionScore;", "Lkotlin/collections/ArrayList;", "sectionScore", "timeRemaining", "Landroid/text/format/Time;", "timer", "Landroid/os/CountDownTimer;", "userMarkedAnswerSheet", "Lcom/example/gceolmcq/datamodels/QuestionWithUserAnswerMarkedData;", "userSelections", "Lcom/example/gceolmcq/datamodels/UserSelection;", "appendLetterToFourOptions", "", "evaluateUserSelections", "getIndexPreviousAndCurrentItemOfQuestion", "getIsQuestionAnswered", "Landroidx/lifecycle/LiveData;", "getIsTimeAlmostOut", "getIsTimeOut", "getLetters", "()[Ljava/lang/String;", "getNumberOfQuestionsAnswered", "getNumberOfQuestionsInSection", "getQuestion", "Lcom/example/gceolmcq/datamodels/QuestionDataModel;", "getQuestionIndex", "getSectionDirections", "getSectionIndex", "getSectionResultData", "Lcom/example/gceolmcq/datamodels/SectionResultData;", "getSectionTitle", "getTimeRemaining", "incrementQuestionIndex", "initSectionData", "initSectionQuestionsScores", "initUserMarkedAnswerSheet", "initUserSelections", "resetIndexPreviousAndCurrentItemOfQuestion", "resetIsQuestionAnswered", "setQuestionsCorrectAnswers", "setSectionDuration", "setSectionIndex", "index", "shuffleSectionQuestions", "startTimer", "sumSectionQuestionScores", "updateIndexQuestionOptionSelected", "indexOptionSelected", "updateIsQuestionAnswered", "updateIsTimeAlmostOut", "timeLeft", "updateNumberOfQuestionsAnswered", "updateUserMarkedAnswerSheet", "updateUserSelection", "optionSelectedIndex", "app_release"})
public final class SectionFragmentViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.datamodels.SectionDataModel sectionDataModel;
    private java.util.ArrayList<com.example.gceolmcq.datamodels.UserSelection> userSelections;
    private final java.lang.String[] letters = null;
    private final com.example.gceolmcq.datamodels.IndexPreviousAndCurrentSelectedOptionOfQuestion indexPreviousAndCurrentSelectedOptionOfQuestion = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> numberOfQuestionsAnswered = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isQuestionAnswered = null;
    private final java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionScore> sectionQuestionsScores = null;
    private int sectionScore = 0;
    private long sectionDuration = 0L;
    private android.os.CountDownTimer timer;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> questionIndex = null;
    private final java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionWithUserAnswerMarkedData> userMarkedAnswerSheet = null;
    private java.lang.Integer sectionIndex;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTimeOut = null;
    private final androidx.lifecycle.MutableLiveData<android.text.format.Time> timeRemaining = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTimeAlmostOut = null;
    private final long isTimeAlmostOutStartTime = 20000L;
    
    public SectionFragmentViewModel() {
        super();
    }
    
    public final void setSectionIndex(int index) {
    }
    
    private final void initSectionData(int sectionIndex) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getLetters() {
        return null;
    }
    
    private final void shuffleSectionQuestions() {
    }
    
    private final void setSectionDuration() {
    }
    
    public final void startTimer() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<android.text.format.Time> getTimeRemaining() {
        return null;
    }
    
    public final void updateIsTimeAlmostOut(long timeLeft) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTimeAlmostOut() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTimeOut() {
        return null;
    }
    
    public final int getNumberOfQuestionsInSection() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getNumberOfQuestionsAnswered() {
        return null;
    }
    
    private final void updateNumberOfQuestionsAnswered() {
    }
    
    public final void incrementQuestionIndex() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getQuestionIndex() {
        return null;
    }
    
    private final void updateIsQuestionAnswered() {
    }
    
    private final void resetIsQuestionAnswered() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsQuestionAnswered() {
        return null;
    }
    
    private final void initUserMarkedAnswerSheet() {
    }
    
    private final void initUserSelections() {
    }
    
    private final void initSectionQuestionsScores() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.QuestionDataModel getQuestion() {
        return null;
    }
    
    private final void updateUserMarkedAnswerSheet() {
    }
    
    private final void setQuestionsCorrectAnswers() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSectionTitle() {
        return null;
    }
    
    public final void updateUserSelection(int optionSelectedIndex) {
    }
    
    private final void appendLetterToFourOptions() {
    }
    
    private final void evaluateUserSelections(int questionIndex) {
    }
    
    private final void sumSectionQuestionScores() {
    }
    
    private final void updateIndexQuestionOptionSelected(int indexOptionSelected) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.IndexPreviousAndCurrentSelectedOptionOfQuestion getIndexPreviousAndCurrentItemOfQuestion() {
        return null;
    }
    
    private final void resetIndexPreviousAndCurrentItemOfQuestion() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SectionResultData getSectionResultData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSectionDirections() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSectionIndex() {
        return null;
    }
}