package com.example.myapplication.networkvideo.utils;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;

/**
 * 关于文件的util
 */

public class FileUtil {
    /*
   * 获取文件大小
   * */
    public static long getFileSize(File file) throws Exception {
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        } else {
            file.createNewFile();
            Log.e("获取文件大小", "文件不存在!");
        }
        return size;
    }

    /*
    * 获取文件夹大小
    * */
    public static long getFileSizes(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSizes(flist[i]);
            } else {
                size = size + getFileSize(flist[i]);
            }
        }
        Log.d("文件大小",size+"");
        return size;
    }

    /*
  * 根据文件路径获取文件名，如果加上.把扩展名也会截取掉
  * */
    public static String getFileName(String pathandname){
        int start=pathandname.lastIndexOf("/");
        // int end=pathandname.lastIndexOf(".");
        if(start!=-1){
            return pathandname.substring(start+1);
        }else{
            return null;
        }
    }
}
