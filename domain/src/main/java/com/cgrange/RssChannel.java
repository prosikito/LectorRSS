package com.cgrange;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

@Root(strict = false)
public class RssChannel implements Serializable {
    @ElementList(name = "item", required = true, inline = true)
    private List<RssFeedItem> itemList;

    public RssChannel(List<RssFeedItem> mFeedItems) {
        this.itemList = mFeedItems;
    }

    public RssChannel() {
    }

    public List<RssFeedItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<RssFeedItem> itemList) {
        this.itemList = itemList;
    }
}
