package izijia.ccpress.com.mylibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.base.loadingdialog.view.LoadingDialog;


/**
 * Created by Admin on 2017/11/22.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected RelativeLayout mRootInflate;//根布局

    protected LinearLayout mRootToolBar;//toolbar

    private RelativeLayout mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRootView = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.base_activity_view, null);

        mRootInflate = (RelativeLayout) mRootView.findViewById(R.id.root_view);
        mRootToolBar = (LinearLayout) mRootView.findViewById(R.id.toolbar);

        mRootInflate.addView(getLayoutInfater());

        setContentView(mRootView);

        initView();

        initData();
    }


    public abstract View getLayoutInfater();

    public abstract int setRootView();

    public abstract void initView();

    public abstract void initData();


    @Override
    public void loadingView() {

    }

    @Override
    public void failLoad() {

    }

    @Override
    public void LoadingDialog() {
        LoadingDialog mLoadingDialog=new LoadingDialog(this);
        mLoadingDialog
                .setLoadingText("加载中...")
                .show();
    }

    @Override
    public void LoadingFailDialog(String msg) {
        LoadingDialog mLoadingDialog=new LoadingDialog(this);
            mLoadingDialog
                    .setLoadingText("加载中...")
                    .setFailedText(msg)
                    .show();
            mLoadingDialog.loadFailed();
    }
}
