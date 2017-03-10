package com.example.zx.myapplication.biz.retrofit;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * [类功能说明]
 *
 * @author ex-zhangxiang
 * @version v 2.0.0 2017/3/9 15:28 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public interface RetrofitContract {

    interface view extends BaseView<presenter> {
        void showText(String text);
    }

    interface presenter extends BasePresenter {
        void retrofit2query();

        void retrofit2QueryMap();

        void retrofit2Path();

        void queryBook2FieldMap();
    }
}
