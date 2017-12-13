package izijia.ccpress.com.mylibrary.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import java.util.ArrayList;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.base.listener.OnItemClickListsner;
import izijia.ccpress.com.mylibrary.base.listener.OnLongItemClickListener;


/**
 * Created by Admin on 2017/11/24.
 */

public class BaseMultiAdpter<D extends BaseMultiAdapterData> extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    public static final int VIEW_EMPTY_TYPE = 1;
    public static final int VIEW_NORMAL_TYPE = 2;

    private Context mContext;
    private int ResId;
    private ArrayList<D> mArraryDatas;
    /**
     * 条目监听
     */
    private OnItemClickListsner mItemClickListsner;
    private OnLongItemClickListener mLongItemClickListener;

    public BaseMultiAdpter setItemClickListsner(OnItemClickListsner itemClickListsner) {
        mItemClickListsner = itemClickListsner;
        return this;
    }

    public BaseMultiAdpter setLongItemClickListener(OnLongItemClickListener longItemClickListener) {
        mLongItemClickListener = longItemClickListener;
        return this;
    }

    private ViewHolderData mVHolderData;

    public BaseMultiAdpter setHolderData(ViewHolderData holderData) {
        mVHolderData = holderData;
        return this;
    }

    public BaseMultiAdpter setVHolderData(ViewHolderData VHolderData) {
        mVHolderData = VHolderData;
        return this;
    }

    /**
     * 设置数据
     *
     * @param arraryDatas
     * @return
     */
    public BaseMultiAdpter setArraryDatas(ArrayList<D> arraryDatas) {
        this.mArraryDatas = arraryDatas;
        notifyDataSetChanged();
        return this;
    }

    /**
     * 添加数据
     *
     * @param arraryDatas
     * @return
     */
    public BaseMultiAdpter addArraryDatas(ArrayList<D> arraryDatas) {
        if (mArraryDatas != null) {
            mArraryDatas.addAll(arraryDatas);
            notifyDataSetChanged();
        }
        return this;
    }

    public ArrayList<D> getArraryDatas() {
        return mArraryDatas;
    }

    public BaseMultiAdpter(Context mContext, int ResId) {
        this.ResId = ResId;
        this.mContext = mContext;
    }

    private View inflate;//根布局
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_EMPTY_TYPE:
                inflate = LayoutInflater.from(mContext).inflate(R.layout.base_adapter_view, parent, false);
                break;
            default:
                inflate = LayoutInflater.from(mContext).inflate(ResId, parent, false);
                inflate.setOnClickListener(this);
                inflate.setOnLongClickListener(this);
        }
        inflate.setAnimation(new Animation() {
        });
        return new BaseViewHolder(mContext, inflate);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (mVHolderData != null || mArraryDatas.size() != 0) {
            holder.itemView.setTag(position);
            mVHolderData.bindVHTheData(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        if (mArraryDatas == null || mArraryDatas.size() == 0) {
            return 1;
        } else {
            return mArraryDatas.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mArraryDatas == null || mArraryDatas.size() == 0) {
            return VIEW_EMPTY_TYPE;//空数据
        } else {
            return VIEW_NORMAL_TYPE;//正常数据
        }
    }

    @Override
    public void onClick(View view) {
        if (mItemClickListsner != null) {
            int position = (int) view.getTag();
            mItemClickListsner.setItemOnClickListener(view, position);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mLongItemClickListener != null) {
            int position = (int) view.getTag();
            mLongItemClickListener.setOnLongItemClickListener(view, position);
        }
        return true;
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
