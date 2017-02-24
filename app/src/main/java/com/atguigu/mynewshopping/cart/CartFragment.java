package com.atguigu.mynewshopping.cart;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.mynewshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/24 0024.
 * 功能:购物fragment
 */

public class CartFragment extends BaseFragment {
    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextColor(Color.RED);
        Log.e("TAG", "购物初始化视图");
        return mTextView;
    }

    @Override
    protected void initData() {
        Log.e("TAG", "购物初始化数据");
        mTextView.setText("购物");
    }
}
