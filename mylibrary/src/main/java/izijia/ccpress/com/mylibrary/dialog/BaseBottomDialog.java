package izijia.ccpress.com.mylibrary.dialog;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import izijia.ccpress.com.mylibrary.R;

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


    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.BOTTOM;
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(attributes);
    }

    @Override
    public int getResId() {
        return R.layout.dialog_bottom;
    }

    @Override
    protected void initView(ViewGroup mRootView) {
        mTitle = (TextView) mRootView.findViewById(R.id.tv_title);
        mCancel = (TextView) mRootView.findViewById(R.id.tv_cancel);
        mRecyclerItem = (RecyclerView) mRootView.findViewById(R.id.recy_item);

    }

    public BaseBottomDialog setTitle(String title) {
        this.title = title;
        return this;
    }


    class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {

        @Override
        public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(DialogViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }


        class DialogViewHolder extends RecyclerView.ViewHolder {
            public DialogViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
