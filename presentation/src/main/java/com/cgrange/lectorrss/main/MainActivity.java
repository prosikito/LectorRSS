package com.cgrange.lectorrss.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cgrange.data.constants.DataConstants;
import com.cgrange.lectorrss.abstracts.AbstractActivity;
import com.cgrange.lectorrss.R;
import com.cgrange.lectorrss.databinding.ActivityMainBinding;
import com.cgrange.lectorrss.newslist.NewsFragment;

public class MainActivity extends AbstractActivity implements MainContracts.MainView{

    private static final int TAB_COUNT = 2;
    private MainContracts.Presenter presenter;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(activityMainBinding.toolbar);

        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), TAB_COUNT);

        // CREATE 2 FRAGMENTS FOR THE MAIN ACTIVITY PAGER

        NewsFragment jsonFragment = NewsFragment.newInstance();
        Bundle jsonFragmentBundle = new Bundle();
        jsonFragmentBundle.putInt(DataConstants.RSS_TYPE, DataConstants.RssTypes.JSON_RSS_VALUE);
        jsonFragment.setArguments(jsonFragmentBundle);

        NewsFragment xmlFragment  = NewsFragment.newInstance();
        Bundle xmlFragmentBundle = new Bundle();
        xmlFragmentBundle.putInt(DataConstants.RSS_TYPE, DataConstants.RssTypes.XML_RSS_VALUE);
        xmlFragment.setArguments(xmlFragmentBundle);

        pagerAdapter.addFrag(jsonFragment, getString(R.string.json));
        pagerAdapter.addFrag(xmlFragment, getString(R.string.xml));
        activityMainBinding.pager.setAdapter(pagerAdapter);

        activityMainBinding.tabLayout.setupWithViewPager(activityMainBinding.pager);

        activityMainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // WHEN WE CHANGE FRAGMENT WE WANT MENU TO REACT
                invalidateOptionsMenu();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // unused
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // unused
            }
        });

        presenter = new MainPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            presenter.menuSettings();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // PREFERENCES MENU WILL BE ONLY DISPLAYED ON JSON FEED TAB
        MenuInflater inflater = getMenuInflater();
        int currentTab =  activityMainBinding.tabLayout.getSelectedTabPosition();
        menu.clear();
        if (currentTab == 0) {
            inflater.inflate(R.menu.menu_main, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
