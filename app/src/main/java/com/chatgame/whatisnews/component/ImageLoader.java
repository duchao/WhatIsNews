package com.chatgame.whatisnews.component;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by duchao on 2016/12/12.
 */

public class ImageLoader {

    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
    public static void loader(Activity activity, String url, ImageView imageView) {
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
        }
    }

}
