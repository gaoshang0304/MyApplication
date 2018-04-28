package com.junchao.frametest.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/11/4.
 */
public class MathUtil {

    /**
     * 保留两位小数
     * @param price
     * @return
     */
    public static float getTwoFloat(float price){
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        float newPrice= 0;
        try {
            newPrice = Float.parseFloat(decimalFormat.format(price));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return newPrice;
    }

    /**
     * 保留两位小数
     * @param price
     * @return
     */
    public static double getTwoDouble(double price){
        BigDecimal bigDecimal = new BigDecimal(price);
        double value = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


        return value;
    }

    /**
     * 保留两位小数
     * @param price
     * @return
     */
    public static String getTwoDoubleString(double price){
        String newPrice = "";
        try {
            DecimalFormat decimalFormat=new DecimalFormat("0.0000");
            try {
                String temp = decimalFormat.format(price);
                char last = temp.charAt(temp.length() - 1);

                Double value = Double.valueOf(temp);
                value += 0.0001d;
                LogUtil.e("myapp", "last :" + last);
                LogUtil.e("myapp", "temp :" + temp);
                DecimalFormat tempFormat=new DecimalFormat("0.00");
                String format = tempFormat.format(value);
                newPrice = format;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            newPrice = "0.00";
        }
        return newPrice;
    }

    /**
     * 保留两位小数
     * @param price
     * @return
     */
    public static float getTwoFloat(String price){
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        float newPrice= 0;
        try {
            newPrice = Float.parseFloat(decimalFormat.format(Float.parseFloat(price)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return newPrice;
    }

    /**
     * 保留两位小数
     * @param price
     * @return
     */
    public static String getTwoFloatString(String price){
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        String newPrice= "";
        try {
            newPrice = (decimalFormat.format(Float.parseFloat(price)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return newPrice;
    }
    /**
     * 保留两位小数
     * @param price
     * @return
     */
    public static String getTwoFloatString(float price){
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        String newPrice= "";
        try {
            newPrice = (decimalFormat.format(price));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return newPrice;
    }


    /**
     * 把集合转为字符串
     * @param lists
     * @return
     */
    public static String getStringByList(ArrayList<String> lists){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<lists.size();i++){
            sb.append(lists.get(i));
        }
        return sb.toString();
    }

    /**
     * 修改利息字体颜色
     * @param text
     */
    public static SpannableStringBuilder modifyTextColor(String text, int start, int end, int color){
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        ForegroundColorSpan redSpan = new ForegroundColorSpan(color);
        builder.setSpan(redSpan, start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * @Method     : isNumber
     * @Description: 判断是否为金额
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        if ("0".equals(str)){
            return false;
        }
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)(\\.\\d{1,2})?|0\\.([1-9]|\\d[1-9])|0)$");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    /**
     * @Method     : isNumber
     * @Description: 判断是否为金额
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)(\\.\\d{1,2})?|0\\.([1-9]|\\d[1-9])|0)$");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    /**
     * 去除字符串中的<></>
     */
    public static String clearChar(String content){
        return content.replaceAll("<[^><]*>","");
    }
}
