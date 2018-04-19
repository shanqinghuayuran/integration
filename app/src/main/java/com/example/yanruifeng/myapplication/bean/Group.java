package com.example.yanruifeng.myapplication.bean;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yanruifeng.myapplication.R;

import butterknife.BindView;

/**
 * Created by yanruifeng on 2018/4/18.
 * @author yanruifeng
 * 自定义组合控件
 */

public class Group extends RelativeLayout {
    private Button btLogin;

    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout, this);
        btLogin=this.findViewById(R.id.bt_login);
    }

    public Group(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Group(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //添加监听事件
    public void setBottomButtonOnClick(OnClickListener listener){
        btLogin.setOnClickListener(listener);
    }
}
