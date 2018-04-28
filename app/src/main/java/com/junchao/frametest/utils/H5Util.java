package com.junchao.frametest.utils;

/**
 * h5��ʽ
 * @author lqy
 * @since 2017-03-24
 */
public class H5Util {

    public static String getPlayGif(){
        return "<HTML style= 'padding��0; margin:0;' ><body style='padding:0;margin:0;" +
                "background:url(file:///android_asset/loading_check.gif) no-repeat center center' " +
                "bgcolor='#ffffff'></body></html>";
    }

    /**
     * wv_gif.loadDataWithBaseURL(null, H5Util.getPlayGif(), "text/html", "UTF-8", null);
     */
}
