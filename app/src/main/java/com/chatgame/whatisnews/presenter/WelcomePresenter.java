package com.chatgame.whatisnews.presenter;

import com.chatgame.whatisnews.base.RxPresenter;
import com.chatgame.whatisnews.model.bean.WelcomeBean;
import com.chatgame.whatisnews.model.http.RetrofitHelper;
import com.chatgame.whatisnews.presenter.Contract.WelcomeContract;
import com.chatgame.whatisnews.utils.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by duchao on 2016/12/9.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {


    private static String RES = "1080*1776";

    static final int COUNT_DOWN_TIME = 2200;
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public WelcomePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getWelcomeData() {
        Subscription rxSubscrption = mRetrofitHelper.fetchWelcomeInfo(RES)
                .compose(RxUtil.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Action1<WelcomeBean>() {
                    @Override
                    public void call(WelcomeBean welcomeBean) {

                        mView.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("");
                        mView.jumpToMain();
                    }
                });
        addSubscrebe(rxSubscrption);
    }

    public void startCountDown() {
        Subscription rxSubscrption = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
        addSubscrebe(rxSubscrption);
    }
}
