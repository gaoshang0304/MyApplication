package com.junchao.frametest.utils;

import android.content.Context;

/**
 * ScreenUtil
 * 
 * @author
 */
public class ScreenUtil {

	public static float dp2Px(Context context, float dp) {
		if (context == null) {
			return -1;
		}
		return dp * context.getResources().getDisplayMetrics().density;
	}

	public static float px2Dp(Context context, float px) {
		if (context == null) {
			return -1;
		}
		return px / context.getResources().getDisplayMetrics().density;
	}

	public static int dip2px(Context context, float dp) {
		return (int) (dp2Px(context, dp) + 0.5f);
	}

	public static int px2DpCeilInt(Context context, float px) {
		return (int) (px2Dp(context, px) + 0.5f);
	}

}
