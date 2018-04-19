package com.example.yanruifeng.myapplication.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.yanruifeng.myapplication.greendao.DBHelper;
import com.example.yanruifeng.myapplication.greendao.DaoMaster;
import com.example.yanruifeng.myapplication.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by yanruifeng on 2018/4/19.
 */

public class SysApplication extends Application {
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private static SysApplication instance=null;
    @Override
    public void onCreate() {
        setDataBase();
        super.onCreate();
    }
    //单例模式
    public static SysApplication getInstance(){
        if(instance==null){
            instance=new SysApplication();
        }
        return instance;
    }
    public void setDataBase(){
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DBHelper dbHelper=new DBHelper(this,"user",null);
        db=dbHelper.getWritableDatabase();
        daoMaster=new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
