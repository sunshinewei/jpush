package izijia.ccpress.com.mylibrary.dialog;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import izijia.ccpress.com.mylibrary.R;
import izijia.ccpress.com.mylibrary.dialog.listener.BaseListener;

/**
 * Created by Admin on 2017/12/6.
 * <p>
 * 提示框，位于中心
 */

public class BaseCenterMsgDialog extends BaseDialog {
    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvCancel;
    private TextView tvOk;


    private String mTitle;//标题
    private String mContent;//内容


    private BaseListener mBaseListener;

    /**
     * @return
     */
    public static BaseCenterMsgDialog newInstance() {
        return new BaseCenterMsgDialog();
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.CENTER;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        attributes.width = (int) (displayMetrics.widthPixels * 0.8);
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(attributes);
    }


    @Override
    public int getResId() {
        return R.layout.dialog_center_msg;
    }

    @Override
    protected void initView(ViewGroup mRootView) {
        tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
        tvContent = (TextView) mRootView.findViewById(R.id.tv_content);
        tvCancel = (TextView) mRootView.findViewById(R.id.tv_cancel);
        tvOk = (TextView) mRootView.findViewById(R.id.tv_ok);

        if (!TextUtils.isEmpty(mContent)) {
            tvContent.setText(mContent);
        }
        if (!TextUtils.isEmpty(mTitle)) {
            tvTitle.setText(mTitle);
        }
        /**
         * 点击确定按钮逻辑处理
         */
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBaseListener != null) {
                    mBaseListener.setOnClickListner(v);
                }
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 设置标题
     *
     * @param title
     * @return
     */
    public BaseCenterMsgDialog setTitle(String title) {
        mTitle = title;
        return this;
    }

    /**
     * 设置内容
     *
     * @param content
     * @return
     */
    public BaseCenterMsgDialog setContent(String content) {
        mContent = content;
        return this;
    }

    /**
     * 点击监听
     *
     * @param baseListener
     * @return
     */
    public BaseCenterMsgDialog setBaseListener(BaseListener baseListener) {
        mBaseListener = baseListener;
        return this;
    }

    /**
     *
     */
    public BaseCenterMsgDialog show(AppCompatActivity activity) {
        show(activity.getSupportFragmentManager(), "center");
        return this;
    }


}
