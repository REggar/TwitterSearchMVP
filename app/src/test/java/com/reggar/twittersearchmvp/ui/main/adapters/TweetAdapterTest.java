package com.reggar.twittersearchmvp.ui.main.adapters;

import com.pcl.vlad.TestReggarApplication;
import com.pcl.vlad.utils.MockData;
import com.reggar.twittersearchmvp.BuildConfig;
import com.reggar.twittersearchmvp.models.Tweet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class,
        application = TestReggarApplication.class)
public class TweetAdapterTest {

    TestReggarApplication app;
    TweetAdapter adapter;
    List<Tweet> tweets;

    @Before
    public void setUp() throws Exception {
        app = (TestReggarApplication) RuntimeEnvironment.application;
        tweets = MockData.getMockTweets();
        adapter = new TweetAdapter(tweets, app);
    }

    @Test
    public void testSetTweets() throws Exception {
        List<Tweet> newTweets = MockData.getMockTweets();
        newTweets.add(new Tweet());

        assertNotEquals(newTweets, adapter.tweets);

        adapter.setTweets(newTweets);

        assertEquals(newTweets, adapter.tweets);
    }

    @Test
    public void testClear() throws Exception {
        adapter.clear();

        assertEquals(0, adapter.tweets.size());
    }
}