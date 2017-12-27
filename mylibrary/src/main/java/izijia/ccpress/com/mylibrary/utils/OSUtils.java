package izijia.ccpress.com.mylibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Admin on 2017/12/20.
 */

public class OSUtils {


    /**
     * 获取屏幕的像素宽高 单位：px
     *
     * @param mContext
     * @return
     */
    public static WHBean getDefaultDisplay(Activity mContext) {
        WHBean whBean = new WHBean();

        Display defaultDisplay = mContext.getWindowManager().getDefaultDisplay();

        whBean.setHeight(defaultDisplay.getHeight());
        whBean.setWidth(defaultDisplay.getWidth());
        return whBean;
    }

    /**
     * 获取屏幕的像素宽高
     *
     * @param mContext
     * @return
     */
    public static WHBean getDefaultDispla(Activity mContext) {
        WHBean whBean = new WHBean();

        DisplayMetrics displayMetrics = new DisplayMetrics();

        mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        float density = displayMetrics.density;

        return whBean;
    }

    /**
     * 设备名称
     *
     * @return
     */
    public static String getDeviceName() {

        return Build.MODEL;
    }

    /**
     * 设备生产厂商
     *
     * @return
     */
    public static String getDeviceProduct() {

        return Build.BRAND;
    }

    /**
     * 设备生产厂商
     *
     * @return
     */
    public static String getSystemVersion() {

        return Build.VERSION.RELEASE;
    }


    /**
     * 获取系统的版本号
     *
     * @param context
     * @return
     */
    public static int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
