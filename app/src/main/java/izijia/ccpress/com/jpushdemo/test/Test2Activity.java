package izijia.ccpress.com.jpushdemo.test;

import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.jpushdemo.data.Test2Presenter;
import izijia.ccpress.com.jpushdemo.data.TestDemoView;
import izijia.ccpress.com.jpushdemo.data.TestPresenter;
import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;


/**
 * Created by Admin on 2017/11/23.
 */

public class Test2Activity extends BaseCommonActivity implements TestDemoView {
    private TextView tvLoad;
    @Override
    public int setRootView() {
        return R.layout.activity_test;
    }


    @Override
    public void initView() {
        super.initView();
    }

    private Test2Presenter mTestPresenter;

    @Override
    public void initData() {
        super.initData();
        mTestPresenter = new Test2Presenter(this);
        mTestPresenter.getData();
    }

    @Override
    public void successView(TestDemoBean bean) {
        tvLoad = (TextView) findViewById(R.id.tv_load);
        tvLoad.setText(bean.toString());
    }
}
