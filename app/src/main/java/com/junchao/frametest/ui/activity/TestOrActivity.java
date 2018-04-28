package com.junchao.frametest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.junchao.frametest.R;
import com.junchao.frametest.WebView.WebViewActivity;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;
import com.junchao.frametest.utils.LogUtil;
import com.junchao.frametest.utils.MathUtil;
import com.junchao.frametest.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gjc on 2017/6/3.
 */
public class TestOrActivity extends ToolbarBaseActivity {

    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.btn_check)
    Button btnCheck;
    @BindView(R.id.tv_show1)
    TextView tvShow1;
    @BindView(R.id.tv_show2)
    TextView tvShow2;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "Test");
    }

    @OnClick(R.id.btn_check)
    public void onViewClicked() {
        String text = String.valueOf(etInput.getText());
        if (TextUtils.isEmpty(text)) {
            ToastUtil.showToast(mContext, "输入框为空");
        } else {
            //checkStringAnd();
            //checkStringOr();
            checkDouble(text);
            checkDouble2(text);
        }
    }

    private void checkDouble(String text) {
        String twoDouble = MathUtil.getTwoDoubleString(Double.valueOf(text));
        LogUtil.e("myapp", "double1" + Double.valueOf(text));
        tvShow1.setText(twoDouble + "");
    }

    private void checkDouble2(String text) {
        double twoDouble = MathUtil.getTwoDouble(Double.valueOf(text));
        LogUtil.e("myapp", "double2" + Double.valueOf(text));
        tvShow2.setText(twoDouble + "");
    }

    private void checkStringOr() {
        String text = String.valueOf(etInput.getText());

        if (!text.contains("zjdg.cn") || !text.contains("zhongjie51.com")) {
            tvShow1.setText("true");
        } else {
            tvShow1.setText("false");
        }
    }

    private void checkStringAnd() {
        String text = String.valueOf(etInput.getText());

        if (!text.contains("zjdg.cn") && !text.contains("zhongjie51.com")) {
            tvShow1.setText("true");
        } else {
            tvShow1.setText("false");
        }

    }

}
