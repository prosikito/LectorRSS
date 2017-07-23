package com.cgrange.lectorrss.settings;

import android.support.annotation.NonNull;

import com.cgrange.data.LectorRSSRepository;

/**
 * Created by Cristian on 23/07/2017.
 *
 */

class SettingsInteractor implements SettingsContracts.Interactor {

    private SettingsContracts.SettingsView view;

    SettingsInteractor(SettingsContracts.SettingsView view) {
        this.view = view;
    }

    @Override
    public void storeFeedUrl(@NonNull String url) {
        LectorRSSRepository.storeFeedUrl(view.getContext(), url);
    }
}
