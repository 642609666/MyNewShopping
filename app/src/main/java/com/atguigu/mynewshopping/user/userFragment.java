package com.atguigu.mynewshopping.user;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.mynewshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/24 0024.
 * 功能:个人fragment
 */

public class userFragment extends BaseFragment {
    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextColor(Color.RED);
        Log.e("TAG", "个人初始化视图");
        return mTextView;
    }

    @Override
    protected void initData() {
        Log.e("TAG", "个人初始化数据");
        mTextView.setText("个人");
    }
}
