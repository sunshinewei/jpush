package com.example.behaviordemo.livedata;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by mm on 2018/5/22.
 */

public class NameViewModel extends ViewModel {

    // Create a LiveData with a String
    private MediatorLiveData<String> mCurrentName;
    // Create a LiveData with a String list
    private MutableLiveData<List<String>> mNameListData;

    public MediatorLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MediatorLiveData<>();
            mCurrentName.postValue("dsasasaad");
        }
        return mCurrentName;
    }

    public MutableLiveData<List<String>> getNameList() {
        if (mNameListData == null) {
            mNameListData = new MutableLiveData<>();
        }
        return mNameListData;
    }


}