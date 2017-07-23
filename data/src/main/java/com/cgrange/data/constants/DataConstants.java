package com.cgrange.data.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class DataConstants {

    // USED TO PASS BUNDLE DATA TO NEWS DETAIL ACTIVITY
    public static final String RSS_TYPE = "RSS_TYPE";

    // USED TO STORE URL IN PREFERENCES
    public static final String FEED_URL = "FEED_URL";

    /**
     * Enumeración que representa los distintos tipos de feed.
     */
    @IntDef({RssTypes.JSON_RSS_VALUE, RssTypes.XML_RSS_VALUE})

    @Retention(RetentionPolicy.SOURCE)
    public @interface RssTypes {
        int JSON_RSS_VALUE  = 1;
        int XML_RSS_VALUE   = 2;
    }

    private DataConstants(){
        // empty private constructor to hide the public one
    }
}