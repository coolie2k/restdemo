package com.lycoo.tweetengine.restdemo.Twitter.api;

import java.util.Date;
import java.util.List;


/**
 * Represents a list of trending topics at a specific point in time.
 * @author Craig Walls
 */
public class Trends extends TwitterObject {
    private final Date time;
    private final List<Trend> trends;

    public Trends(Date time, List<Trend> trends) {
        this.time = time;
        this.trends = trends;
    }

    public Date getTime() {
        return time;
    }

    public List<Trend> getTrends() {
        return trends;
    }

}
