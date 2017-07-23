package com.cgrange.lectorrss.main;

/**
 * Created by Cristian on 23/07/2017.
 *
 */

public class MainPresenter implements MainContracts.Presenter {

    private MainContracts.Router router;

    public MainPresenter(MainContracts.MainView view) {
        this.router = new MainRouter(view);
    }

    @Override
    public void menuSettings() {
        router.openSettings();
    }
}
