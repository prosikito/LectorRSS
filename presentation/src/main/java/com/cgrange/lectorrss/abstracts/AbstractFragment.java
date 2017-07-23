package com.cgrange.lectorrss.abstracts;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cgrange.lectorrss.navigation.NavigationController;

/**
 * Created by Cristian on 22/07/2017.
 *
 * THIS PARENT FRAGMENT CONTAINS THE COMMON VIEW METHODS
 *
 */

public class AbstractFragment extends Fragment {

    public void startActivity(@NonNull Class<?> destination, boolean finishCurrent, @Nullable Bundle bundle, boolean finishAll, @Nullable ActivityOptions transition) {
        NavigationController.startActivity(getActivity(), destination, finishCurrent, bundle, finishAll, transition);
    }
}
