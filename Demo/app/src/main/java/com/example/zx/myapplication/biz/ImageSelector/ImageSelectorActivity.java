package com.example.zx.myapplication.biz.ImageSelector;

import android.content.Intent;
import android.net.Uri;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.tdroid.imageselector.library.imageselelctor.ImageSelectorImageFromDialog;
import com.tdroid.imageselector.library.imageselelctor.ImageSelectorView;
import com.tdroid.imageselector.library.imageselelctor.SelectorBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片选择器	3
 * Created by ex-zhangxiang on 2016/8/5.
 */
public class ImageSelectorActivity extends BaseActivity implements ImageSelectorContract.view{
	@Override
	protected int getLayoutId() {
		return R.layout.activity_imageselector;
	}

	private ImageSelectorView imageSelectorViewEditModel;
	private ImageSelectorView imageSelectorViewViewModel;

	private ImageSelectorContract.presenter mPresenter;

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.image_selecor_title);
		imageSelectorViewEditModel = (ImageSelectorView) findViewById(R.id.imageselector_editmodel);
		imageSelectorViewViewModel = (ImageSelectorView) findViewById(R.id.imageselector_viewmodel);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		//初始化
		imageSelectorViewEditModel.initSelector(this);
		imageSelectorViewViewModel.initSelector(this);
		//显示图片描述
		imageSelectorViewEditModel.setShowDisc(true);
		//显示图片描述
		imageSelectorViewViewModel.setShowDisc(true);

		new ImageSelectorPresenter(this);

		//可编辑的imageviewselector监听设置
		imageSelectorViewEditModel.setImageSelectorViewListener(new ImageSelectorView.ImageSelectorViewListener() {
			@Override
			public void onChoice(Intent intent, int intentTag, Uri uri) {
				//该方法会调用系统相机. intentTag=ImageSelectorImageFromDialog.CAMERA_INTENT_REQUEST
				//需要处理onActivityResult
				//防止部分手机调用系统相机时，activity会被销毁而不能获取到传入的图片路径.
				//会在onActivityResult里获取该值
				// new SharedPreferencesUtils(ResureIdCardActivity.this).setTakeCameraSharePath(uri.getPath());
				startActivityForResult(intent, intentTag);
			}

			@Override
			public void onDelete(int position, SelectorBean selectorBean) {
				//删除图片操作时，需要调用
				imageSelectorViewEditModel.refreshDeleteResult(position);
			}
		});

		//获取imageselector里最终的数据
		List<SelectorBean> selectorBeen=imageSelectorViewEditModel.getFinalImageList();
	}

	@Override
	protected void initData() {
		super.initData();

		mPresenter.data();

//		//需要手动构建该集合
//		List<SelectorBean> images = new ArrayList<>();
//		//测试2张数据
//
//		for(int i=0;i<2;i++){
//			String path="";
//			String dis="图片描述";
//			SelectorBean selectorBean=new SelectorBean();
//			if(i==0){
//				path="http://imgsrc.baidu.com/baike/pic/item/728da9773912b31b4d4df1ed8518367adbb4e1d5.jpg";
//				dis+="1";
//			}
//			if(i==1){
//				path="http://e.hiphotos.baidu.com/image/pic/item/b17eca8065380cd785f7d9d6a644ad345982811b.jpg";
//				dis+="2";
//			}
//			selectorBean.setDisc(dis);
//			selectorBean.setPath(path);
//			images.add(selectorBean);
//		}
//		imageSelectorViewViewModel.setSelectorData(images);
////        if (images.size() > 0) {
////            imageSelectorView.setVisibility(View.VISIBLE);
////            List<SelectorBean> selectorBeanList = new ArrayList<SelectorBean>();
////            for (AskInfoImage image : images) {
////                SelectorBean selectorBean = new SelectorBean();
////                selectorBean.setDisc((image.getDescription() == null) ? "" : image.getDescription());
////                selectorBean.setPath((image.getImageUrl() == null) ? "" : image.getImageUrl());
////                selectorBean.setIsAddTag(false);
////                selectorBeanList.add(selectorBean);
////            }
////            imageSelectorViewViewModel.setSelectorData(selectorBeanList);
////        }
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//相机

		mPresenter.result(requestCode, resultCode);

//		if (resultCode == RESULT_OK && requestCode == ImageSelectorImageFromDialog.CAMERA_INTENT_REQUEST) {
//			try {
//				//String path = new SharedPreferencesUtils(ResureIdCardActivity.this).getTakeCameraSharePath();
//				String path = "调用系统相继返回的图片路径";
//				File file = new File(path);
//				if (file.exists()) {
//					//需要手动给imageSelectorView 传入值显示相机返回图片
//					imageSelectorViewEditModel.setImageFromCamera(path);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void setSelectorData(List<SelectorBean> images) {
		imageSelectorViewViewModel.setSelectorData(images);
	}

	@Override
	public void setImageFromCamera(String path) {
		imageSelectorViewEditModel.setImageFromCamera(path);
	}

	@Override
	public void setPresenter(ImageSelectorContract.presenter presenter) {
		mPresenter = presenter;
	}
}
