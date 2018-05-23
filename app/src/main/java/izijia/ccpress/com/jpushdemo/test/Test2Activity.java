package izijia.ccpress.com.jpushdemo.test;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.jpushdemo.data.Test2Presenter;
import izijia.ccpress.com.jpushdemo.data.TestDemoView;
import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;
import izijia.ccpress.com.mylibrary.dialog.DialogFactory;
import izijia.ccpress.com.mylibrary.dialog.listener.OnClickListener;
import izijia.ccpress.com.mylibrary.utils.OSUtils;


/**
 * Created by Admin on 2017/11/23.
 */

public class Test2Activity extends BaseCommonActivity implements TestDemoView {

    @Override
    public int setRootView() {
        return R.layout.activity_test;
    }

    private TextView tvLoad;

    @Override
    public void initView() {
        super.initView();

        tvLoad = (TextView) findViewById(R.id.tv_load);

        tvLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("点击", "点击");
//                ArrayList<String> mArray = new ArrayList<>();
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//
//                DialogFactory.dialogViewBottomMsg(Test2Activity.this)
//                        .setmArrays(mArray)
//                        .setOnClickListener(new OnClickListener() {
//                            @Override
//                            public void setOnClickListner(View view, int position) {
//                                toastLong("sdfsdgfsdfg");
//                            }
//                        })
//                        .show(tvLoad);

                startActivity(new Intent(mContext, BehaviorActivity.class));

//                new BaseViewBottomPopupWindow(Test2Activity.this)
//                        .setmArrays(mArray)
//                        .showAsDropDown(tvLoad);

            }
        });
    }

    private Test2Presenter mTestPresenter;

    @Override
    public void initData() {
        super.initData();
//        mTestPresenter = new Test2Presenter(this);
//        mTestPresenter.getData();
    }

    @Override
    public void successView(TestDemoBean bean) {

        LottieAnimationView lottieAnimationView = findViewById(R.id.animation_view);
        lottieAnimationView.setAnimation("walkthrough.json");
        lottieAnimationView.loop(false);
        lottieAnimationView.playAnimation();
        lottieAnimationView.setProgress(0.8f);
        tvLoad.setText("OSUtils" + OSUtils.getDefaultDisplay(Test2Activity.this)
                .getHeight() + "  :  " + OSUtils.getDefaultDisplay(Test2Activity.this)
                .getWidth() + "  :  " + OSUtils.getDeviceName() + "  :   " + OSUtils.getDeviceProduct() + "  :   " + OSUtils.getSystemVersion());


    }

    @Override
    public void successView() {

    }
}
