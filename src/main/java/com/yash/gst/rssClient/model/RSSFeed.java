package com.yash.gst.rssClient.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rss feed.
 */
public class RSSFeed {

    private final String title;
    private final String link;
    private final String description;
    private final String language;
    private final String copyright;
    private final String pubDate;

    private final List<FeedMessage> entries = new ArrayList<> ();

    /**
     * Instantiates a new Rss feed.
     *
     * @param title
     *         the title
     * @param link
     *         the link
     * @param description
     *         the description
     * @param language
     *         the language
     * @param copyright
     *         the copyright
     * @param pubDate
     *         the pub date
     */
    public RSSFeed ( final String title, final String link, final String description, final String language,
            final String copyright, final String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    /**
     * Gets messages.
     *
     * @return the messages
     */
    public List<FeedMessage> getMessages() {
        return entries;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets copyright.
     *
     * @return the copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Gets pub date.
     *
     * @return the pub date
     */
    public String getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return "RSSFeed [copyright=" + copyright + ", description=" + description
                + ", language=" + language + ", link=" + link + ", pubDate="
                + pubDate + ", title=" + title + "]";
    }

    /**
     * Make csv string string.
     *
     * @return the string
     */
    public String makeCSVString() {
        return copyright + ", " + description + ", " + language + ", " + link + ", "
                + pubDate + ", " + title;
    }
}