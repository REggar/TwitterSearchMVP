package com.reggar.twittersearchmvp.ui.main;

import android.os.Bundle;

import com.pcl.vlad.TestReggarApplication;
import com.pcl.vlad.di.MockApplicationModule;
import com.pcl.vlad.utils.MockData;
import com.reggar.twittersearchmvp.BuildConfig;
import com.reggar.twittersearchmvp.models.Tweet;
import com.reggar.twittersearchmvp.sync.twitter.TwitterClient;

import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class,
        application = TestReggarApplication.class)
public class MainPresenterTest {
    public static final String SEARCH_QUERY = "test";

    MainPresenter presenter;

    TwitterClient mockTwitterClient;
    MainActivity mockMainActivity;

    @Before
    public void setup() {
        TestReggarApplication app = (TestReggarApplication) RuntimeEnvironment.application;

        MockApplicationModule mockAppModule = new MockApplicationModule(app);

        mockTwitterClient = mock(TwitterClient.class);
        mockMainActivity = mock(MainActivity.class);

        mockAppModule.setOverrideObserveOn(Schedulers.immediate());
        mockAppModule.setOverrideSubscribeOn(Schedulers.immediate());
        mockAppModule.setOverrideTwitterClient(mockTwitterClient);

        app.setApplicationModule(mockAppModule);

        presenter = new MainPresenter();
    }

    @Test
    public void testSearch() throws Exception {
        List<Tweet> tweetList = MockData.getMockTweets();

        when(mockTwitterClient.search(SEARCH_QUERY))
                .thenReturn(Observable.just(tweetList));

        presenter.onCreate(null);
        presenter.takeView(mockMainActivity);
        presenter.search(SEARCH_QUERY);

        verify(mockMainActivity)
                .updateTweets(tweetList);
    }

    @Test
    public void testRefresh() throws Exception {
        List<Tweet> tweetList = MockData.getMockTweets();

        when(mockTwitterClient.search(""))
                .thenReturn(Observable.just(tweetList));

        presenter.onCreate(null);
        presenter.takeView(mockMainActivity);
        presenter.refresh();

        verify(mockMainActivity)
                .updateTweets(tweetList);
    }
}