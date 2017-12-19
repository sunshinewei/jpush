package izijia.ccpress.com.jpushdemo.test;
import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import izijia.ccpress.com.jpushdemo.bean.TestDemoBean;
import izijia.ccpress.com.jpushdemo.data.Test2Presenter;
import izijia.ccpress.com.jpushdemo.data.TestDemoView;


/**
 * Created by Admin on 2017/12/19.
 */
@RunWith(AndroidJUnit4.class)
public class Test2ActivityTest extends ActivityInstrumentationTestCase2<Test2Activity> implements TestDemoView {

    private Test2Activity mTest2Activity;


    public Test2ActivityTest() {
        super(Test2Activity.class);
    }

    @Before
    public void setUp() throws Exception {//避免手动触摸的情况，关闭TouchMode
        super.setUp();
        setActivityInitialTouchMode(false);
        Instrumentation instrumentation = getInstrumentation();
        if (mTest2Activity!=null){
            Log.e("mTest2Activity","不为空！");
        }else {
            Log.e("mTest2Activity","为空！");
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setRootView() throws Exception {
    }

    @Test
    public void initView() throws Exception {
    }

    private Test2Presenter mTestPresenter;
    @Test
    public void initData1() throws Exception {
        mTestPresenter = new Test2Presenter(this);
        mTestPresenter.getData();
    }

    @Test
    public void successView() throws Exception {
    }

    @Override
    public void loadingView() {

    }

    @Override
    public void failLoad() {

    }

    @Override
    public void LoadingDialog() {

    }

    @Override
    public void LoadingFailDialog(String msg) {

    }

    @Override
    public void loadfinishView() {

    }

    @Override
    public void successView(TestDemoBean bean) {
        Log.e("mTest2Activity","为空！");
    }
}