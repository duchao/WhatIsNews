package com.chatgame.whatisnews.di.component;

import android.app.Activity;

import com.chatgame.whatisnews.di.FragmentScope;
import com.chatgame.whatisnews.di.module.FragmentModule;

import dagger.Component;

/**
 * Created by duchao on 2016/12/7.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
}
