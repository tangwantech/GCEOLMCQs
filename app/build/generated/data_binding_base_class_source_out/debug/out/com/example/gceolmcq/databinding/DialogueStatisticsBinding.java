// Generated by view binder compiler. Do not edit!
package com.example.gceolmcq.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class DialogueStatisticsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView tvAttempts;

  @NonNull
  public final TextView tvAverageGrade;

  @NonNull
  public final TextView tvAverageScore;

  @NonNull
  public final TextView tvHighestScore;

  @NonNull
  public final TextView tvLastGrade;

  @NonNull
  public final TextView tvLastScore;

  @NonNull
  public final TextView tvLowestScore;

  @NonNull
  public final TextView tvTitle;

  private DialogueStatisticsBinding(@NonNull LinearLayout rootView, @NonNull TextView tvAttempts,
      @NonNull TextView tvAverageGrade, @NonNull TextView tvAverageScore,
      @NonNull TextView tvHighestScore, @NonNull TextView tvLastGrade,
      @NonNull TextView tvLastScore, @NonNull TextView tvLowestScore, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.tvAttempts = tvAttempts;
    this.tvAverageGrade = tvAverageGrade;
    this.tvAverageScore = tvAverageScore;
    this.tvHighestScore = tvHighestScore;
    this.tvLastGrade = tvLastGrade;
    this.tvLastScore = tvLastScore;
    this.tvLowestScore = tvLowestScore;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogueStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogueStatisticsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialogue_statistics, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogueStatisticsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvAttempts;
      TextView tvAttempts = ViewBindings.findChildViewById(rootView, id);
      if (tvAttempts == null) {
        break missingId;
      }

      id = R.id.tvAverageGrade;
      TextView tvAverageGrade = ViewBindings.findChildViewById(rootView, id);
      if (tvAverageGrade == null) {
        break missingId;
      }

      id = R.id.tvAverageScore;
      TextView tvAverageScore = ViewBindings.findChildViewById(rootView, id);
      if (tvAverageScore == null) {
        break missingId;
      }

      id = R.id.tvHighestScore;
      TextView tvHighestScore = ViewBindings.findChildViewById(rootView, id);
      if (tvHighestScore == null) {
        break missingId;
      }

      id = R.id.tvLastGrade;
      TextView tvLastGrade = ViewBindings.findChildViewById(rootView, id);
      if (tvLastGrade == null) {
        break missingId;
      }

      id = R.id.tvLastScore;
      TextView tvLastScore = ViewBindings.findChildViewById(rootView, id);
      if (tvLastScore == null) {
        break missingId;
      }

      id = R.id.tvLowestScore;
      TextView tvLowestScore = ViewBindings.findChildViewById(rootView, id);
      if (tvLowestScore == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new DialogueStatisticsBinding((LinearLayout) rootView, tvAttempts, tvAverageGrade,
          tvAverageScore, tvHighestScore, tvLastGrade, tvLastScore, tvLowestScore, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
