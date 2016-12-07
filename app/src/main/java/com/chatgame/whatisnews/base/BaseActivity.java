package com.chatgame.whatisnews.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chatgame.whatisnews.app.App;
import com.chatgame.whatisnews.di.component.ActivityComponent;
import com.chatgame.whatisnews.di.component.DaggerActivityComponent;
import com.chatgame.whatisnews.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by duchao on 2016/12/6.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Inject
    protected T mPresenter;
    protected Activity mActivity;

    private Unbinder mUnbinder;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mActivity = this;
        initInject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
        App.getInstance().addActivity(this);
        initEnventAndData();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mUnbinder.unbind();
        App.getInstance().removeActivity(this);
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityMode())
                .build();
    }

    protected ActivityModule getActivityMode() {
        return new ActivityModule(this);
    }

    public abstract int getLayout();

    public abstract void initInject();

    public abstract void initEnventAndData();

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title );
        setSupportActionBar(toolbar);//toolbar取代actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//在左边加一个返回的图标
        getSupportActionBar().setDisplayShowHomeEnabled(true);//左上角图标可以点击
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });//左上角图标设置监听
    }
}
