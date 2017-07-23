package com.cgrange.lectorrss.settings;

import android.support.annotation.NonNull;

import com.cgrange.lectorrss.abstracts.IView;

/**
 * Created by Cristian on 23/07/2017.
 *
 */

public class SettingsContracts {

    interface SettingsView extends IView{

    }

    @FunctionalInterface
    public interface Presenter {
        void selectedFeedUrl(@NonNull String url);
    }

    @FunctionalInterface
    interface Interactor {
        void storeFeedUrl(@NonNull String url);
    }
}
