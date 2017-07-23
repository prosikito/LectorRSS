package com.cgrange.data.cloud;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

class RetrofitXMLClient {

    private static Retrofit retrofit = null;

    private RetrofitXMLClient(){
        // unused
    }

    // RETROFIT CLIENT FOR JSON FEED NEWS - XATAKA BASE URL
    static Retrofit getClient() {
       if (retrofit == null ) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            SimpleXmlConverterFactory conv = SimpleXmlConverterFactory.createNonStrict();
            retrofit = new Retrofit.Builder()
                    .baseUrl(UrlFactory.XATAKA_NEWS_BASE_URL)
                    .client(client)
                    .addConverterFactory(conv)
                    .build();
        }

        return retrofit;
    }
}
