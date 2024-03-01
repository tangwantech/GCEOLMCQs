// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gceolmcq.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final HomeListItemHeaderBinding header;

  @NonNull
  public final FrameLayout mainActivityFragmentHolder;

  @NonNull
  public final RelativeLayout mainActivityLinearLayout;

  private ActivityMainBinding(@NonNull RelativeLayout rootView,
      @NonNull HomeListItemHeaderBinding header, @NonNull FrameLayout mainActivityFragmentHolder,
      @NonNull RelativeLayout mainActivityLinearLayout) {
    this.rootView = rootView;
    this.header = header;
    this.mainActivityFragmentHolder = mainActivityFragmentHolder;
    this.mainActivityLinearLayout = mainActivityLinearLayout;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.header;
      View header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }
      HomeListItemHeaderBinding binding_header = HomeListItemHeaderBinding.bind(header);

      id = R.id.mainActivityFragmentHolder;
      FrameLayout mainActivityFragmentHolder = ViewBindings.findChildViewById(rootView, id);
      if (mainActivityFragmentHolder == null) {
        break missingId;
      }

      RelativeLayout mainActivityLinearLayout = (RelativeLayout) rootView;

      return new ActivityMainBinding((RelativeLayout) rootView, binding_header,
          mainActivityFragmentHolder, mainActivityLinearLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}