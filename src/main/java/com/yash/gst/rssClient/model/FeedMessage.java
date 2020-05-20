package com.yash.gst.rssClient.model;

/**
 * The type Feed message.
 */
public class FeedMessage {

    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
    private String pubDate;

    public String getPubDate () {
        return pubDate;
    }

    public void setPubDate ( final String pubDate ) {
        this.pubDate = pubDate;
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
     * Sets title.
     *
     * @param title
     *         the title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * Sets description.
     *
     * @param description
     *         the description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Sets link.
     *
     * @param link
     *         the link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author
     *         the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets guid.
     *
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Sets guid.
     *
     * @param guid
     *         the guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString () {
        return "FeedMessage{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", link='" + link
                + '\'' + ", author='" + author + '\'' + ", guid='" + guid + '\'' + ", pubDate='" + pubDate + '\'' + '}';
    }

    /**
     * Make csv string string.
     *
     * @return the string
     */
    public String makeCSVString() {
        return title.trim ()
                + ", " + pubDate
                + ", " + description.trim ()
                + ", " + link.trim ()
                + ", " + author.trim ()
                + ", " + guid.trim () + "\n";
    }
}
