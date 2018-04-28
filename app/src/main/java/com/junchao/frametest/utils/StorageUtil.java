package com.junchao.frametest.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class StorageUtil {

    private final static String KEY_PIC_CACHE = "pic";
    private final static String KEY_VOICE_CACHE = "voice";
    private final static String KEY_DOWNLOAD_CHACHE = "download";
    private final static String KEY_ZJDG_CHACHE = "zjdg";

    public static boolean isStorageAvailable = false;

    public static String PIC_CACHE = "";
    public static String VOICE_CACHE = "";
    public static String DOWNLOAD_CACHE = "";

    public static void init(Context context) {
        isStorageAvailable = getExternalStorageState();
        createFiles(context);
    }

    //创建指定文件夹和获取指定文件夹目录

    private static void createFiles(Context context) {
        PIC_CACHE = createPicDirs();
        VOICE_CACHE = createVoiceDirs();
        DOWNLOAD_CACHE = createDownloadDirs();
    }

    //获取SD卡是否可用
    public static boolean getExternalStorageState() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED) ? true : false;
    }

    private static String createPicDirs() {
        if (isStorageAvailable) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + KEY_ZJDG_CHACHE + "/" + KEY_PIC_CACHE);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }

    private static String createVoiceDirs() {
        if (isStorageAvailable) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + KEY_ZJDG_CHACHE + "/" + KEY_VOICE_CACHE);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }

    private static String createDownloadDirs() {
        if (isStorageAvailable) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + KEY_ZJDG_CHACHE + "/" + KEY_DOWNLOAD_CHACHE);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }

}
