package com.reggar.twittersearchmvp;

import android.app.Application;
import android.content.Context;

import com.reggar.twittersearchmvp.di.ApplicationComponent;
import com.reggar.twittersearchmvp.di.ApplicationModule;
import com.reggar.twittersearchmvp.di.DaggerApplicationComponent;

public class ReggarApplication  extends Application {
    public static ReggarApplication instance;
    protected ApplicationComponent component;

    public static ApplicationComponent getAppComponent(Context context) {
        ReggarApplication app = (ReggarApplication) context.getApplicationContext();
        if (app.component == null) {
            createComponent(app);
        }
        return app.component;
    }

    protected static void createComponent(ReggarApplication app) {
        app.component = DaggerApplicationComponent.builder()
                .applicationModule(app.getApplicationModule())
                .build();
    }

    public static void clearAppComponent(Context context) {
        ReggarApplication app = (ReggarApplication) context.getApplicationContext();
        app.component = null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    protected ApplicationModule getApplicationModule() {
        return new ApplicationModule(this);
    }
}
