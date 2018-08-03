package com.lycoo.tweetengine.restdemo.Twitter.api;

public class SearchMetadata {

    private final long max_id;
    private final long since_id;

    public SearchMetadata(long max_id, long since_id) {
        this.max_id = max_id;
        this.since_id = since_id;
    }

    public long getMaxId() {
        return max_id;
    }

    public long getSinceId() {
        return since_id;
    }


}
