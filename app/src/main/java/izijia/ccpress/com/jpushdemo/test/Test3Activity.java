package izijia.ccpress.com.jpushdemo.test;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;

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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(new Intent(Test3Activity.this, Test4Activity.class),
                            ActivityOptionsCompat.makeSceneTransitionAnimation(Test3Activity.this,
                                    //                                Pair.create((View)linearLayout,"shareAnim"),
                                    Pair.create((View) tvShare, "share")).toBundle());
                }
            }
        });
    }

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
