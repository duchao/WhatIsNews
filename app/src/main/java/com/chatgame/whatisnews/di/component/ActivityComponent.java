package com.chatgame.whatisnews.di.component;

import android.app.Activity;

import com.chatgame.whatisnews.di.ActivityScope;
import com.chatgame.whatisnews.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by duchao on 2016/12/7.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    //void inject(MainActivity mainActivity);
}
