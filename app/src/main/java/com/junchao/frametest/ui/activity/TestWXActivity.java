package com.junchao.frametest.ui.activity;

import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;
import com.junchao.frametest.utils.ToastUtil;

import butterknife.BindView;

/**
 * @author gjc
 * @version 4.0.6
 * @since 2017-07-12
 */
public class TestWXActivity extends ToolbarBaseActivity {

    @BindView(R.id.open)
    ImageView open;

    @Override
    public int getContentLayoutId() {
        return R.layout.acticity_test_wx;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "TestWX");
        open = (ImageView) findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //打开系统设置中辅助功能
                    Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    startActivity(intent);
                    ToastUtil.showToast(mContext, "找到抢红包，然后开启服务即可");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
