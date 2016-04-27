package com.reggar.twittersearchmvp.sync.twitter;

import com.reggar.twittersearchmvp.models.Tweet;

import java.util.List;

import rx.Observable;

/**
 * A client for accessing Twitter.
 */
public interface TwitterClient {
    /**
     *
     * @param query The query to search Twitter for. Queries operators can also be used,
     *              visit {@see <a href="https://dev.twitter.com/rest/public/search">Twitters documentation</a>} for more information
     * @return A list of {@link Tweet Tweets} that contain the search query
     */
    Observable<List<Tweet>> search(String query);
}
