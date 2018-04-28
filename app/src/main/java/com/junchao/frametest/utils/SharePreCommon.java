package com.junchao.frametest.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 退出不清空缓存内容
 *
 * @author LQY
 */
public class SharePreCommon {

    public static final String CACHE_LOGIN_COMMON = "zjdg_common";

    public static final String URL_ONE_GO = "url_one_go";

    private static SharePreCommon instance;
    private Context context;
    private Editor edit = null;
    private SharedPreferences sp = null;

    /**
     * Create DefaultSharedPreferences
     *
     * @param context
     */
    private SharePreCommon(Context context) {
        this(context, CACHE_LOGIN_COMMON);
    }

    /**
     * Create SharedPreferences by filename
     *
     * @param context
     * @param filename
     */
    private SharePreCommon(Context context, String filename) {
        this(context, context.getSharedPreferences(filename, Context.MODE_PRIVATE));
    }

    /**
     * Create SharedPreferences by SharedPreferences
     *
     * @param context
     * @param sp
     */
    private SharePreCommon(Context context, SharedPreferences sp) {
        this.context = context;
        this.sp = sp;
        edit = sp.edit();
    }

    public static SharePreCommon getInstance(Context context) {
        if (instance == null) {
            instance = new SharePreCommon(context);
        }
        return instance;
    }

    // ====================/Set/====================

    // Boolean
    public SharePreCommon setValue(String key, boolean value) {
        edit.putBoolean(key, value);
        edit.commit();
        return SharePreCommon.this;
    }

    public SharePreCommon setValue(int resKey, boolean value) {
        setValue(this.context.getString(resKey), value);
        return SharePreCommon.this;
    }

    // Float
    public SharePreCommon setValue(String key, float value) {
        edit.putFloat(key, value).commit();
        return SharePreCommon.this;
    }

    public SharePreCommon setValue(int resKey, float value) {
        setValue(this.context.getString(resKey), value);
        return SharePreCommon.this;
    }

    // Integer
    public SharePreCommon setValue(String key, int value) {
        edit.putInt(key, value).commit();
        return SharePreCommon.this;
    }

    public SharePreCommon setValue(int resKey, int value) {
        setValue(this.context.getString(resKey), value);
        return SharePreCommon.this;
    }

    // Long
    public SharePreCommon setValue(String key, long value) {
        edit.putLong(key, value).commit();
        return SharePreCommon.this;
    }

    public SharePreCommon setValue(int resKey, long value) {
        setValue(this.context.getString(resKey), value);
        return SharePreCommon.this;
    }

    // String
    public SharePreCommon setValue(String key, String value) {
        edit.putString(key, value).commit();
        return SharePreCommon.this;
    }

    public SharePreCommon setValue(int resKey, String value) {
        setValue(this.context.getString(resKey), value);
        return SharePreCommon.this;
    }

    // ====================/Get/====================

    // Boolean
    public boolean getValue(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    public boolean getValue(int resKey, boolean defaultValue) {
        return getValue(this.context.getString(resKey), defaultValue);
    }

    // Float
    public float getValue(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    public float getValue(int resKey, float defaultValue) {
        return getValue(this.context.getString(resKey), defaultValue);
    }

    // Integer
    public int getValue(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public int getValue(int resKey, int defaultValue) {
        return getValue(this.context.getString(resKey), defaultValue);
    }

    // Long
    public long getValue(String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    public long getValue(int resKey, long defaultValue) {
        return getValue(this.context.getString(resKey), defaultValue);
    }

    // String
    public String getValue(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public String getValue(int resKey, String defaultValue) {
        return getValue(this.context.getString(resKey), defaultValue);
    }

    // Delete
    public void remove(String key) {
        edit.remove(key).commit();
    }

    public void clear() {
        sp.edit().clear().commit();
    }

}
