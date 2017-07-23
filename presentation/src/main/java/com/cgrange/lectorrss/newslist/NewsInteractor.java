package com.cgrange.lectorrss.newslist;

import com.cgrange.JSONNewsResponse;
import com.cgrange.News;
import com.cgrange.RssFeed;
import com.cgrange.data.LectorRSSRepository;
import com.cgrange.data.cloud.ConnectionListener;
import com.cgrange.lectorrss.logger.Logger;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

class NewsInteractor implements NewsContracts.Interactor{

    private NewsContracts.NewsView view;
    private NewsContracts.Presenter presenter;

    private Disposable disposable;

    private Observer<JSONNewsResponse> jsonResponseObserver = new Observer<JSONNewsResponse>() {
        @Override
        public void onSubscribe(Disposable d) {
            disposable = d;
        }

        @Override
        public void onNext(JSONNewsResponse response) {
            LectorRSSRepository.storeJSONNews(response.getArticles());
            presenter.updateNewsList(response.getArticles());
            view.dismissLoading();
        }

        @Override
        public void onError(Throwable e) {
            Logger.log(e.getMessage());
            view.showConnectionError();

            // IF OUR REQUEST FAILS, JUST LOAD PREVIOUSLY SAVED NEWS
            presenter.updateNewsList(LectorRSSRepository.getJSONNewsOffline());
            view.dismissLoading();
        }

        @Override
        public void onComplete() {
            disposable.dispose();
        }
    };

    private ConnectionListener<RssFeed> xmlResponseObserver = new ConnectionListener<RssFeed>() {
        @Override
        public void onResponse(RssFeed response) {
            List<News> newsList = presenter.convertRssFeedItemToNews(response.getChannel().getItemList());
            LectorRSSRepository.storeXMLNews(newsList);
            presenter.updateNewsList(newsList);
            view.dismissLoading();
        }

        @Override
        public void onError(Throwable t) {
            Logger.log(t);
            view.showConnectionError();

            // IF OUR REQUEST FAILS, JUST LOAD PREVIOUSLY SAVED NEWS
            presenter.updateNewsList(LectorRSSRepository.getXMLNewsOffline());
            view.dismissLoading();
        }
    };

    NewsInteractor(NewsContracts.NewsView view, NewsContracts.Presenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public void requestJSONNews() {
        view.showLoading();
        LectorRSSRepository.getJSONNews(jsonResponseObserver, view.getContext());
    }


    @Override
    public void requestXMLNews() {
        view.showLoading();
        LectorRSSRepository.getXMLNews(xmlResponseObserver);
    }
}
