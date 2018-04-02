package com.view.mark.markcoderecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.view.mark.markcoderecyclerviewdemo.R;

import java.util.List;

/**
 * 项目名称：MarkCodeRecyclerViewDemo
 * 类描述：适配器
 * Created by mark on 2018/4/2 17:08
 * 修改人：mark
 * 修改时间：2018/4/2 17:08
 * 修改备注：
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> datas;
    private Context mContext;
    public MyAdapter(List<String> datas,Context mContext){
        this.datas=datas;
        this.mContext=mContext;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(datas.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }
}