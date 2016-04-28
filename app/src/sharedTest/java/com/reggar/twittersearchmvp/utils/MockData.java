package com.reggar.twittersearchmvp.utils;

import com.reggar.twittersearchmvp.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rob on 27/04/2016.
 */
public class MockData {
    public static List<Tweet> getMockTweets() {
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet());
        tweets.add(new Tweet());
        return tweets;
    }
}
