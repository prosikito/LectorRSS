package com.cgrange;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Cristian on 22/07/2017.
 *
 */

@Root(name = "rss", strict = false)
public class RssFeed implements Serializable {

    @Element
    private
    RssChannel channel;

    public RssChannel getChannel() {
        return channel;
    }

    public void setChannel(RssChannel channel) {
        this.channel = channel;
    }
}
