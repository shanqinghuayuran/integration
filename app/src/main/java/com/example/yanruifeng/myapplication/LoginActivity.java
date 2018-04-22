package com.example.yanruifeng.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.yanruifeng.myapplication.adapter.lvdapter;
import com.example.yanruifeng.myapplication.bean.Product;
import com.example.yanruifeng.myapplication.http.RetrofitManager;
import com.example.yanruifeng.myapplication.http.RetrofitService;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.lvList)
    ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
       // MyApp.getInstance().addActivity(this);
        RetrofitService service = new RetrofitManager(this).createService(RetrofitService.class);
        Observable<Product> userObservable = service.getProduct();
        //发起网络请求
        userObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Product>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("123",e.getMessage());
                //Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(Product product) {
                lvList.setAdapter(new lvdapter(product.getCarouselItems(),LoginActivity.this));
            }
        });
  }
}
