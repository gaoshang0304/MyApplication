package com.junchao.frametest.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.BaseActivity;
import com.junchao.frametest.ui.fragment.DiscoverFragment;
import com.junchao.frametest.ui.fragment.HomeFragment;
import com.junchao.frametest.ui.fragment.MineFragment;
import com.junchao.frametest.ui.fragment.SecondFragment;
import com.junchao.frametest.utils.ToastUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private long firstTime;
    private RelativeLayout rela_menuHome;
    private RelativeLayout rela_menuSecond;
    private RelativeLayout rela_menuDiscover;
    private RelativeLayout rela_menuMine;
    private HomeFragment mHomeFragment;
    private SecondFragment mSecondFragment;
    private DiscoverFragment mDiscoverFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrentContent;

    public enum MENU {
        HOME, SECOND, DISCOVER, MINE
    }

    @Override
    protected int getLayoutId() {
        return R.layout.acticity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //PermissionsUtil.getSinglePermission(this, Manifest.permission.READ_EXTERNAL_STORAGE, "没有获得存储权限功能将受限");
        //set system statusBar
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        init();
    }

    private void init() {
        rela_menuHome = (RelativeLayout) findViewById(R.id.main_rl_menu_home);
        rela_menuSecond = (RelativeLayout) findViewById(R.id.main_rl_menu_second);
        rela_menuDiscover = (RelativeLayout) findViewById(R.id.main_rl_menu_discover);
        rela_menuMine = (RelativeLayout) findViewById(R.id.main_rl_menu_mine);
        rela_menuHome.setOnClickListener(this);
        rela_menuSecond.setOnClickListener(this);
        rela_menuDiscover.setOnClickListener(this);
        rela_menuMine.setOnClickListener(this);

        mHomeFragment = new HomeFragment();
        mSecondFragment = new SecondFragment();
        mDiscoverFragment = new DiscoverFragment();
        mMineFragment = new MineFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_content, mHomeFragment).commit();
        mCurrentContent = mHomeFragment;
        selectMenu(MENU.HOME);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_rl_menu_home:
                if (mHomeFragment == mCurrentContent) {
                    //可以做刷新首页操作
                    ToastUtil.showToast(this, "第二次点击");

                    return;
                }
                switchContent(mCurrentContent, mHomeFragment);
                selectMenu(MENU.HOME);
                break;
            case R.id.main_rl_menu_second:
                switchContent(mCurrentContent, mSecondFragment);
                selectMenu(MENU.SECOND);
                break;
            case R.id.main_rl_menu_discover:
                switchContent(mCurrentContent, mDiscoverFragment);
                selectMenu(MENU.DISCOVER);
                break;
            case R.id.main_rl_menu_mine:
                switchContent(mCurrentContent, mMineFragment);
                selectMenu(MENU.MINE);
                break;

        }
    }

    private void selectMenu(MENU menu) {
        switch (menu) {
            case HOME: {
                rela_menuHome.setSelected(true);
                rela_menuSecond.setSelected(false);
                rela_menuDiscover.setSelected(false);
                rela_menuMine.setSelected(false);
            }
            break;
            case SECOND: {
                rela_menuHome.setSelected(false);
                rela_menuSecond.setSelected(true);
                rela_menuDiscover.setSelected(false);
                rela_menuMine.setSelected(false);
            }
            break;
            case DISCOVER: {
                rela_menuHome.setSelected(false);
                rela_menuSecond.setSelected(false);
                rela_menuDiscover.setSelected(true);
                rela_menuMine.setSelected(false);
            }
            break;
            case MINE: {
                rela_menuHome.setSelected(false);
                rela_menuSecond.setSelected(false);
                rela_menuDiscover.setSelected(false);
                rela_menuMine.setSelected(true);
            }
            break;
            default:
                break;
        }
    }

    private void switchContent(Fragment from, Fragment to) {
        if (mCurrentContent != to) {
            mCurrentContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                transaction.hide(from).add(R.id.fragment_content, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            // 再按一次退出应用
            long secondTime = System.currentTimeMillis();
            if ((System.currentTimeMillis() - firstTime) > 1000) {
                ToastUtil.showToast(this, R.string.alert_click_again_to_exit);
                firstTime = secondTime;
            } else {
                // 停止打印Toast
                ToastUtil.cancelToast();
                // TODO: 2017/6/5  other candle
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
