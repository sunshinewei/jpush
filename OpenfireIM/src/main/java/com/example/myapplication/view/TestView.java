package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by mm on 2018/10/25.
 */

public class TestView extends ViewGroup {


    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        boolean isTouchEvent;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
