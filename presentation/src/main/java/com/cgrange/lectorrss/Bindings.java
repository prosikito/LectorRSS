package com.cgrange.lectorrss;

import android.databinding.BindingAdapter;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cgrange.lectorrss.logger.Logger;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class Bindings {

    private Bindings(){
        // private constructor to hide public one
    }

    /**
     * Setting image to imageview with glide
     * @param imageView view to set content image
     * @param url image url to load
     */
    @BindingAdapter({"app:load"})
    public static void bindLoad(@NonNull ImageView imageView, @NonNull String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Logger.log(e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Logger.log(url);
                        return false;
                    }
                })
                .into(imageView);
    }


    /**
     * Setting text from html
     * @param textView view to apply font format
     * @param text text
     */
    @BindingAdapter({"app:fromhtml"})
    public static void bindFromhtml(@NonNull TextView textView, @NonNull String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
        }
        else{
            textView.setText(Html.fromHtml(text));
        }
    }
}
