package izijia.ccpress.com.mylibrary.dialog.listener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import izijia.ccpress.com.mylibrary.R;

/**
 * Created by Admin on 2017/12/15.
 */

public class BaseViewBottomPopupWindow extends PopupWindow {

    private Context mContext;

    public BaseViewBottomPopupWindow(Context mContext) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom, null);
        setContentView(inflate);
    }
}
