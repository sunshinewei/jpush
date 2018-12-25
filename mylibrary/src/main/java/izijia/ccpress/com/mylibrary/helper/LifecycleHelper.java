package izijia.ccpress.com.mylibrary.helper;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * Created by mm on 2018/11/6.
 * <p>
 * Activity的生命周期内操作
 */

public interface LifecycleHelper extends LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStartLifecycle();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreateLifecycle();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResumeLifecycle();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPauseLifecycle();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStopLifecycle();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroyLifecycle();

}
