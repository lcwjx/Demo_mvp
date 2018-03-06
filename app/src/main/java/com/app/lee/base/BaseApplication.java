package com.app.lee.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by lichen on 2017/12/26.
 */

public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        ARouter.openLog();  // 开启日志
        ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        ARouter.openDebug();
        ARouter.init(this);
    }

    public static BaseApplication getAppContext() {
        return baseApplication;
    }
}
