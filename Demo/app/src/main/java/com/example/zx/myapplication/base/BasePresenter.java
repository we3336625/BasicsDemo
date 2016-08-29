package com.example.zx.myapplication.base;

/**
 * MVP中Presenter层基类接口
 * Created by lison on 8/8/16.
 */
public interface BasePresenter {

    void start();
    void subscribe();

    void unsubscribe();

}
