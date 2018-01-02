package izijia.ccpress.com.mylibrary.dialog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.dialog.listener.BaseListener;
import izijia.ccpress.com.mylibrary.dialog.listener.OnClickListener;

/**
 * Created by Admin on 2017/12/6.
 * <p>
 * 底部弹出框
 */

public class BaseBottomDialog extends BaseDialog {

    private TextView mTitle;
    private TextView mCancel;
    private RecyclerView mRecyclerItem;

    private String title;

    private String[] mStrings;

    private ArrayList<String> mArrays;

    private int mGrideCount = 1;

    private OnClickListener mBaseListener;

    /**
     * @return
     */
    public static BaseBottomDialog newInstance() {
        return new BaseBottomDialog();
    }


    @Override
    public int getResId() {
        return R.layout.dialog_bottom;
    }

    /**
     * 设置Dialog宽度占满全屏必须设置
     * <>
     * window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
     * </>
     */
    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
    }

    View viewGroup;

    public BaseBottomDialog setViewGroup(View viewGroup) {
        this.viewGroup = viewGroup;
        return this;
    }

    @Override
    protected void initView(ViewGroup mRootView) {
        mTitle = (TextView) mRootView.findViewById(R.id.tv_title);
        mCancel = (TextView) mRootView.findViewById(R.id.tv_cancel);
        mRecyclerItem = (RecyclerView) mRootView.findViewById(R.id.recy_item);

        initRecyclerView();

    }


    public BaseBottomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    private DialogAdapter mDialogAdapter;

    private void initRecyclerView() {

        mRecyclerItem.setLayoutManager(new GridLayoutManager(getActivity(), mGrideCount));

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
     * Dialog 的显示
     *
     * @param mAct
     * @return
     */
    public BaseBottomDialog show(Activity mAct) {
        show(getFragmentManager(), this.toString());
        return this;
    }


    public BaseBottomDialog setOnClickListener(OnClickListener mBaseListener) {
        this.mBaseListener = mBaseListener;
        return this;
    }

    /**
     * 设置布局格式
     *
     * @param mGrideCount
     */
    public BaseBottomDialog setmGrideCount(int mGrideCount) {
        this.mGrideCount = mGrideCount;
        return this;
    }

    /**
     * 设置数据为集合格式
     *
     * @param mArrays
     */
    public BaseBottomDialog setmArrays(ArrayList<String> mArrays) {
        this.mArrays = mArrays;
        return this;
    }

    /**
     * 设置数据格式为数组格式
     *
     * @param mStrings
     */
    public BaseBottomDialog setmStrings(String[] mStrings) {
        this.mStrings = mStrings;
        return this;
    }

    /**
     *
     */
    class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> implements View.OnClickListener {

        private ClickListener mClickListener;

        @Override
        public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.adapter_dialog_view, parent, false);

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
