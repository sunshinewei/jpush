package izijia.ccpress.com.mylibrary.helper;

import android.app.Activity;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Intent;

/**
 * Created by Admin on 2018/1/2.
 * <p>
 * 处理startActivityForResult()中在onActivityResult()方法中返回的数据
 * <p>
 * 调用规则
 * onResultHelper.setResultCallBack(new OnResultHelper.OnResultCallBack() {
 *
 * @Override public void callBack(int resultCode, Intent intent) {
 * <p>
 * }
 * }).setinitData(1, 2, data);
 */

public class OnResultHelper {

    private int resultCode;
    private int requestCode;

    private OnResultCallBack mResultCallBack;

    private Activity mActivity;

    private Intent mIntent;

    /**
     * 回调逻辑处理
     *
     * @param resultCallBack
     * @return
     */
    public OnResultHelper setResultCallBack(OnResultCallBack resultCallBack) {
        mResultCallBack = resultCallBack;
        return this;
    }


    public OnResultHelper() {

    }

    /**
     * activity中返回的数据
     *
     * @param reqCode
     * @param resCode
     * @param data
     */
    public OnResultHelper setinitData(int reqCode, int resCode, Intent data) {
        this.requestCode = reqCode;
        this.resultCode = resCode;
        this.mIntent = data;
        if (mResultCallBack != null) {
            mResultCallBack.callBack(resCode, data);
        }
        return this;
    }




    public interface OnResultCallBack {
        void callBack(int resultCode, Intent intent);
    }

}
