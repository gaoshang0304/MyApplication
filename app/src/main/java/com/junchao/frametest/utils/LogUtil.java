package com.junchao.frametest.utils;

import android.util.Log;

import com.junchao.frametest.config.AppConfig;

/**
 * 日志工具
 *
 * @author zhangmao
 * @version 1.0.0
 * @since 2015-04-16
 */
public class LogUtil {

    private static final String TAG = "";

    public static void d(String msg) {
        if (AppConfig.isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (AppConfig.isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void w(String msg) {
        if (AppConfig.isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (AppConfig.isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void e(String msg) {
        if (AppConfig.isDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (AppConfig.isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void i(String msg) {
        if (AppConfig.isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (AppConfig.isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void v(String msg) {
        if (AppConfig.isDebug) {
            Log.v(TAG, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (AppConfig.isDebug) {
            Log.v(tag, msg);
        }
    }


    public static void wtf(String msg) {
        if (AppConfig.isDebug) {
            Log.wtf(TAG, msg);
        }
    }

    public static void wtf(String tag, String msg) {
        if (AppConfig.isDebug) {
            Log.wtf(tag, msg);
        }
    }

    public static void json(String json) {
        if (AppConfig.isDebug) {
//            Logger.json(json);
        }
    }

}