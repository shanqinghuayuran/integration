package com.example.yanruifeng.myapplication.interfaces;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.yanruifeng.myapplication.MyApp;
import com.example.yanruifeng.myapplication.utils.LogUtils;
import com.example.yanruifeng.myapplication.utils.NetworkUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yanruifeng
 */
public class ServiceGenerator {
    private Context context;
    private  File httpCacheDirectory;
    private  int cacheSize = 10 * 1024 * 1024; // 10 MiB
    private Cache cache;
    private  OkHttpClient client;
    private  Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR;
    public ServiceGenerator(Context context) {
        this.context = context;
        this.httpCacheDirectory=new File(context.getCacheDir(), "responses");
        this.cache = new Cache(httpCacheDirectory, cacheSize);
        this.REWRITE_CACHE_CONTROL_INTERCEPTOR=chain -> {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();
            Log.d("12345",context.toString());
            Request request = chain.request();
            if (!NetworkUtils.isAvailable(context)) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();

            }
            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.isAvailable(context)) {
                int maxAge = 0; // read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        };
        this.client=new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache).build();
    }
    /**
     * 配置网络缓存
     */
    public  final String API_BASE_URL = "http://192.168.10.100:80/ajia_code/";
    private  Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public  <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

    }