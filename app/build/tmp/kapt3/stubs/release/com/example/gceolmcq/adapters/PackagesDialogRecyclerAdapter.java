package com.example.gceolmcq.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter$ViewHolder;", "context", "Landroid/content/Context;", "packages", "Ljava/util/ArrayList;", "Lcom/example/gceolmcq/datamodels/PackageData;", "Lkotlin/collections/ArrayList;", "itemSelectListener", "Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter$ItemSelectListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter$ItemSelectListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemSelectListener", "ViewHolder", "app_release"})
public final class PackagesDialogRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.example.gceolmcq.datamodels.PackageData> packages = null;
    private final com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter.ItemSelectListener itemSelectListener = null;
    
    public PackagesDialogRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gceolmcq.datamodels.PackageData> packages, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter.ItemSelectListener itemSelectListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.PackagesDialogRecyclerAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter;Landroid/view/View;)V", "packageRootLo", "Landroidx/cardview/widget/CardView;", "radio", "Landroid/widget/RadioButton;", "getRadio", "()Landroid/widget/RadioButton;", "tvDuration", "Landroid/widget/TextView;", "getTvDuration", "()Landroid/widget/TextView;", "tvPackageTitle", "getTvPackageTitle", "tvPrice", "getTvPrice", "getView", "()Landroid/view/View;", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPackageTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPrice = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDuration = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RadioButton radio = null;
        private final androidx.cardview.widget.CardView packageRootLo = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPackageTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPrice() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDuration() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RadioButton getRadio() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/gceolmcq/adapters/PackagesDialogRecyclerAdapter$ItemSelectListener;", "", "onItemSelected", "", "position", "", "isChecked", "", "app_release"})
    public static abstract interface ItemSelectListener {
        
        public abstract void onItemSelected(int position, boolean isChecked);
    }
}