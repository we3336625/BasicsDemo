package com.tdroid.imageselector.library.imageselelctor;/**
 * Created by Administrator on 2016/3/23.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.tdroid.imageselector.library.R;
import com.tdroid.imageselector.library.imageselelctor.loader.ImageLoader;
import com.tdroid.imageselector.library.imageselelctor.loader.OtherUtils;

import java.util.List;


/**
 * Created by Administrator on 2016/3/23.
 * 描述:
 * 修改者:
 *
 * @author tianhongtao on 2016/3/23 14:10
 * @version 1.0 2016/3/23 14:10
 * @since 1.0
 */
public class ImageChoiceAdapter extends BaseAdapter {
    private List<SelectorBean> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageChoiceAdapterListener imageChoiceAdapterListener;
    //private WaterFallImageLoader imageManager;
    private int mWidth;

    public ImageChoiceAdapter(Context context, List<SelectorBean> list, ImageChoiceAdapterListener imageChoiceAdapterListener) {
        this.list = list;
        this.context = context;
        this.imageChoiceAdapterListener = imageChoiceAdapterListener;
        //this.imageManager=imageManager;
        layoutInflater = LayoutInflater.from(context);
        int screenWidth = OtherUtils.getWidthInPx(context);
        mWidth = (screenWidth - OtherUtils.dip2px(context, 4))/3;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public SelectorBean getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (list != null) {
            return position;
        }
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageItem imageItem = null;
        if (convertView == null) {
            imageItem = new ImageItem();
            convertView = layoutInflater.inflate(
                    R.layout.cp_layout_imageselectorview_imagechoice, null);

            imageItem.imageView = (SquareImageView) convertView.findViewById(R.id.iv_selectorview_list_image);
            imageItem.checkBox = (ImageView) convertView.findViewById(R.id.chk_selectorview_checkbox);
            imageItem.wrapLayout=(FrameLayout) convertView.findViewById(R.id.imageselector_wrap_layout);
            convertView.setTag(imageItem);
        } else {
            imageItem = (ImageItem) convertView.getTag();
        }
        imageItem.imageView.setImageResource(R.mipmap.cp_icon_image_stub);
        //imageManager.displayImage(list.get(position).getPath(), imageItem.imageView);

        final ImageView checkBox = imageItem.checkBox;
        final SquareImageView squareImageView=imageItem.imageView;
        final  FrameLayout frameLayout=imageItem.wrapLayout;
        final boolean checked=list.get(position).isChecked();
        if(checked){
            checkBox.setBackgroundResource(R.mipmap.cp_icon_imageselector_checked);
            squareImageView.setColorFilter(Color.parseColor("#70000000"));
        }
        else{
            checkBox.setBackgroundResource(R.mipmap.cp_icon_imageselector_unchecked);
            squareImageView.setColorFilter(null);
        }
        ImageLoader.getInstance(context).display(list.get(position).getPath(), squareImageView,
                mWidth, mWidth);
//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (imageChoiceAdapterListener != null) {
//                    imageChoiceAdapterListener.onChoice(position, !checked, list.get(position));
//                }
//            }
//        });
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean chk=list.get(position).isChecked();
                //boolean newChecked=!chk;
                //list.get(position).setIsChecked(newChecked);
//                if(newChecked){
//                    checkBox.setBackgroundResource(R.mipmap.cp_icon_imageselector_checked);
//                    squareImageView.setColorFilter(Color.parseColor("#70000000"));
//                }
//                else{
//                    checkBox.setBackgroundResource(R.mipmap.cp_icon_imageselector_unchecked);
//                    squareImageView.setColorFilter(null);
//                }
                if (imageChoiceAdapterListener != null) {
                    imageChoiceAdapterListener.onChoice(frameLayout,position, !chk, list.get(position));
                }
            }
        });
        return convertView;
    }

    public void toggleImageSelect(View convertView,int postion,boolean checked){
        if(checked){
            convertView.findViewById(R.id.chk_selectorview_checkbox).setBackgroundResource(R.mipmap.cp_icon_imageselector_checked);
            ((SquareImageView)convertView.findViewById(R.id.iv_selectorview_list_image)).setColorFilter(Color.parseColor("#70000000"));
        }
        else{
            convertView.findViewById(R.id.chk_selectorview_checkbox).setBackgroundResource(R.mipmap.cp_icon_imageselector_unchecked);
            ((SquareImageView)convertView.findViewById(R.id.iv_selectorview_list_image)).setColorFilter(null);
        }
        list.get(postion).setIsChecked(checked);
    }

    private class ImageItem {
        SquareImageView imageView;
        ImageView checkBox;
        private FrameLayout wrapLayout;
    }

    public interface ImageChoiceAdapterListener {
        void onChoice(View convertView, int postion, boolean checked, SelectorBean selectorBean);
    }
}
