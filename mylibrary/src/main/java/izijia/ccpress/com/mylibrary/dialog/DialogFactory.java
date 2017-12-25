package izijia.ccpress.com.mylibrary.dialog;

import android.app.Activity;

import izijia.ccpress.com.mylibrary.dialog.popupwindow.ViewBottomPopupWindow;

/**
 * Created by Administrator on 2017/12/8.
 */

public class DialogFactory {

    /**
     * 弹出框位于中心
     *
     * @return
     */
    public static BaseCenterMsgDialog dialogCenterMsg() {

        return BaseCenterMsgDialog.newInstance();
    }

    /**
     * 弹出框位于底部
     *
     * @return
     */
    public static BaseBottomDialog dialogBottomMsg() {

        return BaseBottomDialog.newInstance();
    }


    /**
     * 弹出框位于View底部
     *
     * @return
     */
    public static ViewBottomPopupWindow dialogViewBottomMsg(Activity act) {

        return new ViewBottomPopupWindow(act);
    }

}
