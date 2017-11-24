package izijia.ccpress.com.jpushdemo.data;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;

/**
 * Created by Admin on 2017/11/22.
 */

public class TestPresenter {

    TestDemoView mTestDemoView;

    public TestPresenter(TestDemoView mTestDemoView) {
        this.mTestDemoView = mTestDemoView;
    }

    public void getData() {
        OkGo.<String>get("http://s.east-profit.com/api.php/space/detail?latitude=null&longitude=null&id=5")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        Gson gson = new Gson();
                        TestDemoBean testDemoBean = gson.fromJson(response.body(), TestDemoBean.class);
                        mTestDemoView.successView(testDemoBean);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        mTestDemoView.loadingView();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mTestDemoView.failLoad();
                    }
                });
    }
}