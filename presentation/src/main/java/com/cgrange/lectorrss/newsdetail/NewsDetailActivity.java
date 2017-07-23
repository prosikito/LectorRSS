package com.cgrange.lectorrss.newsdetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.cgrange.News;
import com.cgrange.lectorrss.abstracts.AbstractActivity;
import com.cgrange.lectorrss.R;
import com.cgrange.lectorrss.databinding.ActivityNewsDetailBinding;
import com.cgrange.lectorrss.navigation.NavigationController;

import org.parceler.Parcels;

public class NewsDetailActivity extends AbstractActivity implements NewsDetailContracts.NewsDetailView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsDetailBinding activityNewsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        setSupportActionBar(activityNewsDetailBinding.toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        News news = Parcels.unwrap(getIntent().getParcelableExtra(NavigationController.EXTRA_NEWS));
        activityNewsDetailBinding.setNews(news);

        NewsDetailContracts.Presenter presenter = new NewsDetailPresenter(this);
        activityNewsDetailBinding.setPresenter(presenter);

        presenter.onCreate();
    }
}
