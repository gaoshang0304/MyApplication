package com.junchao.frametest.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.junchao.frametest.R;

import java.io.File;

/**
 * Created by gjc on 2017/6/5.
 */

public class GlideImageManager {

    public static void loadImage(Context context, String url, int erroImg, int emptyImg, ImageView iv) {
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).into(iv);
    }

    /**
     * with cross fade
     * @param context
     * @param url
     * @param iv
     */
    public static void loadImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).crossFade().placeholder(R.drawable.img_default)
                .error(R.drawable.img_default).into(iv);
    }

    public static void loadGifImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.img_default).error(R.drawable.img_default).into(iv);
    }


    public static void loadCircleImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.drawable.img_default).error(R.drawable.img_default)
                .transform(new GlideCircleTransform(context)).into(iv);
    }

    public static void loadRoundCornerImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.drawable.img_default).error(R.drawable.img_default)
                .transform(new GlideRoundTransform(context,10)).into(iv);
    }


    public static void loadImage(Context context, final File file, final ImageView imageView) {
        Glide.with(context)
                .load(file)
                .into(imageView);


    }

    public static void loadImage(Context context, final int resourceId, final ImageView imageView) {
        Glide.with(context)
                .load(resourceId)
                .into(imageView);
    }
}

