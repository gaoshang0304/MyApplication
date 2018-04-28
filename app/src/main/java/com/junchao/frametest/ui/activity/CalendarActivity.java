package com.junchao.frametest.ui.activity;

import android.os.Bundle;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;
import com.junchao.frametest.utils.LogUtil;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import butterknife.BindView;

/**
 * @author gjc
 * @version ;;
 * @since 2017-10-16
 */

public class CalendarActivity extends ToolbarBaseActivity {

    @BindView(R.id.calendarView)
    MaterialCalendarView calendarView;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_calendar;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "Calendar");

    }

}
