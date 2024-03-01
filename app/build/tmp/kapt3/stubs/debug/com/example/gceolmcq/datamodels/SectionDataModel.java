package com.example.gceolmcq.datamodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u00c6\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/example/gceolmcq/datamodels/SectionDataModel;", "Ljava/io/Serializable;", "title", "", "numberOfQuestions", "", "directions", "questions", "Ljava/util/ArrayList;", "Lcom/example/gceolmcq/datamodels/QuestionDataModel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V", "getDirections", "()Ljava/lang/String;", "getNumberOfQuestions", "()I", "getQuestions", "()Ljava/util/ArrayList;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
public final class SectionDataModel implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    private final int numberOfQuestions = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String directions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionDataModel> questions = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SectionDataModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String title, int numberOfQuestions, @org.jetbrains.annotations.NotNull()
    java.lang.String directions, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionDataModel> questions) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SectionDataModel(@org.jetbrains.annotations.NotNull()
    java.lang.String title, int numberOfQuestions, @org.jetbrains.annotations.NotNull()
    java.lang.String directions, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionDataModel> questions) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getNumberOfQuestions() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDirections() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionDataModel> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.gceolmcq.datamodels.QuestionDataModel> getQuestions() {
        return null;
    }
}