package izijia.ccpress.com.jpushdemo.view.refresh;

import android.util.Log;

/**
 * Created by mm on 2018/6/8.
 */


public class LogUtil {
    private static final boolean DEBUG = false;

    public static void i(String msg) {
        if (!DEBUG) return;
        Log.i("TwinklingRefreshLayout", msg);
    }
}