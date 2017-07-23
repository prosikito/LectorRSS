package com.cgrange.lectorrss.newslist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgrange.data.LectorRSSRepository;
import com.cgrange.data.constants.DataConstants;
import com.cgrange.lectorrss.R;
import com.cgrange.lectorrss.abstracts.AbstractFragment;
import com.cgrange.lectorrss.databinding.FragmentNewsBinding;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class NewsFragment extends AbstractFragment implements NewsContracts.NewsView {

    private NewsAdapter adapter;
    private FragmentNewsBinding fragmentNewsBinding;
    private NewsContracts.Presenter presenter;

    private int rssType;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            rssType = bundle.getInt(DataConstants.RSS_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentNewsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);

        presenter = new NewsPresenter(this, rssType);
        fragmentNewsBinding.setPresenter(presenter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        fragmentNewsBinding.recyclerView.setLayoutManager(mLayoutManager);
        adapter = new NewsAdapter(presenter);
        fragmentNewsBinding.recyclerView.setAdapter(adapter);

        fragmentNewsBinding.swipeRefresh.setOnRefreshListener(presenter::requestNews);

        presenter.requestNews();

        return fragmentNewsBinding.getRoot();
    }

    @Override
    public void showLoading() {
        fragmentNewsBinding.swipeRefresh.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        fragmentNewsBinding.swipeRefresh.setRefreshing(false);
    }

    @Override
    public void updateList() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
        fragmentNewsBinding.emptyView.setVisibility(presenter.getNews().isEmpty() ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showConnectionError() {
        Snackbar.make(fragmentNewsBinding.recyclerView, R.string.connection_error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (LectorRSSRepository.isFeedUrlChanged(getContext()))
            presenter.requestNews();
        LectorRSSRepository.storeFeedUrlChanged(getContext(), false);
    }
}
