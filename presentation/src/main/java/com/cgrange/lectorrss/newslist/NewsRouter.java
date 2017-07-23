package com.cgrange.lectorrss.newslist;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.cgrange.News;
import com.cgrange.lectorrss.navigation.NavigationController;
import com.cgrange.lectorrss.newsdetail.NewsDetailActivity;

import org.parceler.Parcels;

/**
 * Created by Cristian on 22/07/2017.
 *
 */
class NewsRouter implements NewsContracts.Router{

    private NewsContracts.NewsView view;

    NewsRouter(NewsContracts.NewsView view) {
        this.view = view;
    }

    @Override
    public void openNews(@NonNull News news) {
        // USE OF PARCELER LIBRARY
        Bundle bundle = new Bundle();
        bundle.putParcelable(NavigationController.EXTRA_NEWS, Parcels.wrap(news));
        view.startActivity(NewsDetailActivity.class, false, bundle, false, null);
    }
}
