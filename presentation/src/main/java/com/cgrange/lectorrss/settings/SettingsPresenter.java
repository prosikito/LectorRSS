package com.cgrange.lectorrss.settings;

import android.support.annotation.NonNull;

/**
 * Created by Cristian on 23/07/2017.
 *
 */

public class SettingsPresenter implements SettingsContracts.Presenter {

    private SettingsContracts.Interactor interactor;

    public SettingsPresenter(SettingsContracts.SettingsView view) {
        this.interactor = new SettingsInteractor(view);
    }

    @Override
    public void selectedFeedUrl(@NonNull String url) {
        interactor.storeFeedUrl(url);
    }
}
