package izijia.ccpress.com.jpushdemo.view.refresh;

import android.view.MotionEvent;

/**
 * Created by mm on 2018/6/8.
 */
public interface OnGestureListener {
    void onDown(MotionEvent ev);

    void onScroll(MotionEvent downEvent, MotionEvent currentEvent, float distanceX, float distanceY);

    void onUp(MotionEvent ev, boolean isFling);

    void onFling(MotionEvent downEvent, MotionEvent upEvent, float velocityX, float velocityY);
}