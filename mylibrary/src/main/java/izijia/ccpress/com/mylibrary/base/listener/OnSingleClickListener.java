package izijia.ccpress.com.mylibrary.base.listener;

import android.app.Application;
import android.view.View;

import izijia.ccpress.com.mylibrary.MyLibApplication;
import izijia.ccpress.com.mylibrary.toast.ToastUtil;

/**
 * Created by mm on 2018/10/15.
 * 用户点击事件，防止重复点击
 */

public abstract class OnSingleClickListener implements View.OnClickListener {

    private double mLastClick;
    private int mTime = 1000;

    @Override
    public void onClick(View v) {
        if (System.currentTimeMillis() - mLastClick > mTime) {
            onSingleClick(v);
            mLastClick = System.currentTimeMillis();
        } else {
            ToastUtil.toast(MyLibApplication.mContext, "不可重复点击!");
        }
    }

    public abstract void onSingleClick(View v);
}
