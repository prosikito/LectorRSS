package com.cgrange.lectorrss.navigation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Cristian on 22/07/2017.
 *
 * THIS CLASS CONTAINS STANDARD METHODS TO START ACTIVITIES
 */

public class NavigationController {

    private static final String EXTRA_SOURCE_ACTIVITY = "source_activity";

    public static final String EXTRA_NEWS = "extra_news";

    private NavigationController(){
        // unused
    }

    public static void startActivity(@NonNull Activity activity, Class<?> destination,
                                     boolean finishCurrent, Bundle extras, boolean oneOnTop, @Nullable ActivityOptions transition) {

        Intent intent = new Intent(activity, destination);
        if (oneOnTop) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }

        Bundle bundle = extras;
        if (bundle == null) {
            bundle = new Bundle();
        }

        bundle.putString(EXTRA_SOURCE_ACTIVITY, activity.getClass().getName());
        intent.putExtras(bundle);

        if (transition == null)
            activity.startActivity(intent);
        else
            activity.startActivity(intent, transition.toBundle());

        if (finishCurrent)
            activity.finish();
    }
}
