package izijia.ccpress.com.mylibrary.base.listener;

import android.view.View;

/**
 * adapter 条目点击监听
 * @author Admin
 * @date 2017/11/27
 */

public interface OnItemClickListsner {
    /**
     * 点击监听
     * @param view
     * @param position
     */
    void setItemOnClickListener(View view, int position);
}
