package com.cgrange.lectorrss.newsdetail;

import android.content.ComponentName;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class NewsDetailPresenter implements NewsDetailContracts.Presenter {

    private NewsDetailContracts.NewsDetailView view;
    private static final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";

    private CustomTabsClient mCustomTabsClient;
    private CustomTabsSession mCustomTabsSession;
    private CustomTabsIntent mCustomTabsIntent;


    public NewsDetailPresenter(NewsDetailContracts.NewsDetailView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

        // INSTEAD OPENING IN EXTERNAL BROWSER, IT USES CHROME CUSTOM TABS
        CustomTabsServiceConnection mCustomTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                mCustomTabsClient = customTabsClient;
                mCustomTabsClient.warmup(0L);
                mCustomTabsSession = mCustomTabsClient.newSession(null);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mCustomTabsClient = null;
            }
        };

        CustomTabsClient.bindCustomTabsService(view.getContext(), CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection);

        mCustomTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setShowTitle(true)
                .build();
    }

    @Override
    public void openInBrowserClick(@NonNull String url) {
        mCustomTabsIntent.launchUrl(view.getContext(), Uri.parse(url));
    }
}
