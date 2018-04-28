package com.junchao.frametest.recyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junchao.frametest.R;
import com.junchao.frametest.recyclerview.bean.HomeDataVO;


/**
 * @author gjc
 * @version ;;
 * @since 2017-11-07
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_BANNER = 0;
    public static final int TYPE_CHANNEL = 1;
    public static final int TYPE_TEXT = 2;
    public static final int TYPE_IMAGE = 3;
    public static final int TYPE_VIDEO = 4;

    public int mCurrentType = TYPE_BANNER;

    private Context mContext;
    private HomeDataVO mData;

    public HomeFragmentAdapter(Context context, HomeDataVO data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getItemViewType(int position) {

        if (0 == position) {
            mCurrentType = TYPE_BANNER;
        } else if (1 == position){
            mCurrentType = TYPE_CHANNEL;
        }else if (2 == position){
            mCurrentType = TYPE_TEXT;
        }
        return mCurrentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TYPE_BANNER:
                return new BannerViewHolder(inflater.inflate(R.layout.layout_home_banner_view, parent, false));

            case TYPE_CHANNEL:
                return new BannerViewHolder(inflater.inflate(R.layout.layout_home_channel_view, parent, false));
            case TYPE_TEXT:
                return new BannerViewHolder(inflater.inflate(R.layout.layout_home_text_view, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case TYPE_BANNER:
                // banner 逻辑处理
                break;
            case TYPE_CHANNEL:
                // 广告逻辑处理
                break;
            case TYPE_TEXT:
                // 文本逻辑处理
                break;
            case TYPE_IMAGE:
                //图片逻辑处理
                break;
            case TYPE_VIDEO:
                //视频逻辑处理
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        public BannerViewHolder(View itemView) {
            super(itemView);

        }
    }
}
