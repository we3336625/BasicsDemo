package com.example.zx.myapplication.biz.ImageSelector;

import android.app.Activity;

import com.tdroid.imageselector.library.imageselelctor.ImageSelectorImageFromDialog;
import com.tdroid.imageselector.library.imageselelctor.SelectorBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public class ImageSelectorPresenter implements ImageSelectorContract.presenter {

	ImageSelectorContract.view view;

	public ImageSelectorPresenter(ImageSelectorContract.view view){
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void start() {

	}

	@Override
	public void subscribe() {

	}

	@Override
	public void unsubscribe() {

	}

	@Override
	public void data() {
		List<SelectorBean> images = new ArrayList<>();
		//测试2张数据

		for(int i=0;i<2;i++){
			String path="";
			String dis="图片描述";
			SelectorBean selectorBean=new SelectorBean();
			if(i==0){
				path="http://imgsrc.baidu.com/baike/pic/item/728da9773912b31b4d4df1ed8518367adbb4e1d5.jpg";
				dis+="1";
			}
			if(i==1){
				path="http://e.hiphotos.baidu.com/image/pic/item/b17eca8065380cd785f7d9d6a644ad345982811b.jpg";
				dis+="2";
			}
			selectorBean.setDisc(dis);
			selectorBean.setPath(path);
			images.add(selectorBean);
		}
		view.setSelectorData(images);
//        if (images.size() > 0) {
//            imageSelectorView.setVisibility(View.VISIBLE);
//            List<SelectorBean> selectorBeanList = new ArrayList<SelectorBean>();
//            for (AskInfoImage image : images) {
//                SelectorBean selectorBean = new SelectorBean();
//                selectorBean.setDisc((image.getDescription() == null) ? "" : image.getDescription());
//                selectorBean.setPath((image.getImageUrl() == null) ? "" : image.getImageUrl());
//                selectorBean.setIsAddTag(false);
//                selectorBeanList.add(selectorBean);
//            }
//            imageSelectorViewViewModel.setSelectorData(selectorBeanList);
//        }
	}

	@Override
	public void result(int requestCode, int resultCode) {
		//相机
		if (resultCode == Activity.RESULT_OK && requestCode == ImageSelectorImageFromDialog.CAMERA_INTENT_REQUEST) {
			try {
				//String path = new SharedPreferencesUtils(ResureIdCardActivity.this).getTakeCameraSharePath();
				String path = "调用系统相继返回的图片路径";
				File file = new File(path);
				if (file.exists()) {
					//需要手动给imageSelectorView 传入值显示相机返回图片
					view.setImageFromCamera(path);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
