package com.example.yanruifeng.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class GlideActivity extends AppCompatActivity {

    @BindView(R.id.civ_pic)
    CircleImageView civPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523529064350&di=41b9a33e81e4526ecfe8566e3cde1804&imgtype=0&src=http%3A%2F%2Fpic32.photophoto.cn%2F20140706%2F0013026472380593_b.jpg").into(civPic);
    }
}
