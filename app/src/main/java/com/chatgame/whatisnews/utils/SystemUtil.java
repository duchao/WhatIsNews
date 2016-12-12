package com.chatgame.whatisnews.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.chatgame.whatisnews.app.App;

/**
 * Created by duchao on 2016/12/11.
 */

public class SystemUtil {
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
