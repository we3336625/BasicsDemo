package com.tdroid.imageselector.library.imageselelctor;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.tdroid.imageselector.library.R;

import java.io.File;



/**
 * Created by Administrator on 2016/1/21.
 */

/**
 * Created by Administrator on  2016/1/21.
 * 图像选择对话框
 * @author tianhongtao
 * @version  1.0 2016/1/21.
 * @since  1.0
 */
public class ImageSelectorImageFromDialog extends Dialog {
    //相机权限
    public static final String CAMERA = Manifest.permission.CAMERA;
    public static final int CAMERA_REQUESTCODE = 0x00004;
    //STORAGE
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final int READ_EXTERNAL_STORAGE_REQUESTCODE = 0x002562;
    private ImageSelectorImageFromListener imageSelectorListener;
    private double flexX = 1.0;// 宽度比
    private double flexY = 0.25;// 高度比
    public static final int ALBUM_INTENT_REQUEST = 0XFF01;
    public static final int CAMERA_INTENT_REQUEST = 0XFF02;

    public static final int TYPE_SYSPHOTO=0XFF03;
    public static final int TYPE_CAMERA=0XFF04;

    public ImageSelectorImageFromDialog(final Context context, ImageSelectorImageFromListener imageSelectorListener1) {
        super(context, R.style.cp_components_ios_dialogNoTitle);
        this.imageSelectorListener = imageSelectorListener1;
        setContentView(R.layout.cp_layout_dialog_imageselectorview_imagefrom);
        //setCanceledOnTouchOutside(false);
        findViewById(R.id.dialog_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasPermisson(getContext().getApplicationContext(), CAMERA)) {
                    cameraPhoto();
                }
                else{
                    Toast.makeText(getContext(),"你不能使用相机功能，请同意授权",Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        ((Activity)context).
                                requestPermissions(new String[]{CAMERA},
                                        CAMERA_REQUESTCODE);
                    }
                }
                dismiss();
            }
        });
//        findViewById(R.id.dialog_frommobile).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(hasPermisson(context.getApplicationContext(),READ_EXTERNAL_STORAGE)) {
//                    systemPhoto();
//                }
//                else{
//                    Toast.makeText(getContext(),"你不能使用选择图片功能，请同意读取外部存储授权",Toast.LENGTH_SHORT).show();
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        ((Activity)getContext()).
//                                requestPermissions(new String[]{READ_EXTERNAL_STORAGE},
//                                        READ_EXTERNAL_STORAGE_REQUESTCODE);
//                    }
//                }
//                dismiss();
//            }
//        });
        findViewById(R.id.dialog_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageSelectorListener != null) {
                    imageSelectorListener.onCustom();
                }
                dismiss();
            }
        });
        findViewById(R.id.dialog_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public interface ImageSelectorImageFromListener {
        void onChoice(int type, Intent intent, int intentTag, Uri uri);
        void onCustom();
    }

    /**
     * 检查是否拥有授权
     * **/
    public static boolean hasPermisson(Context context,String permissionName){
        int hasPermission = ActivityCompat.checkSelfPermission(context, permissionName);
        return hasPermission == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 从手机选择
     */
//    private void systemPhoto() {
//        try {
//            Intent intent = new Intent();
//            intent.setType("image/*");
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            if (imageSelectorListener != null) {
//                imageSelectorListener.onChoice(TYPE_SYSPHOTO,intent, ALBUM_INTENT_REQUEST,null);
//            }
//        }catch (Exception e){ //ActivityNotFoundException
//            Toast.makeText(this.getContext(), "初始化失败！", Toast.LENGTH_SHORT).show();
//        }
//    }

    /**
     * 调用相机拍照
     */
    private void cameraPhoto() {
        String sdStatus = Environment.getExternalStorageState();
        /* 检测sd是否可用 */
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this.getContext(), "SD卡不可用", Toast.LENGTH_SHORT).show();
            return;
        }

        Uri fileUri;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // create a file to save the image
        File imageFile = ImageSelectorUtil.getOutputMediaFile(getContext(),ImageSelectorUtil.MEDIA_TYPE_IMAGE);
        if (imageFile != null) {
            fileUri = Uri.fromFile(imageFile);

            // 此处这句intent的值设置关系到后面的onActivityResult中会进入那个分支，即关系到data是否为null，如果此处指定，则后来的data为null
            // set the image file name
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

            if(imageSelectorListener!=null){
                imageSelectorListener.onChoice(TYPE_CAMERA,intent, CAMERA_INTENT_REQUEST, fileUri);
            }
        }

    }

    @Override
    public void show() {
        Window dialogWindow = this.getWindow();
        dialogWindow.setWindowAnimations(R.style.cp_dialogWindowAnim);
        WindowManager windowManager = dialogWindow.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL
                | Gravity.BOTTOM);
        lp.width = (int) (display.getWidth() * flexX);
        if (flexY > 0) {
            lp.height = (int) (display.getHeight() * flexY);
        }
        dialogWindow.setAttributes(lp);
        super.show();
    }
}
