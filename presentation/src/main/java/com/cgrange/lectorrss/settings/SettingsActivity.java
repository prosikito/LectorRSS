package com.cgrange.lectorrss.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.cgrange.data.LectorRSSRepository;
import com.cgrange.lectorrss.abstracts.AbstractActivity;
import com.cgrange.lectorrss.R;
import com.cgrange.lectorrss.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AbstractActivity implements SettingsContracts.SettingsView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySettingsBinding activitySettingsBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        setSupportActionBar(activitySettingsBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.settings);
        }
        SettingsContracts.Presenter presenter = new SettingsPresenter(this);
        activitySettingsBinding.setPresenter(presenter);

        // SET UP SPINNER TO DISPLAY AVAILABLE URLS
        String[] spinnerArray =  getResources().getStringArray(R.array.json_feed_urls);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySettingsBinding.spinner.setAdapter(adapter);
        activitySettingsBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.selectedFeedUrl(spinnerArray[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // unused
            }
        });

        // PRE-SELECT CURRENT URL IN SPINNER
        for (int i=0; i<spinnerArray.length;i++){
            if (spinnerArray[i].equals(LectorRSSRepository.getFeedUrl(this))){
                activitySettingsBinding.spinner.setSelection(i);
            }
        }
    }
}
