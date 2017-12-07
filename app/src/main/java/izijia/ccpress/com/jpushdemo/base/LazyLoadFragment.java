package izijia.ccpress.com.jpushdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import izijia.ccpress.com.jpushdemo.R;

/**
 * Created by Administrator on 2017/12/4.
 *
 *
 */

public abstract class LazyLoadFragment extends Fragment {

    /**
     * 视图是否已经初初始化
     */
    protected boolean isInit = false;
    protected boolean isLoad = false;
    protected final String TAG = "FragmentLazyLoad";
    public FrameLayout mRootView;
    private Toast mToast;
    private Context mContext;
    private Bundle mSavedInstanceState;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (FrameLayout) inflater.inflate(R.layout.base_view, container, false);
        isInit = true;
        mSavedInstanceState = savedInstanceState;
        mContext = getContext();
        /**初始化的时候去加载数据**/
        isCanLoadData();
        return mRootView;
    }

    /**
     * 视图Id
     *
     * @return
     */
    public abstract int setInflaterView();

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }


    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 视图销毁的时候讲Fragment是否初始化的状态变为false
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;

    }

    /**
     * 获取设置的布局
     *
     * @return
     */
    protected View getContentView() {
        return mRootView;
    }


    /**
     * 找出对应的控件
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewById(int id) {

        return (T) getContentView().findViewById(id);
    }

    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected abstract void lazyLoad();

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {
    }
}