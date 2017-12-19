package izijia.ccpress.com.jpushdemo.test;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.bean.TestBean;
import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.jpushdemo.data.TestDemoView;
import izijia.ccpress.com.jpushdemo.data.TestPresenter;
import izijia.ccpress.com.mylibrary.base.BaseLoadActivity;
import izijia.ccpress.com.mylibrary.base.adapter.BaseAdpter;
import izijia.ccpress.com.mylibrary.base.adapter.BaseViewHolder;
import izijia.ccpress.com.mylibrary.base.listener.OnItemClickListsner;
import izijia.ccpress.com.mylibrary.dialog.listener.BaseViewBottomPopupWindow;

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
        Log.e("sdfs", "sdfsd");
    }


    @Override
    public void setRetryListener() {
        mTestPresenter.getData();
    }

    BaseAdpter baseAdpter;

    @Override
    public void successView(TestDemoBean bean) {
        statusViewChange(1);
        final TextView viewById = (TextView) findViewById(R.id.tv_load);
        RecyclerView mRecy = (RecyclerView) findViewById(R.id.recy);
        final ArrayList<TestBean> mA = new ArrayList<>();
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));
        mA.add(new TestBean("sssss"));

        baseAdpter = new BaseAdpter(this, R.layout.adapter_main).setArraryDatas(mA)
                .setVHolderData(new BaseAdpter.ViewHolderData() {
                    @Override
                    public void bindVHTheData(BaseViewHolder holder, int position) {
                    }
                }).setItemClickListsner(new OnItemClickListsner() {
                    @Override
                    public void setItemOnClickListener(View view, int position) {
                        baseAdpter.addArraryDatas(mA);
                    }
                });
        mRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecy.setAdapter(baseAdpter);

        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BaseViewBottomPopupWindow(TestActivity.this)
                        .showAsDropDown(viewById);
            }
        });

    }
}
