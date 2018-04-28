package com.junchao.frametest.utils;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

public class PopupUtil {
    private static PopupWindow mPopupWindow      = null;
    //展示录音动画时
    public static void ShowPopupWindowGrivtyMatch(View view, View parentView, int y) {
        if (mPopupWindow == null) {
            mPopupWindow = new PopupWindow(view, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }
        mPopupWindow.setContentView(view);
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setTouchable(false);
        mPopupWindow.setFocusable(false);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#00000000"));
        //        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setBackgroundDrawable(colorDrawable);
        mPopupWindow.showAtLocation(parentView, Gravity.CENTER | Gravity.CENTER, 0, y);

    }

    //展示大图时使用 待封装
    public static void ShowPopupWindowMatch(View view, View parentView, int y) {
        mPopupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mPopupWindow.setContentView(view);
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#00000000"));
        //        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setBackgroundDrawable(colorDrawable);
        mPopupWindow.showAtLocation(parentView, Gravity.CENTER | Gravity.CENTER, 0, y);

    }


    /**
     * dismissPopPopWindow
     */
    public static void disMissPopupWindow() {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
            mPopupWindow = null;
        }
    }
}
