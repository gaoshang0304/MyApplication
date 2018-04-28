package com.junchao.frametest.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Deprecated
public class CompressImageUtil {

    private final static int MAX_PIC_SIZE = 85; // KB

    public static Bitmap compressFile(String pathName) throws IOException {
        int degree = readPictureDegree(pathName);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;// 不去真的解析图片，只是获取图片的头部信息，包含宽高等；
        Bitmap bitmap = BitmapFactory.decodeFile(pathName, opts);

        // /////////////////////////////////////////////////////
        // //////////////得到方向正确而且根据屏幕宽高压缩的得图片////////////////////////////

        // 得到图片的宽度、高度；
        int imgWidth = opts.outWidth;
        int imgHeight = opts.outHeight;
        // 分别计算图片宽度、高度与目标宽度、高度的比例；取大于等于该比例的最小整数；
        int widthRatio = (int) Math.ceil(imgWidth / (float) 480);
        int heightRatio = (int) Math.ceil(imgHeight / (float) 480);
        if (widthRatio > 1 || heightRatio > 1) {
            if (widthRatio > heightRatio) {
                opts.inSampleSize = widthRatio;
            } else {
                opts.inSampleSize = heightRatio;
            }
        }
        // 设置好缩放比例后，加载图片进内容；
        opts.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFile(pathName, opts);

        if (degree != 0) {// 旋转照片角度
            bitmap = rotateBitmap(bitmap, degree);
        }
        // /////////////////////////////////////////////////////
        compressBitmapToFile(bitmap, pathName);

        return bitmap;
    }


    /**
     * 处理图片旋转
     *
     * @param bitmap  要处理的bitmap
     * @param degress 当前的角度
     * @return
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, int degress) {
        if (bitmap != null) {
            Matrix m = new Matrix();
            m.postRotate(degress);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
            return bitmap;
        }
        return bitmap;
    }

    /**
     * 获取图片旋转的角度
     *
     * @param path 尧判断的角度
     * @return 返回当前的角度
     * @throws IOException
     */
    public static int readPictureDegree(String path) throws IOException {
        int degree = 0;
        ExifInterface exifInterface = new ExifInterface(path);
        int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                degree = 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                degree = 180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                degree = 270;
                break;
        }
        return degree;
    }

    /**
     * 把图片写到某个文件里
     *
     * @param bitmap
     * @param path
     * @throws IOException
     */
    public static void compressBitmapToFile(Bitmap bitmap, String path) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int quality = 80;
        bitmap.compress(CompressFormat.JPEG, quality, baos);
        while (baos.toByteArray().length / 1024 > MAX_PIC_SIZE) {
            quality -= 5;
            baos.reset();
            bitmap.compress(CompressFormat.JPEG, quality, baos);
        }
        FileOutputStream out = new FileOutputStream(path);
        baos.writeTo(out);
        out.flush();
        out.close();
        baos.close();
    }
}
