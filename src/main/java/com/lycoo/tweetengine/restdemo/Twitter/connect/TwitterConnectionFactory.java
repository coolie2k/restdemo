package com.lycoo.tweetengine.restdemo.Twitter.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.twitter.api.Twitter;


public class TwitterConnectionFactory extends OAuth1ConnectionFactory<Twitter> {

    public TwitterConnectionFactory(String consumerKey, String consumerSecret) {
        super("twitter", new TwitterServiceProvider(consumerKey, consumerSecret), new TwitterAdapter());
    }

}
