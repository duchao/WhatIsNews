package com.chatgame.whatisnews.ui.main.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chatgame.whatisnews.MainActivity;
import com.chatgame.whatisnews.R;
import com.chatgame.whatisnews.base.BaseActivity;
import com.chatgame.whatisnews.component.ImageLoader;
import com.chatgame.whatisnews.model.bean.WelcomeBean;
import com.chatgame.whatisnews.presenter.Contract.WelcomeContract;
import com.chatgame.whatisnews.presenter.WelcomePresenter;

import butterknife.BindView;

/**
 * Created by duchao on 2016/12/9.
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.img_welcome_bg)
    ImageView mImgWelcomeBg;
    @BindView(R.id.txt_welcome_author)
    TextView mTxtWelcomeAuthor;

    @Override
    public int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void initEnventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ImageLoader.loader(this, welcomeBean.getImg(), mImgWelcomeBg);
        mImgWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f)
                .setDuration(2000).setStartDelay(100).start();
        mTxtWelcomeAuthor.setText(welcomeBean.getText());
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void onDestroy() {
        Glide.clear(mImgWelcomeBg);
        super.onDestroy();
    }
}
