package com.example.behaviordemo.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Created by mm on 2018/11/20.
 */

public class HelpClickService extends AccessibilityService {
    /**
     * 监听窗口变化时回调
     *
     * @param event
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e("aaaaaaaaaaaa","sss");

        switch (event.getEventType()){

            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
                AccessibilityNodeInfo rootNode = getRootInActiveWindow();
                String viewIdResourceName = rootNode.getViewIdResourceName();
                Log.e("aaaaaaaaaaaa",viewIdResourceName);
                break;
        }
//

    }

    /**
     * 中断服务回调
     */
    @Override
    public void onInterrupt() {

    }
}
