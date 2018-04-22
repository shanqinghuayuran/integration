package com.example.yanruifeng.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yanruifeng.myapplication.R;
import com.example.yanruifeng.myapplication.bean.ProductList;
import com.example.yanruifeng.myapplication.interfaces.HttpUrl;

import java.util.List;

/**
 * Created by yanruifeng on 2018/4/21.
 */

public class ListAdapter extends RecyclerView.Adapter {
    private List<ProductList.DataBean> list;
    private Context context;

    public ListAdapter(List<ProductList.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        Log.d("tag",list.size()+"");
    }

    public ListAdapter(){

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recylerview_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tvTitle.setText(list.get(position).getTitle());
        viewHolder.tvPrice.setText(list.get(position).getPrice());
        Glide.with(context).load(HttpUrl.IP+"/"+list.get(position).getPic()).into(viewHolder.ivPic);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    static  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public TextView tvPrice;
        public ImageView ivPic;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvPrice=itemView.findViewById(R.id.tv_price);
            ivPic=itemView.findViewById(R.id.iv_pic);
        }
    }
}
