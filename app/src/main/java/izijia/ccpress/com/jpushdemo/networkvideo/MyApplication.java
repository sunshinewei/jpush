package izijia.ccpress.com.jpushdemo.networkvideo;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;

/**
 * Created by wzxai on 2018-7-23.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static MyApplication appContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        appContext = this;
        Utils.init(this);
    }

    public static Context getApplContext() {
        return mContext;
    }

    public static MyApplication getInstance() {
        return appContext;
    }


}
