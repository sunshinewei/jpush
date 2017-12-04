package izijia.ccpress.com.jpushdemo.base;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.base.listener.LoadListener;
import izijia.ccpress.com.jpushdemo.base.listener.RetryListener;

/**
 * 进入页面就需要网络请求，加载数据
 *
 * @author Admin
 * @date 2017/11/22
 */

public abstract class BaseLoadActivity extends BaseActivity implements LoadListener,RetryListener,BaseView{

    public static final int LOADING_SUCCESS = 1;
    public static final int LOADING_FAIL = 2;
    public static final int LOADING_LOADING = 3;

    @Override
    public View getLayoutInfater() {
        ViewGroup inflate = (ViewGroup) LayoutInflater.from(this).inflate(LoadingResId(), null);
        return inflate;
    }

    @Override
    public int LoadingResId() {
        return R.layout.activity_loading;
    }


    @Override
    public int LoadFailResId() {
        return R.layout.activity_loadfail;
    }

    /**
     * 判断布局状态，动态添加布局
     * (添加ButterKnife时在此添加)
     */
    ViewGroup inflate;

    public void statusViewChange(@Nullable int status) {
        mRootInflate.removeAllViews();
        switch (status) {
            case LOADING_SUCCESS:
                inflate = (ViewGroup) LayoutInflater.from(this).inflate(setRootView(), null);
                break;
            case LOADING_FAIL:
                inflate = (ViewGroup) LayoutInflater.from(this).inflate(LoadFailResId(), null);
                break;
            case LOADING_LOADING:
                inflate = (ViewGroup) LayoutInflater.from(this).inflate(LoadingResId(), null);
                break;
            default:
        }
        mRootInflate.addView(inflate);

        //添加注入初始化控件，如ButterKnife


    }


    @Override
    public void loadingView() {
        statusViewChange(3);
    }
    public TextView mTvLoadRetry;

    @Override
    public void failLoad() {
        statusViewChange(2);
        mTvLoadRetry= (TextView) findViewById(R.id.tv_loadfail);

        mTvLoadRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRetryListener();
            }
        });
    }
}

