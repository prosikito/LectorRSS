package com.cgrange.lectorrss.abstracts;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Cristian on 22/07/2017.
 *
 * THIS PARENT VIEW INTERFACE CONTAINS THE COMMON VIEW METHODS,
 * USUALLY IMPLEMENTED IN THE PARENT ABSTRACT ACTIVITY/FRAGMENT
 */

public interface IView {
    void showLoading();
    void dismissLoading();
    void updateList();
    void showConnectionError();
    Context getContext();
    void startActivity(@NonNull Class<?> destination, boolean finishCurrent, @Nullable Bundle bundle, boolean finishAll, @Nullable ActivityOptions transition);
}
