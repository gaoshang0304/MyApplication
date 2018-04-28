package com.junchao.frametest.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.junchao.frametest.CustomPicker.CustomPickerActivity;
import com.junchao.frametest.R;
import com.junchao.frametest.VideoPlayer.VideoPlayerActivity;
import com.junchao.frametest.WebView.WebViewActivity;
import com.junchao.frametest.ui.activity.AnimActivity;
import com.junchao.frametest.ui.activity.BlankActivity;
import com.junchao.frametest.ui.activity.CalendarActivity;
import com.junchao.frametest.ui.activity.OverDrawTestActivity;
import com.junchao.frametest.ui.activity.TestCustomViewActivity;
import com.junchao.frametest.ui.activity.TestOrActivity;
import com.junchao.frametest.ui.activity.TestWXActivity;
import com.junchao.frametest.ui.base.BaseFragment;
import com.junchao.frametest.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @auther gjc
 * @since 2017/5/15.
 */
public class DiscoverFragment extends BaseFragment implements FlowLayout.Listener {


    @BindView(R.id.flow_layout)
    FlowLayout flowLayout;
    private Context mContext;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView() {
        mContext = getActivity();
        flowLayout.setOnItemClickListener(this);
    }

    @Override
    protected void loadData() {
        List<String> list = new ArrayList<String>();
        list.clear();
        list.add("WebView");
        list.add("VideoPlayer");
        list.add("TestA");
        list.add("CustomPicker");
        list.add("TestWX");
        list.add("AnimActivity");
        list.add("TestCustomView");
        list.add("Calendar");
        list.add("Blank");
        list.add("OverDrawTest");

        if (flowLayout != null) {
            flowLayout.addData(list);
        }
    }

    @Override
    public void onItemClickListener(String item) {
        if (TextUtils.equals("WebView", item)) {
            startActivity(new Intent(mContext, WebViewActivity.class));
        } else if (TextUtils.equals("VideoPlayer", item)) {
            startActivity(new Intent(mContext, VideoPlayerActivity.class));
        } else if (TextUtils.equals("TestA", item)) {
            startActivity(new Intent(mContext, TestOrActivity.class));
        } else if (TextUtils.equals("CustomPicker", item)) {
            startActivity(new Intent(mContext, CustomPickerActivity.class));
        }else if (TextUtils.equals("TestWX", item)) {
            startActivity(new Intent(mContext, TestWXActivity.class));
        }else if (TextUtils.equals("AnimActivity", item)) {
            startActivity(new Intent(mContext, AnimActivity.class));
        }else if (TextUtils.equals("TestCustomView", item)) {
            startActivity(new Intent(mContext, TestCustomViewActivity.class));
        }else if (TextUtils.equals("Calendar", item)) {
            startActivity(new Intent(mContext, CalendarActivity.class));
        }else if (TextUtils.equals("Blank", item)) {
            startActivity(new Intent(mContext, BlankActivity.class));
        }else if (TextUtils.equals("OverDrawTest", item)) {
            startActivity(new Intent(mContext, OverDrawTestActivity.class));
        }
    }

}
