package com.view.mark.markcoderecyclerviewdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.view.mark.markcoderecyclerviewdemo.R;
import com.view.mark.markcoderecyclerviewdemo.adapter.ListAdapter;
import com.view.mark.markcoderecyclerviewdemo.view.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * $desc$
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/9/30
 */
public class VerticalActivity extends AppCompatActivity {
    private List<String> list=new ArrayList<>();//adapter数据源
    private MyListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_vertical);
        listView = findViewById(R.id.ll);

        for (int i = 0; i < 40; i++) {
            list.add("哎呀妈呀，脑瓜疼！" + (i+1));
        }

        ListAdapter adapter = new ListAdapter(this,list);
        listView.setAdapter(adapter);

    }
}
