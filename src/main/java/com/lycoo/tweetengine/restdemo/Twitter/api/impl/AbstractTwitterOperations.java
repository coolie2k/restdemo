package com.lycoo.tweetengine.restdemo.Twitter.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

class AbstractTwitterOperations {

    private final boolean isUserAuthorized;

    private boolean isAppAuthorized;

    public AbstractTwitterOperations(boolean isUserAuthorized, boolean isAppAuthorized) {
        this.isUserAuthorized = isUserAuthorized;
        this.isAppAuthorized = isAppAuthorized;
    }

    protected void requireUserAuthorization() {
        if (!isUserAuthorized) {
            throw new MissingAuthorizationException("twitter");
        }
    }

    protected void requireAppAuthorization() {
        if (!isAppAuthorized) {
            throw new MissingAuthorizationException("twitter");
        }
    }

    protected void requireEitherUserOrAppAuthorization() {
        if (!isUserAuthorized && !isAppAuthorized) {
            throw new MissingAuthorizationException("twitter");
        }
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
    }

    private static final String API_URL_BASE = "https://api.twitter.com/1.1/";

    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

}