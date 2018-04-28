package com.junchao.frametest.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本工具类
 *
 * @author ZhangMao
 * @version 4.2.0
 * @since 2015-03-31
 */
public class StringUtil {

    /**
     * 获取格式化的手机号（将手机号中间4位替换为*号）
     *
     * @param phone
     * @return
     */
    public static String getFormattedPhone(String phone) {
        return phone.trim().replaceAll("(?<=\\d{3})\\d(?=\\d{4})", "*");
    }

    /**
     * 校验URL
     *
     * @param url
     * @param urlRules
     * @return URL是否符合规则
     */
    public static boolean checkUrl(String url, List<String> urlRules) {
        boolean isUrlOK = false;
        if (!TextUtils.isEmpty(url) && urlRules != null) {
            for (String urlRule : urlRules) {
                String newUrl = url.toLowerCase();
                if (newUrl.contains(urlRule)) {
                    isUrlOK = true;
                    break;
                }
            }
        }
        return isUrlOK;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        //Pattern pattern = Pattern.compile("[0-9]*");
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)(\\.\\d{1,2})?|0\\.([1-9]|\\d[1-9])|0)$");//判断是否为有效金额
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    /**
     * 数字，小数点及之后数字变小
     */
    public static CharSequence toSpanStringSize(Context context, String string, int size){
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(string);
        StyleSpan ss = new StyleSpan(Typeface.BOLD);
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(size);
        char[] chars = string.toCharArray();
        ssb.setSpan(ass, chars.length-3, chars.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ssb.setSpan(ss, 0, chars.length-3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    /**
     * 读取本地json文件
     * @param context
     * @param fileName
     * @return
     */
    public static String readLocalJson(Context context, String fileName){
        String jsonString;
        String resultString="";
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(
                    context.getResources().getAssets().open(fileName)));
            while ((jsonString=bufferedReader.readLine())!=null) {
                resultString+=jsonString;
            }
        } catch (Exception e) {
            ToastUtil.showToast(context, e.toString());
        }
        return resultString;
    }


}
