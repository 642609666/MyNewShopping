package com.atguigu.mynewshopping.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/24 0024.
 * 功能:父类fragment
 */

public abstract class BaseFragment extends Fragment {

    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    /**
     * 初始化视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 子类用于初始化视图使用
     *
     * @return
     */
    public abstract View initView();

    /**
     * 创建活动时回调
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    /**
     * 1.子类初始化数据
     * 2.网络联网请求数据
     */
    protected abstract void initData();
}
