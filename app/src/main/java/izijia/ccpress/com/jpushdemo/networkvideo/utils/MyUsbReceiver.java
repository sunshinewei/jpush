package izijia.ccpress.com.jpushdemo.networkvideo.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import java.io.File;
import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.MainActivity;

/**
 * usb动作监听的广播
 */

public class MyUsbReceiver extends BroadcastReceiver{
    private String TAG="MyUsbReceiver";
    ArrayList<String> as = new ArrayList<String>();  //保存视频的集合
    ArrayList<String> image=new ArrayList<>();  //保存图片的文件

    @Override
    public void onReceive(final Context context, Intent intent) {
        final Context mContext = context;
        String action = intent.getAction();
        Uri uri = intent.getData();
        final String path = uri.getPath();
        final String featureFilePath=path;
        if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
            new Thread() {
                public void run() {
                    File file = new File(featureFilePath);
                    listFile(context,file);
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putStringArrayListExtra("ff", as);
                    intent.putStringArrayListExtra("gg",image);
                    mContext.startActivity(intent);
                }
            }.start();
        }else if(action.equals("android.intent.action.BOOT_COMPLETED")){
            //如果是开机完成，则需要调用另外的方法获取U盘的路径
            new Thread(){
                @Override
                public void run() {
                    File file = new File(featureFilePath);
                    listFile(context,file);
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putStringArrayListExtra("ff", as);
                    intent.putStringArrayListExtra("gg",image);
                    mContext.startActivity(intent);
                }
            }.start();
        }
    }

    private void listFile(Context context,File dir){
        //得到某个文件夹下所有的文件
        File[] files = dir.listFiles();
        //文件为空
        if (files == null) {
            return;
        }
        //遍历当前文件下的所有文件
        for (int i=0;i<files.length;i++) {
            //如果是文件夹
            if (files[i].isDirectory()) {
                //则递归(方法自己调用自己)继续遍历该文件夹
                listFile(context,files[i]);
            } else { //如果不是文件夹 则是文件
                String s= String.valueOf(files[i]);
                System.out.println(s+"我的文件");
            }
        }
    }

}
