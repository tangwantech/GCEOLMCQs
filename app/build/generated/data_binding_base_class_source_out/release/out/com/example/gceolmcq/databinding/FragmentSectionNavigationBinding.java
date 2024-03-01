// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSectionNavigationBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final PaperRemarkBinding paperGradeLayout;

  @NonNull
  public final Button restartPaperBtn;

  @NonNull
  public final RecyclerView rvSectionNavigation;

  @NonNull
  public final LinearLayout sectionsNavLayout;

  private FragmentSectionNavigationBinding(@NonNull FrameLayout rootView,
      @NonNull PaperRemarkBinding paperGradeLayout, @NonNull Button restartPaperBtn,
      @NonNull RecyclerView rvSectionNavigation, @NonNull LinearLayout sectionsNavLayout) {
    this.rootView = rootView;
    this.paperGradeLayout = paperGradeLayout;
    this.restartPaperBtn = restartPaperBtn;
    this.rvSectionNavigation = rvSectionNavigation;
    this.sectionsNavLayout = sectionsNavLayout;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSectionNavigationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSectionNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_section_navigation, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSectionNavigationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.paperGradeLayout;
      View paperGradeLayout = ViewBindings.findChildViewById(rootView, id);
      if (paperGradeLayout == null) {
        break missingId;
      }
      PaperRemarkBinding binding_paperGradeLayout = PaperRemarkBinding.bind(paperGradeLayout);

      id = R.id.restartPaperBtn;
      Button restartPaperBtn = ViewBindings.findChildViewById(rootView, id);
      if (restartPaperBtn == null) {
        break missingId;
      }

      id = R.id.rvSectionNavigation;
      RecyclerView rvSectionNavigation = ViewBindings.findChildViewById(rootView, id);
      if (rvSectionNavigation == null) {
        break missingId;
      }

      id = R.id.sectionsNavLayout;
      LinearLayout sectionsNavLayout = ViewBindings.findChildViewById(rootView, id);
      if (sectionsNavLayout == null) {
        break missingId;
      }

      return new FragmentSectionNavigationBinding((FrameLayout) rootView, binding_paperGradeLayout,
          restartPaperBtn, rvSectionNavigation, sectionsNavLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}