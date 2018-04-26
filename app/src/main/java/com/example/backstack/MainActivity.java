package com.example.backstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button mBtnFragmentA;
  private Button mBtnFragmentB;
  private Button mBtnFragmentC;
  private Button mBtnFragmentD;
  private FragmentA mFragmentA;
  private FragmentB mFragmentB;
  private FragmentC mFragmentC;
  private FragmentD mFragmentD;
  private List<Fragment> mFragments;

  private void assignViews() {
   mBtnFragmentA = (Button) findViewById(R.id.btn_fragmentA);
   mBtnFragmentB = (Button) findViewById(R.id.btn_fragmentB);
   mBtnFragmentC = (Button) findViewById(R.id.btn_fragmentC);
   mBtnFragmentD = (Button) findViewById(R.id.btn_fragmentD);
   mBtnFragmentA.setOnClickListener(this);
   mBtnFragmentB.setOnClickListener(this);
   mBtnFragmentC.setOnClickListener(this);
   mBtnFragmentD.setOnClickListener(this);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    assignViews();
    mFragments = new ArrayList<>();
    mFragmentA = new FragmentA();
    mFragmentB = new FragmentB();
    mFragmentC = new FragmentC();
    mFragmentD = new FragmentD();
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction
        .add(R.id.fl_container, mFragmentA)
        .add(R.id.fl_container, mFragmentB)
        .add(R.id.fl_container, mFragmentC)
        .add(R.id.fl_container, mFragmentD)
        .hide(mFragmentB)
        .hide(mFragmentC)
        .hide(mFragmentD)
        .commit();

    addToBackStack(mFragmentA);
  }

  /**
   * 使其在最后添加的Fragment在栈顶
   */
  private void addToBackStack(Fragment fragment) {
    if (mFragments.contains(fragment)) {
      mFragments.remove(fragment);
      mFragments.add(fragment);
    } else {
      mFragments.add(fragment);
    }
  }

  @Override public void onClick(View v) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction
        .hide(mFragmentA)
        .hide(mFragmentB)
        .hide(mFragmentC)
        .hide(mFragmentD);
    switch (v.getId()) {
      case R.id.btn_fragmentA:
        transaction.show(mFragmentA);
        addToBackStack(mFragmentA);
        break;
      case R.id.btn_fragmentB:
        transaction.show(mFragmentB);
        addToBackStack(mFragmentB);
        break;
      case R.id.btn_fragmentC:
        transaction.show(mFragmentC);
        addToBackStack(mFragmentC);
        break;
      case R.id.btn_fragmentD:
        transaction.show(mFragmentD);
        addToBackStack(mFragmentD);
        break;
    }
    transaction.commit();
  }

  @Override public void onBackPressed() {
    //super.onBackPressed();必须注释掉
    if (mFragments.size() > 1) {
      mFragments.remove(mFragments.size() - 1);
      showFragment(mFragments.get(mFragments.size() - 1));
    } else {
      finish();
    }
  }

  private void showFragment(Fragment fragment) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction
        .hide(mFragmentA)
        .hide(mFragmentB)
        .hide(mFragmentC)
        .hide(mFragmentD)
        .show(fragment)
        .commit();
  }
}
