// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSectionBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final Button btnResult;

  @NonNull
  public final LinearLayout btnResultLayout;

  @NonNull
  public final ScrollView svQuestion;

  private FragmentSectionBinding(@NonNull FrameLayout rootView, @NonNull Button btnNext,
      @NonNull Button btnResult, @NonNull LinearLayout btnResultLayout,
      @NonNull ScrollView svQuestion) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnResult = btnResult;
    this.btnResultLayout = btnResultLayout;
    this.svQuestion = svQuestion;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_section, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSectionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNext;
      Button btnNext = ViewBindings.findChildViewById(rootView, id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.btnResult;
      Button btnResult = ViewBindings.findChildViewById(rootView, id);
      if (btnResult == null) {
        break missingId;
      }

      id = R.id.btnResultLayout;
      LinearLayout btnResultLayout = ViewBindings.findChildViewById(rootView, id);
      if (btnResultLayout == null) {
        break missingId;
      }

      id = R.id.svQuestion;
      ScrollView svQuestion = ViewBindings.findChildViewById(rootView, id);
      if (svQuestion == null) {
        break missingId;
      }

      return new FragmentSectionBinding((FrameLayout) rootView, btnNext, btnResult, btnResultLayout,
          svQuestion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}