package com.example.gceolmcq.datamodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/gceolmcq/datamodels/SectionResultData;", "Ljava/io/Serializable;", "sectionIndex", "", "scoreData", "Lcom/example/gceolmcq/datamodels/ScoreData;", "userMarkedAnswersSheet", "Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;", "(ILcom/example/gceolmcq/datamodels/ScoreData;Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;)V", "getScoreData", "()Lcom/example/gceolmcq/datamodels/ScoreData;", "getSectionIndex", "()I", "getUserMarkedAnswersSheet", "()Lcom/example/gceolmcq/datamodels/UserMarkedAnswersSheetData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"})
public final class SectionResultData implements java.io.Serializable {
    private final int sectionIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.gceolmcq.datamodels.ScoreData scoreData = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheet = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SectionResultData copy(int sectionIndex, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.ScoreData scoreData, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheet) {
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
    
    public SectionResultData(int sectionIndex, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.ScoreData scoreData, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData userMarkedAnswersSheet) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getSectionIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.ScoreData component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.ScoreData getScoreData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData getUserMarkedAnswersSheet() {
        return null;
    }
}