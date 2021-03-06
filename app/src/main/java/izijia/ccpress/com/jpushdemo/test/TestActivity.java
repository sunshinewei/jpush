package izijia.ccpress.com.jpushdemo.test;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;

import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.bean.TestBean;
import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.jpushdemo.data.TestDemoView;
import izijia.ccpress.com.jpushdemo.data.TestPresenter;
import izijia.ccpress.com.mylibrary.base.BaseLoadActivity;
import izijia.ccpress.com.mylibrary.base.adapter.BaseAdpter;
import izijia.ccpress.com.mylibrary.base.adapter.BaseViewHolder;
import izijia.ccpress.com.mylibrary.base.listener.OnItemClickListsner;
import izijia.ccpress.com.mylibrary.cache.CacheHelper;
import izijia.ccpress.com.mylibrary.cache.DiskLruCache;
import izijia.ccpress.com.mylibrary.cache.LruJsonCache;
import izijia.ccpress.com.mylibrary.cache.UCacheHelper;

public class TestActivity extends BaseLoadActivity implements TestDemoView {

    private TestPresenter mTestPresenter;

    @Override
    public int setRootView() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {

    }

    LruJsonCache lruJsonCache;

    @Override
    public void initData() {
        lruJsonCache = LruJsonCache.get(this);
        mTestPresenter = new TestPresenter(this);
        mTestPresenter.getData();
    }


    @Override
    public void setRetryListener() {
        mTestPresenter.getData();
    }

    BaseAdpter baseAdpter;
     TextView viewById;
    @Override
    public void successView(TestDemoBean bean) {
        statusViewChange(1);

//        ImageView load = findViewById(R.id.img_load);
//        TextView viewById = (TextView) findViewById(R.id.tv_load);
//
//        UCacheHelper uCacheHelper = new UCacheHelper(mContext);
//        uCacheHelper.addImageCache("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3424226810,3788025634&fm=27&gp=0.jpg");
//
//        Bitmap bitmap = uCacheHelper.readImageCache("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3424226810,3788025634&fm=27&gp=0.jpg");
//        load.setImageBitmap(bitmap);
//
//        //第3步：从缓存中取数据
//        String cacheData = lruJsonCache.getAsString("newsList");//从缓存中取数据
//        if (cacheData != null) {//如果缓存中有，就不访问网络
//            viewById.setText(cacheData);
//        } else {
//            //第2步：设置缓存数据，有效时间设置为1小时
//            if (bean != null) {
//                Gson gson = new Gson();
//                String s = gson.toJson(bean);
//                lruJsonCache.put("newsList", s, 60 * 60 * 1);
//            }
//        }


//        RecyclerView mRecy = (RecyclerView) findViewById(R.id.recy);
//        final ArrayList<TestBean> mA = new ArrayList<>();
//        mA.add(new TestBean("sssss"));
//        mA.add(new TestBean("sssss"));
//        mA.add(new TestBean("sssss"));
//        mA.add(new TestBean("sssss"));
//        mA.add(new TestBean("sssss"));
//        mA.add(new TestBean("sssss"));
//
//        baseAdpter = new BaseAdpter(this, R.layout.adapter_main).setArraryDatas(mA)
//                .setVHolderData(new BaseAdpter.ViewHolderData() {
//                    @Override
//                    public void bindVHTheData(BaseViewHolder holder, int position) {
//                    }
//                }).setItemClickListsner(new OnItemClickListsner() {
//                    @Override
//                    public void setItemOnClickListener(View view, int position) {
//                        baseAdpter.addArraryDatas(mA);
//                    }
//                });
//        mRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mRecy.setAdapter(baseAdpter);


//        Message obtain = Message.obtain();
//        mHanlder.sendMessage(obtain);
    }

    @Override
    public void successView() {
        statusViewChange(1);
        viewById= (TextView) findViewById(R.id.tv_load);

    }


    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }




}
