package com.junchao.frametest.VideoPlayer.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.junchao.frametest.R;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayer;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayerController;
import com.junchao.frametest.VideoPlayer.bean.VideoBean;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by jc on 2017/5/21.
 */

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private final JCVideoPlayerStandard mVideoPlayer;
//    private NiceVideoPlayerController mController;
//    private NiceVideoPlayer mVideoPlayer;

    public VideoViewHolder(View itemView) {
        super(itemView);
//        mVideoPlayer = (NiceVideoPlayer) itemView.findViewById(R.id.nice_video_player);
        mVideoPlayer = (JCVideoPlayerStandard) itemView.findViewById(R.id.jc_video_player);
    }

//    public void setController(NiceVideoPlayerController controller) {
//        mController = controller;
//    }

    public void bindData(VideoBean mBean) {
//        mController.setTitle(mBean.video_title);
//        mController.setImage(mBean.image_url);
//        mVideoPlayer.setController(mController);
//        mVideoPlayer.setUp(mBean.quality_480p, null);
        mVideoPlayer.setUp(mBean.quality_480p, JCVideoPlayer.SCREEN_LAYOUT_NORMAL, mBean.video_title);

    }
}
