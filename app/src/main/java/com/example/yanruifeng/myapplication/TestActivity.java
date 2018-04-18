package com.example.yanruifeng.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_test)
    Button btTest;
    private Handler handler=new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            if(msg.what==1)
                tvTitle.setText("去你妈的");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        //子线程可以在Oncreate,OnStart,OnResume中更新Ui操作 那会ViewRootImpl 还没有被创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                //不推荐
                handler.sendEmptyMessage(1);
                //tvTitle.setText("您好");
                // Looper.prepare();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                tvTitle.setText("这是什么");
                //推荐使用方式
          }
        }).start();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    //    @OnClick({R.id.bt_test})
//    public void click(){
//        Toast.makeText(this, "我被点击了", Toast.LENGTH_SHORT).show();
//    }
}
