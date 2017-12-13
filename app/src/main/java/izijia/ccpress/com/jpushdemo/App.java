package izijia.ccpress.com.jpushdemo;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.logging.Level;

import cn.jiguang.api.JProtocol;
import cn.jpush.android.api.JPushInterface;
import izijia.ccpress.com.mylibrary.MyLibApplication;
import okhttp3.OkHttpClient;

/**
 * Created by Admin on 2017/11/17.
 */

public class App extends MyLibApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
    }

}
