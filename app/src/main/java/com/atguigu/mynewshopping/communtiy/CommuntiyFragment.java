package com.atguigu.mynewshopping.communtiy;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.mynewshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/24 0024.
 * 功能:主题fragment
 */

public class CommuntiyFragment extends BaseFragment {
    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextColor(Color.RED);
        Log.e("TAG", "主题初始化视图");
        return mTextView;
    }

    @Override
    protected void initData() {
        Log.e("TAG", "主题初始化数据");
        mTextView.setText("主题");
    }
}
