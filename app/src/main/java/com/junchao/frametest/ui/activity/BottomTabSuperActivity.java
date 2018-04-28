package com.junchao.frametest.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.junchao.frametest.R;
import com.junchao.frametest.utils.LogUtil;
import com.junchao.frametest.view.BottomTabView;

import java.util.List;

/**
 * @auther gjc
 * @since 2017/5/15.
 */
public abstract class BottomTabSuperActivity extends AppCompatActivity {

    FrameLayout mContent;
    BottomTabView bottomTabView;
    private int mLastPosition = 0; //记录上一个点击的位置

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_bottom_tab);
        //set system statusBar
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        mContent = (FrameLayout) findViewById(R.id.frame_container);
        bottomTabView = (BottomTabView) findViewById(R.id.bottomTabView);



        if (getCenterView() == null){
            bottomTabView.setTabItemViews(getTabViews());
        }else {
            bottomTabView.setTabItemViews(getTabViews(), getCenterView());
        }

        bottomTabView.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(int position) {
//                changeFragment(position);
                switchContent(getFragments().get(mLastPosition), getFragments().get(position));
                LogUtil.e("app", "mLastPosition =" + mLastPosition);
                mLastPosition = position;
                LogUtil.e("app", "mLastPosition =" + mLastPosition);
            }
        });

        bottomTabView.setOnSecondSelectListener(new BottomTabView.OnSecondSelectListener() {
            @Override
            public void onSecondSelect(int position) {

            }
        });
    }

    private void changeFragment(int index) {
        //1.获取fragment的管理者对象    FragmentManager
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_container,getFragments().get(index)).commit();
    }

    private void switchContent(Fragment from, Fragment to) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(R.id.frame_container, to).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }

    }

    protected abstract List<BottomTabView.TabItemView> getTabViews();
    protected abstract List<Fragment> getFragments();

    protected View getCenterView(){
        return null;
    }

}
