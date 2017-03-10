/*
 * 乡邻小站
 *  Copyright (c) 2016 XiangLin,Inc.All Rights Reserved.
 */

package com.example.zx.myapplication.http;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TransformUtils {
    /**
     * 默认计划,发布在io线程,订阅在ui线程
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> defaultSchedulers() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * IO计划,发布和订阅都在IO线程
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> allIoSchedulers() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
    }
}
