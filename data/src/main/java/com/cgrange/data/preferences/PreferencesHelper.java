package com.cgrange.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.cgrange.data.R;
import com.cgrange.data.constants.DataConstants;

/**
 * Created by Cristian on 23/07/2017.
 *
 * THIS CLASS STORES AND RETRIEVES DATA FROM PREFERENCES
 */

public class PreferencesHelper {

    private PreferencesHelper(){
        // private constructor to hide public one
    }

    private static SharedPreferences getPreferences(@NonNull Context context){
        return context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    public static String getFeedUrl(@NonNull Context context){
        // DEFAULT URL IS GOOGLE NEWS
        return getPreferences(context).getString(DataConstants.FEED_URL, context.getString(R.string.google_url));
    }

    public static void storeFeedUrl(@NonNull Context context, String url){
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(DataConstants.FEED_URL, url);
        editor.apply();
    }
}
