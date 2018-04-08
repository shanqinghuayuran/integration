package com.example.yanruifeng.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yanruifeng on 2018/4/8.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[] tabTitleArray;
    public MyAdapter(FragmentManager fm, List<Fragment> list, String[] tabTitleArray) {
        super(fm);
        this.list = list;
        this.tabTitleArray = tabTitleArray;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleArray[position % tabTitleArray.length];
    }
}
