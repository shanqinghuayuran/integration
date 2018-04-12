package com.example.yanruifeng.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.yanruifeng.myapplication.utils.LogUtils;

/**
 * Created by yanruifeng on 2018/4/11.
 */

public class MyApp extends Application{
    private static Context mContext;
    private static MyApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.Builder lBuilder = new LogUtils.Builder();
        mContext=getApplicationContext();
    }
    public static Context getContext() {
        return mContext;
    }

    /**
     * 单例模式中获取唯一的MyApplication实例
     *
     * @return
     */
    public static MyApp getInstance() {
        if (null == instance) {
            instance = new MyApp();
        }
        return instance;
    }



}
