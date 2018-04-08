package com.example.yanruifeng.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yanruifeng.myapplication.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tl_tab)
    TabLayout tlTab;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    private String[] tabTitleArray = {"要闻", "英雄联盟", "守望先锋"};
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //此处使用for循环
        for(int i=0;i<tabTitleArray.length;i++){
            tlTab.addTab(tlTab.newTab().setText(tabTitleArray[i]));
        }
        tlTab.setTabMode(TabLayout.MODE_FIXED);
        list=new ArrayList<>();
        list.add(new NewsFragment());
        list.add(new SwxfFragment());
        list.add(new YxlmFragment());
        vpPager.setAdapter(new MyAdapter(getSupportFragmentManager(),list,tabTitleArray));
        tlTab.setupWithViewPager(vpPager);
    }
}
