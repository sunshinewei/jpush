package izijia.ccpress.com.mylibrary.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import izijia.ccpress.com.mylibrary.R;

/**
 * @author Admin
 * @date 2017/12/25
 */

public final class ToastUtil {

    private static Toast mToast;

    /**
     * toast弹出框
     *
     * @param mCtx
     * @param msg
     */
    public static void toast(Context mCtx, String msg) {
        if (mToast == null) {
            mToast = new Toast(mCtx);
        }
        View inflate = LayoutInflater.from(mCtx).inflate(R.layout.toast_view, null);
        TextView tv_msg = inflate.findViewById(R.id.tv_msg);
        tv_msg.setText(msg);
        mToast.setView(inflate);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }



}
