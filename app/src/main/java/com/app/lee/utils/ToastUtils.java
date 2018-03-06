package com.app.lee.utils;

import android.widget.Toast;

import com.app.lee.base.BaseApplication;


/**
 * Created by wenxin
 */
public class ToastUtils {
    private static Toast toast = null; //Toast的对象！

    private ToastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message) {
        if (toast == null) {//改为静态吐司。防止多次点击反复弹出
            toast = Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        if (isShow)
            toast.show();
    }


    /**
     * 短时间显示Toast
     *
     */
    public static void showShort(int id) {
        if (toast == null) {//改为静态吐司。防止多次点击反复弹出
            toast = Toast.makeText(BaseApplication.getAppContext(), id, Toast.LENGTH_SHORT);
        } else {
            toast.setText(id);
        }
        if (isShow)
            toast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(CharSequence message) {
        if (isShow)
            Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(int message) {
        if (isShow)
            Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(BaseApplication.getAppContext(), message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(int message, int duration) {
        if (isShow)
            Toast.makeText(BaseApplication.getAppContext(), message, duration).show();
    }

}