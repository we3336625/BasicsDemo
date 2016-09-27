package com.example.zx.myapplication.biz.convenionbanner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ConvenientBannerActivity extends BaseActivity {

	@BindView(R.id.convenientbanner)
	ConvenientBanner convenientBanner;


	@Override
	protected int getLayoutId() {
		return R.layout.activity_convenient_banner;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.convenientbanner);

		List<Integer> list = new ArrayList<Integer>();
		list.add(R.drawable.icon);
		list.add(R.drawable.convenientbanner);
		list.add(R.drawable.bank_card);

		convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
			@Override
			public NetworkImageHolderView createHolder() {
				return new NetworkImageHolderView();
			}
		}, list)
				.setPointViewVisible(true) // 设置指示器是否可见
				.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}) // 设置指示器原点
				.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT) // 设置指示器位置（左，中，右）
				.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(int position) {
						tip("这是第" + (position + 1) + "张图");
					}
				})
				//			.setManualPageable(false)  //  设置手动影响（是否可以手动切换）
				.startTurning(3000)  //  设置自动切换（时间间隔）
//				.stopTurning()	//  关闭自动切换
		;

	}

	private class NetworkImageHolderView implements Holder<Integer> {
		private ImageView imageView;

		@Override
		public View createView(Context context) {
			imageView = new ImageView(context);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			return imageView;
		}

		@Override
		public void UpdateUI(Context context, int position, Integer data) {
			imageView.setImageResource(data);
		}

	}
}
