package com.example.yanruifeng.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yanruifeng.myapplication.bean.MessageEvent;
import com.example.yanruifeng.myapplication.utils.LogUtils;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_Test)
    Button btTest;
    @BindView(R.id.bw_webview)
    BridgeWebView bwWebview;
    @BindView(R.id.bt_testEventBus)
    Button btTestEventBus;
    @BindView(R.id.bt_testRetroftRxjava)
    Button btTestRetroftRxjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册EventBus
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
       // LogUtils.d("1111",MyApp.getInstance().getApplicationContext());
        bwWebview.loadUrl("file:///android_asset/index.html");
        bwWebview.registerHandler("Android", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Toast.makeText(MainActivity.this, "H5给我的数据：" + data, Toast.LENGTH_SHORT).show();
                function.onCallBack("fuck!");
            }
        });
    }

    @OnClick({R.id.bt_Test, R.id.bt_testEventBus,R.id.bt_testRetroftRxjava})
    public void click(View v) {
        switch (v.getId()) {
            //给js发送消息
            case R.id.bt_Test:
                bwWebview.callHandler("functionInJs", "传递消息给h5", new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.bt_testEventBus:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_testRetroftRxjava:
                Intent intent1 = new Intent(this,  LoginActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }

    }

    //订阅 获取信息
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent(MessageEvent event) {
        Toast.makeText(this, event.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        EventBus.getDefault().unregister(this);
    }
}
