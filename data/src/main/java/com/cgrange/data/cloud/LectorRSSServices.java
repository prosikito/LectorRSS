package com.cgrange.data.cloud;

import com.cgrange.JSONNewsResponse;
import com.cgrange.RssFeed;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Cristian on 22/07/2017.
 *
 */
interface LectorRSSServices {

    @GET(UrlFactory.NEWS_API_PARAMS)
    Observable<JSONNewsResponse> getJSONNews(@Query("source") String source);

    @GET(UrlFactory.XATAKA_NEWS_PARAMS)
    Call<RssFeed> getXMLNews();
}