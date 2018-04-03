package com.view.mark.markcoderecyclerviewdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.view.mark.markcoderecyclerviewdemo.R;
import com.view.mark.markcoderecyclerviewdemo.adapter.RelistAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：MarkCodeRecyclerViewDemo
 * 类描述：
 * Created by mark on 2018/4/3 16:43
 * 修改人：mark
 * 修改时间：2018/4/3 16:43
 * 修改备注：https://www.baidu.com/link?url=_-CNE5QiCJ1-izfAJJBW9Xs0F26d8xpd5AEEZ1cUQe2osyRfv67mjenH7Rj-oI8qKpT7XP-JkG05oxZzlNBKqa&wd=&eqid=b12c1ea900099492000000025ac33d36
 */
public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_top)
    TextView tv_top;
    @BindView(R.id.top_divider)
    View top_Divider;
    @BindView(R.id.ll_top)
    LinearLayout ll_top;


    private int height;
    private int currentPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        RelistAdapter adapter=new RelistAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                height=ll_top.getHeight();

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view=linearLayoutManager.findViewByPosition(currentPosition+1);
                if (view==null)return;

                if (view.getTop()<=height){
                    ll_top.setY(-(height-view.getTop()));
                }else {
                    ll_top.setY(0);
                }


                if (currentPosition!=linearLayoutManager.findFirstVisibleItemPosition()){
                    currentPosition=linearLayoutManager.findFirstVisibleItemPosition();
                    ll_top.setY(0);

//                    tv_top.setText(" "+currentPosition);
                }
            }
        });

    }
}
