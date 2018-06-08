package com.example.behaviordemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.behaviordemo.livedata.NameViewModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

public class Main2Activity extends AppCompatActivity implements LifecycleOwner {

    NameViewModel nameViewModel;

    private TextView mTvname;
    private TextView mTvname2;


    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTvname = findViewById(R.id.tv_text);
        mTvname2 = findViewById(R.id.tv_tex1);


        Log.e("设备号：", SystemOSUtils.getDeviceUniqueID(this)+"   "+SystemOSUtils.getDeviceBrand()+" "+SystemOSUtils.getSystemModel()+"  "+SystemOSUtils.getSystemVersion());
        LifeCycleObser lifeCycleObser = new LifeCycleObser();

        getLifecycle().addObserver(lifeCycleObser);


        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);

        nameViewModel.getCurrentName().observeForever(new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                mTvname.setText(s);
            }
        });

        nameViewModel.getNameList().observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {

            }
        });

        mTvname2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        i++;
        nameViewModel.getCurrentName().postValue(i + "Main2Activity");
    }
}
