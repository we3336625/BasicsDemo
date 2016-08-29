package com.example.zx.myapplication.base;

/**
 * MVP中view基类接口
 * Created by lison on 8/8/16.
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

}
