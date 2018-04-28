package com.junchao.frametest.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import butterknife.internal.Utils;

/**
 * 吐司工具
 */
public class ToastUtil {

    public static Toast mToast;

    /**
     * 自定义图片toast
     *
     * @param resId   背景图片
     */
    public static void showImage(Context context, int resId) {
        try {
            cancelToast();
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(resId);
            mToast = new Toast(context);
            mToast.setGravity(Gravity.CENTER, 0, -60);
            mToast.setView(imageView);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义布局toast
     *
     * @param layoutId
     */
    public static void showLayout(Context context, int layoutId) {
        try {
            cancelToast();
            View view = View.inflate(context, layoutId, null);
            mToast = new Toast(context);
            mToast.setGravity(Gravity.CENTER, 0, -60);
            mToast.setView(view);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印普通toast方法
     *
     * @param msg
     */
    public static void showToast(Context context, String msg, int duration) {
        try {
            cancelToast();
            mToast = Toast.makeText(context, msg, duration);
            mToast.setGravity(Gravity.CENTER, 0, -30);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印普通toast方法
     *
     * @param resId
     */
    public static void showToast(Context context, int resId, int duration) {
        try {
            cancelToast();
            mToast = Toast.makeText(context, resId, duration);
            mToast.setGravity(Gravity.CENTER, 0, -30);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印普通toast方法
     *
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    /**
     * 打印普通toast方法
     *
     * @param resId
     */
    public static void showToast(Context context, int resId) {
        showToast(context, resId, Toast.LENGTH_SHORT);
    }

    /**
     * 关闭toast
     */
    public static void cancelToast() {
        try {
            if (mToast != null) {
                mToast.cancel();
                mToast = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showToastCustomTime(Context context, String text, long duration) {

        //先创建一个Toast对象
        final Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        //设置Toast信息提示框显示的位置（在屏幕顶部水平居中显示）
        toast.setGravity(Gravity.CENTER, 0, -60);
        try {
            //从Toast对象中获得mTN变量
            Field field = toast.getClass().getDeclaredField("mTN");
            field.setAccessible(true);
            Object obj = field.get(toast);
            //TN对象中获得了show方法
            Method method = obj.getClass().getDeclaredMethod("show", new Class[0]);
            //调用show方法来显示Toast信息提示框
            method.invoke(obj, new Object());

            //需要将前面代码中的obj变量变成类变量。这样在多个地方就都可以访问了
            Method method1 = obj.getClass().getDeclaredMethod("hide", new Class[0]);
            method1.invoke(obj, new Object());


        } catch (Exception e) {
        }
        final long ONE_SECOND = 1000;
        new CountDownTimer(duration, ONE_SECOND) {

            @Override
            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.cancel();
            }
        }.start();
    }

}