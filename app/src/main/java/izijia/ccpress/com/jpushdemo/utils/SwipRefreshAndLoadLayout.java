package izijia.ccpress.com.jpushdemo.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by mm on 2018/5/24.
 */

public class SwipRefreshAndLoadLayout extends SwipeRefreshLayout {

    public SwipRefreshAndLoadLayout(@NonNull Context context) {
        super(context);
    }

    public SwipRefreshAndLoadLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        for (int index = 0; index < getChildCount(); index++) {
            if (getChildAt(index) instanceof RecyclerView || getChildAt(index) instanceof ListView) {

            }
        }
    }
}
