package izijia.ccpress.com.jpushdemo.test;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.R;

public class Test4Activity extends AppCompatActivity {
    private TextView tvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        tvShare = (TextView) findViewById(R.id.tv_share);
        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2);
                finish();
            }
        });

    }
}
