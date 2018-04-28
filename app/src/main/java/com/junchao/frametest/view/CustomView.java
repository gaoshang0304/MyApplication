package com.junchao.frametest.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import com.junchao.frametest.R;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


/**
 * @author gjc
 * @version ;;
 * @since 2017-10-16
 */

public class CustomView extends RelativeLayout{

    private MaterialCalendarView calendarView;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 111) {
                translaDownSecond(1200);
            }
        }
    };

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_custom, this);
        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        translaDownFirst(1200);
    }

    /**
     * 弹出框 平移到中心位置
     */
    private void translaDownFirst(int duration) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new BounceInterpolator());
        TranslateAnimation translateAnimation = new TranslateAnimation(
                //X轴初始位置
                Animation.RELATIVE_TO_SELF, 0.0f,
                //X轴移动的结束位置
                Animation.RELATIVE_TO_SELF, 0.0f,
                //y轴开始位置
                Animation.RELATIVE_TO_SELF, -1.8f,
                //y轴移动后的结束位置
                Animation.RELATIVE_TO_SELF, 0f);
        translateAnimation.setDuration(duration);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        calendarView.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mHandler.sendEmptyMessageDelayed(111, 1500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /**
     * 弹出框 平移出底部
     */
    private void translaDownSecond (int duration){
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new AccelerateInterpolator());
        TranslateAnimation translateAnimation = new TranslateAnimation(
                //X轴初始位置
                Animation.RELATIVE_TO_SELF, 0.0f,
                //X轴移动的结束位置
                Animation.RELATIVE_TO_SELF,0.0f,
                //y轴开始位置
                Animation.RELATIVE_TO_SELF,0f,
                //y轴移动后的结束位置
                Animation.RELATIVE_TO_SELF,2f);
        translateAnimation.setDuration(duration);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        calendarView.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
