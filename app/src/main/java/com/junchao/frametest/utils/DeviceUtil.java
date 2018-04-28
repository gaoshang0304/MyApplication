package com.junchao.frametest.utils;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.util.Set;


/**
 * 设备相关信息
 */
public class DeviceUtil {

    public static String DEVICE_RELEASE_VERSION = android.os.Build.VERSION.RELEASE; // 获取版本号

    public static String DEVICE_MODEL = android.os.Build.MODEL;            // 获取手机型号

    public static String DEVICE_ID;

    public static String MAC_ADDRESS;

    public static void init(Context context) {

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if(!TextUtils.isEmpty(tm.getDeviceId())) {
            DeviceUtil.DEVICE_ID = tm.getDeviceId();
        } else {
            // pad 设备,没有device_id,给个默认的id
            DeviceUtil.DEVICE_ID = "868734026370770";
        }


        WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        DeviceUtil.MAC_ADDRESS = wifi.getConnectionInfo().getMacAddress();
    }

    public static int getWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getStateHeight(Activity activity) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 设置设备别名
     * @param context
     * @param name      设备别名
     */
    public static void setAlias(Context context, String name){
        // 设置设备别名(Alias)
//          JPushInterface.setAlias(context, name, new TagAliasCallback() {
//            @Override
//            public void gotResult(int i, String s, Set<String> strings) {
//
//            }
//        });
    }

}
