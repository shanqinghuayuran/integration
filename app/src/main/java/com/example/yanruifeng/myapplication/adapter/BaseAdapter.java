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
import com.example.yanruifeng.myapplication.bean.Product;
import com.example.yanruifeng.myapplication.interfaces.HttpUrl;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yanruifeng on 2018/4/20.
 * @author yanruifeng
 */

public class BaseAdapter extends RecyclerView.Adapter{
    private List<Product.CarouselItemsBean> list;
    private Context context;

    public BaseAdapter(List<Product.CarouselItemsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private BaseAdapter(){

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lvlist_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).tvHref.setText(list.get(position).getHref());
        ((ViewHolder) holder).tvTitle.setText(list.get(position).getTitle());
        Log.d("tag",list.get(position).getImg());
        //加载圆形图片
        Glide.with(context).load(HttpUrl.IP+"/"+list.get(position).getImg()).into(((ViewHolder)holder).imageView);
    }

    @Override
    public int getItemCount()
    {
        return list==null?0:list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvHref;
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvHref=itemView.findViewById(R.id.tvHref);
            imageView=itemView.findViewById(R.id.iv_pic);
        }
    }
}
