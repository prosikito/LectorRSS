package com.cgrange.lectorrss.abstracts;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;

import com.cgrange.lectorrss.navigation.NavigationController;

/**
 * Created by Cristian on 22/07/2017.
 *
 * THIS PARENT ACTIVITY CONTAINS THE COMMON VIEW METHODS
 *
 */

public abstract class AbstractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public void startActivity(@NonNull Class<?> destination, boolean finishCurrent, @Nullable Bundle bundle, boolean finishAll, @Nullable ActivityOptions transition){
        NavigationController.startActivity(AbstractActivity.this, destination, finishCurrent, bundle, finishAll, transition);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void showLoading() {
        // to implement in child activities
    }

    public void dismissLoading() {
        // to implement in child activities
    }

    public void updateList() {
        // to implement in child activities
    }

    public void showConnectionError() {
        // to implement in child activities
    }

    public Context getContext(){
        return this;
    }
}
