package izijia.ccpress.com.jpushdemo.data;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Iterator;

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
                .setUrl("http://123.57.133.7/TinyFinance3/app/common/appDetails/projectDetails?id=700472")
                .setBaseView(mTestDemoView)
                .setIsLoad(false)
                .setmResponseJson(new BaseGoSpace.ResponseJson() {
                    @Override
                    public void jsonData(String json) {

                        try {
                            pareJson(json);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setOnSuccessListener(new OnSuccessListener<TestDemoBean>() {
                    @Override
                    public void setSuccessInfo(TestDemoBean datas) {
                        mTestDemoView.successView(datas);
                    }
                })
                .goPostSpace();
    }


    /**
     * json解析
     *
     * @param json
     * @throws JSONException
     */
    private void pareJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String jsonValues = jsonObject.getString(next);
            Object jsonV = new JSONTokener(jsonValues).nextValue();
            if (jsonV instanceof JSONObject) {
                Log.v("key===>", next);
                Log.v("values1===>", jsonValues.toString());
                pareJson(jsonValues.toString());
            } else if (jsonV instanceof JSONArray) {
                Log.v("key===>", next);
                Log.v("values2===>", jsonValues.toString());
            } else {
                Log.v("key===>", next);
                Log.v("values3===>", jsonValues.toString());
            }
        }
    }

}