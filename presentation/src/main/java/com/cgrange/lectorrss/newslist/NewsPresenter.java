package com.cgrange.lectorrss.newslist;

import android.support.annotation.NonNull;

import com.cgrange.News;
import com.cgrange.RssFeedItem;
import com.cgrange.data.constants.DataConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class NewsPresenter implements NewsContracts.Presenter {

    private NewsContracts.NewsView view;
    private NewsContracts.Interactor interactor;
    private NewsContracts.Router router;
    @DataConstants.RssTypes
    private int rssType;

    private List<News> newsList = new ArrayList<>();

    public NewsPresenter(NewsContracts.NewsView view, @DataConstants.RssTypes int type) {
        rssType    = type;
        this.view  = view;
        interactor = new NewsInteractor(view, this);
        router     = new NewsRouter(view);
    }

    @Override
    @NonNull
    public List<News> getNews() {
        return newsList;
    }

    @Override
    public void updateNewsList(@NonNull List<News> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        view.updateList();
    }

    @Override
    public void requestNews() {
        if (rssType == DataConstants.RssTypes.JSON_RSS_VALUE)
            interactor.requestJSONNews();
        if (rssType == DataConstants.RssTypes.XML_RSS_VALUE)
            interactor.requestXMLNews();
    }

    @Override
    public void onNewsClick(News news) {
        router.openNews(news);
    }


    // IN ORDER TO USE THE SAME VIEWS AND LOGIC, WE PARSE THE RSSFEEDITEMS TO A NEWS OBJECT
    @Override
    public List<News> convertRssFeedItemToNews(List<RssFeedItem> news){
        List<News> newsAux = new ArrayList<>();
        for (RssFeedItem feedItem : news) {
            Document doc = Jsoup.parse(feedItem.getDescription());
            Element imageElement = doc.select("img").first();
            newsAux.add(new News(
                                feedItem.getTitle(),
                                doc.body().text(),
                                feedItem.getLink(),
                                imageElement.absUrl("src")));
        }
        return newsAux;
    }
}
