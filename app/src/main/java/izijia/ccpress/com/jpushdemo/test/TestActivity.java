package izijia.ccpress.com.jpushdemo.test;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.base.BaseLoadActivity;
import izijia.ccpress.com.jpushdemo.base.adapter.BaseAdpter;
import izijia.ccpress.com.jpushdemo.base.adapter.BaseViewHolder;
import izijia.ccpress.com.jpushdemo.bean.TestBean;
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
    public void setRetryListener() {
        mTestPresenter.getData();
    }

    @Override
    public void successView(TestDemoBean bean) {
        statusViewChange(1);
        TextView viewById = (TextView) findViewById(R.id.tv_load);
        RecyclerView mRecy=(RecyclerView)findViewById(R.id.recy);
        ArrayList<TestBean> mA=new ArrayList<>();
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));

        mRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecy.setAdapter(new BaseAdpter(this,R.layout.adapter_main).setArraryDatas(mA)
        .setVHolderData(new BaseAdpter.ViewHolderData() {
            @Override
            public void bindVHTheData(BaseViewHolder holder, int position) {

            }
        }));
    }
}
