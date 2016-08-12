package com.tdroid.imageselector.library.imageselelctor;/**
 * Created by Administrator on 2016/3/23.
 */

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.tdroid.imageselector.library.R;
import com.tdroid.imageselector.library.imageselelctor.loader.ImageLoader;
import com.tdroid.imageselector.library.imageselelctor.photoview.PhotoView;
import com.tdroid.imageselector.library.imageselelctor.photoview.PhotoViewAttacher;

/**
 * Created by Administrator on 2016/3/23.
 * 描述:
 * 修改者:
 *
 * @author tianhongtao on 2016/3/23 12:01
 * @version 1.0 2016/3/23 12:01
 * @since 1.0
 */
public class ImageSelectorViewImageDialog extends Dialog {
    private ImageSelectorViewImageListener imageSelectorListener;
    private double flexX =0.9;// 宽度比
    private double flexY = 0.9;// 高度比
    private PhotoView imageView;
    private EditText etDiscription;
    private TextView textViewDis;
    //private LinearLayout llContent;
    private SelectorBean selectorBean;
    //private PhotoViewAttacher mAttacher;
    private boolean isViewModel=false;

    private boolean showDisc=true;

    private int viewSize=0;

    //private int contentHeight=0;
    //private int windowHeight=0;
    private int position=-1;
    public ImageSelectorViewImageDialog(boolean viewModel,Context context, ImageSelectorViewImageListener listener) {
        super(context, R.style.cp_components_dialogNoTitle);
        this.imageSelectorListener = listener;
        this.isViewModel=viewModel;
        setContentView(R.layout.cp_layout_dialog_imageselectorview_imageview);
        //setCanceledOnTouchOutside(false);

        imageView=(PhotoView)findViewById(R.id.iv_image);
        etDiscription=(EditText)findViewById(R.id.et_discription);
        textViewDis=(TextView)findViewById(R.id.tv_isviewmodel);
        findViewById(R.id.ll_notviewmodel).setVisibility(viewModel?View.GONE:View.VISIBLE);
        textViewDis.setVisibility(viewModel&&showDisc ? View.VISIBLE : View.GONE);
        etDiscription.setVisibility(showDisc?View.VISIBLE:View.GONE);
        //mAttacher = new PhotoViewAttacher(imageView);

//        mAttacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
//            @Override
//            public void onPhotoTap(View arg0, float arg1, float arg2) {
//                dismiss();
//            }
//        });
//        llContent=(LinearLayout)findViewById(R.id.ll_content);
//        llContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @SuppressWarnings("deprecation")
//            @Override
//            public void onGlobalLayout() {
//                llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                contentHeight = llContent.getWidth();
//                LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)imageView.getLayoutParams();
//                layoutParams.height=windowHeight-contentHeight;
//                imageView.setLayoutParams(layoutParams);
//            }
//        });
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
        imageView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                dismiss();
            }
        });
        findViewById(R.id.btn_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectorBean.setDisc(etDiscription.getText().toString());
                if(imageSelectorListener!=null){
                    imageSelectorListener.onCompleted(position,selectorBean);
                }
                dismiss();
            }
        });
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageSelectorListener!=null){
                    imageSelectorListener.onDelete(position,selectorBean);
                }
                dismiss();
            }
        });
    }

    public ImageSelectorViewImageDialog setPosition(int position){
        this.position=position;
        return this;
    }

    public ImageSelectorViewImageDialog setShowDesc(boolean showDisc1){
        this.showDisc=showDisc1;
        textViewDis.setVisibility(isViewModel&&showDisc ? View.VISIBLE : View.GONE);
        etDiscription.setVisibility(showDisc?View.VISIBLE:View.GONE);
        return this;
    }

    public ImageSelectorViewImageDialog setSelectorBean(SelectorBean selectorBean){
        this.selectorBean=selectorBean;
        Log.e("image-view_path",selectorBean.getPath());

        ImageLoader.getInstance(getContext()).display(selectorBean.getPath(),imageView,viewSize,viewSize);
        if(!isViewModel) {
            etDiscription.setText(selectorBean.getDisc());
        }
        else{
            textViewDis.setText(selectorBean.getDisc());
        }
        return this;
    }

    public interface ImageSelectorViewImageListener {
        void onCompleted(int position, SelectorBean selectorBean);
        void onDelete(int position, SelectorBean selectorBean);
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
        viewSize=lp.width;
        if (flexY > 0) {
            lp.height = (int) (display.getHeight() * flexY);
        }
        //windowHeight=lp.height;
        dialogWindow.setAttributes(lp);

        super.show();
    }
}
