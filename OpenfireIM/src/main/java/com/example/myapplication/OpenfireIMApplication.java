package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import izijia.ccpress.com.mylibrary.MyLibApplication;

/**
 * Created by mm on 2018/9/10.
 */

public class OpenfireIMApplication extends MyLibApplication{


    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

                Log.e("打开到了前台",activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e("切换到后台了",activity.getLocalClassName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
