package com.view.mark.markcoderecyclerviewdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.view.mark.markcoderecyclerviewdemo.R;
import com.view.mark.markcoderecyclerviewdemo.adapter.StaggeredAdapter;
import com.view.mark.markcoderecyclerviewdemo.utils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：MarkCodeRecyclerViewDemo
 * 类描述：瀑布流实现
 * Created by mark on 2018/5/2 20:12
 * 修改人：mark
 * 修改时间：2018/5/2 20:12
 * 修改备注：
 */
public class StaggeredGridViewLayoutActivity extends AppCompatActivity {

    @BindView(R.id.staggered_rv)
    RecyclerView staggeredRv;
    private StaggeredAdapter adapter;
    private Context mContext;
    private StaggeredGridLayoutManager layoutManager;
    //图片链接
    private String[] mDatas={
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2056059545,3075726884&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1240426408,3396216424&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1765208127,2618259413&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1447507835,3654535229&fm=27&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2716881984,3272848008&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4056436047,3626959226&fm=27&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519994047809&di=5b646d6c9d8fca47ff0749aeebf46fba&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201407%2F20%2F20140720201056_HmZ4d.jpeg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1286656969,4109636359&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1928187901,3300785708&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3941443566,3889552161&fm=27&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519994047808&di=af68834c33967cd6a82bd047fbf8f809&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201310%2F23%2F20131023105257_zNeA3.jpeg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1820318310,3796454650&fm=27&gp=0.jpg",
            "http://img07.tooopen.com/images/20170316/tooopen_sy_201956178977.jpg",
            "http://img.zcool.cn/community/01638059302785a8012193a36096b8.jpg@2o.jpg",
            "http://pic71.nipic.com/file/20150610/13549908_104823135000_2.jpg",
            "http://pic2.nipic.com/20090424/1242397_110033072_2.jpg",
            "http://pic2.ooopic.com/12/22/95/08bOOOPICe2_1024.jpg",
            "http://img05.tooopen.com/images/20140326/sy_57640132134.jpg",
            "http://www.taopic.com/uploads/allimg/140421/318743-140421213T910.jpg",
            "http://news.cnhubei.com/ctjb/ctjbsgk/ctjb40/200808/W020080822221006461534.jpg",
            "http://img3.redocn.com/tupian/20150430/mantenghuawenmodianshiliangbeijing_3924704.jpg",
            "http://d.hiphotos.baidu.com/zhidao/pic/item/72f082025aafa40fe871b36bad64034f79f019d4.jpg",
            "http://pic40.nipic.com/20140424/13846002_113008517141_2.jpg",
            "http://i9.download.fd.pchome.net/t_960x600/g1/M00/0B/10/oYYBAFQlOmuIZDQRAALvMZ8mYRIAAB9HAKQEtcAAu9J875.jpg",
            "http://img2.imgtn.bdimg.com/it/u=834235734,679217072&fm=27&gp=0.jpg"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_layout);
        ButterKnife.bind(this);
        mContext = this;

        //初始化
        initView();
    }

    private void initView() {
        staggeredRv.setHasFixedSize(true);
        layoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //item之间互换位置的情况解决
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        staggeredRv.setLayoutManager(layoutManager);
        adapter = new StaggeredAdapter(mContext, getData());
        staggeredRv.setAdapter(adapter);
//        staggeredRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                layoutManager.invalidateSpanAssignments();
////                adapter.notifyItemChanged(0);
//            }
//        });
//        staggeredRv.addItemDecoration(
//                new GridSpacingItemDecoration(2, 10, true));
//        staggeredRv.setItemAnimator(new DefaultItemAnimator());
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        adapter.setOnItemClickListener(new StaggeredAdapter.OnItemClickListener() {
            @Override
            public void onClick(RecyclerView.ViewHolder VH, int position) {
                Toast.makeText(mContext,
                        "你大爷的点击了" + (position + 1) + "萌宠"
                        , Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(mDatas);
        return list;
    }

}
