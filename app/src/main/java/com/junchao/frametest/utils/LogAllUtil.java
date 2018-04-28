package com.junchao.frametest.utils;

import android.util.Log;

/**
 * �����־��ӡ��ȫ
 *
 * @author lqy
 * @since 2017-03-29
 */
public class LogAllUtil {

    public static void logAllMessage(String content) {
        if (content.length() > 3000) {
            for (int i = 0; i < content.length(); i += 3000) {
                if (i + 3000 < content.length())
                    Log.e("myapp_logall==" + i + "==", content.substring(i, i + 3000));
                else
                    Log.e("myapp_logall==" + i + "==", content.substring(i, content.length()));
            }
        } else
            Log.e("myapp_logall==", content);
    }
}
