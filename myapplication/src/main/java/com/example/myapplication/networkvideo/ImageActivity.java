package com.example.myapplication.networkvideo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.ArrayList;


public class ImageActivity extends AppCompatActivity {
    private ImageView mImageView;
    int index=0;
    private Intent intent;
    //存放图片的
    private ArrayList<String> image;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                Intent intent=new Intent(ImageActivity.this,MainActivity.class);
                intent.putStringArrayListExtra("ff",getIntent().getStringArrayListExtra("video"));
                intent.putStringArrayListExtra("gg",image);
                startActivity(intent);
                finish();
            }
        }
    };
    MyRunable myRunable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           /*设置当前Activity的背景色*/
        Resources res = getResources();
//        Drawable drawable = res.getDrawable(R.drawable.bkcolor);
//        this.getWindow().setBackgroundDrawable(drawable);
        //隐藏状态栏
        //定义全屏参数
        Window window = getWindow();
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_image);
        mImageView=findViewById(R.id.imageView);
        intent = getIntent();
        image=intent.getStringArrayListExtra("image");
        myRunable=new MyRunable();
        handler.postDelayed(myRunable, 5000);

    }

    class MyRunable implements Runnable {

        @Override
        public void run() {
            index++;
            index=index%image.size();
            Glide.with(ImageActivity.this).load(image.get(index)).into(mImageView);
            handler.postDelayed(myRunable, 5000);
            System.out.println(index+"当前的位置");
            if(index==0){
                handler.removeCallbacks(myRunable);
                handler.sendEmptyMessageDelayed(1,5000);
            }
        }

    }
}
