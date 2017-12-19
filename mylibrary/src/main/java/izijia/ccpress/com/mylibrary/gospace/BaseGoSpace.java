package izijia.ccpress.com.mylibrary.gospace;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;

import izijia.ccpress.com.mylibrary.MyLibApplication;
import izijia.ccpress.com.mylibrary.base.IBaseView;
import izijia.ccpress.com.mylibrary.gospace.listener.OnSuccessListener;
import izijia.ccpress.com.mylibrary.utils.NetWorkStatus;

/**
 * Created by Administrator on 2017/12/5.
 * <p>
 * 网络请求
 */

public class BaseGoSpace<T> {
    private String url;//请求地址
    private HashMap<String, String> mHashParams = new HashMap<>();//参数
    private T dataTypes;//数据格式
    private Class dataType;

    private boolean isLoad = true;//设置加载模式 false:进入页面加载，true:单个点击事件请求

    private OnSuccessListener mOnSuccessListener;//请求成功监听
    private IBaseView mBaseView;//


    public static <B> BaseGoSpace helper() {
        return new BaseGoSpace<B>();
    }


    public BaseGoSpace setBaseView(IBaseView baseView) {
        mBaseView = baseView;
        return this;
    }

    public Class getDataType() {
        return dataType;
    }

    public BaseGoSpace setDataType(Class dataType) {
        this.dataType = dataType;
        return this;
    }

    public BaseGoSpace setIsLoad(boolean load) {
        isLoad = load;
        return this;
    }

    public BaseGoSpace setOnSuccessListener(OnSuccessListener onSuccessListener) {
        mOnSuccessListener = onSuccessListener;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BaseGoSpace setUrl(String url) {
        this.url = url;
        return this;
    }

    public HashMap<String, String> getHashParams() {
        return mHashParams;
    }

    public BaseGoSpace setHashParams(HashMap<String, String> hashParams) {
        mHashParams = hashParams;
        return this;
    }

    public T getDataTypes() {
        return dataTypes;
    }

    public BaseGoSpace setDataTypes(T dataTypes) {
        this.dataTypes = dataTypes;
        return this;
    }

    /**
     * 设置请求参数
     *
     * @param param
     * @return
     */
    public BaseGoSpace setParam(String... param) {
        if (param.length % 2 == 0) {
            for (int i = 0; i < param.length; i = i + 2) {
                mHashParams.put(param[i], param[i + 1]);
            }
        }
        return this;
    }

    /**
     * get请求
     */
    public void goGetSpace() {
//        if (!NetWorkStatus.isNetworkConnected(MyLibApplication.mContext)) {
//            if (!isLoad) {
//                mBaseView.failLoad();
//            } else {
//                mBaseView.LoadingFailDialog("数据解析失败!");
//            }
//            return;
//        }
        OkGo.<String>get(url)
                .tag(this)
                .params(mHashParams)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (isLoad) {
                            mBaseView.LoadingDialog();
                        }
                    }
                    @Override
                    public void onSuccess(Response<String> response) {
                        goAnalysisData(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (!isLoad) {
                            mBaseView.failLoad();
                        } else {
                            mBaseView.LoadingFailDialog("请求异常!");
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (isLoad) {
                            mBaseView.loadfinishView();
                        }
                    }
                });
    }

    /**
     * post请求
     */
    public void goPostSpace() {
        OkGo.<String>post(url)
                .tag(this)
                .params(mHashParams)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (isLoad) {
                            mBaseView.LoadingDialog();
                        }
                    }
                    @Override
                    public void onSuccess(Response<String> response) {
                        goAnalysisData(response.body());
                    }
                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (!isLoad) {
                            mBaseView.failLoad();
                        } else {
                            mBaseView.LoadingFailDialog("请求异常!");
                        }
                    }
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (isLoad) {
                            mBaseView.loadfinishView();
                        }
                    }
                });
    }

    /**
     * 解析数据
     *
     * @param datas
     */
    private void goAnalysisData(String datas) {
        try {
            Gson gson = new Gson();
            T data = (T) gson.fromJson(datas, dataType);
            mOnSuccessListener.setSuccessInfo(data);
        } catch (Exception e) {
            if (!isLoad) {
                mBaseView.failLoad();
                Log.e("数据解析","数据解析失败!");

            } else {
                mBaseView.LoadingFailDialog("数据解析失败!");
            }
        }
    }
}
