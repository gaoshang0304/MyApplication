package com.junchao.frametest.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author gjc
 * @version ;;
 * @since 2017-10-17
 */

public class BlankActivity extends ToolbarBaseActivity {
    @BindView(R.id.ll_text_group)
    LinearLayout ll_group;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_blank;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "Blank");

        List<String> list = new ArrayList<>();
        list.add("京东98折");
        list.add("京东98折98折98折");
        list.add("京京京京东98折");

        for (int i = 0; i < list.size(); i++) {
            ll_group.addView(createTextView(list.get(i)));
        }
    }

    private View createTextView(String s) {
        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20,0,0,0);//4个参数按顺序分别是左上右下

        tv.setLayoutParams(layoutParams);
        tv.setText(s);
        tv.setTextSize(10);
        tv.setBackground(getResources().getDrawable(R.drawable.bg_text_view, null));
        tv.setTextColor(Color.parseColor("#ff4200"));

        return tv;
    }

}
