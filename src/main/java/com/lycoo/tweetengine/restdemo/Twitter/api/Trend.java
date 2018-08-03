package com.lycoo.tweetengine.restdemo.Twitter.api;

public class Trend extends TwitterObject {
    private final String name;

    private final String query;

    public Trend(String name, String query) {
        this.name = name;
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public String getQuery() {
        return query;
    }

}