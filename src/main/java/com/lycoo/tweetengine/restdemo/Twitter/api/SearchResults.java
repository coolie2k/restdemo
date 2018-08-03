package com.lycoo.tweetengine.restdemo.Twitter.api;

import java.util.List;

public class SearchResults extends TwitterObject {
    private List<Tweet> tweets;
    private SearchMetadata metadata;
    private boolean lastPage;

    public SearchResults(List<Tweet> tweets, SearchMetadata metaData) {
        this(tweets, metaData, false);
    }

    public SearchResults(List<Tweet> tweets, SearchMetadata metaData, boolean lastPage) {
        this.tweets = tweets;
        this.metadata = metaData;
        this.lastPage = lastPage;
    }

    /**
     * @return the list of matching {@link Tweet}s
     */
    public List<Tweet> getTweets() {
        return tweets;
    }

    /**
     * @return the {@link SearchMetadata} associated with a particular search
     */
    public SearchMetadata getSearchMetadata() {
        return metadata;
    }

    /**
     * @return <code>true</code> if this is the last page of matching
     * {@link Tweet}s; <code>false</code> if there are more pages that follow
     * this one.
     */
    public boolean isLastPage() {
        return lastPage;
    }

}
