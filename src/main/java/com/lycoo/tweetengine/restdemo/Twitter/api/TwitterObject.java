package com.lycoo.tweetengine.restdemo.Twitter.api;

import java.util.HashMap;
import java.util.Map;

public class TwitterObject {

    private Map<String, Object> extraData;

    public TwitterObject() {
        this.extraData = new HashMap<String, Object>();
    }


    public Map<String, Object> getExtraData() {
        return extraData;
    }

    protected void add(String key, Object value) {
        extraData.put(key, value);
    }

}