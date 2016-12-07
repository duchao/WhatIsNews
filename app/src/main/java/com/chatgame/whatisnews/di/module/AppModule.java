package com.chatgame.whatisnews.di.module;

import com.chatgame.whatisnews.app.App;
import com.chatgame.whatisnews.di.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duchao on 2016/12/7.
 */
@Module
public class AppModule {
    private final App mApp;
    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return mApp;
    }
}
