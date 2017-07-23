package com.cgrange.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cgrange.JSONNewsResponse;
import com.cgrange.News;
import com.cgrange.RssFeed;
import com.cgrange.data.cloud.ConnectionListener;
import com.cgrange.data.cloud.ConnectionManager;
import com.cgrange.data.database.RealmHelper;
import com.cgrange.data.preferences.PreferencesHelper;

import java.util.List;

import io.reactivex.Observer;

/**
 * Created by Cristian on 22/07/2017.
 * THIS CLASS CENTRALIZES ALL DATA REQUESTS TO THE DIFFERENT SOURCES - ONLINE REQUEST, DATABASE, PREFERENCES...
 *
 */

public class LectorRSSRepository {

    private LectorRSSRepository(){
        // private constructor to hide the public one
    }

    public static void getJSONNews(@NonNull Observer<JSONNewsResponse> jsonNewsResponseObserver, @NonNull Context context){
        ConnectionManager.getJSONNews(jsonNewsResponseObserver, context);
    }

    public static void getXMLNews(@NonNull ConnectionListener<RssFeed> rssFeedConnectionListener){
        ConnectionManager.getXMLNews(rssFeedConnectionListener);
    }

    public static List<News> getJSONNewsOffline(){
        return RealmHelper.getJSONNewsFromRealm();
    }

    public static List<News> getXMLNewsOffline(){
        return RealmHelper.getXMLNewsFromRealm();
    }

    public static void storeJSONNews(List<News> newsList){
        RealmHelper.storeJSONNews(newsList);
    }

    public static void storeXMLNews(List<News> newsList){
        RealmHelper.storeXMLNews(newsList);
    }

    public static void storeFeedUrl(@NonNull Context context, @NonNull String url){
        PreferencesHelper.storeFeedUrl(context, url);
    }

    public static String getFeedUrl(@NonNull Context context){
        return PreferencesHelper.getFeedUrl(context);
    }

    public static void storeFeedUrlChanged(@NonNull Context context, boolean isChanged){
        PreferencesHelper.storeFeedUrlChanged(context, isChanged);
    }

    public static boolean isFeedUrlChanged(@NonNull Context context){
        return PreferencesHelper.isFeedUrlChanged(context);
    }
}
