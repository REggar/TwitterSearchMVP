package com.reggar.twittersearchmvp.sync.twitter;

import com.reggar.twittersearchmvp.BuildConfig;
import com.reggar.twittersearchmvp.models.Tweet;
import com.reggar.twittersearchmvp.sync.twitter.dto.TweetsResponse;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by rob on 26/04/2016.
 */
public class TwitterRestClientImpl implements TwitterClient {
    TwitterRestService twitterApi;

    public TwitterRestClientImpl() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(BuildConfig.CONSUMER_KEY,
                BuildConfig.CONSUMER_SECRET);
        consumer.setTokenWithSecret(BuildConfig.TOKEN, BuildConfig.TOKEN_SECRET);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("https://api.twitter.com/1.1/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        twitterApi = restAdapter.create(TwitterRestService.class);
    }

    /**
     * {@inheritDoc}
     */
    public Observable<List<Tweet>> search(String query) {
        return twitterApi.search(query)
                .map(new Func1<TweetsResponse, List<Tweet>>() {
                    @Override
                    public List<Tweet> call(TweetsResponse tweetsResponse) {
                        return tweetsResponse.tweets;
                    }
                });
    }
}
