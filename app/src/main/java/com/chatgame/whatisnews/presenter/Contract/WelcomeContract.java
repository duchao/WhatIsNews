package com.chatgame.whatisnews.presenter.Contract;

import com.chatgame.whatisnews.base.BasePresenter;
import com.chatgame.whatisnews.base.BaseView;
import com.chatgame.whatisnews.model.bean.WelcomeBean;

/**
 * Created by duchao on 2016/12/9.
 */

public interface WelcomeContract {
    interface View extends BaseView {
        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter<View> {
        void getWelcomeData();
    }


}
