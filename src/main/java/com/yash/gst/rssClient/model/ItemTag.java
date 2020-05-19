package com.yash.gst.rssClient.model;

public class ItemTag {
    private String title;
    private String link;
    private String guid;
    private String description;
    //private String `dc:creator`;

    @Override
    public String toString () {
        return "ItemTag[" + "title='" + title + '\'' + ", link='" + link + '\'' + ", guid='" + guid + '\''
                + ", description='" + description + '\'' + ']';
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

    public String getGuid () {
        return guid;
    }

    public void setGuid ( final String guid ) {
        this.guid = guid;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( final String description ) {
        this.description = description;
    }
}
