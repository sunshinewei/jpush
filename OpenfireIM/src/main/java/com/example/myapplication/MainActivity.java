package com.example.myapplication;

import com.example.myapplication.SmarkUtil.ConntionUtils;
import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;

public class MainActivity extends BaseCommonActivity {

    @Override
    public int setRootView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();

        new Thread(){
            @Override
            public void run() {
//                super.run();
                ConntionUtils.getInstance(null,null);
            }
        }.start();
    }
}
