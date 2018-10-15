package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.SmarkUtil.ConntionUtils;

import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;
import izijia.ccpress.com.mylibrary.base.listener.OnSingleClickListener;
import izijia.ccpress.com.mylibrary.toast.ToastUtil;

public class MainActivity extends BaseCommonActivity{
    private ImageView imgView;

    @Override
    public int setRootView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();

        imgView = (ImageView) findViewById(R.id.img_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            imgView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                     Log.e("sss",scrollX+"   "+scrollY+"   "+oldScrollX+"        "+oldScrollY);
                }
            });
        }

        imgView.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                ToastUtil.toast(mContext,"sasdasdasdas");
            }
        });
    }

    Bitmap bitmap;

    @Override
    public void initData() {
        super.initData();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.map111, options);
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;
        System.out.println("宽度+高度" + outWidth + "   " + outHeight);
        options.inSampleSize = caculateInSimpleSize(options, 1000, 2000);
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.map111, options);
        imgView.setImageBitmap(bitmap);
    }



    private int caculateInSimpleSize(BitmapFactory.Options options, int reqHeight, int reqWidth) {
        int inSimple = 1;
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;

        if (outWidth > reqHeight || outHeight > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) outHeight / (float) reqHeight);
            final int widthRatio = Math.round((float) outWidth / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSimple = heightRatio < widthRatio ? heightRatio : widthRatio;
            return inSimple;
        }
        return inSimple;
    }


}
