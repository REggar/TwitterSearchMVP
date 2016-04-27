package com.reggar.twittersearchmvp.sync.twitter;


import com.reggar.twittersearchmvp.sync.twitter.dto.TweetsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rob on 26/04/2016.
 */
public interface TwitterRestService {
    @GET("search/tweets.json")
    Observable<TweetsResponse> search(@Query("q") String query);
}
