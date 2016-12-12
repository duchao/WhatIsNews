package com.chatgame.whatisnews.app;

import java.io.File;

/**
 * Created by duchao on 2016/12/5.
 */

public class Constants {
    //================= PATH ====================

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
}
