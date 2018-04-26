package com.example.backstack;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Create in 2018/4/26 21:10.
 *
 * @author lhh.
 */
public class FragmentD extends Fragment {

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    TextView textView = new TextView(getActivity());
    textView.setText("我是FragmentD");
    textView.setTextColor(Color.CYAN);
    return textView;
  }
}
