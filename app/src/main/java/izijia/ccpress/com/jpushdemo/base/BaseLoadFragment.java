package izijia.ccpress.com.jpushdemo.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.base.listener.RetryListener;

/**
 * Created by Administrator on 2017/12/4.
 * <p>
 * 网络请求Fragment
 */

public abstract class BaseLoadFragment extends LazyLoadFragment implements BaseView, RetryListener {


    public static final int LOADING_SUCCESS = 1;//布局加载成功
    public static final int LOADING_FAIL = 2;//布局加载失败
    public static final int LOADING_LOADING = 3;//布局加载中


    /**
     * 加载失败视图
     *
     * @return
     */
    public int setFailView() {
        return R.layout.activity_loadfail;
    }

    /**
     * 加载中视图
     *
     * @return
     */
    public int setLoadingView() {
        return R.layout.activity_loading;
    }


    @Override
    protected void lazyLoad() {
        initData();
    }

    /**
     * 初始化数据
     */
    public abstract void initData();

    @Override
    public void loadingView() {
        setLoadStatus(LOADING_LOADING);
    }

    public TextView mTvLoadRetry;

    @Override
    public void failLoad() {
        setLoadStatus(LOADING_FAIL);
        mTvLoadRetry = (TextView) findViewById(R.id.tv_loadfail);
        mTvLoadRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRetryListener();
            }
        });
    }

    private ViewGroup inflate;

    /**
     * 切换布局状态,网络加载切换状态调用此方法
     *
     * @param loadStatus
     */
    public void setLoadStatus(int loadStatus) {
        mRootView.removeAllViews();
        switch (loadStatus) {
            case LOADING_SUCCESS:
                inflate = (ViewGroup) LayoutInflater.from(getContext()).inflate(setInflaterView(), null, false);
                break;
            case LOADING_LOADING:
                inflate = (ViewGroup) LayoutInflater.from(getContext()).inflate(setLoadingView(), null, false);
                break;
            case LOADING_FAIL:
                inflate = (ViewGroup) LayoutInflater.from(getContext()).inflate(setFailView(), null, false);
                break;
        }
        mRootView.addView(inflate);

        //添加注入初始化控件，如ButterKnife

    }

    /**
     * 重试监听，网络请求失败后，重写此方法，重新请求网络
     */
    @Override
    public void setRetryListener() {

    }
}
