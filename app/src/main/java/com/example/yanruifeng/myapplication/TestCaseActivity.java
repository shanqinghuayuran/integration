package com.example.yanruifeng.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestCaseActivity extends AppCompatActivity {

    @BindView(R.id.bt_skip)
    Button btSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_case);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.bt_skip})
    public void click(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
