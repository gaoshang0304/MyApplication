package com.junchao.frametest.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.junchao.frametest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by quantan.liu on 2017/4/7.
 * 在添加一个带Toolbar的BaseActivity，大家学习这个思想。有很多地方用的就抽取出来。
 * 这个是不带网络请求的，带网络请求的可以自己继承LoadingBaseActivity来完成
 */

public abstract class ToolbarBaseActivity extends BaseActivity {

    private FrameLayout flToolbarBase;
    private Unbinder bind;
    private View contentView;
    protected Toolbar toolbarBaseActivity;
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        toolbarBaseActivity = (Toolbar) findViewById(R.id.toolbar_base_activity);
        flToolbarBase = (FrameLayout) findViewById(R.id.fl_toolbar_base);
        contentView = LayoutInflater.from(this).inflate(getContentLayoutId(), null);
        flToolbarBase.addView(contentView);
        bind = ButterKnife.bind(this, contentView);
        setToolBar(toolbarBaseActivity, "");
        initUI();
    }

    public abstract int getContentLayoutId();
    /**
     * 用于初始化UI至少要初始化toolbar，如果还需要别的方法可以自己加
     */
    protected abstract void initUI();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_toolbar_base;
    }

}
