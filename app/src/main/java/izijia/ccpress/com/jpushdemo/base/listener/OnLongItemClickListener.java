package izijia.ccpress.com.jpushdemo.base.listener;

import android.view.View;

/**
 * Adapter 条目长按点击监听
 * Created by Admin on 2017/11/27.
 */

public interface OnLongItemClickListener {

    /**
     * 条目长按点击监听
     *
     * @param view
     * @param position
     */
    void setOnLongItemClickListener(View view, int position);
}
