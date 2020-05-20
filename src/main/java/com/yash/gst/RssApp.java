package com.yash.gst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.yash.gst.rssClient.FeedParser;
import com.yash.gst.rssClient.model.FeedMessage;
import com.yash.gst.rssClient.model.RSSFeed;

public class RssApp {

    public static void main ( final String[] args ) throws IOException {
        final String feedUrl = "http://localhost:8080/rss-feed-converter";
        getRssFeed ( feedUrl );
    }
    public static RSSFeed getRssFeed ( final String rssUrl ) throws IOException {
        final File csvFile = new File ( "/dev/rssFeed.csv" );
        final FileWriter writer = new FileWriter(csvFile);
        writer.write ( "title, pubDate, description, link, creator, guid\n" );
        final FeedParser parser = new FeedParser ( rssUrl );
        final RSSFeed RSSFeed = parser.readRSSFeed ();
        //System.out.println( RSSFeed );
        for ( final FeedMessage message : RSSFeed.getMessages()) {
            writer.write ( message.makeCSVString () );
        }
        writer.close ();
        return RSSFeed;
    }
}
