// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PackageActivationFailedDialogBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView tvPackageActivationFailed;

  private PackageActivationFailedDialogBinding(@NonNull FrameLayout rootView,
      @NonNull TextView tvPackageActivationFailed) {
    this.rootView = rootView;
    this.tvPackageActivationFailed = tvPackageActivationFailed;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PackageActivationFailedDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PackageActivationFailedDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.package_activation_failed_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PackageActivationFailedDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvPackageActivationFailed;
      TextView tvPackageActivationFailed = ViewBindings.findChildViewById(rootView, id);
      if (tvPackageActivationFailed == null) {
        break missingId;
      }

      return new PackageActivationFailedDialogBinding((FrameLayout) rootView,
          tvPackageActivationFailed);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}