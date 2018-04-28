package com.junchao.frametest.VideoPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.junchao.frametest.R;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayer;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayerController;
import com.junchao.frametest.VideoPlayer.Player.NiceVideoPlayerManager;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jc on 2017/6/1.
 */
public class VideoPlayerActivity extends ToolbarBaseActivity {

    @BindView(R.id.nice_video_player)
    NiceVideoPlayer mNiceVideoPlayer;

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "VideoPlayer");
        init();
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_video_player;
    }

    private void init() {
        mNiceVideoPlayer = (NiceVideoPlayer) findViewById(R.id.nice_video_player);
        //set player
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.PLAYER_TYPE_NATIVE);
        mNiceVideoPlayer.setUp("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-33-30.mp4", null);
        NiceVideoPlayerController controller = new NiceVideoPlayerController(this);
        controller.setTitle("办公室小野开番外了，居然在办公室开澡堂！老板还点赞？");
        controller.setImage("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg");
        mNiceVideoPlayer.setController(controller);
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
        super.onStop();
    }

    public void enterTinyWindow(View view) {
        if (mNiceVideoPlayer.isPlaying()
                || mNiceVideoPlayer.isBufferingPlaying()
                || mNiceVideoPlayer.isPaused()
                || mNiceVideoPlayer.isBufferingPaused()) {
            mNiceVideoPlayer.enterTinyWindow();
        } else {
            Toast.makeText(this, "要播放后才能进入小窗口", Toast.LENGTH_SHORT).show();
        }
    }

    public void showVideoList(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
