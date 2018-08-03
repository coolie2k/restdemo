package com.lycoo.tweetengine.restdemo.Twitter.api.impl;

import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;

class SearchParametersUtil {

    public static MultiValueMap<String, String> buildQueryParametersFromSearchParameters(SearchParameters searchParameters) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set("q", searchParameters.getQuery());
        if (searchParameters.getGeoCode() != null) {
            parameters.set("geocode", searchParameters.getGeoCode().toString());
        }
        if (searchParameters.getLang() != null) {
            parameters.set("lang", searchParameters.getLang());
        }
        if (searchParameters.getLocale() != null) {
            parameters.set("locale", searchParameters.getLocale());
        }
        if (searchParameters.getResultType() != null) {
            parameters.set("result_type", searchParameters.getResultType().toString());
        }
        parameters.set("count", searchParameters.getCount() != null ? String.valueOf(searchParameters.getCount()) : String.valueOf(DEFAULT_RESULTS_PER_PAGE));
        if (searchParameters.getUntil() != null) {
            parameters.set("until", new SimpleDateFormat("yyyy-MM-dd").format(searchParameters.getUntil()));
        }
        if (searchParameters.getSinceId() != null) {
            parameters.set("since_id", String.valueOf(searchParameters.getSinceId()));
        }
        if (searchParameters.getMaxId() != null) {
            parameters.set("max_id", String.valueOf(searchParameters.getMaxId()));
        }
        if (!searchParameters.isIncludeEntities()) {
            parameters.set("include_entities", "false");
        }
        return parameters;
    }

    public static final int DEFAULT_RESULTS_PER_PAGE = 50;

}