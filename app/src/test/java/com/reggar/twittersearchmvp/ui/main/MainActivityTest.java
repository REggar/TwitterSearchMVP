package com.reggar.twittersearchmvp.ui.main;

import com.pcl.vlad.TestReggarApplication;
import com.reggar.twittersearchmvp.BuildConfig;
import com.reggar.twittersearchmvp.models.Tweet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class,
        application = TestReggarApplication.class)
public class MainActivityTest {
    MainActivity activity;

    @Before
    public void setup() {
        TestReggarApplication app = (TestReggarApplication) RuntimeEnvironment.application;
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }


    @Test
    public void testViewBinding() throws Exception {
        assertNotNull(activity.toolbar);
        assertNotNull(activity.recyclerView);
        assertNotNull(activity.searchButton);
        assertNotNull(activity.searchQuery);
        assertNotNull(activity.swipeRefresh);
    }
    @Test
    public void testUpdateTweets() throws Exception {
        activity.swipeRefresh.setRefreshing(true);
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet());
        tweets.add(new Tweet());

        activity.updateTweets(tweets);

        //assertEquals(2, activity.recyclerView.getChildCount());
        assertFalse(activity.swipeRefresh.isRefreshing());
    }
}
