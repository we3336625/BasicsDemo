package com.example.zx.myapplication.biz.selectbank.bankinsertdb;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.data.data.BankCardBean;

import butterknife.BindView;

/**
 * Created by ex-zhangxiang on 2016/8/31.
 */
public class BankInsertDbActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, BankInsertDbContract.view {

	@BindView(R.id.et_insertbanknumber)
	EditText et_insertbanknumber;
	@BindView(R.id.btn_insertbank)
	View btn_insertbank;
	@BindView(R.id.rg_bank)
	RadioGroup rg_bank;

	private BankCardBean bean = new BankCardBean();

	private BankInsertDbContract.presenter mPresenter;

	@Override
	protected void findViews() {
		super.findViews();

		new BankInsertDbPresenter(this, this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_insertbank.setOnClickListener(this);
		rg_bank.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
			case R.id.btn_insertbank:
				String banknumber = et_insertbanknumber.getText().toString();
				bean.setCardNumber(banknumber);
				mPresenter.inseterDB(bean);
				closeActivity();
				break;
		}
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_bankinsert;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (group.getId() == R.id.rg_bank) {
			if (checkedId == R.id.rb_china_bank) {//中国银行
				bean.setBankName(getString(R.string.china_bank));
			} else if (checkedId == R.id.rb_nong_ye_bank) {//农业银行
				bean.setBankName(getString(R.string.nong_ye_bank));
			} else if (checkedId == R.id.rb_jian_she_bank) {//建设银行
				bean.setBankName(getString(R.string.jian_she_bank));
			} else if (checkedId == R.id.rb_zhao_shang_bank) {//招商银行
				bean.setBankName(getString(R.string.zhao_shang_bank));
			} else if (checkedId == R.id.rb_zhe_shang_bank) {//浙商银行
				bean.setBankName(getString(R.string.zhe_shang_bank));
			} else if (checkedId == R.id.rb_gong_shang_bank) {//工商银行
				bean.setBankName(getString(R.string.gong_shang_bank));
			} else if (checkedId == R.id.rb_ren_min_bank) {//人民银行
				bean.setBankName(getString(R.string.ren_min_bank));
			}
		}
	}

	@Override
	public void setPresenter(BankInsertDbContract.presenter presenter) {
		mPresenter = presenter;
	}
}
