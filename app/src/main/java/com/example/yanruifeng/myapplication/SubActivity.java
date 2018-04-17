package com.example.yanruifeng.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubActivity extends AppCompatActivity {

    @BindView(R.id.bt_skip)
    Button btSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ButterKnife.bind(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("1");
        SysBroadcastReceiver sbr = new SysBroadcastReceiver();
        registerReceiver(sbr, filter);
    }
    @OnClick({R.id.bt_skip})
    public void click(){
        Intent intent=new Intent();
        intent.putExtra("tag","这是我发送的广播");
        intent.setAction("1");
        //发送普通广播
        sendBroadcast(intent);
    }
}
