package com.example.gceolmcq.datamodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u00c6\u0003JK\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/example/gceolmcq/datamodels/PaperDataModel;", "Ljava/io/Serializable;", "privateTitle", "", "publicTitle", "numberOfQuestions", "", "numberOfSections", "sections", "Ljava/util/ArrayList;", "Lcom/example/gceolmcq/datamodels/SectionDataModel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;)V", "getNumberOfQuestions", "()I", "getNumberOfSections", "getPrivateTitle", "()Ljava/lang/String;", "getPublicTitle", "getSections", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
public final class PaperDataModel implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String privateTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String publicTitle = null;
    private final int numberOfQuestions = 0;
    private final int numberOfSections = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.gceolmcq.datamodels.SectionDataModel> sections = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.PaperDataModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String privateTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String publicTitle, int numberOfQuestions, int numberOfSections, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.SectionDataModel> sections) {
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
    
    public PaperDataModel(@org.jetbrains.annotations.NotNull()
    java.lang.String privateTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String publicTitle, int numberOfQuestions, int numberOfSections, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.SectionDataModel> sections) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrivateTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPublicTitle() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getNumberOfQuestions() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getNumberOfSections() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.gceolmcq.datamodels.SectionDataModel> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.gceolmcq.datamodels.SectionDataModel> getSections() {
        return null;
    }
}