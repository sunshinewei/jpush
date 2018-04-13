package izijia.ccpress.com.jpushdemo.data;


import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import izijia.ccpress.com.jpushdemo.bean.ProDetailBean;
import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.mylibrary.gospace.BaseGoSpace;
import izijia.ccpress.com.mylibrary.gospace.listener.OnSuccessListener;

/**
 * Created by Admin on 2017/11/22.
 */

public class TestPresenter {

    TestDemoView mTestDemoView;
    private ArrayList<ProDetailBean> proDetailBeans;

    public TestPresenter(TestDemoView mTestDemoView) {
        this.mTestDemoView = mTestDemoView;
    }

    public void getData() {
        proDetailBeans = new ArrayList<>();
        new BaseGoSpace<TestDemoBean>()
                .setDataType(TestDemoBean.class)
                .setUrl("http://123.57.133.7/TinyFinance3/app/common/appDetails/projectDetails?id=700472")
                .setBaseView(mTestDemoView)
                .setIsLoad(false)
                .setmResponseJson(new BaseGoSpace.ResponseJson() {
                    @Override
                    public void jsonData(String json) {
                        try {
                            pareGson(json);
                            Log.d("集合", proDetailBeans.toString());
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
    ProDetailBean detail;

    JsonParser jsonParser;

    private void pareGson(String json) throws JSONException {
        jsonParser = new JsonParser();
        JsonElement parse = jsonParser.parse(json);
        if (parse.isJsonObject()) {
            JsonObject asJsonObject = parse.getAsJsonObject();
            Set<String> strings = asJsonObject.keySet();
            if (!strings.isEmpty()) {
                Iterator<String> iterator = strings.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    JsonElement jsonElement = asJsonObject.get(next);
                    ProDetailBean mDeatilBean = new ProDetailBean();
                    if (jsonElement.isJsonNull()) {
                        mDeatilBean.setKey(next);
                        proDetailBeans.add(mDeatilBean);
                        Log.i("isJsonNull=====key:" + next, "=====" + jsonElement.toString());
                    } else if (jsonElement.isJsonArray()) {
                        JsonArray asJsonArray = jsonElement.getAsJsonArray();
                        mDeatilBean.setKey(next);
                        ArrayList mArrylist = new ArrayList();
                        for (int i = 0; i < asJsonArray.size(); i++) {
                            Log.i("jsonElement=====key:" + next, "=====" + asJsonArray.get(i).toString());
                            mArrylist.add(next);
                        }
                        mDeatilBean.setPropoty(mArrylist);
                        proDetailBeans.add(mDeatilBean);
                        pareGson(asJsonArray.toString());
                    } else if (jsonElement.isJsonObject()) {
                        JsonObject jsonObject = asJsonObject.getAsJsonObject(next);
                        Log.i("isJsonObject=====key:" + next, "=====" + jsonObject.toString());
                        mDeatilBean.setKey(next);
                        proDetailBeans.add(mDeatilBean);
                        pareGson(jsonObject.toString());
                    }
                }
            }
        } else if (parse.isJsonArray()) {
            JsonArray asJsonArray = parse.getAsJsonArray();
            Log.e("isJsonArrayzz=====key:", asJsonArray.toString());
            if (asJsonArray.isJsonNull()) {
                Log.i("isJsonArrayzz=====key:", asJsonArray.toString());
            } else {
                for (int i = 0; i < asJsonArray.size(); i++) {
                    JsonElement jsonElement = asJsonArray.get(i);
                    Log.i("isJsonArray=====key:", asJsonArray.toString());
                    pareGson(jsonElement.toString());
                }
            }
        } else if (parse.isJsonNull()) {
            JsonNull asJsonNull = parse.getAsJsonNull();
            Log.i("isJsonArray=====key:", asJsonNull.toString());
        }
    }


    private void pareJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jsonObject1 = jsonObject.getJSONObject(next);
            Object jsonV = new JSONTokener(jsonObject1.toString()).nextValue();
            if (jsonV instanceof JsonObject) {
                Log.v("key===>", next);
                Log.v("values===>", jsonV.toString());
                detail = new ProDetailBean();
                detail.setKey(next);
                detail.setType("TITLE");
                proDetailBeans.add(detail);
                subPareJson(jsonObject1.toString());
            }
        }
    }


    private void subPareJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String jsonValues = jsonObject.getString(next);
            Object jsonV = new JSONTokener(jsonValues).nextValue();
            detail = new ProDetailBean();
            detail.setKey(next);
            if (jsonV instanceof JSONObject) {
                Log.v("key===>", next);
                Log.v("values1===>", jsonValues.toString());
                detail.setType("TITLE");
//                proDetailBeans.add(detail);
                subPareJson(jsonValues.toString());
            } else if (jsonV instanceof JSONArray) {
                JSONArray json_arr_values = jsonObject.getJSONArray(next);
                Log.v("key===>", next);
                detail = new ProDetailBean();
                detail.setKey(next);
                ArrayList<String> arr_values = new ArrayList<>();
                for (int i = 0; i < json_arr_values.length(); i++) {
                    Object values = json_arr_values.get(i);
                    Log.v("values2===>", values.toString());
                    arr_values.add(values.toString());
                }
                detail.setPropoty(arr_values);
                detail.setType("GRIDE");
            } else {
                Log.v("key===>", next);
                Log.v("values3===>", jsonValues.toString());
                detail = new ProDetailBean();
                detail.setKey(next);
                detail.setName(jsonValues.toString());
                detail.setType("CONTENT");
            }
            proDetailBeans.add(detail);
        }
        Log.e("集合", proDetailBeans.toString());
    }

}