### [下拉刷新-android-Ultra-Pull-To-Refresh](https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh)
### 网络请求 RxJava+Retrofit+Okhttp3.0
### 网络请求相关主要放在了http包中,有两个辅助类 一个是RetroftManager，另一个是RetrofitService，其中使用OKhttp3.0设置了缓存,再也不需要用Sqlite和S进行网络缓存数据。 使用方式 网络相关NetworkUtils工具类 [可查看我的blog](https://blog.csdn.net/qq_21937107/article/details/79904324)
```java
  RetrofitService service = new RetrofitManager(this).createService(RetrofitService.class);
        Observable<Product> userObservable = service.getProduct();
        userObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Product>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.d("123",e.getMessage());
            }
            @Override
            public void onNext(Product product) {
                lvList.setAdapter(new lvdapter(product.getCarouselItems(),LoginActivity.this));
            }
        });
  }
```
### RxJava+Retrofit+Okhttp3 需要在build.gradle下配置 
    compile 'io.reactivex:rxandroid:1.2.1'
    compile 'com.squareup.retrofit2:retrofit:2.1.0'##
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
 ### ButterKnife框架
    compile 'com.jakewharton:butterknife:8.4.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'
 ### 图片圆形库
Github地址：https://github.com/hdodenhof/CircleImageView


