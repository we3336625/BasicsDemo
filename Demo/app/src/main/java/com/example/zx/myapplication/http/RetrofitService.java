package com.example.zx.myapplication.http;

import com.example.zx.myapplication.db.BookBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * [类功能说明]
 *
 * @author ex-zhangxiang
 * @version v 2.0.0 2017/3/9 10:27 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public interface RetrofitService {

    // https://api.douban.com/v2/book/search?q=%E9%87%91%E7%93%B6%E6%A2%85&tag=&start=0&count=1

    @GET("book/search")
    Observable<BookBean> queryBook(@Query("q") String q,
                                   @Query("tag") String tag,
                                   @Query("start") String start,
                                   @Query("count") String count);

    @GET("book/search")
    Observable<BookBean> queryBook(@QueryMap Map<String, String> map);

    @GET("book/{q}?q=金瓶梅&tag=&start=0&count=1")
    Observable<BookBean> queryBook(@Path("q") String q);

    @FormUrlEncoded
    @POST("book/search")
    Observable<BookBean> queryBook2FieldMap(@FieldMap Map<String,String> map);
}
