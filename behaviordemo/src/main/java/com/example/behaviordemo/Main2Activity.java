package com.example.behaviordemo;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.behaviordemo.livedata.NameViewModel;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    NameViewModel nameViewModel;

    private TextView mTvname;
    private TextView mTvname2;

    Activity activity[]={

    };

    public Main2Activity() {
        activity = new Activity[]{

        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTvname = findViewById(R.id.tv_text);
        mTvname2 = findViewById(R.id.tv_tex1);

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
                nameViewModel.getCurrentName().setValue("jjj");
            }
        });

    }
}
