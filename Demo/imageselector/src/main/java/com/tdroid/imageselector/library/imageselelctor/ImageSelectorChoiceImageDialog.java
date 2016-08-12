package com.tdroid.imageselector.library.imageselelctor;/**
 * Created by Administrator on 2016/3/23.
 */

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.tdroid.imageselector.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/23.
 * 描述:
 * 修改者:
 *
 * @author tianhongtao on 2016/3/23 12:35
 * @version 1.0 2016/3/23 12:35
 * @since 1.0
 */
public class ImageSelectorChoiceImageDialog extends Dialog {
    private ImageSelectorChoiceImageListener imageSelectorListener;
    private double flexX = 1.0;// 宽度比
    private double flexY = 1.0;// 高度比
    List<SelectorBean> selectorBeanList = new ArrayList<SelectorBean>();
    private ImageChoiceAdapter imageChoiceAdapter;
    private GridView gridView;
    private Button btnDone;

    private int currUsefullCount = 0;

    public ImageSelectorChoiceImageDialog(final Context context, ImageSelectorChoiceImageListener listener) {
        super(context, R.style.cp_components_dialogNoTitle);
        this.imageSelectorListener = listener;
        setContentView(R.layout.cp_layout_dialog_imageselectorview_choiceimage);

        gridView = (GridView) findViewById(R.id.photo_gridview);
        btnDone = (Button) findViewById(R.id.btn_done);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();//屏幕宽度
        //WaterFallImageLoader imageManager = new WaterFallImageLoader(context);
        //imageManager.setIsUseMediaStoreThumbnails(true);
        //imageManager.setRequiredSize(width / 3);

        imageChoiceAdapter = new ImageChoiceAdapter(context, selectorBeanList, new ImageChoiceAdapter.ImageChoiceAdapterListener() {
            @Override
            public void onChoice(View convertView,int postion, boolean checked, SelectorBean selectorBean) {
                int count = getSelectedList().size();
                if (count >= currUsefullCount && checked) {
                    checked = false;
                    Toast.makeText(context, "只能选择" + String.valueOf(currUsefullCount) + "张图片", Toast.LENGTH_SHORT).show();
                }
                selectorBeanList.get(postion).setIsChecked(checked);
                btnDone.setText("确定(" + String.valueOf(getSelectedList().size()) + "/" + String.valueOf(currUsefullCount) + ")");
               // imageChoiceAdapter.notifyDataSetChanged();
                imageChoiceAdapter.toggleImageSelect(convertView,postion,checked);
            }
        });
        //setCanceledOnTouchOutside(false);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getSelectedList().size()>0) {
                    if (imageSelectorListener != null) {
                        imageSelectorListener.onCompleted(getSelectedList());
                    }
                    dismiss();
                }
                else{
                    Toast.makeText(context, "请选择图片", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gridView.setAdapter(imageChoiceAdapter);
        queryMediaImages(context);
    }

    private List<SelectorBean> getSelectedList() {
        List<SelectorBean> list = new ArrayList<SelectorBean>();
        for (SelectorBean selectorBean : selectorBeanList) {
            if (selectorBean.isChecked()) {
                list.add(selectorBean);
            }
        }
        return list;
    }


    public ImageSelectorChoiceImageDialog setUsefullSize(int size) {
        this.currUsefullCount = size;
        btnDone.setText("确定(0/" + String.valueOf(size) + ")");
        return this;
    }

    private void queryMediaImages(Context context) {
        selectorBeanList.clear();
        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = context
                .getContentResolver();

        // 只查询jpeg和png的图片
//        Cursor mCursor = mContentResolver.query(mImageUri, null,
//                MediaStore.Images.Media.MIME_TYPE + "=? or "
//                        + MediaStore.Images.Media.MIME_TYPE + "=?",
//                new String[]{"image/jpeg", "image/png"},//"image/jpeg", "image/png"
//                MediaStore.Images.Media.DATE_MODIFIED);
        //查询所有图片
        Cursor mCursor = mContentResolver.query(mImageUri,
                new String[]{MediaStore.Images.Media.DATA,MediaStore.Images.Media.DISPLAY_NAME},
                null,
                null,
                MediaStore.Images.Media.DATE_MODIFIED);
        while (mCursor.moveToNext()) {
            // 获取图片的路径
            String path = mCursor.getString(mCursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));
            String name = mCursor.getString(mCursor
                    .getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
            SelectorBean selectorBean = new SelectorBean();
            selectorBean.setIsAddTag(false);
            selectorBean.setIsChecked(false);
            selectorBean.setPath(path);
            selectorBean.setName(name);
            selectorBeanList.add(selectorBean);
        }
        mCursor.close();

        imageChoiceAdapter.notifyDataSetChanged();
    }


    public interface ImageSelectorChoiceImageListener {
        void onCompleted(List<SelectorBean> list);
    }

    @Override
    public void show() {
        Window dialogWindow = this.getWindow();
        dialogWindow.setWindowAnimations(R.style.cp_dialogWindowAnim);
        WindowManager windowManager = dialogWindow.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL
                | Gravity.CENTER_VERTICAL);
        lp.width = (int) (display.getWidth() * flexX);
        if (flexY > 0) {
            lp.height = (int) (display.getHeight() * flexY);
        }
        dialogWindow.setAttributes(lp);
        super.show();
    }
}
