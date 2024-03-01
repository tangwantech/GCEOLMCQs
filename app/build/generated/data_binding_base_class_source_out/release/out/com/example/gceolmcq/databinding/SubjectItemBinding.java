// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SubjectItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnPackage;

  @NonNull
  public final Button btnSubscribe;

  @NonNull
  public final LinearLayout layoutSubjectNavItem;

  @NonNull
  public final TextView tvSubjectNavItem;

  @NonNull
  public final TextView tvSubjectStatus;

  private SubjectItemBinding(@NonNull LinearLayout rootView, @NonNull Button btnPackage,
      @NonNull Button btnSubscribe, @NonNull LinearLayout layoutSubjectNavItem,
      @NonNull TextView tvSubjectNavItem, @NonNull TextView tvSubjectStatus) {
    this.rootView = rootView;
    this.btnPackage = btnPackage;
    this.btnSubscribe = btnSubscribe;
    this.layoutSubjectNavItem = layoutSubjectNavItem;
    this.tvSubjectNavItem = tvSubjectNavItem;
    this.tvSubjectStatus = tvSubjectStatus;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SubjectItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SubjectItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.subject_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SubjectItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnPackage;
      Button btnPackage = ViewBindings.findChildViewById(rootView, id);
      if (btnPackage == null) {
        break missingId;
      }

      id = R.id.btnSubscribe;
      Button btnSubscribe = ViewBindings.findChildViewById(rootView, id);
      if (btnSubscribe == null) {
        break missingId;
      }

      LinearLayout layoutSubjectNavItem = (LinearLayout) rootView;

      id = R.id.tvSubjectNavItem;
      TextView tvSubjectNavItem = ViewBindings.findChildViewById(rootView, id);
      if (tvSubjectNavItem == null) {
        break missingId;
      }

      id = R.id.tvSubjectStatus;
      TextView tvSubjectStatus = ViewBindings.findChildViewById(rootView, id);
      if (tvSubjectStatus == null) {
        break missingId;
      }

      return new SubjectItemBinding((LinearLayout) rootView, btnPackage, btnSubscribe,
          layoutSubjectNavItem, tvSubjectNavItem, tvSubjectStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}