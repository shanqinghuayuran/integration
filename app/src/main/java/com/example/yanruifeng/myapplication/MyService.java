package com.example.yanruifeng.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private String data;
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    class Binder extends android.os.Binder{
        public void setData(String data){
           MyService.this.data=data;
           Log.d("tag",data);
        }
    }
}
