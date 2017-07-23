package com.cgrange.lectorrss.newslist;

import android.support.annotation.NonNull;

import com.cgrange.News;
import com.cgrange.RssFeedItem;
import com.cgrange.lectorrss.abstracts.IView;

import java.util.List;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class NewsContracts {

    interface NewsView extends IView {
    }

    interface Interactor {
        void requestJSONNews();
        void requestXMLNews();
    }

    public interface Presenter {
        @NonNull List<News> getNews();
        void updateNewsList(@NonNull List<News> newsList);
        void requestNews();
        List<News> convertRssFeedItemToNews(List<RssFeedItem> news);
        void onNewsClick(News news);
    }

    @FunctionalInterface
    interface Router {
        void openNews(@NonNull News news);
    }
}
