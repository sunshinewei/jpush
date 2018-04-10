package izijia.ccpress.com.jpushdemo.data;



import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.mylibrary.gospace.BaseGoSpace;
import izijia.ccpress.com.mylibrary.gospace.listener.OnSuccessListener;

/**
 * Created by Admin on 2017/11/22.
 */

public class TestPresenter {

    TestDemoView mTestDemoView;

    public TestPresenter(TestDemoView mTestDemoView) {
        this.mTestDemoView = mTestDemoView;
    }

    public void getData() {

        new BaseGoSpace<TestDemoBean>()
                .setDataType(TestDemoBean.class)
                .setUrl("http://dev.m.baobaot.com/api/3/index/marketer")
                .setBaseView(mTestDemoView)
                .setIsLoad(false)
                .setOnSuccessListener(new OnSuccessListener<TestDemoBean>() {
                    @Override
                    public void setSuccessInfo(TestDemoBean datas) {
                        mTestDemoView.successView(datas);
                    }
                })
                .goPostSpace();
    }
}