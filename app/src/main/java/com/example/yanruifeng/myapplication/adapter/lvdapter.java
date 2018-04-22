package com.example.yanruifeng.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanruifeng.myapplication.R;
import com.example.yanruifeng.myapplication.bean.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yanruifeng on 2018/4/11.
 */

public class lvdapter extends BaseAdapter {
    private List<Product.CarouselItemsBean> list;
    private Context context;

    public lvdapter(List<Product.CarouselItemsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.lvlist_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
       holder.tvTitle.setText(list.get(i).getTitle());
        holder.tvHref.setText(list.get(i).getHref());
        return view;
    }

    class ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvHref)
        TextView tvHref;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
