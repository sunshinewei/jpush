package izijia.ccpress.com.mylibrary.base;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Admin on 2017/11/23.
 */

public abstract class BaseCommonActivity extends BaseActivity {
    @Override
    public View getLayoutInfater() {
        View inflate = LayoutInflater.from(this).inflate(setRootView(), null);

        //添加注入初始化控件，如ButterKnife

        return inflate;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
