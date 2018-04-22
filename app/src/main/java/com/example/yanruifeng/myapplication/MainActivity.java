package com.example.yanruifeng.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yanruifeng.myapplication.bean.Group;
import com.example.yanruifeng.myapplication.bean.MessageEvent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    @BindView(R.id.bt_Test)
    Button btTest;
    @BindView(R.id.bw_webview)
    BridgeWebView bwWebview;
    @BindView(R.id.bt_testEventBus)
    Button btTestEventBus;
    @BindView(R.id.bt_testRetroftRxjava)
    Button btTestRetroftRxjava;
    @BindView(R.id.bt_glide)
    Button btGlide;
    @BindView(R.id.bt_sendBroadcast)
    Button btSendBroadcast;
    @BindView(R.id.bt_service)
    Button btService;
    @BindView(R.id.civ_pic)
    ImageView civPic;
    @BindView(R.id.group)
    Group group;
    @BindView(R.id.bt_skip)
    Button btSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册EventBus
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        Log.d("tag","走了");
        group.setBottomButtonOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        //动态注.册接受广播者
        IntentFilter filter = new IntentFilter();
        filter.addAction("1");
        SysBroadcastReceiver sbr = new SysBroadcastReceiver();
        registerReceiver(sbr, filter);
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

    @OnClick({R.id.bt_skip,R.id.bt_Test, R.id.bt_testEventBus, R.id.bt_testRetroftRxjava, R.id.bt_glide, R.id.bt_service, R.id.civ_pic})
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
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_glide:
                Intent intent2 = new Intent(this, GlideActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_sendBroadcast:
                Intent intent3 = new Intent(this, SubActivity.class);
                startActivity(intent3);
                break;
            case R.id.bt_service:
                //Activity 与service交互 第一种方式
                Intent intent4 = new Intent(this, MyService.class);
                intent4.putExtra("123", "我了个去");
                startService(intent4);
                break;
            case R.id.civ_pic:
                //启动动画 补间动画执行之后并未改变View的真实布局属性值。
                civPic.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation));
                break;
            case R.id.bt_skip:
                Intent intent5=new Intent(MainActivity.this,TestCaseActivity.class);
                startActivity(intent5);
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

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        // MyService mService= (MyService) iBinder;
        MyService.Binder binder = (MyService.Binder) iBinder;
        binder.setData("我了个去");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag","走了1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag","走了2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag","走了3");
    }
}
