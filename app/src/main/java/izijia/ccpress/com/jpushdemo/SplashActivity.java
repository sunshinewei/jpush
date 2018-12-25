package izijia.ccpress.com.jpushdemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import izijia.ccpress.com.jpushdemo.utils.NetWorkUtils;
import izijia.ccpress.com.jpushdemo.view.CustomVideoView;

public class SplashActivity extends AppCompatActivity implements View.OnTouchListener {

    private CustomVideoView mVideoView;
    private TextView mTvGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mVideoView = (CustomVideoView) findViewById(R.id.video);
        mTvGo = (TextView) findViewById(R.id.tv_go);
//        initView();

        mVideoView.setOnTouchListener(this);
//        startActivity(new Intent(SplashActivity.this, MainActivity.class));
//        finish();

        mTvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        //网络地址：http://wzl.dmxwl.com/public/static/admin/img/video.mp4
        if (NetWorkUtils.getNetworkState(this)==NetWorkUtils.NETWORN_WIFI){

        }


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int startX = 0;
        int startY = 0;
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                startY = (int) event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                System.out.println("点击事件" + Math.abs(event.getX() - startX) + "         " + Math.abs(event.getY() - startY));

                break;


        }

        return true;
    }

//    private void initView() {
//        //设置播放加载路径
//        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
//        //播放
//        mVideoView.start();
//        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                finish();
//            }
//        });


//
//        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//            @Override
//            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
//
//                return false;
//            }
//        });
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//       if (mVideoView!=null){
//           mVideoView.pause();
//       }
//    }
}
