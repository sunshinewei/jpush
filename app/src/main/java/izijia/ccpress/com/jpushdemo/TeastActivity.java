package izijia.ccpress.com.jpushdemo;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.HashMap;
import java.util.List;


import izijia.ccpress.com.jpushdemo.bean.ProDetailBean;
import izijia.ccpress.com.jpushdemo.utils.CommonUtil;
import izijia.ccpress.com.mylibrary.helper.LifecycleHelper;

/**
 * Created by mm on 2018/9/5.
 */

public class TeastActivity extends AppCompatActivity implements LifecycleHelper {

    ImageView imageView;
    private Bitmap bitmap;
    private String filepath;
    private MyLocationListener myLocationListener;

    private TextView btn_save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teast);

        btn_save = findViewById(R.id.btn_save);
        imageView = findViewById(R.id.image);
//        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ddd);

        getLifecycle().addObserver(this);


    }

    public void doPick(View view) {
//        CommonUtil.choosePhoto(this, PictureConfig.CHOOSE_REQUEST);
//        finish();

        String a = null, b = null;

        if ((a = b) == null) {
        }

        HashMap hashMap = new HashMap();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                String path = "";
                if (selectList != null && selectList.size() > 0) {
                    LocalMedia localMedia = selectList.get(0);
                    if (localMedia.isCompressed()) {
                        path = localMedia.getCompressPath();
                    } else if (localMedia.isCut()) {
                        path = localMedia.getCutPath();
                    } else {
                        path = localMedia.getPath();
                    }
                }
                filepath = CommonUtil.amendRotatePhoto(path, TeastActivity.this);
//                imageView.setImageBitmap(BitmapFactory.decodeFile(filepath));
                bitmap = CommonUtil.createAsciiPic(filepath, TeastActivity.this);
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public void doSave(View view) {
//        CommonUtil.saveBitmap2file(bitmap, System.currentTimeMillis() + "", TeastActivity.this);

        teastViewModel.getMutableLiveData().setValue(new ProDetailBean().setName("123456789"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(this);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    @Override
    public void onStartLifecycle() {
        Log.e("生命周期", "TeastActivity+onStart");
    }

    @Override
    public void onCreateLifecycle() {
        Log.e("生命周期", "TeastActivity+onCreate");
    }

    TeastViewModel teastViewModel;

    @Override
    public void onResumeLifecycle() {
        Log.e("生命周期", "TeastActivity+onResume");

        teastViewModel = ViewModelProviders.of(this).get(TeastViewModel.class);
        teastViewModel.getMutableLiveData().observe(this, new Observer<ProDetailBean>() {
            @Override
            public void onChanged(@Nullable ProDetailBean proDetailBean) {

                Log.e("设置数据", "设置数据了，需要更新UI");

                btn_save.setText(proDetailBean.getName());
            }

        });
    }

    @Override
    public void onPauseLifecycle() {

    }

    @Override
    public void onStopLifecycle() {
        Log.e("生命周期", "TeastActivity+onStop");
    }

    @Override
    public void onDestroyLifecycle() {
        Log.e("生命周期", "TeastActivity+Destory");
    }
}

