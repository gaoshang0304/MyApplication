package com.junchao.frametest.ui.activity;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;

/**
 * @author gjc
 * @version 4.0.6
 * @since 2017-07-12
 */
public class TestCustomViewActivity extends ToolbarBaseActivity {

    @Override
    public int getContentLayoutId() {
        return R.layout.acticity_test_custom_view;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "TestCustomView");


    }

}
