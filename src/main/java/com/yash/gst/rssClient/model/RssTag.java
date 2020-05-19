package com.yash.gst.rssClient.model;

public class RssTag {
    private ChannelTag channelTag;

    @Override
    public String toString () {
        return "RssTag[" + channelTag + ']';
    }

    public ChannelTag getChannelTag () {
        return channelTag;
    }

    public void setChannelTag ( final ChannelTag channelTag ) {
        this.channelTag = channelTag;
    }
}
