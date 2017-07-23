package com.cgrange.lectorrss.main;

import com.cgrange.lectorrss.abstracts.IView;

/**
 * Created by Cristian on 23/07/2017.
 *
 */

class MainContracts {

    interface MainView extends IView {

    }

    @FunctionalInterface
    interface Presenter {
        void menuSettings();
    }

    @FunctionalInterface
    interface Router {
        void openSettings();
    }
}
