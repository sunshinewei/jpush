package com.example.myapplication.networkvideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import com.blankj.utilcode.util.PhoneUtils;
import com.example.myapplication.R;
import com.example.myapplication.networkvideo.utils.FormatUtil;
import com.example.myapplication.networkvideo.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    public static final String TAG = "MainActivity";
    private SurfaceView mSv;
    private SurfaceHolder mHolder;
    //用于播放视频的mediaPlayer对象
    private MediaPlayer firstPlayer,     //负责播放进入视频播放界面后的第一段视频
            nextMediaPlayer, //负责一段视频播放结束后，播放下一段视频
            cachePlayer,     //负责setNextMediaPlayer的player缓存对象
            currentPlayer;   //负责当前播放视频段落的player对象
    //存放所有视频端的url
    private ArrayList<String> as;
    private List<String> videoList;
    //存放图片的
    private ArrayList<String> image;
    //所有player对象的缓存
    private HashMap<String, MediaPlayer> playersCache = new HashMap<String, MediaPlayer>();
    //当前播放到的视频段落数
    private int currentVideoIndex;
    //记录现在的播放位置
    private int mCurrentPos;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                File[] files = file.listFiles();
                if (files == null) {
                    for (int i = 0; i < fileList.size(); i++) {

                        if (fileList.get(i).isFinish() == true) {
                            Log.d("判断", "都下载完");
                        } else {
                            Log.d("判断", "未完成");
                            downLoad(fileList.get(i).getUrl(), path, fileList.get(i).getFile_name(), i);
                        }
                    }
                } else {
                    for (int i = 0; i < fileList.size(); i++) {
                        if (fileList.size() != files.length) {
                            downLoad(fileList.get(i).getUrl(), path, fileList.get(i).getFile_name(), i);
                        } else {
                            return;
                        }
                    }
                }

            } else if (msg.what == 2) {
                Log.d("判断", "aaa");


//               initSV();
                playVideo();
            }

            isExit = false;
        }
    };
    /*
    * 为了定期刷新的新开的线程
    * */
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            httpGetUrl();
            handler.postDelayed(runnable, 1000 * 60 * 60);
        }
    };
    //定义一个变量，来标志是否退出
    public static boolean isExit = false;
    private Intent intent;
    String filePath;
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/baobaotang/";
    private List<FileBean> fileList = new ArrayList<>();  //存放url和文件名的集合
    File file = new File(path);

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
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_video);
        videoView = findViewById(R.id.surfaceView);
//        Log.i("获取IMEI", PhoneUtils.getIMEI() + "获取到的IMEI");
        Log.i("获取序列号", android.os.Build.SERIAL + "获取序列号");
        videoList = new ArrayList<>();
        httpGetUrl();
//        initData();
        if (savedInstanceState != null) {
            mCurrentPos = savedInstanceState.getInt("currentPos", -1);
        }
        //开始播放
//        initSV();

        playVideo();
    }

    private VideoView videoView;
    private int count;

    private void playVideo() {

        listFile(MainActivity.this, file);

        if (videoList == null || videoList.size() == 0) {
            return;
        } else {
            Log.i("数据源", videoList.get(count));
            String s = videoList.get(count);
            videoView.setVideoURI(Uri.parse(s));  //播放视频时,默认选择从第一个开始播放
            videoView.start();
            //监听视频的播放,视频播放结束后调用该方法
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    count++;  //视频资源变成下一个
                    if (count >= videoList.size()) {
                        //表示已经全部播放完毕,让count变成0即可
                        count = 0;
                    }
                    playVideo();
                }
            });
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentPos", mCurrentPos);
        super.onSaveInstanceState(outState);
    }

    private void initData() {
        intent = getIntent();
        as = intent.getStringArrayListExtra("ff");
        image = intent.getStringArrayListExtra("gg");
        if (as != null) {
            videoList = new ArrayList<>();
            videoList.addAll(as);//把U盘上的视频的集合放到另一个集合中，不收到U盘的动作影响
        }
        listFile(this, file);
    }


    /*
    * 初始化播放器
    * */

    private void initSV() {
        mHolder = mSv.getHolder();
        // 兼容2.3及以下版本，否则只有声音没有画面
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //然后初始化播放首段视频的player对象
        initFirstPlayer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    /*
 * 初始化播放首段视频的player
 */
    private void initFirstPlayer() {
        firstPlayer = new MediaPlayer();
        firstPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        firstPlayer.setDisplay(mHolder);
        firstPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                onVideoPlayCompleted(mp);
            }
        });

        //设置cachePlayer为该player对象
        cachePlayer = firstPlayer;
        initNexttPlayer();
        //player对象初始化完成后，开启播放
        startPlayFirstVideo();
    }

    private void startPlayFirstVideo() {


        if (videoList != null && videoList.size() != 0) {

            videoList.clear();
            listFile(this, file);

            Log.e("videoList", "为空" + videoList.size());

            try {
                firstPlayer.setDataSource(videoList.get(currentVideoIndex));
                if (firstPlayer.isPlaying()) {

                } else {
                    firstPlayer.prepare();
                    firstPlayer.start();
                }

            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        } else {

            Log.e("videoList", "不为空");
        }


    }

    /*
    * 新开线程负责初始化负责播放剩余视频分段的player对象,避免UI线程做过多耗时操作
    */
    private void initNexttPlayer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (videoList != null) {
                    for (int i = 1; i < videoList.size(); i++) {


                        Log.e("视频个数", videoList.size() + "");
                        nextMediaPlayer = new MediaPlayer();
                        nextMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        nextMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                onVideoPlayCompleted(mp);
                            }
                        });

                        try {
                            nextMediaPlayer.setDataSource(videoList.get(i));
                            nextMediaPlayer.prepare();
                        } catch (IOException e) {
                            // TODO 自动生成的 catch 块
                            e.printStackTrace();
                        }

                        //set next mediaplayer
                        cachePlayer.setNextMediaPlayer(nextMediaPlayer);
                        //set new cachePlayer
                        cachePlayer = nextMediaPlayer;
                        //put nextMediaPlayer in cache
                        playersCache.put(String.valueOf(i), nextMediaPlayer);

                    }
                }
            }
        }).start();
    }

    /*
 * 负责处理一段视频播放过后，切换player播放下一段视频
 */
    private void onVideoPlayCompleted(MediaPlayer mp) {
        mp.setDisplay(null);
        //get next player
        ++currentVideoIndex;
        currentPlayer = playersCache.get(String.valueOf(currentVideoIndex));
        if (currentPlayer != null) {
            currentPlayer.setDisplay(mHolder);
        } else {
            //Toast.makeText(MainActivity.this, "视频播放完毕..", Toast.LENGTH_SHORT).show();
//            currentVideoIndex=0;
//            initFirstPlayer();
            if (image == null || image.size() == 0) {
                currentVideoIndex = 0;
                initFirstPlayer();
//                initNexttPlayer();
            } else {
                ToastUtil toastUtil3 = new ToastUtil(MainActivity.this, R.layout.toast_show, "5秒后跳转到图片");
                toastUtil3.show(5000);
                //如果有图片就跳转到下一页，展示图片，然后数据传递过去
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putStringArrayListExtra("image", image);
                intent.putStringArrayListExtra("video", (ArrayList<String>) videoList);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (firstPlayer != null) {
            if (firstPlayer.isPlaying()) {
                firstPlayer.stop();
            }
            firstPlayer.release();
        }
        if (nextMediaPlayer != null) {
            if (nextMediaPlayer.isPlaying()) {
                nextMediaPlayer.stop();
            }
            nextMediaPlayer.release();
        }

        if (currentPlayer != null) {
            if (currentPlayer.isPlaying()) {
                currentPlayer.stop();
            }
            currentPlayer.release();
        }
        currentPlayer = null;
    }

    /*
   * 监听返回键
   * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            handler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    private void httpGetUrl() {
//        if (!NetworkUtils.isConnected()) {
//            Toast.makeText(MainActivity.this, "你的网络连接不给力,请连接后重试", Toast.LENGTH_SHORT).show();
//            return;
//        }
        HttpParams httpParams = new HttpParams();
        httpParams.put("device", android.os.Build.SERIAL);
        OkGo.post("http://dev.m.baobaot.com/api/3/video_list").tag(this).params(httpParams).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                handler.postDelayed(runnable, 1000 * 60 * 60);
                Log.i("TAG", s.toString());
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    if (jsonObject.getString("code").equals("0")) {
                        JSONObject object = jsonObject.getJSONObject("response");
                        JSONArray array = object.getJSONArray("player_list");
                        List<FileBean> fileBeanList = new ArrayList<>();
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject playObject = array.getJSONObject(i);
                            String url = playObject.getString("url");
                            String fileName = playObject.getString("file_name");
                            JSONObject cover_attachment = playObject.getJSONObject("cover_attachment");
                            String size = cover_attachment.getString("size");
                            FileBean fileBean = new FileBean(url, fileName, false, size);
                            fileBeanList.add(fileBean);
                            Log.d("获取到的url", url);
                        }
                        fileList.addAll(fileBeanList);
                        handler.sendEmptyMessageDelayed(1, 1000);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }
        });
    }

    /*
    * 文件下载
    * @param url 下载地址
    * @param destFileDir 保存文件路径
    * @param destFileName 保存文件名
    * */

    private int downLoadOk = 0;
    private void downLoad(String url, String destFileDir, String destFileName, final int position) {
        OkGo.get(url).tag(this).execute(new FileCallback(destFileDir, destFileName) {
            @Override
            public void onSuccess(File files, Call call, Response response) {
                // file 即为文件数据，文件保存在指定目录
                filePath = files.getAbsolutePath();
                fileList.get(position).setFinish(true);
                downLoadOk++;
                if (downLoadOk == fileList.size()) {
                    Log.d("downLoadOk的数", downLoadOk+"");
                    handler.sendEmptyMessage(2);
                }

            }

            @Override
            public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
            }
        });
    }

    /*
    * 获取文件夹下的所有文件
    * */
    private void listFile(Context context, File dir) {
        //得到某个文件夹下所有的文件
        File[] files = dir.listFiles();
        //文件为空
        if (files == null) {
            return;
        }
        //遍历当前文件下的所有文件
        for (int i = 0; i < files.length; i++) {
            //如果是文件夹
            if (files[i].isDirectory()) {
                //则递归(方法自己调用自己)继续遍历该文件夹
                listFile(context, files[i]);
            } else { //如果不是文件夹 则是文件
                String s = String.valueOf(files[i]);
                if (FormatUtil.isMovieSuffix(context, s)) {
//                    videoList=new ArrayList<>();
                    videoList.add(s);
                }
                if (videoList != null) {
                    System.out.println("我的文件" + videoList.size());
                }
                if (FormatUtil.isImageSuffix(context, s)) {

                }
            }
        }
    }


}
