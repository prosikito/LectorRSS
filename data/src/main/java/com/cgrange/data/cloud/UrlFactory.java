package com.cgrange.data.cloud;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

class UrlFactory {

    static final String NEWS_API_BASE_URL    = "https://newsapi.org/v1/articles/";
    static final String NEWS_API_PARAMS      = "?sortBy=top&apiKey=9c295ce0170c4668a70623012ecb23de";

    static final String XATAKA_NEWS_BASE_URL = "https://www.xatakandroid.com/";
    static final String XATAKA_NEWS_PARAMS   = "tag/feeds/rss2.xml";

    private UrlFactory(){
        // private constructor to hide the public one
    }
}
