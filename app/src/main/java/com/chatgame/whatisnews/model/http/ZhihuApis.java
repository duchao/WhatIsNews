package com.chatgame.whatisnews.model.http;

import com.chatgame.whatisnews.model.bean.WelcomeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by duchao on 2016/12/12.
 */

public interface ZhihuApis {
    String HOST = "http://news-at.zhihu.com/api/4/";

    @GET("start-image/{res}")
    Observable<WelcomeBean> getWelcomeInfo(@Path("res") String res);

}
