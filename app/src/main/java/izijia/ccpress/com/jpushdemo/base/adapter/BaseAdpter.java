package izijia.ccpress.com.jpushdemo.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/11/24.
 */

public class BaseAdpter<T, D extends BaseAdapterData> extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private int ResId;
    private ArrayList<D> mArraryDatas;

    private ViewHolderData mVHolderData;

    public BaseAdpter setHolderData(ViewHolderData holderData) {
        mVHolderData = holderData;
        return this;
    }

    public BaseAdpter setVHolderData(ViewHolderData VHolderData) {
        mVHolderData = VHolderData;
        return this;
    }

    public BaseAdpter setArraryDatas(ArrayList<D> arraryDatas) {
        this.mArraryDatas = arraryDatas;
        return this;
    }

    public ArrayList<D> getArraryDatas() {
        return mArraryDatas;
    }

    public BaseAdpter(Context mContext, int ResId) {
        this.ResId = ResId;
        this.mContext = mContext;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(ResId, parent, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (mVHolderData != null) {
            mVHolderData.bindVHTheData(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mArraryDatas != null ? mArraryDatas.size() : 0;
    }


    public interface ViewHolderData {
        /**
         * 设置ViewHoder数据源
         *
         * @param holder
         * @param position
         */
        void bindVHTheData(BaseViewHolder holder, int position);
    }

}
