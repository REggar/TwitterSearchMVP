package com.reggar.twittersearchmvp.di;

import android.app.Application;

import com.reggar.twittersearchmvp.sync.twitter.TwitterClient;

import dagger.Module;
import rx.Scheduler;

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
