package com.example.yanruifeng.myapplication.http;
import com.example.yanruifeng.myapplication.bean.Product;
import com.example.yanruifeng.myapplication.bean.ProductList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanruifeng on 2018/4/11.
 */

public interface RetrofitService {
    @GET("data/product/index.php")
Observable<Product> getProduct();
    @GET("data/product/list.php")
    Observable<ProductList> getProductList(@Query("pno") int pageNumber,@Query("pageSize") int pageSize);
}
