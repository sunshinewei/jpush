package izijia.ccpress.com.jpushdemo;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import izijia.ccpress.com.jpushdemo.networkvideo.utils.ToastUtil;

/**
 * Created by mm on 2018/12/6.
 */

public class CoustomWebview extends WebView{
    public CoustomWebview(Context context) {
        super(context);
        mContext=context;
    }

    public CoustomWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }

    public CoustomWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }

    public CoustomWebview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext=context;
    }

    public CoustomWebview(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        mContext=context;
    }


    private Context mContext;
    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode actionMode = super.startActionMode(callback);
        return actionMode(actionMode);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        ActionMode actionMode = super.startActionMode(callback, type);
        return actionMode(actionMode);
    }
    private ActionMode actionMode(ActionMode actionMode) {

        if (actionMode != null) {
            final Menu menu = actionMode.getMenu();
            menu.clear();
            for (int i = 0; i <3; i++) {
                menu.add("菜单");
            }
            for (int i = 0; i < menu.size(); i++) {
                MenuItem menuItem = menu.getItem(i);

                menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(mContext,item.getTitle().toString(),Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
            }
        }
        return actionMode;
    }


}
