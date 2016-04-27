package com.pcl.vlad.di;

import android.app.Application;
import android.content.SharedPreferences;

import com.reggar.twittersearchmvp.di.ApplicationModule;
import com.reggar.twittersearchmvp.sync.twitter.TwitterClient;
import com.reggar.twittersearchmvp.utils.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class MockApplicationModule extends ApplicationModule {
    private TwitterClient overrideTwitterClient;
    private Scheduler overrideSubscribeOn;
    private Scheduler overrideObserveOn;

    public MockApplicationModule(Application app) {
        super(app);
    }

    @Override
    public TwitterClient provideTwitterClient() {
        if(overrideTwitterClient != null) {
            return overrideTwitterClient;
        }
        return super.provideTwitterClient();
    }

    @Override
    public Scheduler provideSubscribeOn() {
        if(overrideSubscribeOn != null) {
            return overrideSubscribeOn;
        }
        return super.provideSubscribeOn();
    }

    @Override
    public Scheduler provideObserveOn() {
        if(overrideObserveOn != null) {
            return overrideObserveOn;
        }
        return super.provideObserveOn();
    }

    public void setOverrideTwitterClient(TwitterClient overrideTwitterClient) {
        this.overrideTwitterClient = overrideTwitterClient;
    }

    public void setOverrideSubscribeOn(Scheduler overrideSubscribeOn) {
        this.overrideSubscribeOn = overrideSubscribeOn;
    }

    public void setOverrideObserveOn(Scheduler overrideObserveOn) {
        this.overrideObserveOn = overrideObserveOn;
    }
}
