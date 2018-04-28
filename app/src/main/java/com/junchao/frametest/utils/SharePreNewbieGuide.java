package com.junchao.frametest.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 本地资源信息保存数据
 *
 * @author liqingyuan
 * @version 1.3.4
 * @since 2016-03-15
 */
public class SharePreNewbieGuide {

    public static final String CACHE_LOCATION = "location";

    public static final String SEARCH_X = "search_x";
    public static final String SEARCHE_Y = "search_y";
    public static final String SEARCHE_ISSAVE = "search_issave";
    public static final String WEBSITE_X = "website_x";
    public static final String WEBSITE_Y = "website_y";
    public static final String WEBSITE_ISSAVE = "website_issave";
    public static final String SELFSUPPORT_X = "selfsupport_x";
    public static final String SELFSUPPORT_Y = "selfsupport_y";
    public static final String SELFSUPPORT_ISSAVE = "selfsupport_issave";
    public static final String VIP_X = "vip_x";
    public static final String VIP_Y = "vip_y";
    public static final String VIP_ISSAVE = "vip_issave";
    public static final String VOICE_X = "voice_x";
    public static final String VOICE_Y = "voice_y";
    public static final String VOICE_ISSAVE = "voice_issave";
    public static final String MINE_X = "mine_x";
    public static final String MINE_Y = "mine_y";
    public static final String MINE_ISSAVE = "mine_issave";

    private static SharePreNewbieGuide instance;
    private Context context;
    private Editor edit = null;
    private SharedPreferences sp = null;

    /**
     * Create DefaultSharedPreferences
     *
     * @param context
     */
    private SharePreNewbieGuide(Context context) {
        this(context, CACHE_LOCATION);
    }

    /**
     * Create SharedPreferences by filename
     *
     * @param context
     * @param filename
     */
    private SharePreNewbieGuide(Context context, String filename) {
        this(context, context.getSharedPreferences(filename, Context.MODE_PRIVATE));
    }

    /**
     * Create SharedPreferences by SharedPreferences
     *
     * @param context
     * @param sp
     */
    private SharePreNewbieGuide(Context context, SharedPreferences sp) {
        this.context = context;
        this.sp = sp;
        edit = sp.edit();
    }

    public static SharePreNewbieGuide getInstance(Context context) {
        if (instance == null) {
            instance = new SharePreNewbieGuide(context);
        }
        return instance;
    }

    // Boolean
    public SharePreNewbieGuide setValue(String key, boolean value) {
        edit.putBoolean(key, value);
        edit.commit();
        return SharePreNewbieGuide.this;
    }

    public SharePreNewbieGuide setValue(int resKey, boolean value) {
        setValue(this.context.getString(resKey), value);
        return SharePreNewbieGuide.this;
    }

    // Float
    public SharePreNewbieGuide setValue(String key, float value) {
        edit.putFloat(key, value).commit();
        return SharePreNewbieGuide.this;
    }

    public SharePreNewbieGuide setValue(int resKey, float value) {
        setValue(this.context.getString(resKey), value);
        return SharePreNewbieGuide.this;
    }

    // Integer
    public SharePreNewbieGuide setValue(String key, int value) {
        edit.putInt(key, value).commit();
        return SharePreNewbieGuide.this;
    }

    public SharePreNewbieGuide setValue(int resKey, int value) {
        setValue(this.context.getString(resKey), value);
        return SharePreNewbieGuide.this;
    }

    // Long
    public SharePreNewbieGuide setValue(String key, long value) {
        edit.putLong(key, value).commit();
        return SharePreNewbieGuide.this;
    }

    public SharePreNewbieGuide setValue(int resKey, long value) {
        setValue(this.context.getString(resKey), value);
        return SharePreNewbieGuide.this;
    }

    // String
    public SharePreNewbieGuide setValue(String key, String value) {
        edit.putString(key, value).commit();
        return SharePreNewbieGuide.this;
    }

    public SharePreNewbieGuide setValue(int resKey, String value) {
        setValue(this.context.getString(resKey), value);
        return SharePreNewbieGuide.this;
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
