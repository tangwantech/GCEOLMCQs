// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PackageActivationSuccessfulDialogBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView imgPaymentStatus;

  @NonNull
  public final TextView tvPackageActivationSuccessful;

  private PackageActivationSuccessfulDialogBinding(@NonNull FrameLayout rootView,
      @NonNull ImageView imgPaymentStatus, @NonNull TextView tvPackageActivationSuccessful) {
    this.rootView = rootView;
    this.imgPaymentStatus = imgPaymentStatus;
    this.tvPackageActivationSuccessful = tvPackageActivationSuccessful;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PackageActivationSuccessfulDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PackageActivationSuccessfulDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.package_activation_successful_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PackageActivationSuccessfulDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgPaymentStatus;
      ImageView imgPaymentStatus = ViewBindings.findChildViewById(rootView, id);
      if (imgPaymentStatus == null) {
        break missingId;
      }

      id = R.id.tvPackageActivationSuccessful;
      TextView tvPackageActivationSuccessful = ViewBindings.findChildViewById(rootView, id);
      if (tvPackageActivationSuccessful == null) {
        break missingId;
      }

      return new PackageActivationSuccessfulDialogBinding((FrameLayout) rootView, imgPaymentStatus,
          tvPackageActivationSuccessful);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
