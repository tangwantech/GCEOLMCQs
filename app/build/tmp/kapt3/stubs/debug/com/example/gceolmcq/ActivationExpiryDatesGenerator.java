package com.example.gceolmcq;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/example/gceolmcq/ActivationExpiryDatesGenerator;", "", "()V", "checkExpiry", "", "activatedOn", "", "expiresOn", "Companion", "app_debug"})
public final class ActivationExpiryDatesGenerator {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.ActivationExpiryDatesGenerator.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SECONDS = "seconds";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MINUTES = "minutes";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOURS = "hours";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DAYS = "days";
    
    public ActivationExpiryDatesGenerator() {
        super();
    }
    
    public final boolean checkExpiry(@org.jetbrains.annotations.NotNull()
    java.lang.String activatedOn, @org.jetbrains.annotations.NotNull()
    java.lang.String expiresOn) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/gceolmcq/ActivationExpiryDatesGenerator$Companion;", "", "()V", "DAYS", "", "HOURS", "MINUTES", "SECONDS", "generateTrialActivationExpiryDates", "Lcom/example/gceolmcq/datamodels/ActivationExpiryDates;", "timeType", "duration", "", "getTimeRemaining", "", "activatedOn", "expiresOn", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gceolmcq.datamodels.ActivationExpiryDates generateTrialActivationExpiryDates(@org.jetbrains.annotations.NotNull()
        java.lang.String timeType, int duration) {
            return null;
        }
        
        public final long getTimeRemaining(@org.jetbrains.annotations.NotNull()
        java.lang.String activatedOn, @org.jetbrains.annotations.NotNull()
        java.lang.String expiresOn) {
            return 0L;
        }
    }
}