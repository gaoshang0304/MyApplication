package com.junchao.frametest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具
 */
public class TimeUtil {

    public final static int oneY = 365 * 24 * 3600;// 秒
    public final static int oneD = 24 * 3600;// 秒
    public final static int oneH = 3600;// 秒
    public final static int oneM = 60;// 秒
    public final static String DEFAULT_TIME_FORMAT = "yyyy年MM月dd日";

    public static String getTime() {
        return SimpleDateFormat.getInstance().format(new Date());
    }

    /**
     * 解析时间
     *
     * @param timeText 默认格式：yyyy年MM月dd日
     * @return 时间毫秒值
     */
    public static long parseTime(String timeText) {
        return parseTime(timeText, DEFAULT_TIME_FORMAT);
    }

    /**
     * 解析时间
     *
     * @param timeText   时间文本
     * @param timeFormat 对应的时间格式
     * @return 时间毫秒值
     */
    public static long parseTime(String timeText, String timeFormat) {
        long time = 0;
        try {
            time = new SimpleDateFormat(timeFormat).parse(timeText).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 格式化时间
     *
     * @param milliseconds
     * @return 默认格式：yyyy年MM月dd日
     */
    public static String formatTime(long milliseconds) {
        return formatTime(milliseconds, DEFAULT_TIME_FORMAT);
    }

    /**
     * 格式化时间
     *
     * @param milliseconds
     * @param timeFormat
     * @return
     */
    public static String formatTime(long milliseconds, String timeFormat) {
        return new SimpleDateFormat(timeFormat).format(new Date(milliseconds));
    }

    /**
     * 用于首页倒计时格式化
     *
     * @param durationInSeconds 时长（秒）
     * @return 格式："-天 --：--：--"
     */
    public static String formatDuration(int durationInSeconds) {
        int d = durationInSeconds / oneD;
        int h = (durationInSeconds - d * oneD) / oneH;
        int m = (durationInSeconds - d * oneD - h * oneH) / oneM;
        int s = (durationInSeconds - d * oneD - h * oneH - m * oneM);
        StringBuilder builder = new StringBuilder();
        builder.append(d == 0 ? "" : d + "天 ");
        builder.append(h < 10 ? "0" + h : "" + h);
        builder.append(":");
        builder.append(m < 10 ? "0" + m : "" + m);
        builder.append(":");
        builder.append(s < 10 ? "0" + s : "" + s);
        return builder.toString();
    }

}

