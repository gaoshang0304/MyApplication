package com.junchao.frametest.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author gjc
 * @version 4.0.6
 * @since 2017-07-27
 */
public class AnimActivity extends ToolbarBaseActivity {

    @BindView(R.id.iv_android_logo)
    ImageView iv_Logo;
    @BindView(R.id.iv_android_logo1)
    ImageView iv_Logo1;
    private RotateAnimation ra;

    @Override
    public int getContentLayoutId() {
        return R.layout.acticity_anim;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "AnimActivity");

        startAnimation(iv_Logo);
        startAnimation1(iv_Logo1);
    }

    private void startAnimation(ImageView iv_logo) {
//        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_set);
//        iv_logo.startAnimation(rotate);

        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_logo, "rotation", 0, 10f, 20f, 30f, 40f, 50f, 65f, -65f, 0, 45f, -45f, 0, 45f, -45f, 0);
        animator.setDuration(5000);
        animator.setRepeatCount(Integer.MAX_VALUE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setStartDelay(3000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    private void startAnimation1(ImageView iv_logo) {
//        ObjectAnimator aa = ObjectAnimator.ofFloat(iv_logo, "alpha", 1f, 0.5f);
//        aa.setDuration(200);
//        aa.setRepeatCount(Integer.MAX_VALUE);
//        aa.setRepeatMode(ValueAnimator.RESTART);
//        aa.start();
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_logo, "translationY", 0, 52f, 10f, 15f, 20f);
        animator.setDuration(2000);
        animator.setRepeatCount(Integer.MAX_VALUE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //iv_Logo.clearAnimation();
    }
}
