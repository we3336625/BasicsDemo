package com.example.zx.myapplication.biz.selectbank.banklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.data.data.BankCardBean;
import com.example.zx.myapplication.utils.BankCardIconUtil;

import java.util.List;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class BankListAdapter extends BaseAdapter {

	private Context mContext;
	private List<BankCardBean> mList;
	private LayoutInflater mLayoutInflater;

	public BankListAdapter(Context context, List<BankCardBean> list){
		this.mContext = context;
		this.mList = list;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		if (mList == null)
			return 0;
		return mList.size();
	}

	@Override
	public Object getItem(int i) {
		if (mList == null)
			return null;
		return mList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		ViewHolder viewHolder;
		if (view == null){
			view = mLayoutInflater.inflate(R.layout.bank_list,viewGroup,false);
			viewHolder = new ViewHolder();
			viewHolder.bankIcon = (ImageView) view.findViewById(R.id.iv_bank_card);
			viewHolder.bankName = (TextView) view.findViewById(R.id.tv_bank_name);
			viewHolder.bankCardNumber = (TextView) view.findViewById(R.id.tv_bank_card_number);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}

		BankCardBean bankCardBean = mList.get(i);
		if (bankCardBean == null)
			return null;
		viewHolder.bankName.setText(bankCardBean.getBankName());
		viewHolder.bankCardNumber.setText(bankCardBean.getCardNumber());
		BankCardIconUtil.setBankIcon(bankCardBean.getBankName(), viewHolder.bankIcon);

		return view;
	}

	class ViewHolder{
		ImageView bankIcon;
		TextView bankName;
		TextView bankCardNumber;
	}
}
