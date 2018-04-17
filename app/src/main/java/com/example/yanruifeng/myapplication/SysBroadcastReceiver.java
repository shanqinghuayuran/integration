package com.example.yanruifeng.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by yanruifeng on 2018/4/17.
 */

public class SysBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, ""+intent.getStringExtra("tag"), Toast.LENGTH_SHORT).show();
        //发送广播销毁当前Activity
        ((Activity)context).finish();
    }
}
