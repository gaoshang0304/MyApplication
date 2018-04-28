package com.junchao.frametest.global;

import android.app.Application;

/**
 * init application
 * Created by gjc on 2017/6/5.
 */

public class MyApplication extends Application {
    protected static MyApplication appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }
}
