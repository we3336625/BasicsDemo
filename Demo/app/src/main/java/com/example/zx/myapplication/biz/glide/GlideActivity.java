package com.example.zx.myapplication.biz.glide;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class GlideActivity extends BaseActivity {

	@BindView(R.id.iv_glide)
	ImageView iv_glide;
	@BindView(R.id.btn_glide)
	Button btn_glide;
	@BindView(R.id.btn_picasso)
	Button btn_picasso;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_glide;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.glide);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_glide.setOnClickListener(this);
		btn_picasso.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		if (view.getId() == R.id.btn_glide) {
			Glide.with(this)
					.load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
					.diskCacheStrategy(DiskCacheStrategy.ALL) // 让Glide既缓存全尺寸又缓存其他尺寸
					.error(R.drawable.icon)
					.into(iv_glide);
		} else if (view.getId() == R.id.btn_picasso) {
			Picasso.with(this)
					.load("http://imgsrc.baidu.com/forum/pic/item/092855affbd2ba5df8dc618f.jpg")
//					.noFade()
					.error(R.drawable.icon)
					.into(iv_glide);
		}
	}
}
