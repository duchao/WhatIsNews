package com.chatgame.whatisnews.di.component;

import com.chatgame.whatisnews.app.App;
import com.chatgame.whatisnews.di.ContextLife;
import com.chatgame.whatisnews.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by duchao on 2016/12/7.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    App getContext();


}
