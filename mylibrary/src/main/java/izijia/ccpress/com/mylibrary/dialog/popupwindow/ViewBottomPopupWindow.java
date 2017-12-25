package izijia.ccpress.com.mylibrary.dialog.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.dialog.listener.OnClickListener;

/**
 * Created by Admin on 2017/12/25.
 * <p>
 * popupWindow
 */

public class ViewBottomPopupWindow {

    private Activity mContext;

    private PopupWindow mPopupWindow;

    private OnClickListener mOnClickListener;

    public ViewBottomPopupWindow(Activity mCtx) {
        this.mContext = mCtx;
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom, null);
        initView(inflate);
        mPopupWindow = new PopupWindow(mContext);
        mPopupWindow.setBackgroundDrawable(null);
        mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        WindowManager.LayoutParams attributes = mCtx.getWindow().getAttributes();
        attributes.alpha = 0.5f;
        mCtx.getWindow().setAttributes(attributes);
        mPopupWindow.setContentView(inflate);
        mPopupWindow.setOutsideTouchable(true);

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = mContext.getWindow().getAttributes();
                attributes.alpha = 1f;
                mContext.getWindow().setAttributes(attributes);
            }
        });
    }


    public RelativeLayout lnTitle;
    private TextView tvTitle;
    private TextView tvCancel;
    private RecyclerView recyItem;

    private void initView(View inflate) {
        lnTitle = (RelativeLayout) inflate.findViewById(R.id.ln_title);
        tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        tvCancel = (TextView) inflate.findViewById(R.id.tv_cancel);
        recyItem = (RecyclerView) inflate.findViewById(R.id.recy_item);

        lnTitle.setVisibility(View.GONE);
        initRecyclerView();
    }


    private String[] mStrings;

    private ArrayList<String> mArrays;

    private int mGrideCount = 1;


    /**
     * 设置布局格式
     *
     * @param mGrideCount
     */
    public ViewBottomPopupWindow setmGrideCount(int mGrideCount) {
        this.mGrideCount = mGrideCount;
        return this;
    }

    /**
     * 设置数据为集合格式
     *
     * @param mArrays
     */
    public ViewBottomPopupWindow setmArrays(ArrayList<String> mArrays) {
        this.mArrays = mArrays;
        return this;
    }

    /**
     * 设置数据格式为数组格式
     *
     * @param mStrings
     */
    public ViewBottomPopupWindow setmStrings(String[] mStrings) {
        this.mStrings = mStrings;
        return this;
    }

    public ViewBottomPopupWindow setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
        return this;
    }

    private void initRecyclerView() {
        recyItem.setLayoutManager(new GridLayoutManager(mContext, mGrideCount));

        PopupWindowAdapter popupWindowAdapter = new PopupWindowAdapter();

        recyItem.setAdapter(popupWindowAdapter);

        popupWindowAdapter.setmClickListener(new ClickListener() {
            @Override
            public void onClickListener(View view, int position) {
                if (mOnClickListener != null) {
                    mOnClickListener.setOnClickListner(view, position);
                }
            }
        });
    }

    public void show(View view) {
        if (mPopupWindow != null) {
            mPopupWindow.showAsDropDown(view);
        }
    }

    /**
     *
     */
    class PopupWindowAdapter extends RecyclerView.Adapter<PopupWindowAdapter.PopupWindowViewHolder> implements View.OnClickListener {

        private ClickListener mClickListener;

        @Override
        public PopupWindowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_dialog_view, parent, false);

            inflate.setOnClickListener(this);
            return new PopupWindowViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(PopupWindowViewHolder holder, int position) {
            holder.itemView.setTag(position);
            if (mStrings != null) {
                holder.mTvText.setText(mStrings[position]);
            } else if (mArrays != null) {
                holder.mTvText.setText(mArrays.get(position));
            }
        }

        @Override
        public int getItemCount() {
            if (mStrings != null) {
                return mStrings.length;
            } else {
                return mArrays.size();
            }
        }

        /**
         * 设置点击监听
         *
         * @param mClickListener
         */
        public void setmClickListener(ClickListener mClickListener) {
            this.mClickListener = mClickListener;
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onClickListener(view, (Integer) view.getTag());
            }
        }

        class PopupWindowViewHolder extends RecyclerView.ViewHolder {
            private TextView mTvText;

            public PopupWindowViewHolder(View itemView) {
                super(itemView);

                mTvText = (TextView) itemView.findViewById(R.id.tv_text);
            }
        }
    }

    public interface ClickListener {

        void onClickListener(View view, int position);
    }


}
