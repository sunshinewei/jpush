package izijia.ccpress.com.jpushdemo.test;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;

/**
 * Created by mm on 2018/5/14.
 */

public class BehaviorActivity extends BaseCommonActivity {
    @Override
    public int setRootView() {
        return R.layout.activity_behavior;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        super.initView();


        Notification.Builder builder = new Notification.Builder(mContext);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText("aaa");
        builder.setContentTitle("aaaaaa");
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(100, builder.build());

        Lifecycle lifecycle = getLifecycle();
        Log.e("actvity的生命周期",lifecycle.getCurrentState()+"");
    }

    private ShareActionProvider mShareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.share_menu, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) item.getActionProvider();

        // Return true to display menu
        return true;
    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }
}
