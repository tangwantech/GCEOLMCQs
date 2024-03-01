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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SubjectItemCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button activateButton;

  @NonNull
  public final LinearLayout activateButtonLo;

  @NonNull
  public final TextView activatedOnTv;

  @NonNull
  public final Button btnSubscribe;

  @NonNull
  public final LinearLayout contentLo;

  @NonNull
  public final LinearLayout expireInLo;

  @NonNull
  public final TextView expiresInTv;

  @NonNull
  public final TextView expiresOnTv;

  @NonNull
  public final CardView layoutSubjectNavItem;

  @NonNull
  public final LinearLayout navArrowLo;

  @NonNull
  public final TextView subjectTitleTv;

  @NonNull
  public final TextView tvPackageType;

  @NonNull
  public final TextView tvSubjectStatus;

  private SubjectItemCardBinding(@NonNull CardView rootView, @NonNull Button activateButton,
      @NonNull LinearLayout activateButtonLo, @NonNull TextView activatedOnTv,
      @NonNull Button btnSubscribe, @NonNull LinearLayout contentLo,
      @NonNull LinearLayout expireInLo, @NonNull TextView expiresInTv,
      @NonNull TextView expiresOnTv, @NonNull CardView layoutSubjectNavItem,
      @NonNull LinearLayout navArrowLo, @NonNull TextView subjectTitleTv,
      @NonNull TextView tvPackageType, @NonNull TextView tvSubjectStatus) {
    this.rootView = rootView;
    this.activateButton = activateButton;
    this.activateButtonLo = activateButtonLo;
    this.activatedOnTv = activatedOnTv;
    this.btnSubscribe = btnSubscribe;
    this.contentLo = contentLo;
    this.expireInLo = expireInLo;
    this.expiresInTv = expiresInTv;
    this.expiresOnTv = expiresOnTv;
    this.layoutSubjectNavItem = layoutSubjectNavItem;
    this.navArrowLo = navArrowLo;
    this.subjectTitleTv = subjectTitleTv;
    this.tvPackageType = tvPackageType;
    this.tvSubjectStatus = tvSubjectStatus;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static SubjectItemCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SubjectItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.subject_item_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SubjectItemCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.activateButton;
      Button activateButton = ViewBindings.findChildViewById(rootView, id);
      if (activateButton == null) {
        break missingId;
      }

      id = R.id.activateButtonLo;
      LinearLayout activateButtonLo = ViewBindings.findChildViewById(rootView, id);
      if (activateButtonLo == null) {
        break missingId;
      }

      id = R.id.activatedOnTv;
      TextView activatedOnTv = ViewBindings.findChildViewById(rootView, id);
      if (activatedOnTv == null) {
        break missingId;
      }

      id = R.id.btnSubscribe;
      Button btnSubscribe = ViewBindings.findChildViewById(rootView, id);
      if (btnSubscribe == null) {
        break missingId;
      }

      id = R.id.contentLo;
      LinearLayout contentLo = ViewBindings.findChildViewById(rootView, id);
      if (contentLo == null) {
        break missingId;
      }

      id = R.id.expireInLo;
      LinearLayout expireInLo = ViewBindings.findChildViewById(rootView, id);
      if (expireInLo == null) {
        break missingId;
      }

      id = R.id.expiresInTv;
      TextView expiresInTv = ViewBindings.findChildViewById(rootView, id);
      if (expiresInTv == null) {
        break missingId;
      }

      id = R.id.expiresOnTv;
      TextView expiresOnTv = ViewBindings.findChildViewById(rootView, id);
      if (expiresOnTv == null) {
        break missingId;
      }

      CardView layoutSubjectNavItem = (CardView) rootView;

      id = R.id.navArrowLo;
      LinearLayout navArrowLo = ViewBindings.findChildViewById(rootView, id);
      if (navArrowLo == null) {
        break missingId;
      }

      id = R.id.subjectTitleTv;
      TextView subjectTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (subjectTitleTv == null) {
        break missingId;
      }

      id = R.id.tvPackageType;
      TextView tvPackageType = ViewBindings.findChildViewById(rootView, id);
      if (tvPackageType == null) {
        break missingId;
      }

      id = R.id.tvSubjectStatus;
      TextView tvSubjectStatus = ViewBindings.findChildViewById(rootView, id);
      if (tvSubjectStatus == null) {
        break missingId;
      }

      return new SubjectItemCardBinding((CardView) rootView, activateButton, activateButtonLo,
          activatedOnTv, btnSubscribe, contentLo, expireInLo, expiresInTv, expiresOnTv,
          layoutSubjectNavItem, navArrowLo, subjectTitleTv, tvPackageType, tvSubjectStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}