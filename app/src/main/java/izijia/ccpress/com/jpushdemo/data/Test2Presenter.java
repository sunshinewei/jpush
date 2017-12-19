package izijia.ccpress.com.jpushdemo.data;

import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.mylibrary.gospace.BaseGoSpace;
import izijia.ccpress.com.mylibrary.gospace.listener.OnSuccessListener;

/**
 * Created by Admin on 2017/11/22.
 */

public class Test2Presenter {

    TestDemoView mTestDemoView;

    public Test2Presenter(TestDemoView mTestDemoView) {
        this.mTestDemoView = mTestDemoView;
    }

    public void getData() {

        BaseGoSpace.helper()
//                .setDataType(TestDemoBean.class)
                .setUrl("http://s.east-profit.com/api.php/space/detail")
                .setParam("id", "5", "latitude", null, "longitude", null)
                .setBaseView(mTestDemoView)
                .setOnSuccessListener(new OnSuccessListener<TestDemoBean>() {
                    @Override
                    public void setSuccessInfo(TestDemoBean datas) {
                        mTestDemoView.successView(datas);
                    }
                })
                .goGetSpace();

//        new BaseGoSpace<TestDemoBean>()
//                .setDataType(TestDemoBean.class)
//                .setUrl("http://s.east-profit.com/api.php/space/detail")
//                .setParam("id","5","latitude",null,"longitude",null)
//                .setBaseView(mTestDemoView)
//                .setOnSuccessListener(new OnSuccessListener<TestDemoBean>() {
//                    @Override
//                    public void setSuccessInfo(TestDemoBean datas) {
//                        mTestDemoView.successView(datas);
//                    }
//                })
//                .goGetSpace();
    }
}