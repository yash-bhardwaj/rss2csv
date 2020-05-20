package com.yash.gst.rssClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import com.yash.gst.rssClient.model.RSSFeed;
import com.yash.gst.rssClient.model.FeedMessage;

/**
 * The type Feed parser.
 */
public class FeedParser {
    private static final String TITLE = "title";
    private static final String LINK = "link";
    private static final String GUID = "guid";
    private static final String DESCRIPTION = "description";
    private static final String PUB_DATE = "pubDate";
    private static final String AUTHOR = "creator";
    private static final String LANGUAGE = "language";
    private static final String COPYRIGHT = "copyright";
    private static final String ITEM = "item";

    /**
     * The Url.
     */
    final URL url;

    /**
     * Instantiates a new Feed parser.
     *
     * @param feedUrl
     *         the feed url
     */
    public FeedParser ( final String feedUrl ) {
        try {
            this.url = new URL ( feedUrl );
        } catch (final MalformedURLException e) {
            throw new RuntimeException ( e );
        }
    }

    /**
     * Read rss feed rss feed.
     *
     * @return the rss feed
     */
    public RSSFeed readRSSFeed () {
        RSSFeed rssFeed = null;
        try {
            boolean isFeedHeader = true;
            String description = "", title = "", link = "", language = "", copyright = "", author = "",
                    pubDate = "", guid = "";
            final XMLInputFactory inputFactory = XMLInputFactory.newInstance ();
            final InputStream in = readRssStream ();
            final XMLEventReader reader = inputFactory.createXMLEventReader ( in );

            while ( reader.hasNext () ) {
                final XMLEvent event = reader.nextEvent ();
                if ( event.isStartElement () ) {
                    final String localPart = event.asStartElement ().getName ().getLocalPart ();
                    switch (localPart) {
                    case ITEM:
                        if ( isFeedHeader ) {
                            isFeedHeader = false;
                            rssFeed = new RSSFeed ( title, link, description, language, copyright, pubDate );
                        }
                        reader.nextEvent ();
                        break;
                    case TITLE: title = getTagText ( reader ); break;
                    case DESCRIPTION: description = getTagText ( reader ); break;
                    case LINK: link = getTagText ( reader ); break;
                    case GUID: guid = getTagText ( reader ); break;
                    case LANGUAGE: language = getTagText ( reader ); break;
                    case AUTHOR: author = getTagText ( reader ); break;
                    case PUB_DATE: pubDate = getTagText ( reader ); break;
                    case COPYRIGHT: copyright = getTagText ( reader ); break;
                    }
                } else if ( event.isEndElement () ) {
                    if ( event.asEndElement ().getName ().getLocalPart ().equals ( ITEM ) ) {
                        final FeedMessage message = new FeedMessage ();
                        message.setAuthor ( author );
                        message.setDescription ( description );
                        message.setGuid ( guid );
                        message.setLink ( link );
                        message.setTitle ( title );
                        message.setPubDate ( pubDate.replace ( ",", " " ) );
                        Objects.requireNonNull ( rssFeed ).getMessages ().add ( message );
                        reader.nextEvent ();
                        continue;
                    }
                }
            }
        } catch (final XMLStreamException e) {
            throw new RuntimeException ( e.getMessage () );
        }
        return rssFeed;
    }

    private String getTagText ( final XMLEventReader eventReader ) throws XMLStreamException {
        String tagText = null;
        final XMLEvent event = eventReader.nextEvent ();
        if ( event instanceof Characters ) {
            tagText = event.asCharacters ().getData ();
        }
        return tagText;
    }

    private InputStream readRssStream () {
        try {
            return url.openStream ();
        } catch (final IOException e) {
            throw new RuntimeException ( e.getMessage () );
        }
    }
}
