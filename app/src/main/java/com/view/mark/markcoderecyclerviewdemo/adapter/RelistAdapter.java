package com.view.mark.markcoderecyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.view.mark.markcoderecyclerviewdemo.R;

import butterknife.ButterKnife;

/**
 * 项目名称：MarkCodeRecyclerViewDemo
 * 类描述：
 * Created by mark on 2018/4/3 16:55
 * 修改人：mark
 * 修改时间：2018/4/3 16:55
 * 修改备注：
 */
public  class RelistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second,parent,false);
        return new ReHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ReHolder extends RecyclerView.ViewHolder{

        public ReHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
