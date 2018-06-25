package com.example.packageandroid.presenter;

import android.content.Context;

import com.example.packageandroid.entity.HomeEntity;

import izijia.ccpress.com.mylibrary.base.IBaseView;
import izijia.ccpress.com.mylibrary.gospace.BaseGoSpace;
import izijia.ccpress.com.mylibrary.gospace.listener.OnSuccessListener;

/**
 * Created by mm on 2018/6/25.
 */

public class IHomePresenter {

    private Context context;
    private IHomeView iHomeView;
    public IHomePresenter(Context context,IHomeView iHomeView){
        this.context=context;
        this.iHomeView=iHomeView;
    }

    public void HomeShow(String url) {

        new BaseGoSpace<HomeEntity>()
                .setUrl(url)
                .setDataType(HomeEntity.class)
                .setBaseView(iHomeView)
                .setIsLoad(false)
                .setOnSuccessListener(new OnSuccessListener<HomeEntity>() {
                    @Override
                    public void setSuccessInfo(HomeEntity datas) {
                        iHomeView.showView();
                    }
                })
                .goGetSpace();
    }

    public interface IHomeView extends IBaseView{

        void showView();
    }
}
