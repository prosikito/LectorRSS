package com.cgrange.lectorrss.main;

import com.cgrange.lectorrss.settings.SettingsActivity;

/**
 * Created by Cristian on 23/07/2017.
 *
 */

class MainRouter implements MainContracts.Router {

    private MainContracts.MainView view;

    MainRouter(MainContracts.MainView view) {
        this.view = view;
    }

    @Override
    public void openSettings() {
        view.startActivity(SettingsActivity.class, false, null, false, null);
    }
}
