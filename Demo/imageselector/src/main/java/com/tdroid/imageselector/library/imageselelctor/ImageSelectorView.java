package com.tdroid.imageselector.library.imageselelctor;
/**
 * Created by Administrator on 2016/3/23.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.tdroid.imageselector.library.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/3/23.
 * 描述:
 * 修改者:
 *
 * @author tianhongtao on 2016/3/23 09:15
 * @version 1.0 2016/3/23 09:15
 * @since 1.0
 */
public class ImageSelectorView extends LinearLayout {
    private LinearLayout llDiscription;
    private Button btnAdd;
    private NeverScrollGridView gridViewList;
    private TextView tvCaption;
    private TextView tvDiscription;
    private TextView tvTips;

    private CharSequence mStrCaption;
    private CharSequence mStrDiscription;
    private int mSelectMaxSize = 5;
    private boolean viewModel=false;

    private int defaultImageSize = 200;

    private ImageSelectorAdapter imageSelectorAdapter;

    private boolean showDisc=true;

    private ImageSelectorViewListener imageSelectorViewListener;

    public void setImageSelectorViewListener(ImageSelectorViewListener imageSelectorViewListener) {
        this.imageSelectorViewListener = imageSelectorViewListener;
    }

    public void setShowDisc(boolean showDisc){
        this.showDisc=showDisc;
    }


    private Context activityContext;
    private List<SelectorBean> imageList = new ArrayList<SelectorBean>();

    public ImageSelectorView(Context context) {
        this(context, null);
    }

    public ImageSelectorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageSelectorView(final Context contexts, AttributeSet attrs, int defStyleAttr) {
        super(contexts, attrs, defStyleAttr);
        //this.context = context;
        TypedArray a = contexts.obtainStyledAttributes(attrs, R.styleable.ImageSelectorView);
        LayoutInflater.from(contexts).inflate(R.layout.cp_layout_imageselectorview, this);
        llDiscription = (LinearLayout) findViewById(R.id.ll_selectorview_discriptioin);
        btnAdd = (Button) findViewById(R.id.btn_selectorview_add);
        gridViewList = (NeverScrollGridView) findViewById(R.id.gridview_selectorview_imagelist);
        tvCaption = (TextView) findViewById(R.id.tv_selectorview_caption);
        tvDiscription = (TextView) findViewById(R.id.tv_selectorview_discription);
        mStrCaption = a.getText(R.styleable.ImageSelectorView_selectorview_caption);
        mStrDiscription = a.getText(R.styleable.ImageSelectorView_selectorview_discription);
        mSelectMaxSize = a.getInteger(R.styleable.ImageSelectorView_selectorview_maxselectsize, mSelectMaxSize);
        viewModel=a.getBoolean(R.styleable.ImageSelectorView_selectorview_viewmodel, viewModel);


        tvTips = (TextView) findViewById(R.id.tv_selectorview_selecttips);
        tvCaption.setVisibility((TextUtils.isEmpty(mStrCaption) || mStrCaption == null) ? View.GONE : View.VISIBLE);
        tvDiscription.setVisibility((TextUtils.isEmpty(mStrDiscription) || mStrDiscription == null) ? View.GONE : View.VISIBLE);

        if(!viewModel) {
            tvTips.setText("最多选择" + String.valueOf(mSelectMaxSize) + "张图片");
        }
        else{
            tvTips.setText(mStrDiscription);
        }
        btnAdd.setVisibility(!viewModel?View.VISIBLE:View.GONE);
        llDiscription.setVisibility(!viewModel?View.VISIBLE:View.GONE);
        gridViewList.setVisibility(!viewModel?View.GONE:View.VISIBLE);

        tvCaption.setText(mStrCaption);
        tvDiscription.setText(mStrDiscription);
        btnAdd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                btnAdd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                defaultImageSize = btnAdd.getWidth();
            }
        });
        a.recycle();
    }

    public void setSelectorTips(String tips){
        tvTips.setText(tips);
    }


    private void invalidateView() {
        if(!viewModel) {
            //resetImageList
            List<SelectorBean> newImageList = new ArrayList<SelectorBean>();
            for (int i = 0; i < imageList.size(); i++) {
                if (imageList.get(i) != null && !imageList.get(i).isAddTag()) {
                    newImageList.add(imageList.get(i));
                }
            }
            imageList.clear();
            imageList.addAll(newImageList);


            if (imageList.size() <= 0) {
                showTips();
            } else if (imageList.size() == 1) {
                if (imageList.get(0).isAddTag()) {
                    imageList.clear();
                    imageSelectorAdapter.notifyDataSetChanged();
                    showTips();
                } else {
                    hideTips();
                    if (imageList.size() < mSelectMaxSize) {
                        SelectorBean selectorBean =new SelectorBean();
                        selectorBean.setIsAddTag(true);
                        imageList.add(selectorBean);
                    }
                    imageSelectorAdapter.notifyDataSetChanged();
                }
            } else {
                hideTips();
                if (imageList.size() < mSelectMaxSize) {
                    SelectorBean selectorBean = new SelectorBean();
                    selectorBean.setIsAddTag(true);
                    imageList.add(selectorBean);
                }
                imageSelectorAdapter.notifyDataSetChanged();
            }
        }
    }

    private void showTips() {
        btnAdd.setVisibility(View.VISIBLE);
        gridViewList.setVisibility(View.GONE);
        llDiscription.setVisibility(View.VISIBLE);
        tvTips.setText("最多选择" + String.valueOf(mSelectMaxSize) + "张图片");
    }

    private void hideTips() {
        btnAdd.setVisibility(View.GONE);
        gridViewList.setVisibility(View.VISIBLE);
        llDiscription.setVisibility(View.GONE);

        tvTips.setText("最多选择" + String.valueOf(mSelectMaxSize) + "张图片" + (TextUtils.isEmpty(mStrDiscription) ? "" : "(" + mStrDiscription + ")"));
    }


    public ImageSelectorView initSelector(Context activity) {
        this.activityContext = activity;
        WindowManager wm = (WindowManager) activityContext.getSystemService(Context.WINDOW_SERVICE);
        int numColumns = (int) wm.getDefaultDisplay().getWidth() / defaultImageSize;
        gridViewList.setNumColumns(numColumns);
        //int width = wm.getDefaultDisplay().getWidth();//屏幕宽度
        //imageManager = new WaterFallImageLoader(activityContext);
        //imageManager.setDefaultImage(R.mipmap.default_imageloader);
        //imageManager.setIsUseMediaStoreThumbnails(true);
        //imageManager.setRequiredSize(width / 3);
        imageSelectorAdapter = new ImageSelectorAdapter(defaultImageSize, activityContext, imageList, new ImageSelectorAdapter.ImageSelectorAdapterListener() {
            @Override
            public void onAdd() {
                addImage();
            }

            @Override
            public void onView(int position, SelectorBean selectorBean) {
                new ImageSelectorViewImageDialog(viewModel,activityContext, new ImageSelectorViewImageDialog.ImageSelectorViewImageListener() {
                    @Override
                    public void onCompleted(int position, SelectorBean selectorBean) {
                        if(!viewModel) {
                            imageList.get(position).setDisc(selectorBean.getDisc());
                            invalidateView();
                        }
                    }

                    @Override
                    public void onDelete(int position, SelectorBean selectorBean) {
                        if(!viewModel) {
//                            imageList.remove(position);
//                            invalidateView();
                            imageSelectorViewListener.onDelete(position,selectorBean);
                        }
                    }
                }).setShowDesc(showDisc).setPosition(position).setSelectorBean(selectorBean).show();
            }
        });
        gridViewList.setAdapter(imageSelectorAdapter);
        btnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addImage();
            }
        });
        invalidateView();
        return this;
    }

    public void refreshDeleteResult(int position){
        if(!viewModel&&imageList!=null&&position>=0&&position<imageList.size()) {
            imageList.remove(position);
            invalidateView();
        }
    }

    public void setSelectorData(List<SelectorBean> list){
        imageList.clear();
        imageList.addAll(list);
        imageSelectorAdapter.notifyDataSetChanged();
        invalidateView();
    }

    public List<SelectorBean> getFinalImageList() {
        List<SelectorBean> newImageList = new ArrayList<SelectorBean>();
        for (int i = 0; i < imageList.size(); i++) {
            if (imageList.get(i) != null && !imageList.get(i).isAddTag()) {
                newImageList.add(imageList.get(i));
            }
        }
        return newImageList;
    }

    private boolean canAdd() {
        int usefullSize = 0;
        if (imageList.size() > 0) {
            for (int i = 0; i < imageList.size(); i++) {
                if (!imageList.get(i).isAddTag()) {
                    usefullSize++;
                }
            }
        }
        return usefullSize < mSelectMaxSize;
    }

    private int getCurrentSize() {
        int count = 0;
        for (SelectorBean selectorBean : imageList) {
            if (!selectorBean.isAddTag()) {
                count++;
            }
        }
        return count;
    }

    public void setImageFromCamera(String path) {
        SelectorBean selectorBean = new SelectorBean();
        selectorBean.setPath(path);
        selectorBean.setIsAddTag(false);
        imageList.add(selectorBean);
        invalidateView();
    }

    private void addImage() {
        if(!viewModel) {
            if (!canAdd()) {
                Toast.makeText(activityContext, "最多添加" + String.valueOf(mSelectMaxSize) + "张", Toast.LENGTH_SHORT).show();
                return;
            }
            new ImageSelectorImageFromDialog(activityContext, new ImageSelectorImageFromDialog.ImageSelectorImageFromListener() {
                @Override
                public void onChoice(int type, Intent intent, int intentTag, Uri uri) {
                    if (imageSelectorViewListener != null) {
                        imageSelectorViewListener.onChoice(intent, intentTag, uri);
                    }
//                    if (type == ImageSelectorImageFromDialog.TYPE_CAMERA) {
//                        if (imageSelectorViewListener != null) {
//                            imageSelectorViewListener.takeCamera(intent, intentTag, uri);
//                        }
//                    } else {
//
//                    }
                }

                @Override
                public void onCustom() {
                    new ImageSelectorChoiceImageDialog(activityContext, new ImageSelectorChoiceImageDialog.ImageSelectorChoiceImageListener() {
                        @Override
                        public void onCompleted(List<SelectorBean> list) {
                            //Toast.makeText(activityContext, String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
                            Log.e("image-return_path",list.get(0).getPath());
                            imageList.addAll(list);
                            invalidateView();
                        }
                    }).setUsefullSize(mSelectMaxSize - getCurrentSize()).show();
                }
            }).show();
        }
    }

    public interface ImageSelectorViewListener {
         void onChoice(Intent intent, int intentTag, Uri uri);
         void onDelete(int position, SelectorBean selectorBean);
    }
}
