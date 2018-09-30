package com.view.mark.markcoderecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.view.mark.markcoderecyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * $desc$
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/9/30
 */
public class ListAdapter extends BaseAdapter{
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public ListAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false);
        TextView textView = convertView.findViewById(R.id.tv);
        textView.setText(mList.get(position));
        return convertView;
    }
}
