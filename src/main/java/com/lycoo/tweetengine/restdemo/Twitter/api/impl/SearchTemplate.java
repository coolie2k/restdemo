package com.lycoo.tweetengine.restdemo.Twitter.api.impl;

import org.springframework.social.twitter.api.*;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.lycoo.tweetengine.restdemo.Twitter.api.impl.SearchParametersUtil.buildQueryParametersFromSearchParameters;


class SearchTemplate extends AbstractTwitterOperations implements SearchOperations {

    private final RestTemplate restTemplate;

    public SearchTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser, boolean isAuthorizedForApp) {
        super(isAuthorizedForUser, isAuthorizedForApp);
        this.restTemplate = restTemplate;
    }

    public SearchResults search(String query) {
        return this.search(new SearchParameters(query));
    }

    public SearchResults search(String query, int resultsPerPage) {
        SearchParameters p = new SearchParameters(query).count(resultsPerPage);
        return this.search(p);
    }

    public SearchResults search(String query, int resultsPerPage, long sinceId, long maxId) {
        SearchParameters p = new SearchParameters(query).count(resultsPerPage).sinceId(sinceId);
        if (maxId > 0) {
            p.maxId(maxId);
        }
        return this.search(p);
    }

    public SearchResults search(SearchParameters searchParameters) {
        requireEitherUserOrAppAuthorization();
        Assert.notNull(searchParameters, "Search parameters must not be null");
        MultiValueMap<String, String> parameters = buildQueryParametersFromSearchParameters(searchParameters);
        return restTemplate.getForObject(buildUri("search/tweets.json", parameters),SearchResults.class);
    }

    public List<SavedSearch> getSavedSearches() {
        requireUserAuthorization();
        return restTemplate.getForObject(buildUri("saved_searches/list.json"), SavedSearchList.class);
    }

    public SavedSearch getSavedSearch(long searchId) {
        requireUserAuthorization();
        return restTemplate.getForObject(buildUri("saved_searches/show/" + searchId + ".json"), SavedSearch.class);
    }

    public SavedSearch createSavedSearch(String query) {
        requireUserAuthorization();
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
        data.set("query", query);
        return restTemplate.postForObject(buildUri("saved_searches/create.json"), data, SavedSearch.class);
    }

    public void deleteSavedSearch(long searchId) {
        requireUserAuthorization();
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
        restTemplate.postForObject(buildUri("saved_searches/destroy/" + searchId + ".json"), data, SavedSearch.class);
    }

    // Trends

    public Trends getLocalTrends(long whereOnEarthId) {
        return getLocalTrends(whereOnEarthId, false);
    }

    public Trends getLocalTrends(long whereOnEarthId, boolean excludeHashtags) {
        requireEitherUserOrAppAuthorization();
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set("id",String.valueOf(whereOnEarthId));
        if(excludeHashtags) {
            parameters.set("exclude", "hashtags");
        }
        return restTemplate.getForObject(buildUri("trends/place.json", parameters), LocalTrendsHolder.class).getTrends();
    }

}