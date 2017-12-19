package izijia.ccpress.com.mylibrary.dialog;

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

}
