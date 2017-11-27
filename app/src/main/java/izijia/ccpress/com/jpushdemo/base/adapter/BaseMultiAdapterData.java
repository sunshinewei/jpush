package izijia.ccpress.com.jpushdemo.base.adapter;

/**
 * Created by Admin on 2017/11/24.
 */

public class BaseMultiAdapterData {
    private int viewType;

    public BaseMultiAdapterData setViewType(int viewType) {
        this.viewType = viewType;
        return this;
    }

    public int getViewType() {
        return viewType;
    }
}
