package com.example.zx.myapplication.biz.ImageSelector;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;
import com.tdroid.imageselector.library.imageselelctor.SelectorBean;

import java.util.List;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public interface ImageSelectorContract {
	interface view extends BaseView<presenter>{

		void setSelectorData(List<SelectorBean> images);

		void setImageFromCamera(String path);
	}

	interface presenter extends BasePresenter{
		void data();

		void result(int requestCode, int resultCode);
	}
}
