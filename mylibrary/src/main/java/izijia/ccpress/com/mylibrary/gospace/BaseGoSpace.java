package izijia.ccpress.com.mylibrary.gospace;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

import izijia.ccpress.com.mylibrary.MyLibApplication;
import izijia.ccpress.com.mylibrary.base.IBaseView;
import izijia.ccpress.com.mylibrary.gospace.listener.OnSuccessListener;
import izijia.ccpress.com.mylibrary.utils.NetWorkStatus;

/**
 * Created by Administrator on 2017/12/5.
 * <p>
 * Base网络请求
 */

public class BaseGoSpace<T> {
    private String url;//请求地址
    private HashMap<String, String> mHashParams = new HashMap<>();//参数
    private T dataTypes;//数据格式
    private Class dataType;

    private OnSuccessListener mOnSuccessListener;


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


    public BaseGoSpace setOnSuccessListener(OnSuccessListener onSuccessListener) {
        mOnSuccessListener = onSuccessListener;
        return this;
    }

    private IBaseView mBaseView;


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
     * get请求
     */
    public void goGetSpace() {

//        if (NetWorkStatus.isNetworkConnected(MyLibApplication.mContext)) {
//            mBaseView.LoadingFailDialog("请检查网络!");
//            return;
//        }
        OkGo.<String>get(url)
                .tag(this)
                .params(mHashParams)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            Gson gson = new Gson();
                            T data = (T) gson.fromJson(response.body(), dataType);
                            mOnSuccessListener.setSuccessInfo(data);
                        } catch (Exception e) {
                            mBaseView.failLoad();
//                            mBaseView.LoadingFailDialog("数据解析失败!");
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mBaseView.LoadingFailDialog("加载失败!");
                    }
                });
    }
}
