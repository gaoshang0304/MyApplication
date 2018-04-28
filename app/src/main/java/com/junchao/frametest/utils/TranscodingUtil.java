package com.junchao.frametest.utils;

import java.io.UnsupportedEncodingException;

/**
 * ת��
 *
 * @author lqy
 * @since 2017-02-20
 */
public class TranscodingUtil {

    /**
     * Stringתbyte[]
     */
    public static byte[] StringTransBtye(String content) {
        return content.getBytes();
    }

    /**
     * byte[]תString
     */
    public static String ByteTransString(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * Stringתbyte[]
     * ����utf-8
     */
    public static byte[] StringTransBtyeCod(String content) {
        byte[] bytes = null;
        try {
            bytes = content.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * byte[]תString
     * ���� "UTF-8"
     */
    public static String ByteTransStringCod(byte[] bytes, String chars) {
        String conent = null;
        try {
            conent = new String(bytes,chars);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return conent;
    }
}
