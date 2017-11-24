package izijia.ccpress.com.jpushdemo.test;

import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.base.BaseLoadActivity;
import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.jpushdemo.data.TestDemoView;
import izijia.ccpress.com.jpushdemo.data.TestPresenter;

public class TestActivity extends BaseLoadActivity implements TestDemoView {

    private TestPresenter mTestPresenter;

    @Override
    public int setRootView() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        mTestPresenter = new TestPresenter(this);
        mTestPresenter.getData();
    }

    @Override
    public void successView(TestDemoBean bean) {

        TextView viewById = (TextView) findViewById(R.id.tv_load);
        viewById.setText(bean.toString());
    }


    @Override
    public void setRetryListener() {
        mTestPresenter.getData();
    }
}
