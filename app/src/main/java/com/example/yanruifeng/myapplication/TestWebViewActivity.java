package com.example.yanruifeng.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yanruifeng.myapplication.bean.JsInterface;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestWebViewActivity extends AppCompatActivity {

    @BindView(R.id.sdk_webview)
    WebView sdkWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_view);
        ButterKnife.bind(this);
        WebSettings ws = sdkWebview.getSettings();
        ws.setJavaScriptEnabled(true);
        sdkWebview.addJavascriptInterface(new JsInterface(this),"jsInterface");
        sdkWebview.loadUrl("file:///android_asset/test.html");
    }
}
