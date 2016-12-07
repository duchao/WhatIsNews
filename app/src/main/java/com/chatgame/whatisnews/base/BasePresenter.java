package com.chatgame.whatisnews.base;

/**
 * Created by duchao on 2016/12/6.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
