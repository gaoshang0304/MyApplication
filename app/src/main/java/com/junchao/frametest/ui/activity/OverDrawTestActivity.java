package com.junchao.frametest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.LinearLayout;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;
import com.junchao.frametest.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author gjc
 * @version ;;
 * @since 2018-03-05
 */

public class OverDrawTestActivity extends ToolbarBaseActivity {

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.drawer_content)
    LinearLayout mDrawerContent;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_over_draw_test;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "OverDrawTest");
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        mDrawerLayout.openDrawer(GravityCompat.END, true);
    }

}
