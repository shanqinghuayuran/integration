package com.example.yanruifeng.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.Toast;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_Test)
    Button btTest;
    @BindView(R.id.bw_webview)
    BridgeWebView bwWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bwWebview.loadUrl("file:///android_asset/index.html");
        bwWebview.registerHandler("Android", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Toast.makeText(MainActivity.this, "H5给我的数据：" + data, Toast.LENGTH_SHORT).show();
                function.onCallBack("fuck!");
            }
        });
    }
    @OnClick({R.id.bt_Test})
    public void click(){
        //给js发送消息
        bwWebview.callHandler("functionInJs", "传递消息给h5", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
