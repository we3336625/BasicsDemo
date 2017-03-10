package com.example.zx.myapplication.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * [类功能说明]
 *
 * @author ex-zhangxiang
 * @version v 2.0.0 2017/3/9 13:44 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class RetrofitUtils {

    private static volatile Retrofit mRetrofit;
    public static final String URL = "https://api.douban.com/v2/";

    public static RetrofitService createService(){
        if (mRetrofit == null) {
            synchronized (RetrofitUtils.class) {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            }
        }
        return mRetrofit.create(RetrofitService.class);
    }
}
