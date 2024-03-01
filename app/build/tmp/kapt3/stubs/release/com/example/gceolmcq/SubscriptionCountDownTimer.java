package com.example.gceolmcq;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/gceolmcq/SubscriptionCountDownTimer;", "", "position", "", "(I)V", "isTimeAlmostOut", "Landroidx/lifecycle/MutableLiveData;", "", "isTimeOut", "timeRemaining", "Landroid/text/format/Time;", "timer", "Landroid/os/CountDownTimer;", "getExpiresIn", "", "timeLeft", "getIsTimeAlmostOut", "Landroidx/lifecycle/LiveData;", "getIsTimeOut", "startTimer", "", "duration", "", "onTimeRemainingListener", "Lcom/example/gceolmcq/SubscriptionCountDownTimer$OnTimeRemainingListener;", "updateIsTimeAlmostOut", "OnTimeRemainingListener", "app_release"})
public final class SubscriptionCountDownTimer {
    private final int position = 0;
    private android.os.CountDownTimer timer;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTimeOut = null;
    private final androidx.lifecycle.MutableLiveData<android.text.format.Time> timeRemaining = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTimeAlmostOut = null;
    
    public SubscriptionCountDownTimer(int position) {
        super();
    }
    
    public final void startTimer(long duration, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.SubscriptionCountDownTimer.OnTimeRemainingListener onTimeRemainingListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExpiresIn(@org.jetbrains.annotations.NotNull()
    android.text.format.Time timeLeft) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/SubscriptionCountDownTimer$OnTimeRemainingListener;", "", "onExpired", "", "onTimeRemaining", "expiresIn", "", "app_release"})
    public static abstract interface OnTimeRemainingListener {
        
        public abstract void onTimeRemaining(@org.jetbrains.annotations.NotNull()
        java.lang.String expiresIn);
        
        public abstract void onExpired();
    }
}