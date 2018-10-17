package com.example.myapplication.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.myapplication.R;

/**
 * Created by mm on 2018/10/16.
 */

public class PicUtils {

    public static Drawable initPic(Context mCtx,int num) {
        switch (num) {
            case 36:
                return mCtx.getResources().getDrawable(R.mipmap.mt92);

            case 35:
                return mCtx.getResources().getDrawable(R.mipmap.mt98);

            case 34:
                return mCtx.getResources().getDrawable(R.mipmap.mt08);

            case 33:
                return mCtx.getResources().getDrawable(R.mipmap.bjjzl);

            case 32:
                return mCtx.getResources().getDrawable(R.mipmap.bjjzh);

            case 31:
                return mCtx.getResources().getDrawable(R.mipmap.bjjzj);

            case 30:
                return mCtx.getResources().getDrawable(R.mipmap.bjjx);

            case 29:
                return mCtx.getResources().getDrawable(R.mipmap.xj);
        }
        return null;
    }
}
