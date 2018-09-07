package com.example.myapplication.networkvideo.utils;

import android.content.Context;

import com.example.myapplication.R;


/**
 * 判断格式
 */

public class FormatUtil {
    //判断是否是视频文件
    public  static boolean isMovieSuffix(Context context, String fileName) {
        String name=fileName.toLowerCase();
        String[] suffixs = context.getResources().getStringArray(R.array.video_type_suffix);
        for (String string : suffixs) {
            if (name.endsWith(string)) {
                return true;
            }
        }
        return false;
    }

    //判断是否是图片文件
    public static   boolean isImageSuffix(Context context,String fileName) {
        String name=fileName.toLowerCase();
        String[] suffixs = context.getResources().getStringArray(R.array.image_type_suffix);
        for (String string : suffixs) {
            if (name.endsWith(string)) {
                return true;
            }
        }
        return false;
    }

}
