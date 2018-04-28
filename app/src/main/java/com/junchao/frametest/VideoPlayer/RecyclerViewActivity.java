package com.junchao.frametest.VideoPlayer;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.junchao.frametest.R;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayerManager;
import com.junchao.frametest.VideoPlayer.adapter.RecyclerViewDivider;
import com.junchao.frametest.VideoPlayer.adapter.VideoAdapter;
import com.junchao.frametest.VideoPlayer.bean.VideoBean;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;
import com.junchao.frametest.utils.JsonUtil;
import com.junchao.frametest.utils.StringUtil;

import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class RecyclerViewActivity extends ToolbarBaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private List<VideoBean> videoData;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "RecyclerView");

        String json = StringUtil.readLocalJson(this, "video.txt");
        videoData = (List<VideoBean>) JsonUtil.parseJsonToList(json, new TypeToken<List<VideoBean>>() {
        }.getType());

        init();
    }

    private void init() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.VERTICAL));
        VideoAdapter adapter = new VideoAdapter(this, videoData);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
//                NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) view.findViewById(R.id.nice_video_player);
//                if (niceVideoPlayer != null) {
//                    niceVideoPlayer.release();
//                }
                JCVideoPlayerStandard jcVideoPlayer = (JCVideoPlayerStandard) view.findViewById(R.id.jc_video_player);
                jcVideoPlayer.startVideo();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return;
        }
        super.onBackPressed();
    }

}
