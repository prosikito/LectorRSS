package com.cgrange.data.database;

import com.cgrange.News;
import com.cgrange.data.constants.DataConstants;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Cristian on 23/07/2017.
 *
 * THIS CLASS STORES AND RETRIEVES DATA FROM LOCAL REALM DATABASE
 */

public class RealmHelper {

    private RealmHelper(){
        // private constructor to hide the public one
    }

    // WE NEED TO CONVERT NEWS TO A NEWSREALM OBJECT SO THAT IT EXTENDS REALMOBJECT, SINCE OUR
    // DOMAIN MODULE IS A PURE JAVA LIBRARY AND REALM IS ONLY FOR ANDROID LIBRARY

    public static void storeJSONNews(List<News> newsList){
        RealmList<NewsRealm> newsRealmRealmList = new RealmList<>();
        for (News news : newsList){
            newsRealmRealmList.add(new NewsRealm(news.getTitle(), news.getDescription(), news.getUrl(), news.getUrlToImage(), DataConstants.RssTypes.JSON_RSS_VALUE));
        }
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(newsRealmRealmList));
        realm.close();
    }

    public static void storeXMLNews(List<News> newsList){
        RealmList<NewsRealm> newsRealmRealmList = new RealmList<>();
        for (News news : newsList){
            newsRealmRealmList.add(new NewsRealm(news.getTitle(), news.getDescription(), news.getUrl(), news.getUrlToImage(), DataConstants.RssTypes.XML_RSS_VALUE));
        }
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(newsRealmRealmList));
        realm.close();
    }

    public static List<News> getJSONNewsFromRealm(){
        List<News> newsList = new ArrayList<>();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<NewsRealm> result = realm.where(NewsRealm.class).equalTo("rssType", DataConstants.RssTypes.JSON_RSS_VALUE).findAll();
        for (NewsRealm newsRealm : result){
            newsList.add(new News(newsRealm.getTitle(), newsRealm.getDescription(), newsRealm.getUrl(), newsRealm.getUrlToImage()));
        }
        realm.close();
        return newsList;
    }

    public static List<News> getXMLNewsFromRealm(){
        List<News> newsList = new ArrayList<>();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<NewsRealm> result = realm.where(NewsRealm.class).equalTo("rssType", DataConstants.RssTypes.XML_RSS_VALUE).findAll();
        for (NewsRealm newsRealm : result){
            newsList.add(new News(newsRealm.getTitle(), newsRealm.getDescription(), newsRealm.getUrl(), newsRealm.getUrlToImage()));
        }
        realm.close();
        return newsList;
    }
}
