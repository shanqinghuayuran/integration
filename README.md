#### [下拉刷新-android-Ultra-Pull-To-Refresh](https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh)
#### 网络请求 RxJava+Retrofit+Okhttp3.0
#### 网络请求相关主要放在了http包中,有两个辅助类 一个是RetroftManager，另一个是RetrofitService，其中使用OKhttp3.0设置了缓存,再也不需要用Sqlite和S进行网络缓存数据。 使用方式 网络相关NetworkUtils工具类 [可查看我的blog](https://blog.csdn.net/qq_21937107/article/details/79904324)
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
#### RxJava+Retrofit+Okhttp3 需要在build.gradle下配置 
    compile 'io.reactivex:rxandroid:1.2.1'
    compile 'com.squareup.retrofit2:retrofit:2.1.0'##
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
 #### ButterKnife框架
    compile 'com.jakewharton:butterknife:8.4.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'
 #### 图片圆形库
Github地址：https://github.com/hdodenhof/CircleImageView
### Android与H5交互通信桥梁 使用JsBridge开源库,传统意义上一般使用是把library引入 ,然后你的Module去依赖它。但是我已经把它弄成 jsBridge.aar包了,你只需要在你的Module下添加一个libs(和app同级目录)，然后把这个jsBridge.aar包放入到该文件夹中,然后在你的Module下的build.gradle下 添加compile(name: "jsBridge", ext: "aar")
```javascript
function connectWebViewJavascriptBridge(callback) {
        if (window.WebViewJavascriptBridge) {
            callback(WebViewJavascriptBridge)
        } else {
            document.addEventListener(
                'WebViewJavascriptBridgeReady'
                , function() {
                    callback(WebViewJavascriptBridge)
                },
                false
            );
        }
    }
    connectWebViewJavascriptBridge(function(bridge) {
//        bridge.init(function(message, responseCallback) {
//        console.log('JS got a message', message);
//           alert(message);
//            responseCallback(data);
//        });
        bridge.registerHandler("functionInJs", function(data, responseCallback) {
                document.getElementById("show").innerHTML = "Native发来的消息是：" + data;
                var responseData = "Javascript Says Right back aka!";
                responseCallback(responseData);
            });
    })
    function go(){
    //给android 发送消息
            window.WebViewJavascriptBridge.callHandler(
                "Android",
                "Hello",
                function(responseData){
                    document.getElementById("show").innerHTML = "Native给我的数据:"+responseData;
                }
            );
        }

```
```java
bwWebview.loadUrl("file:///android_asset/index.html");
        bwWebview.registerHandler("Android", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Toast.makeText(MainActivity.this, "H5给我的数据：" + data, Toast.LENGTH_SHORT).show();
                function.onCallBack("fuck!");
            }
        });
    }
    bwWebview.callHandler("functionInJs", "传递消息给h5", new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
```



