package izijia.ccpress.com.jpushdemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import izijia.ccpress.com.jpushdemo.bean.ProDetailBean;

/**
 * Created by mm on 2018/11/8.
 */

public class TeastViewModel extends ViewModel {

    private MutableLiveData<ProDetailBean> mutableLiveData;

    public MutableLiveData<ProDetailBean> getMutableLiveData() {

        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        mutableLiveData.setValue(new ProDetailBean().setName("姓名"));

        return mutableLiveData;
    }


}
