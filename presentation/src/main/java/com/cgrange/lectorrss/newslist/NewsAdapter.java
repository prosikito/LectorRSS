package com.cgrange.lectorrss.newslist;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cgrange.lectorrss.R;
import com.cgrange.lectorrss.databinding.NewsRowBinding;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private NewsContracts.Presenter presenter;

    NewsAdapter(NewsContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsRowBinding newsRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.news_row, parent, false);
        newsRowBinding.setPresenter(presenter);
        return new NewsViewHolder(newsRowBinding);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bind(presenter.getNews().get(position));
    }

    @Override
    public int getItemCount() {
        return presenter.getNews().size();
    }
}
