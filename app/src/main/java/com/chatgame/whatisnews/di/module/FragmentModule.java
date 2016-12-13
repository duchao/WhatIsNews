package com.chatgame.whatisnews.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.chatgame.whatisnews.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duchao on 2016/12/7.
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideFragment() {
        return mFragment.getActivity();
    }

}
