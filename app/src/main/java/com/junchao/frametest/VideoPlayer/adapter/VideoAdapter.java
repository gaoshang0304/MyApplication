package com.junchao.frametest.VideoPlayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junchao.frametest.R;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayerController;
import com.junchao.frametest.VideoPlayer.adapter.holder.VideoViewHolder;
import com.junchao.frametest.VideoPlayer.bean.VideoBean;

import java.util.List;

/**
 * Created by jc on 2017/5/21.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private Context mContext;
    private List<VideoBean> mVideoList;

    public VideoAdapter(Context context, List<VideoBean> videoList) {
        mContext = context;
        mVideoList = videoList;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);
        VideoViewHolder holder = new VideoViewHolder(itemView);
        //NiceVideoPlayerController controller = new NiceVideoPlayerController(mContext);
        //holder.setController(controller);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        VideoBean video = mVideoList.get(position);

        holder.bindData(video);
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }
}
