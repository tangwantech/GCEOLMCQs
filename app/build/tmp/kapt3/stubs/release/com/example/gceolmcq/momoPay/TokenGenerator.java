package com.example.gceolmcq.momoPay;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/gceolmcq/momoPay/TokenGenerator;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isTokenAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "generate", "", "token", "", "tokenStatus", "Lcom/example/gceolmcq/momoPay/TokenGenerator$TokenStatus;", "getIsTokenAvailable", "Landroidx/lifecycle/LiveData;", "TokenStatus", "app_release"})
public final class TokenGenerator {
    private final android.content.Context context = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTokenAvailable = null;
    
    public TokenGenerator(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void generate(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> token, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.momoPay.TokenGenerator.TokenStatus tokenStatus) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getIsTokenAvailable() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/momoPay/TokenGenerator$TokenStatus;", "", "onTokenAvailable", "", "token", "", "onTokenFailed", "app_release"})
    public static abstract interface TokenStatus {
        
        public abstract void onTokenAvailable(@org.jetbrains.annotations.NotNull()
        java.lang.String token);
        
        public abstract void onTokenFailed();
    }
}