package com.example.zx.myapplication.biz.xrecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * XRecyclerView test
 *
 * @author ex-zhangxiang
 * @version v 1.0.0 2016/11/2 9:39 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */

public class XRecyclerViewActivity extends BaseActivity implements XRecyclerView.LoadingListener {

	@BindView(R.id.xrecyclerview)
	XRecyclerView xRecyclerView;

	private List<String> mList = new ArrayList<String>();

	int page = 1;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_xrecycler_view;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle("XRecyclerView");


		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		xRecyclerView.setLayoutManager(layoutManager);
		for (int i = 0; i < 10; i++) {
			mList.add(page+"test"+i);
		}
		xRecyclerView.setAdapter(new RecyclerViewAdapter(this, mList));
	}


	private List<String> initdata(int position) {
		for (int i = 0; i < 10; i++) {
			mList.add(position+"test"+i);
		}
		return mList;
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		xRecyclerView.setLoadingListener(this);
	}

	@Override
	public void onRefresh() {
		mList.clear();
		page = 1;
		initdata(page);
		xRecyclerView.refreshComplete();
	}

	@Override
	public void onLoadMore() {
		page++;
		initdata(page);
		xRecyclerView.loadMoreComplete();
	}

	public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

		List<String> mList;
		Context mContext;

		public RecyclerViewAdapter(Context context, List<String> list){
			this.mContext = context;
			this.mList = list;
		}

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

			return new Item1ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, parent, false));
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

			if (holder instanceof Item1ViewHolder) {
				Item1ViewHolder holder1 = (Item1ViewHolder) holder;
				holder1.itemView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						tip("第" + position + "条");
					}
				});
				String state = mList.get(position);
				holder1.tv.setText(state);
			}
		}

		@Override
		public int getItemCount() {
			return mList.size();
		}

		public class Item1ViewHolder extends RecyclerView.ViewHolder {
			@BindView(R.id.tv_recyclerview_item)
			TextView tv;

			public Item1ViewHolder(View itemView) {
				super(itemView);

				ButterKnife.bind(this, itemView);
			}
		}
	}
}
