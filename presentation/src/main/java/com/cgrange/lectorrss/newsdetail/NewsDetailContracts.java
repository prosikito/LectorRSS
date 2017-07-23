package com.cgrange.lectorrss.newsdetail;

import android.support.annotation.NonNull;

import com.cgrange.lectorrss.abstracts.IView;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class NewsDetailContracts {
    interface NewsDetailView extends IView{
    }

    public interface Presenter {
        void onCreate();
        void openInBrowserClick(@NonNull String url);
    }
}
