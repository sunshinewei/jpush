package izijia.ccpress.com.mylibrary.base;

/**
 * Created by Admin on 2017/11/22.
 */

public interface IBaseView {

    void loadingView();

    void failLoad();

    void LoadingDialog();

    void LoadingFailDialog(String msg);
}
