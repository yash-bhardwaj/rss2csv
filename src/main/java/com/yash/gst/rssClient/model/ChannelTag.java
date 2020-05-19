package com.yash.gst.rssClient.model;

public class ChannelTag {
    private String title;
    private String link;
    private String description;
    private String language;
    private String generator;
    private String lastBuildDate;
    private ItemTag item;

    @Override
    public String toString () {
        return "ChannelTag [" + "title='" + title + '\'' + ", link='" + link + '\'' + ", description='" + description
                + '\'' + ", language='" + language + '\'' + ", generator='" + generator + '\'' + ", lastBuildDate='"
                + lastBuildDate + '\'' + ", " + item + ']';
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( final String title ) {
        this.title = title;
    }

    public String getLink () {
        return link;
    }

    public void setLink ( final String link ) {
        this.link = link;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( final String description ) {
        this.description = description;
    }

    public String getLanguage () {
        return language;
    }

    public void setLanguage ( final String language ) {
        this.language = language;
    }

    public String getGenerator () {
        return generator;
    }

    public void setGenerator ( final String generator ) {
        this.generator = generator;
    }

    public String getLastBuildDate () {
        return lastBuildDate;
    }

    public void setLastBuildDate ( final String lastBuildDate ) {
        this.lastBuildDate = lastBuildDate;
    }

    public ItemTag getItem () {
        return item;
    }

    public void setItem ( final ItemTag item ) {
        this.item = item;
    }
}
