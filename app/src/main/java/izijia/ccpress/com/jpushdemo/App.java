package izijia.ccpress.com.jpushdemo;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;
import izijia.ccpress.com.mylibrary.MyLibApplication;


/**
 * Created by Admin on 2017/11/17.
 */

public class App extends MyLibApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        application = getApplicationContext();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
//        setCustomDensity(this, this);
        super.registerComponentCallbacks(callback);


    }

    static Context application;

    public static Context getApplication() {
        return application;
    }

    public static void setCustomDensity(@Nullable Context activity, @Nullable Context application) {


        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();



        Log.v("各项参数",displayMetrics.density+"    "+displayMetrics.widthPixels+"    "+displayMetrics.densityDpi);

        float density = displayMetrics.widthPixels / 360;
        int densityDpi = (int) (density * 160);
        displayMetrics.density = displayMetrics.scaledDensity = density;
        displayMetrics.densityDpi = densityDpi;


//        float density = displayMetrics.widthPixels / 360;
//        int densityDpi = (int) (density * 160);
//        displayMetrics.density = displayMetrics.scaledDensity = density;
//        displayMetrics.densityDpi = densityDpi;



        DisplayMetrics displayMetricsTarget = activity.getResources().getDisplayMetrics();
        float densityTarget = displayMetricsTarget.widthPixels / 360;
        int densityDpiTarget = (int) (densityTarget * 160);
        displayMetricsTarget.density = displayMetricsTarget.scaledDensity = densityTarget;
        displayMetricsTarget.densityDpi = densityDpiTarget;


//        Log.v("各项参数修改后",displayMetricsTarget.density+"    "+displayMetricsTarget.widthPixels+"    "+displayMetricsTarget.densityDpi);
    }
}
