package com.cgrange;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

@Root(name = "item", strict = false)
public class RssFeedItem implements Serializable {

    @Element(name = "title", required = true )
    private String title;

    @Element(name = "description", required = true )
    private  String description;

    @Element(name = "link", required = true )
    private String link;

    public RssFeedItem(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public RssFeedItem() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}

