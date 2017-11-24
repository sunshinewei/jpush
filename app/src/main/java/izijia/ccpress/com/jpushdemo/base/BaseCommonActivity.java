package izijia.ccpress.com.jpushdemo.base;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Admin on 2017/11/23.
 */

public abstract class BaseCommonActivity extends BaseActivity {
    @Override
    public View getLayoutInfater() {
        View inflate = LayoutInflater.from(this).inflate(setRootView(), null);
        return inflate;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
