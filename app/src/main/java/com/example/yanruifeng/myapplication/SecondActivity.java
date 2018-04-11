package com.example.yanruifeng.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yanruifeng.myapplication.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //发布消息
        EventBus.getDefault().post(new MessageEvent("这是我的event演示demo"));
    }
}
