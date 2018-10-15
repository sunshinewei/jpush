package izijia.ccpress.com.mylibrary.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.base.loadingdialog.view.LoadingDialog;
import izijia.ccpress.com.mylibrary.toast.ToastUtil;
import izijia.ccpress.com.mylibrary.utils.StatusBarUtils;
import izijia.ccpress.com.mylibrary.utils.SystemStatusManager;


/**
 * Created by Admin on 2017/11/22.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{

    protected RelativeLayout mRootInflate;//根布局

    protected LinearLayout mRootToolBar;//toolbar

    private RelativeLayout mRootView;

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        mContext = this;
        mRootView = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.base_activity_view, null);

        mRootInflate = (RelativeLayout) mRootView.findViewById(R.id.root_view);
        mRootToolBar = (LinearLayout) mRootView.findViewById(R.id.toolbar);

        RelativeLayout inflate = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.base_toolbar, mRootToolBar, false);

        mRootToolBar.addView(inflate);
        mRootInflate.addView(getLayoutInfater());

        setContentView(mRootView);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        /**
         * 设置不用在每一个页面都添加android:fitsSystemWindows="true"
         */
        ViewGroup bar = findViewById(Window.ID_ANDROID_CONTENT);
        View childAt = bar.getChildAt(0);
        if (childAt != null && Build.VERSION.SDK_INT > 14) {
            childAt.setFitsSystemWindows(true);
        }
        /**
         * 状态栏
         */
        new SystemStatusManager(this)
                .setTranslucentStatus(R.color.colorAccent);

        initView();
        initData();
        initToolBar(inflate);
    }

    /**
     * 初始化ToolBar
     *
     * @param inflate
     */
    public TextView tvBack;
    public TextView tvTitle;
    public LinearLayout lnRight;

    private void initToolBar(RelativeLayout inflate) {
        tvBack = (TextView) inflate.findViewById(R.id.tv_back);
        tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        lnRight = (LinearLayout) inflate.findViewById(R.id.ln_right);
        goBack();
        addToolBarRight();
    }

    public void goBack() {
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void addToolBarRight() {
        TextView textView = new TextView(this);

        textView.setText("确定");

        lnRight.addView(textView);
    }


    public abstract View getLayoutInfater();


    public abstract int setRootView();

    /**
     * 此方法存在bug,当进行网络加载是不可用
     */
    public void initView() {

    }

    public abstract void initData();

    /**
     * 吐司
     */
    public void toastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        ToastUtil.toast(mContext,msg);
    }

    @Override
    public void loadingView() {

    }

    @Override
    public void failLoad() {

    }

    LoadingDialog mLoadingDialog;

    @Override
    public void LoadingDialog() {
        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog
                .setShowTime(1)
                .setLoadingText("加载中...")
                .show();
    }

    /**
     * 网络请求完成
     * <p>
     * 1.失败 失败中处理
     * <p>
     * 2.成功 成功中处理
     */
    @Override
    public void loadfinishView() {
//        if (mLoadingDialog != null) {
//            mLoadingDialog.loadSuccess();
//        }
    }


    @Override
    public void LoadingFailDialog(String msg) {
        if (mLoadingDialog != null) {
            mLoadingDialog.loadFailed();
        }
    }


}
