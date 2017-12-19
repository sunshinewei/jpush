package izijia.ccpress.com.mylibrary.dialog.popupwindow;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.dialog.BaseBottomDialog;
import izijia.ccpress.com.mylibrary.dialog.listener.OnClickListener;

/**
 * Created by Administrator on 2017/12/8.
 */

public class ViewBottomDialog extends PopupWindow {

    private Context mContext;

    private TextView mTitle;
    private TextView mCancel;
    private RecyclerView mRecyclerItem;

    private String title;

    private String[] mStrings;

    private ArrayList<String> mArrays;

    private int mGrideCount = 1;

    private OnClickListener mBaseListener;


    private View mTargetView;

    public ViewBottomDialog setTargetView(View view) {
        this.mTargetView = view;
        return this;
    }

    public ViewBottomDialog(Context context, View view) {
        super(context);
        this.mContext = context;

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom, null);

        this.setContentView(inflate);


//        initView(inflate);

        showAsDropDown(view);
    }


    private void initView(View inflate) {

        mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        mCancel = (TextView) inflate.findViewById(R.id.tv_cancel);
        mRecyclerItem = (RecyclerView) inflate.findViewById(R.id.recy_item);

        initRecyclerView();
    }

    private DialogAdapter mDialogAdapter;

    private void initRecyclerView() {

        mRecyclerItem.setLayoutManager(new GridLayoutManager(mContext, mGrideCount));

        mDialogAdapter = new DialogAdapter();

        mRecyclerItem.setAdapter(mDialogAdapter);

        mDialogAdapter.setmClickListener(new ClickListener() {
            @Override
            public void onClickListener(View view, int position) {
                if (mBaseListener != null) {
                    mBaseListener.setOnClickListner(view, position);
                }
            }
        });

    }


    /**
     *
     */
    class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> implements View.OnClickListener {

        private ClickListener mClickListener;

        @Override
        public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_dialog_view, parent, false);

            inflate.setOnClickListener(this);
            return new DialogViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(DialogViewHolder holder, int position) {
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

        class DialogViewHolder extends RecyclerView.ViewHolder {
            private TextView mTvText;

            public DialogViewHolder(View itemView) {
                super(itemView);

                mTvText = (TextView) itemView.findViewById(R.id.tv_text);
            }
        }
    }

    public interface ClickListener {

        void onClickListener(View view, int position);
    }


}
