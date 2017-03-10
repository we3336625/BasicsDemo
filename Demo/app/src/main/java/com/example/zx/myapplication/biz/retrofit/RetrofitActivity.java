package com.example.zx.myapplication.biz.retrofit;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * [类功能说明]
 *
 * @author ex-zhangxiang
 * @version v 2.0.0 2017/3/9 10:20 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class RetrofitActivity extends BaseActivity implements RetrofitContract.view {
    @BindView(R.id.btn_retrofit_query)
    Button btn_retrofit_query;
    @BindView(R.id.tv_retrofit)
    TextView tv_retrofit;

    private RetrofitContract.presenter mPresenter;


    @Override
    protected void findViews() {
        super.findViews();
        new RetrofitPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_retrofit;
    }

    @OnClick({
            R.id.btn_retrofit_query,
            R.id.btn_retrofit_query_map,
            R.id.btn_retrofit_path,
            R.id.btn_retrofit_field_map
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_retrofit_query:
                mPresenter.retrofit2query();
                break;
            case R.id.btn_retrofit_query_map:
                mPresenter.retrofit2QueryMap();
                break;
            case R.id.btn_retrofit_path:
                mPresenter.retrofit2Path();
                break;
            case R.id.btn_retrofit_field_map:
                mPresenter.queryBook2FieldMap();
                break;
            default:
                break;
        }
    }

    @Override
    public void setPresenter(RetrofitContract.presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showText(String text) {
        tv_retrofit.setText(text);
    }
}
