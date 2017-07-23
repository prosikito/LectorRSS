package com.cgrange.lectorrss.newslist;

import android.support.v7.widget.RecyclerView;

import com.cgrange.News;
import com.cgrange.lectorrss.databinding.NewsRowBinding;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

class NewsViewHolder extends RecyclerView.ViewHolder {

    private NewsRowBinding binding;

    NewsViewHolder(NewsRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(News news){
        binding.setNews(news);
        binding.executePendingBindings();
    }
}
