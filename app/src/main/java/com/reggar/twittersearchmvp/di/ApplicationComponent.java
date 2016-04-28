package com.reggar.twittersearchmvp.di;

import com.reggar.twittersearchmvp.ReggarApplication;
import com.reggar.twittersearchmvp.ui.main.MainActivity;
import com.reggar.twittersearchmvp.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    /* Application */
    void inject(ReggarApplication app);

    /* Activities */
    void inject(MainActivity activity);

    /* Presenters */
    void inject(MainPresenter presenter);
}