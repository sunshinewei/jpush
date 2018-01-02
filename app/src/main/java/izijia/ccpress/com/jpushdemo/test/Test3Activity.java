package izijia.ccpress.com.jpushdemo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.mylibrary.helper.OnResultHelper;
import izijia.ccpress.com.mylibrary.toast.ToastUtil;

/**
 * @author Admin
 */
public class Test3Activity extends AppCompatActivity {

    private TextView tvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        tvShare = (TextView) findViewById(R.id.tv_share);

        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pair存在V4包中
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    startActivity(new Intent(Test3Activity.this, Test4Activity.class),
//                            ActivityOptionsCompat.makeSceneTransitionAnimation(Test3Activity.this,
//                                    //                                Pair.create((View)linearLayout,"shareAnim"),
//                                    Pair.create((View) tvShare, "share")).toBundle());
//                }

                Intent intent = new Intent(Test3Activity.this, Test4Activity.class);
                startActivityForResult(intent, 1);
                onResultHelper = new OnResultHelper();
            }
        });
    }

    OnResultHelper onResultHelper;

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onResultHelper.setResultCallBack(new OnResultHelper.OnResultCallBack() {
            @Override
            public void callBack(int resultCode, Intent intent) {
                ToastUtil.toast(Test3Activity.this, "哈哈哈哈哈哈");
            }
        }).setinitData(1, 2, data);
    }
}
