package com.cgrange.lectorrss.logger;

import android.support.annotation.Nullable;
import android.util.Log;

import com.cgrange.lectorrss.BuildConfig;

import java.util.Arrays;

/**
 * Created by Cristian on 22/07/2017.
 *
 * THIS CLASS HIDES DEFAULT ANDROID LOG AND PRINTS MESSAGES, EXCEPTIONS AND THROWABLES WHEN IN DEBUG MODE
 *
 */

public class Logger {

    private static final String TAG = "TAG_LECTOR_RSS";

    private Logger(){
        // not used
    }

    public static void log(@Nullable String message){
        if (BuildConfig.DEBUG && message != null) {
            Log.d(TAG, message);
        }
    }

    public static void log(@Nullable Exception exception){
        if (BuildConfig.DEBUG && exception != null && exception.getMessage() != null) {
            Log.e(TAG, exception.getMessage());
            if (exception.getStackTrace() != null){
                Log.e(TAG, Arrays.toString(exception.getStackTrace()));
            }
        }
    }

    public static void log(@Nullable Throwable throwable){
        if (BuildConfig.DEBUG && throwable != null && throwable.getMessage() != null) {
            Log.e(TAG, throwable.getLocalizedMessage());
        }
    }
}
