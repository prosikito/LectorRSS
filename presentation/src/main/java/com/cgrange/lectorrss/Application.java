package com.cgrange.lectorrss;

import com.cgrange.News;

import org.parceler.ParcelClass;

import io.realm.Realm;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

@ParcelClass(News.class)
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
