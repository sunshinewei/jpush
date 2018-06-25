package com.example.behaviordemo;


import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleOwner;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.TextView;

import com.example.behaviordemo.livedata.NameViewModel;


public class Main2Activity extends AppCompatActivity implements LifecycleOwner {

    NameViewModel nameViewModel;

    private TextView mTvname;
    private TextView mTvname2;



    double count =0;
    @SuppressLint("HandlerLeak")
    private  Handler  mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
             count= count + 0.001;
//            double v = count * 1000;
            java.text.DecimalFormat   df   =new   java.text.DecimalFormat("00.0000");
            String format = df.format(count);

            mTvname2.setText(""+format);
            mHandler.sendEmptyMessageDelayed(1,1);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTvname = findViewById(R.id.tv_text);
        mTvname2 = findViewById(R.id.tv_tex1);

        mHandler.sendEmptyMessage(1);

//        Log.e("设备号：", SystemOSUtils.getDeviceUniqueID(this)+"   "+SystemOSUtils.getDeviceBrand()+" "+SystemOSUtils.getSystemModel()+"  "+SystemOSUtils.getSystemVersion());
//        LifeCycleObser lifeCycleObser = new LifeCycleObser();
//
//        getLifecycle().addObserver(lifeCycleObser);
//
//
//        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
//
//        nameViewModel.getCurrentName().observeForever(new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//
//                mTvname.setText(s);
//            }
//        });
//
//        nameViewModel.getNameList().observeForever(new Observer<List<String>>() {
//            @Override
//            public void onChanged(@Nullable List<String> strings) {
//
//            }
//        });
//
//        mTvname2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        i++;
//        nameViewModel.getCurrentName().postValue(i + "Main2Activity");
    }
}


