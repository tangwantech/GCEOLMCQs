package com.example.gceolmcq.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u0019\u001a\u001bB5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u001e\u0010\u0018\u001a\u00020\u00112\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$ViewHolder;", "context", "Landroid/content/Context;", "subjectPackageDataList", "Ljava/util/ArrayList;", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "Lkotlin/collections/ArrayList;", "onHomeRecyclerItemClickListener", "Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnHomeRecyclerItemClickListener;", "onActivateTrialButtonClickListener", "Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnActivateTrialButtonClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnHomeRecyclerItemClickListener;Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnActivateTrialButtonClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "upSubjectPackageData", "OnActivateTrialButtonClickListener", "OnHomeRecyclerItemClickListener", "ViewHolder", "app_release"})
public final class HomeRecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageDataList;
    private final com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener onHomeRecyclerItemClickListener = null;
    private final com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.OnActivateTrialButtonClickListener onActivateTrialButtonClickListener = null;
    
    public HomeRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageDataList, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener onHomeRecyclerItemClickListener, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.OnActivateTrialButtonClickListener onActivateTrialButtonClickListener) {
        super();
    }
    
    public final void upSubjectPackageData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageDataList) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.HomeRecyclerViewAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0011\u0010\u001d\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR\u0011\u0010\u001f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\f\u00a8\u0006!"}, d2 = {"Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter;Landroid/view/View;)V", "activateButtonLo", "Landroid/widget/LinearLayout;", "getActivateButtonLo", "()Landroid/widget/LinearLayout;", "activatedOnTv", "Landroid/widget/TextView;", "getActivatedOnTv", "()Landroid/widget/TextView;", "btnActivateTrial", "Landroid/widget/Button;", "getBtnActivateTrial", "()Landroid/widget/Button;", "btnSubscribe", "getBtnSubscribe", "expireInLo", "getExpireInLo", "expiresInTv", "getExpiresInTv", "expiresOnTv", "getExpiresOnTv", "layoutSubjectItem", "Landroidx/cardview/widget/CardView;", "tvPackageType", "getTvPackageType", "tvSubjectName", "getTvSubjectName", "tvSubjectStatus", "getTvSubjectStatus", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSubjectName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSubjectStatus = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.Button btnSubscribe = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPackageType = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView activatedOnTv = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView expiresOnTv = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.Button btnActivateTrial = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout activateButtonLo = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView expiresInTv = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout expireInLo = null;
        private final androidx.cardview.widget.CardView layoutSubjectItem = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSubjectName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSubjectStatus() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getBtnSubscribe() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPackageType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getActivatedOnTv() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getExpiresOnTv() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getBtnActivateTrial() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getActivateButtonLo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getExpiresInTv() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getExpireInLo() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnHomeRecyclerItemClickListener;", "", "onSubjectItemClicked", "", "position", "", "isPackageActive", "", "packageName", "", "(ILjava/lang/Boolean;Ljava/lang/String;)V", "onSubscribeButtonClicked", "subjectPackageData", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "app_release"})
    public static abstract interface OnHomeRecyclerItemClickListener {
        
        public abstract void onSubjectItemClicked(int position, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean isPackageActive, @org.jetbrains.annotations.Nullable()
        java.lang.String packageName);
        
        public abstract void onSubscribeButtonClicked(int position, @org.jetbrains.annotations.NotNull()
        com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/gceolmcq/adapters/HomeRecyclerViewAdapter$OnActivateTrialButtonClickListener;", "", "onActivateTrialButtonClicked", "", "position", "", "subjectName", "", "app_release"})
    public static abstract interface OnActivateTrialButtonClickListener {
        
        public abstract void onActivateTrialButtonClicked(int position, @org.jetbrains.annotations.NotNull()
        java.lang.String subjectName);
    }
}