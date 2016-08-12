package com.example.zx.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.activity.BaseActivity;

import java.math.BigDecimal;

/**
 * 计算器（未完成）
 */
public class CalculatorActivity extends BaseActivity {

	private TextView mTvShow;
	private Button btn_zero;
	private Button btn_one;
	private Button btn_two;
	private Button btn_three;
	private Button btn_four;
	private Button btn_five;
	private Button btn_six;
	private Button btn_seven;
	private Button btn_eight;
	private Button btn_nine;
	private Button btn_point;//  点
	private Button btn_plus;//  加
	private Button btn_minus;//  减
	private Button btn_multiply;//  乘
	private Button btn_devide;//  除
	private Button btn_equal;//  等于
	private Button btn_clear;

	private String str = "0";
	private String str2 = "";
	private int mode = 0;

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.calculator_title);
		mTvShow = (TextView) findViewById(R.id.textView_show);
		btn_zero = (Button) findViewById(R.id.zero);
		btn_one = (Button) findViewById(R.id.one);
		btn_two = (Button) findViewById(R.id.two);
		btn_three = (Button) findViewById(R.id.three);
		btn_four = (Button) findViewById(R.id.four);
		btn_five = (Button) findViewById(R.id.five);
		btn_six = (Button) findViewById(R.id.six);
		btn_seven = (Button) findViewById(R.id.seven);
		btn_eight = (Button) findViewById(R.id.eight);
		btn_nine = (Button) findViewById(R.id.nine);
		btn_point = (Button) findViewById(R.id.point);
		btn_plus = (Button) findViewById(R.id.plus);
		btn_minus = (Button) findViewById(R.id.minus);
		btn_multiply = (Button) findViewById(R.id.multiply);
		btn_devide = (Button) findViewById(R.id.devide);
		btn_equal = (Button) findViewById(R.id.equal);
		btn_clear = (Button) findViewById(R.id.clear);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_calculator;
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_zero.setOnClickListener(this);
		btn_one.setOnClickListener(this);
		btn_two.setOnClickListener(this);
		btn_three.setOnClickListener(this);
		btn_four.setOnClickListener(this);
		btn_five.setOnClickListener(this);
		btn_six.setOnClickListener(this);
		btn_seven.setOnClickListener(this);
		btn_eight.setOnClickListener(this);
		btn_nine.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_devide.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.zero:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.zero);
				}

				mTvShow.setText(str);
				break;
			case R.id.one:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.one);
				} else {
					str = getResources().getString(R.string.one);
				}
				mTvShow.setText(str);
				break;
			case R.id.two:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.two);
				} else {
					str = getResources().getString(R.string.two);
				}
				mTvShow.setText(str);
				break;
			case R.id.three:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.three);
				} else {
					str = getResources().getString(R.string.three);
				}
				mTvShow.setText(str);
				break;
			case R.id.four:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.four);
				} else {
					str = getResources().getString(R.string.four);
				}
				mTvShow.setText(str);
				break;
			case R.id.five:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.five);
				} else {
					str = getResources().getString(R.string.five);
				}
				mTvShow.setText(str);
				break;
			case R.id.six:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.six);
				} else {
					str = getResources().getString(R.string.six);
				}
				mTvShow.setText(str);
				break;
			case R.id.seven:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.seven);
				} else {
					str = getResources().getString(R.string.seven);
				}
				mTvShow.setText(str);
				break;
			case R.id.eight:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.eight);
				} else {
					str = getResources().getString(R.string.eight);
				}
				mTvShow.setText(str);
				break;
			case R.id.nine:
				if (!str.equals(getResources().getString(R.string.zero))){
					str = str + getResources().getString(R.string.nine);
				} else {
					str = getResources().getString(R.string.nine);
				}
				mTvShow.setText(str);
				break;
			case R.id.point:
				if (str.equals("")){
					str = getResources().getString(R.string.zero)+getResources().getString(R.string.point);
				} else {
					if (str.indexOf(getResources().getString(R.string.point)) == -1){
						str = str + getResources().getString(R.string.point);
					}
				}
				mTvShow.setText(str);
				break;
			case R.id.plus:
				equal();
				mode = 1;
				mTvShow.setText(str);
				break;
			case R.id.minus:
				mode = 2;
				str2 = str;
				break;
			case R.id.multiply:
				mode = 3;
				str2 = str;
				break;
			case R.id.devide:
				mode = 4;
				str2 = str;
				break;
			case R.id.equal:
				equal();
				break;
			case R.id.clear:
				mTvShow.setText(R.string.zero);
				str = getResources().getString(R.string.zero);
				break;
			default:
				break;
		}
	}

	private void equal(){
		switch (mode){
			case 0:
				str2 = str;
				mTvShow.setText(R.string.zero);
				str = getResources().getString(R.string.zero);
				break;
			case 1:
				BigDecimal bd=new BigDecimal(str);
				BigDecimal bd2=new BigDecimal(str2);
				str = bd.add(bd2).toString();
				str2 = "0";
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
		}
	}
}
