package com.reggar.twittersearchmvp;

import com.reggar.twittersearchmvp.di.ApplicationModule;

public class TestReggarApplication extends ReggarApplication {
    protected ApplicationModule applicationModule;

    @Override
    public ApplicationModule getApplicationModule() {
        if(applicationModule == null) {
            applicationModule = new ApplicationModule(this);
        }
        return applicationModule;
    }

    public void createComponentPublic() {
        createComponent(this);
    }

    public void setApplicationModule(ApplicationModule applicationModule) {
        this.applicationModule = applicationModule;
    }
}

