package izijia.ccpress.com.mylibrary.base;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2017/12/4.
 * <p>
 * 普通的Fragment
 */

public abstract class BaseCommonFragment extends LazyLoadFragment {

    View inflate;

    @Override
    protected void lazyLoad() {
        mRootView.removeAllViews();
        inflate = LayoutInflater.from(getContext()).inflate(setInflaterView(), null);
        mRootView.addView(inflate);

        //添加注入初始化控件，如ButterKnife

        initData();
    }

    /**
     * 初始化视图控件
     */
    public void initView() {

    }

    public abstract void initData();
}
