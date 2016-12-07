package com.chatgame.whatisnews.di.module;

import android.app.Activity;

import com.chatgame.whatisnews.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duchao on 2016/12/7.
 */
@Module
public class ActivityModule {
    Activity mActivity;
    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

}
