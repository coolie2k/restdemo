package com.lycoo.tweetengine.restdemo.Twitter.api.impl;

import org.springframework.social.twitter.api.Trends;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Holds a Trends object deserialized from Twitter's local trends JSON structure.
 * Provides a convenient place to hang the @JsonDeserialize annotation.
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonDeserialize(using = LocalTrendsDeserializer.class)
class LocalTrendsHolder {

    private final Trends trends;

    public LocalTrendsHolder(Trends trends) {
        this.trends = trends;
    }

    public Trends getTrends() {
        return trends;
    }

}
