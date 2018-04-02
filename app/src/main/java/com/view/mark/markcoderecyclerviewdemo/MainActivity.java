package com.view.mark.markcoderecyclerviewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.view.mark.markcoderecyclerviewdemo.adapter.MyAdapter;
import com.view.mark.markcoderecyclerviewdemo.view.FloatingItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Map<Integer,List<String>> datas = new HashMap<>();//模拟服务器返回数据
    private List<String> list=new ArrayList<>();//adapter数据源
    private Map<Integer,String> keys=new HashMap<>();//存放所有key的位置和内容
    private MyAdapter adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= (RecyclerView) findViewById(R.id.rv);
        for (int i = 0; i < Math.random()*10+5; i++) {//(5-15)
            List<String> list=new ArrayList<>();
            for (int j = 0; j < Math.random()*10+5; j++) {//(5-15)
                list.add("第"+(j+1)+"个item，我属于标题"+i);
            }
            datas.put(i,list);
        }
        for (int i = 0; i < datas.size(); i++) {
            keys.put(list.size(),"我是第"+i+"个标题");
            for (int j = 0; j < datas.get(i).size(); j++) {
                list.add(datas.get(i).get(j));
            }
        }

        //设置adapter
        adapter=new MyAdapter(list,this);
        final FloatingItemDecoration floatingItemDecoration=new FloatingItemDecoration(this, Color.BLUE,1,1);
        floatingItemDecoration.setKeys(keys);
        floatingItemDecoration.setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,getResources().getDisplayMetrics()));
        rv.addItemDecoration(floatingItemDecoration);

        //设置布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(1);
        rv.setLayoutManager(layoutManager);

        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }
}