package com.junchao.frametest.recyclerview.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * cell 接口
 *
 * @author gjc
 * @version ;;
 * @since 2017-11-07
 */

public interface Cell {
    /**
     * 回收资源
     */
    void releaseResource();

    /**
     * 获取viewType
     * @return
     */
    int getItemType();

    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * 数据绑定
     * @param holder
     * @param position
     */
    void onBindViewHolder(RecyclerView.ViewHolder holder, int position);
}
