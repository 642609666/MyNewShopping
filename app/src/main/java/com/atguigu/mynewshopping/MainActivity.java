package com.atguigu.mynewshopping;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.atguigu.mynewshopping.base.BaseFragment;
import com.atguigu.mynewshopping.cart.CartFragment;
import com.atguigu.mynewshopping.communtiy.CommuntiyFragment;
import com.atguigu.mynewshopping.home.HomeFragment;
import com.atguigu.mynewshopping.type.TypeFragment;
import com.atguigu.mynewshopping.user.userFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.rl_main)
    RelativeLayout rlMain;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;

    private List<BaseFragment> mHomeFragments;
    private int position = 0;

    /**
     * 缓存碎片
     */
    private BaseFragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        //添加fragment
        initFragment();
        //初始化数据
        initData();
        //监听
        initListener();
    }

    private void initListener() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_type:
                        position = 1;
                        break;
                    case R.id.rb_communtiy:
                        position = 2;
                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                }

                //根据不同的位置显示不同的fragment
                BaseFragment baseFragment = mHomeFragments.get(position);
                switchFragment(baseFragment);
            }

        });
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(BaseFragment baseFragment) {
        //如果不是同一个fragment
        if (tempFragment != baseFragment) {
            //获取fragment管理事务
            FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();

            //如果没有被添加
            if (!baseFragment.isAdded()) {

                //缓存的就隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }

                //添加
                ft.add(R.id.rl_main, baseFragment);
            } else {

                //缓存的就隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //显示
                ft.show(baseFragment);
            }
            //提交事务
            ft.commit();
            //重新赋值
            tempFragment = baseFragment;
        }
    }

    private void initData() {

    }

    private void initFragment() {
        mHomeFragments = new ArrayList<>();
        mHomeFragments.add(new HomeFragment());
        mHomeFragments.add(new TypeFragment());
        mHomeFragments.add(new CommuntiyFragment());
        mHomeFragments.add(new CartFragment());
        mHomeFragments.add(new userFragment());
    }
}
