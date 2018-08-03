package com.lycoo.tweetengine.restdemo.Twitter.api;


import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;
import org.springframework.social.twitter.api.SearchOperations;


public interface Twitter extends ApiBinding {


    SearchOperations searchOperations();

    /**
     * Returns the underlying {@link RestOperations} object allowing for consumption of Twitter endpoints that may not be otherwise covered by the API binding.
     * The RestOperations object returned is configured to include an OAuth "Authorization" header on all requests.
     * @return a RestOperations object instrumented for including an OAuth Authorization header on requests.
     */
    RestOperations restOperations();

}
