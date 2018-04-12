package com.example.yanruifeng.myapplication.interfaces;
import com.example.yanruifeng.myapplication.bean.Product;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yanruifeng on 2018/4/11.
 */

public interface ApiService {
    @GET("data/product/index.php")
    Observable<Product> getProduct();
}
