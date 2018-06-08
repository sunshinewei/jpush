package com.example.behaviordemo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.behaviordemo.livedata.NameViewModel;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    NameViewModel nameViewModel;

    private TextView mTvname;
    private TextView mTvname2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
}
