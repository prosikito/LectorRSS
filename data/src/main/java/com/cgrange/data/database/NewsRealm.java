package com.cgrange.data.database;

import com.cgrange.data.constants.DataConstants;

import io.realm.RealmObject;

/**
 * Created by Cristian on 23/07/2017.
 *
 * WE NEED TO CREATE THIS CLASS TO STORE NEWS IN REALM DATABASE, SINCE OUR NEWS CLASS IS IN THE DOMAIN MODULE
 * AND ITS A PURE-JAVA LIBRARY, CAN'T IMPORT REALM IN NON-ANDROID LIBRARY MODULES.
 *
 */

public class NewsRealm extends RealmObject{

    private String title;
    private String description;
    private String url;
    private String urlToImage;
    @DataConstants.RssTypes
    private int rssType;

    public NewsRealm(String title, String description, String url, String urlToImage, @DataConstants.RssTypes int rssType) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.rssType = rssType;
    }

    public NewsRealm(){
        // unused
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public int getRssType() {
        return rssType;
    }

    public void setRssType(int rssType) {
        this.rssType = rssType;
    }
}
