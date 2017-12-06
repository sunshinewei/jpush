package izijia.ccpress.com.jpushdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import izijia.ccpress.com.jpushdemo.R;

/**
 * Created by Admin on 2017/11/22.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected RelativeLayout mRootInflate;//根布局

    protected LinearLayout mRootToolBar;//toolbar

    private RelativeLayout mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRootView = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.base_activity_view, null);

        mRootInflate = mRootView.findViewById(R.id.root_view);
        mRootToolBar = mRootView.findViewById(R.id.toolbar);

        mRootInflate.addView(getLayoutInfater());

        setContentView(mRootInflate);

        initView();

        initData();
    }


    public abstract View getLayoutInfater();

    public abstract int setRootView();

    public abstract void initView();

    public abstract void initData();
}
