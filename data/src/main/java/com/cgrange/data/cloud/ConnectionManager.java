package com.cgrange.data.cloud;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cgrange.JSONNewsResponse;
import com.cgrange.RssFeed;
import com.cgrange.data.LectorRSSRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class ConnectionManager {

    private ConnectionManager(){
        // unused
    }

    // CREATES RETROFIT CLIENT AND REQUESTS JSON FEED NEWS FROM URL STORED IN PREFERENCES
    public static void getJSONNews(@NonNull Observer<JSONNewsResponse> observer, @NonNull Context context){
        RetrofitJSONClient.getClient()
                .create(LectorRSSServices.class)
                .getJSONNews(LectorRSSRepository.getFeedUrl(context))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }


    // CREATES RETROFIT CLIENT AND REQUEST XML FEED NEWS
    public static void getXMLNews(@NonNull ConnectionListener<RssFeed> connectionListener){
        RetrofitXMLClient.getClient()
                .create(LectorRSSServices.class)
                .getXMLNews()
                .enqueue(new Callback<RssFeed>() {
                    @Override
                    public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                        RssFeed feed = response.body();
                        connectionListener.onResponse(feed);
                    }

                    @Override
                    public void onFailure(Call<RssFeed> call, Throwable t) {
                        connectionListener.onError(t);
                    }
                });
    }
}
