package com.example.myapplication;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Utils.PicUtils;
import com.example.myapplication.bean.HomeBean;

import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;


/**
 * 项目详情页
 */
public class ProInfoActivity extends BaseCommonActivity {

    private ImageView imgShow;
    private TextView tvName;
    private TextView tvMinPrice;
    private TextView tvOriginPrice;
    private TextView tvInfo;
    private TextView tvTel;

    @Override
    public int setRootView() {
        return R.layout.activity_pro_info;
    }

    @Override
    public void initView() {
        super.initView();
        setTitle("项目详情");
        imgShow = (ImageView) findViewById(R.id.img_show);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvMinPrice = (TextView) findViewById(R.id.tv_minPrice);
        tvOriginPrice = (TextView) findViewById(R.id.tv_originPrice);
        tvInfo = (TextView) findViewById(R.id.tv_info);
        tvTel = (TextView) findViewById(R.id.tv_tel);
    }

    private HomeBean intent_HomeBean;
    @Override
    public void initData() {
        intent_HomeBean= (HomeBean) getIntent().getSerializableExtra(Constant.INTENT_INFO);

        if (intent_HomeBean!=null){
            imgShow.setImageDrawable(PicUtils.initPic(mContext, intent_HomeBean.getId()));
            tvName.setText(intent_HomeBean.getName());
            tvInfo.setText(intent_HomeBean.getCharacteristic());
            tvMinPrice.setText(intent_HomeBean.getMinPrice()+"");
            tvOriginPrice.setText(intent_HomeBean.getOriginalPrice()+"");

        }
    }
}
