package com.cgrange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

public class JSONNewsResponse {

    @SerializedName("articles")
    @Expose
    private ArrayList<News> articles;

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = (ArrayList<News>) articles;
    }
}
