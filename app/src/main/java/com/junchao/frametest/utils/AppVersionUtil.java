package com.junchao.frametest.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;

/**
 * App版本信息工具类
 */
public class AppVersionUtil {
    /**
     * 获取版本名称
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }

        return versionName;
    }

    /**
     * 获取应用版本号
     */
    public static String getVersionCode(Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return "0";
        }
        return String.valueOf(versionCode);
    }

    /**
     * 判断当前版本是否大于4.0，如果大于则显示商信银支付，否则隐藏
     *
     * @return
     */
    public static boolean canUserAllSourcePay() {
        return Build.VERSION.SDK_INT >= 14;
    }

    /**
     * 判断是否安装应用
     */
    public static boolean isAppInstalled(Context context, String packageName){
        try {
            PackageInfo packageInfo= context.getPackageManager().getPackageInfo(packageName, 0);
            return !(packageInfo==null);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据包名，跳转到应用市场下载应用
     */
    public static void gotoMarket(Context context, String packageName){
        Uri uri = Uri.parse("market://details?id="+packageName);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(it);
    }

}
