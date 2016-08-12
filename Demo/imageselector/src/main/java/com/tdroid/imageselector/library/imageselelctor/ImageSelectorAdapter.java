package com.tdroid.imageselector.library.imageselelctor;/**
 * Created by Administrator on 2016/3/23.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.tdroid.imageselector.library.R;
import com.tdroid.imageselector.library.imageselelctor.loader.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 2016/3/23.
 * 描述:
 * 修改者:
 *
 * @author tianhongtao on 2016/3/23 09:59
 * @version 1.0 2016/3/23 09:59
 * @since 1.0
 */
public class ImageSelectorAdapter extends BaseAdapter {
    private List<SelectorBean> list;
    private Context context;
    private LayoutInflater layoutInflater;
    //private ImageManager imageManager;
    private int defaultSize = 200;

    private ImageSelectorAdapterListener imageSelectorAdapterListener;

    public ImageSelectorAdapter(int defaultSize, Context context, List<SelectorBean> list, ImageSelectorAdapterListener imageSelectorAdapterListener) {
        this.list = list;
        this.context = context;
        //this.imageManager=imageManager;
        this.defaultSize = defaultSize;
        this.imageSelectorAdapterListener = imageSelectorAdapterListener;
        layoutInflater = LayoutInflater.from(context);
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
                    R.layout.cp_layout_imageselectorview_imagelist, null);

            imageItem.imageView = (SelectorImageView) convertView.findViewById(R.id.iv_selectorview_list_image);
            imageItem.imageViewAdd=(SelectorImageView) convertView.findViewById(R.id.iv_selectorview_list_image_add);
            convertView.setTag(imageItem);
        } else {
            imageItem = (ImageItem) convertView.getTag();
        }
        SelectorImageView imageView = imageItem.imageView;
        SelectorImageView imageViewAdd = imageItem.imageViewAdd;
        imageView.getLayoutParams().width = defaultSize;
        imageView.getLayoutParams().height = defaultSize;
        imageViewAdd.getLayoutParams().width = defaultSize;
        imageViewAdd.getLayoutParams().height = defaultSize;
        imageView.setVisibility(View.GONE);
        imageViewAdd.setVisibility(View.GONE);
        if (!list.get(position).isAddTag()) {
//            Uri uri = Uri.parse(list.get(position).getPath());
//            final String scheme = uri.getScheme();
//            if ( "http".equals( scheme ) || "https".equals( scheme ) ) {
//                if (imageManager != null) {
//                    imageManager.bind(imageItem.imageView, list.get(position).getPath(), ImageSelectorView.getImageOptionsAds());
//                }
//            }
//            else{
//                ImageSelectorImageLoader.getInstance(context).display(list.get(position).getPath(), imageView,
//                        defaultSize, defaultSize);
//            }
            imageView.setVisibility(View.VISIBLE);
            imageViewAdd.setVisibility(View.GONE);
            ImageLoader.getInstance(context).display(list.get(position).getPath(), imageView,
                    defaultSize, defaultSize);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imageSelectorAdapterListener != null) {
                        imageSelectorAdapterListener.onView(position, list.get(position));
                    }
                }
            });
        } else {
            if(position==list.size()-1) {
                imageView.setVisibility(View.GONE);
                imageViewAdd.setVisibility(View.VISIBLE);
                //imageView.setImageResource(R.mipmap.cp_icon_selectorview_add_noborder);
                imageViewAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (imageSelectorAdapterListener != null) {
                            imageSelectorAdapterListener.onAdd();
                        }
                    }
                });
            }
        }
        return convertView;
    }

    private class ImageItem {
        SelectorImageView imageView;
        SelectorImageView imageViewAdd;
    }

    public interface ImageSelectorAdapterListener {
        void onAdd();

        void onView(int position, SelectorBean selectorBean);
    }
}
