package com.junchao.frametest.recyclerview.base;


/**
 * cell 基类，多重item的cell继承该类
 *
 * @author gjc
 * @version ;;
 * @since 2017-11-07
 */

public abstract class RVBaseCell<T> implements Cell {

    public T mData;

    public RVBaseCell(T t) {
        mData = t;
    }

    @Override
    public void releaseResource() {
        // 如果有需要回收的资源，子类自己实现
    }

}
