package com.example.yanruifeng.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yanruifeng.myapplication.adapter.BaseAdapter;
import com.example.yanruifeng.myapplication.adapter.ListAdapter;
import com.example.yanruifeng.myapplication.bean.Product;
import com.example.yanruifeng.myapplication.bean.ProductList;
import com.example.yanruifeng.myapplication.http.RetrofitManager;
import com.example.yanruifeng.myapplication.http.RetrofitService;
import com.example.yanruifeng.myapplication.widget.DividerItemDecoration;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TestRecylerViewActivity extends AppCompatActivity {
    //初始化组件
    @BindView(R.id.xrlv_recylerview)
    XRecyclerView xrlvRecylerview;
    //第一页
    private int num=1;
    private LinearLayoutManager llm;
    private boolean flag;
    private boolean tag;
    private ListAdapter listAdapter;
    private List<ProductList.DataBean> list;
    /**
     * retrofitService接口
     */
    private  RetrofitService rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recyler_view);
        ButterKnife.bind(this);
        llm=new LinearLayoutManager(this);
        //设置chunzhi垂直布局
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        xrlvRecylerview.setLayoutManager(llm);
        //刷新时间可见
        xrlvRecylerview.getDefaultRefreshHeaderView().setRefreshTimeVisible(true);
        xrlvRecylerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrlvRecylerview.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
        //添加横向分割线
       xrlvRecylerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //创建Retrofit
        rs=new RetrofitManager(this).createService(RetrofitService.class);
        startHttpRequest(num);
      // xrlvRecylerview.setAdapter(listAdapter);
        xrlvRecylerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                flag=true;
                num=1;
                startHttpRequest(num);
            }

            @Override
            public void onLoadMore() {
                flag=false;
                num++;
                startHttpRequest(num);
            }
        });
    }

    /**
     * 发起网络请求
     * @param pageNumber
     */
    private void startHttpRequest(int pageNumber){
        rs.getProductList(pageNumber,5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ProductList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ProductList productList) {
                List<ProductList.DataBean> data = productList.getData();
                if(flag==true){
                    list.clear();
                    list.addAll(0,data);
                    listAdapter.notifyDataSetChanged();
                   // listAdapter=new ListAdapter(list,TestRecylerViewActivity.this);
                   // xrlvRecylerview.setAdapter(listAdapter);
                    xrlvRecylerview.refreshComplete();
                    Log.d("tag1","刷新" +data.size()+" "+listAdapter.getItemCount());
                }else{
                    if(tag==false){
                        list= data;
                        listAdapter=new ListAdapter(list,TestRecylerViewActivity.this);
                        xrlvRecylerview.setAdapter(listAdapter);
                        tag=true;
                        Log.d("tag2","首部加载"+data.size()+" "+listAdapter.getItemCount());


                    }else {
                        list.addAll(data);
                        listAdapter.notifyDataSetChanged();
                        //xrlvRecylerview.setAdapter(new ListAdapter(list,TestRecylerViewActivity.this));
                        xrlvRecylerview.loadMoreComplete();
                        Log.d("tag3","尾部加载"+data.size()+" "+listAdapter.getItemCount());

                    }

                }
            }
        });
    }
}
