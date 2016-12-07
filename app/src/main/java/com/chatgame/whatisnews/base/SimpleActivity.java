package com.chatgame.whatisnews.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chatgame.whatisnews.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by duchao on 2016/12/7.
 */

public abstract class SimpleActivity extends AppCompatActivity {
    protected Activity mActivity;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mActivity = this;
        App.getInstance().addActivity(this);
        initEventAndData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }

    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    protected abstract int getLayout();

    protected  abstract void initEventAndData();
}
