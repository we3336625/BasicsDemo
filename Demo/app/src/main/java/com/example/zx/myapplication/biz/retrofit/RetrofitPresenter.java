package com.example.zx.myapplication.biz.retrofit;

import android.support.v4.util.ArrayMap;

import com.example.zx.myapplication.db.BookBean;
import com.example.zx.myapplication.http.RetrofitUtils;
import com.example.zx.myapplication.http.TransformUtils;

import java.util.Map;

import rx.Subscriber;

/**
 * [类功能说明]
 *
 * @author ex-zhangxiang
 * @version v 2.0.0 2017/3/9 15:31 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class RetrofitPresenter implements RetrofitContract.presenter {

    RetrofitContract.view mView;

    public RetrofitPresenter(RetrofitContract.view view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void retrofit2query() {
        RetrofitUtils.createService()
                .queryBook("金瓶梅", null, "0", "1")
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new Subscriber<BookBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BookBean bookBean) {
                        if (bookBean == null) {
                            return;
                        }
                        mView.showText("@Query--->" + bookBean);
                    }
                });
    }

    @Override
    public void retrofit2QueryMap() {
        Map<String, String> map = new ArrayMap<>();
        map.put("q", "金瓶梅");
        map.put("start", "0");
        map.put("count", "1");
        RetrofitUtils.createService().queryBook(map)
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new Subscriber<BookBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BookBean bookBean) {
                        if (bookBean == null) {
                            return;
                        }
                        mView.showText("@QueryMap--->" + bookBean);
                    }
                });
    }

    @Override
    public void retrofit2Path() {
        RetrofitUtils.createService().queryBook("search")
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new Subscriber<BookBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BookBean bookBean) {
                        if (bookBean == null) {
                            return;
                        }
                        mView.showText("@Path--->" + bookBean);
                    }
                });
    }

    @Override
    public void queryBook2FieldMap() {
        Map<String, String> map = new ArrayMap<>();
        map.put("q", "金瓶梅");
        map.put("tag", "");
        map.put("start", "0");
        map.put("count", "1");
        RetrofitUtils.createService()
                .queryBook2FieldMap(map)
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new Subscriber<BookBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BookBean bookBean) {
                        if (bookBean == null) {
                            return;
                        }
                        mView.showText("@FieldMap--->" + bookBean);
                    }
                });
    }
}
