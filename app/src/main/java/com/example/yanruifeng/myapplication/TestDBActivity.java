package com.example.yanruifeng.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yanruifeng.myapplication.app.SysApplication;
import com.example.yanruifeng.myapplication.bean.User;
import com.example.yanruifeng.myapplication.greendao.DaoSession;

public class TestDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);
        DaoSession daoSession = SysApplication.getInstance().getDaoSession();
        //往数据库里添加数据
        daoSession.getUserDao().insert(new User(null,"张三",18,"男"));
        //根据主键删除数据
        daoSession.getUserDao().deleteAll();

    }
}
