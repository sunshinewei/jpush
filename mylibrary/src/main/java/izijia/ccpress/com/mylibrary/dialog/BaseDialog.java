package izijia.ccpress.com.mylibrary.dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import izijia.ccpress.com.mylibrary.R;

/**
 * Created by Admin on 2017/12/6.
 */

public abstract class BaseDialog extends DialogFragment {

    public ViewGroup mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.base_dialog_view, container);
        View inflate = LayoutInflater.from(getActivity()).inflate(getResId(), null);
        mRootView.removeAllViews();
        mRootView.addView(inflate);
        initView(mRootView);
        return mRootView;
    }

    /**
     * 加载布局ID
     *
     * @return
     */
    public abstract int getResId();

    /**
     * 初始化布局控件
     */
    protected abstract void initView(ViewGroup mRootView);

}
