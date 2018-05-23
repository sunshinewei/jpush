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
import java.util.Map;
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

        try {
            examPareGson(json1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new BaseGoSpace<TestDemoBean>()
                .setDataType(TestDemoBean.class)
                .setUrl("http://123.57.133.7/TinyFinance4/app/common/appDetails/projectDetails?id=700580")
                .setBaseView(mTestDemoView)
                .setIsLoad(false)
                .setmResponseJson(new BaseGoSpace.ResponseJson() {
                    @Override
                    public void jsonData(String json) {
                        try {
                            examPareGson(json1);
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
    private ProDetailBean detail;
    private JsonParser jsonParser;

    private void examPareGson(String json) throws JSONException {
        jsonParser = new JsonParser();
        JsonElement parse = jsonParser.parse(json);
        if (parse.isJsonObject()) {
            JsonObject asJsonObject = parse.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entries = asJsonObject.entrySet();
            Iterator<Map.Entry<String, JsonElement>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                ProDetailBean mDeatilBean = new ProDetailBean();
                Map.Entry<String, JsonElement> next = iterator.next();
                String key = next.getKey();
                mDeatilBean.setKey(key)
                        .setType(1);
                proDetailBeans.add(mDeatilBean);
                pareGson(next.getValue().toString(), key);
            }
        }
    }

    String json1 = "{\n" +
            "项目信息: [\n" +
            "{\n" +
            "项目简介: \"赫特\"\n" +
            "},\n" +
            "{\n" +
            "借款用途: \"个人工人家给\"\n" +
            "},\n" +
            "{\n" +
            "还款来源: \"企业\"\n" +
            "},\n" +
            "{\n" +
            "合作机构: [\n" +
            "\"pubNews/76782f6d-f85a-41e7-af4f-fd41ea0736d9.png\",\n" +
            "\"山西企业再担保\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "项目评级: \"5\"\n" +
            "},\n" +
            "{\n" +
            "可能产生的风险结果: \"小\"\n" +
            "},\n" +
            "{\n" +
            "出借人条件: \"风险承受能力“积极性”及以上\"\n" +
            "},\n" +
            "{\n" +
            "相关协议: [\n" +
            "\"借款协议范本\",\n" +
            "\"相关费用\",\n" +
            "\"网络借贷风险提示\",\n" +
            "\"网络借贷禁止性行为\"\n" +
            "]\n" +
            "}\n" +
            "],\n" +
            "借款方信息: [\n" +
            "{\n" +
            "借款企业: \"企业*款人10\"\n" +
            "},\n" +
            "{\n" +
            "注册资本: \"12.6万元\"\n" +
            "},\n" +
            "{\n" +
            "成立时间: \"2018年03月28日\"\n" +
            "},\n" +
            "{\n" +
            "收入情况: \"年营收23.6万元以上\"\n" +
            "},\n" +
            "{\n" +
            "负债情况: \"2.60万元\"\n" +
            "},\n" +
            "{\n" +
            "所属行业: \"05\"\n" +
            "},\n" +
            "{\n" +
            "法定代表人: \"个\"\n" +
            "},\n" +
            "{\n" +
            "注册地址: \"割肉我割肉不********\"\n" +
            "},\n" +
            "{\n" +
            "信用状况: [\n" +
            "{\n" +
            "在平台逾期次数: \"0次\"\n" +
            "},\n" +
            "{\n" +
            "在平台逾期总金额: \"0.00元\"\n" +
            "},\n" +
            "{\n" +
            "在其他网络借贷平台借款情况: \"个人\"\n" +
            "},\n" +
            "{\n" +
            "截至借款前6个月内借款人征信报告中的逾期情况: \"个人\"\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "],\n" +
            "项目图片: {\n" +
            "项目图片: [\n" +
            "\"attachment/ATA0000002192/63c67e50-c7c0-4f59-b59e-908f8e79b959.jpg\",\n" +
            "\"attachment/ATA0000002192/b1bfad59-2bd8-4962-97e6-6c00da8ea936.jpg\",\n" +
            "\"attachment/ATA0000002192/fe8c3f73-bc84-4f9e-b23d-3093bebf1c1a.jpg\",\n" +
            "\"attachment/ATA0000002192/ad8e2c65-b539-4b8a-8c0f-9f5b62bca88a.jpg\"\n" +
            "]\n" +
            "}\n" +
            "}";

    private void pareGson(String json, String type) throws JSONException {
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
                    if (jsonElement.isJsonArray()) {
                        JsonArray asJsonArray = jsonElement.getAsJsonArray();
                        ArrayList mArrylist = new ArrayList();
                        for (int i = 0; i < asJsonArray.size(); i++) {
                            Log.i("jsonElement=====key:" + next, "=====" + asJsonArray.get(i).getAsString());
                            mArrylist.add(asJsonArray.get(i).getAsString());
                        }
                        mDeatilBean.
                                setKey(next)
                                .setPropoty(mArrylist)
                                .setType(3);//网格布局

                        proDetailBeans.add(mDeatilBean);
                        pareGson(asJsonArray.toString(), next);
                    } else if (jsonElement.isJsonObject()) {
                        JsonObject jsonObject = asJsonObject.getAsJsonObject(next);

                        Log.i("isJsonObject=====key:" + next, "=====" + jsonObject.toString());
                        mDeatilBean.setKey(next);

                        proDetailBeans.add(mDeatilBean);
                        pareGson(jsonObject.toString(), next);
                    } else if (jsonElement.isJsonNull()) {

                        mDeatilBean.setKey(next).setType(2);//小布局
                        proDetailBeans.add(mDeatilBean);
                        Log.i("isJsonNull=====key:" + next, "=====" + jsonElement.toString());
                    } else {
                        if ("信用状况".equals(type)) {
                            mDeatilBean.setKey(next).setType(2)
                                    .setGride(1);//小布局
                            proDetailBeans.add(mDeatilBean);
                        } else {
                            mDeatilBean.setKey(next).setType(2);//小布局
                            proDetailBeans.add(mDeatilBean);
                        }

                        String asString = jsonElement.getAsString();

                        Log.i("isJsonelse=====key:" + next, "=====" + asString);
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
                    pareGson(jsonElement.toString(), null);
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
//            JSONObject jsonObject1 = jsonObject.getJSONObject(next);
            Object jsonV = new JSONTokener(json).nextValue();
            if (jsonV instanceof JsonObject) {
                Log.v("key===>", next);
                Log.v("values===>", jsonV.toString());
                detail = new ProDetailBean();
                detail.setKey(next);
                detail.setType(1);
                proDetailBeans.add(detail);
//                subPareJson(jsonObject1.toString());
            }
        }
    }


    private void subPareJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            detail = new ProDetailBean();
            String jsonValues = jsonObject.getString(next);
            Object jsonV = new JSONTokener(jsonValues).nextValue();
            if (jsonV instanceof JSONObject) {
                detail.setKey(next);
                detail.setType(1);
                Log.v("key===>", next);
                Log.v("values1===>", jsonValues.toString());
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
                detail.setType(1);
            } else {
                Log.v("key===>", next);
                Log.v("values3===>", jsonValues.toString());
                detail = new ProDetailBean();
                detail.setKey(next);
                detail.setName(jsonValues.toString());
                detail.setType(1);
            }
            proDetailBeans.add(detail);
        }
    }

}