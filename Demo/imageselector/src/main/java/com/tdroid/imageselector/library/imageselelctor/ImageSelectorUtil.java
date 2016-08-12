package com.tdroid.imageselector.library.imageselelctor;

import android.content.Context;
import android.util.Log;


import com.tdroid.imageselector.library.imageselelctor.loader.OtherUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/1/7.
 */

/**
 * Created by Administrator on  2016/1/7.
 * 自定义文件辅助类
 * @author tianhongtao
 * @version  1.0 2016/1/7.
 * @since  1.0
 */
public class ImageSelectorUtil {
    public static final String IMAGE_JPG=".jpg";
    public static final String IMAGE_PNG=".png";
    public static String VOICE_AMR=".amr"; //声音扩展名
    public static final int MEDIA_TYPE_IMAGE=1;
    public static final int IMAGE_IS_THUMB=1;
    public static final int IMAGE_NOT_THUMB=0;

    public static String getImageCameraPath(Context context) {
        //字符串最后加上目录分隔符
        return OtherUtils.getDiskCacheDir(context.getApplicationContext(), "images").getAbsolutePath();
    }
    /**
     * 调用系统相机数据保存
     * */
    public static File getOutputMediaFile(Context context,int type)
    {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = null;
        try
        {
            // This location works best if you want the created images to be
            // shared
            // between applications and persist after your app has been
            // uninstalled.
            mediaStorageDir = new File(getImageCameraPath(context));

            Log.d("FileHelper", "Successfully created mediaStorageDir: "
                    + mediaStorageDir);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d("FileHelper", "Error in Creating mediaStorageDir: "
                    + mediaStorageDir);
        }

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists())
        {
            if (!mediaStorageDir.mkdirs())
            {
                // 在SD卡上创建文件夹需要权限：
                // <uses-permission
                // android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
                Log.d("FileHelper",
                        "failed to create directory, check if you have the WRITE_EXTERNAL_STORAGE permission");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE)
        {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + IMAGE_JPG);
        }

        else
        {
            return null;
        }

        return mediaFile;
    }
}
