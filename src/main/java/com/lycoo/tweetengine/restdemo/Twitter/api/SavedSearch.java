package com.lycoo.tweetengine.restdemo.Twitter.api;

import java.util.Date;


public class SavedSearch extends TwitterObject {
    private final long id;

    private final String name;

    private final String query;

    private final Date createdAt;

    private final int position;

    public SavedSearch(long id, String name, String query, int position, Date createdAt) {
        this.id = id;
        this.name = name;
        this.query = query;
        this.position = position;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuery() {
        return query;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getPosition() {
        return position;
    }

}
