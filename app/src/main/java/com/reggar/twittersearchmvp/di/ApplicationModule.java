package com.reggar.twittersearchmvp.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.reggar.twittersearchmvp.sync.twitter.TwitterClient;
import com.reggar.twittersearchmvp.sync.twitter.TwitterRestClientImpl;
import com.reggar.twittersearchmvp.utils.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class ApplicationModule {
    private Application app;

    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public TwitterClient provideTwitterClient() {
        return new TwitterRestClientImpl();
    }

    @Provides
    @Singleton
    @Named(Constants.SUBSCRIBE_ON)
    public Scheduler provideSubscribeOn() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(Constants.OBSERVE_ON)
    public Scheduler provideObserveOn() {
        return AndroidSchedulers.mainThread();
    }
}
