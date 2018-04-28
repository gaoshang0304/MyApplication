package com.junchao.frametest.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junchao.frametest.R;
import com.junchao.frametest.recyclerview.adapter.HomeFragmentAdapter;
import com.junchao.frametest.recyclerview.bean.HomeDataVO;
import com.junchao.frametest.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther gjc
 * @since 2017/5/15.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_recycler_view)
    RecyclerView rv_content;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void loadData() {

    }

}
