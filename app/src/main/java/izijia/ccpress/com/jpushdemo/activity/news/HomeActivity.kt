package izijia.ccpress.com.jpushdemo.activity.news

import android.widget.TextView
import izijia.ccpress.com.jpushdemo.R
import izijia.ccpress.com.jpushdemo.bean.news.HomeTabBean
import izijia.ccpress.com.jpushdemo.presenter.news.HomePresenter
import izijia.ccpress.com.mylibrary.base.BaseLoadActivity

/**
 * Created by Admin on 2017/12/19.
 */
class HomeActivity : BaseLoadActivity(), HomePresenter.IHomeView {

    override fun setSuccessView(datas: HomeTabBean?) {
        statusViewChange(LOADING_SUCCESS)
        findViewById<TextView>(R.id.tv_text)
                .setText(datas.toString())
    }

    override fun setRetryListener() {
        HomePresenter(this)
                .setTitleTab()
    }

    override fun setRootView(): Int {
        return R.layout.activity_home
    }

    override fun initData() {
        HomePresenter(this)
                .setTitleTab()
    }

}