package izijia.ccpress.com.mylibrary.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import izijia.ccpress.com.mylibrary.utils.OSUtils;

/**
 * Created by Admin on 2017/12/26.
 * <p>
 * 图片缓存
 */

public class UCacheHelper {

    private CacheHelper mCacheHelper;
    private DiskLruCache mDiskLruCache;

    public UCacheHelper(Context mCtx) {
        mCacheHelper = new CacheHelper();
        try {
            File cacheDir = CacheHelper.getDiskCacheDir(mCtx, "bitmap");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            mDiskLruCache = DiskLruCache.open(cacheDir, OSUtils.getAppVersion(mCtx), 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加图片缓存
     *
     * @param imageUrl
     */
    public void addImageCache(final String imageUrl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String key = mCacheHelper.hashKeyForDisk(imageUrl);
                    DiskLruCache.Editor editor = mDiskLruCache.edit(key);
                    if (editor != null) {
                        OutputStream outputStream = editor.newOutputStream(0);
                        if (mCacheHelper.downloadUrlToStream(imageUrl, outputStream)) {
                            editor.commit();
                        } else {
                            editor.abort();
                        }
                    }
                    mDiskLruCache.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 读取图片的缓存
     *
     * @param imageUrl
     * @return
     */
    public Bitmap readImageCache(String imageUrl) {
        try {
//            String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
            String key = mCacheHelper.hashKeyForDisk(imageUrl);
            DiskLruCache.Snapshot snapShot = mDiskLruCache.get(key);
            if (snapShot != null) {
                InputStream is = snapShot.getInputStream(0);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
