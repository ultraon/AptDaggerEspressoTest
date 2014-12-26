package com.ultraon.aptdaggerespressotest;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by vitaliypopov on 15.12.14.
 */
public abstract class BaseActivity extends ActionBarActivity {
    private boolean viewInjected;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.inject(this);
    }

    @Override
    protected void onPostCreate(final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        injectViews();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onPostCreate(final Bundle savedInstanceState, final PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        injectViews();
    }

    protected void injectViews() {
        if (viewInjected) return;
        viewInjected = true;
        ButterKnife.inject(this);
    }

    @Override
    public void setContentView(final int layoutResID) {
        super.setContentView(layoutResID);
        injectViews();
    }

    @Override
    public void setContentView(final View view) {
        super.setContentView(view);
        injectViews();
    }

    @Override
    public void setContentView(final View view, final ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        injectViews();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.reset(this);
        super.onDestroy();
    }

    public FragmentManager fragmentManager() {
        return getSupportFragmentManager();
    }
}
