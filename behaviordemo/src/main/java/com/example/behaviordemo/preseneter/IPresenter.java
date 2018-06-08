package com.example.behaviordemo.preseneter;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;


/**
 * Created by mm on 2018/5/24.
 */

public class IPresenter extends LiveData<String> {

    @Override
    protected void onActive() {
        super.onActive();
    }
}
