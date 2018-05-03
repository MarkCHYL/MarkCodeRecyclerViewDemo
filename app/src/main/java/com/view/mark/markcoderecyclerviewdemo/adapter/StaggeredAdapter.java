package com.view.mark.markcoderecyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.view.mark.markcoderecyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：MarkCodeRecyclerViewDemo
 * 类描述：瀑布流适配器
 * Created by mark on 2018/5/2 20:34
 * 修改人：mark
 * 修改时间：2018/5/2 20:34
 * 修改备注：
 */
public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> imgUrlList;
    private RequestOptions options;
    private List<Integer> heights = new ArrayList<>();
    private StaggeredGridLayoutManager.LayoutParams layoutParams;

    public StaggeredAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.imgUrlList = list;
        Random random = new Random();
        for (int i = 0; i < imgUrlList.size(); i++) {
            int x=random.nextInt(200) + 200;
            heights.add(x);
        }
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = null;
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        if (viewHolder == null) {
            viewHolder = new MyViewHolder(itemView);
//            options = new RequestOptions()
//                    .placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        String idStr = "第" + (position + 1) + "张";
        holder.imgId.setText(idStr);
        int errorImg = R.drawable.ic_launcher;
        layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        layoutParams.height = heights.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        Glide.with(mContext).load(imgUrlList.get(position)).into(holder.imgShow);

        holder.imgShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onClick(holder, position);
                }
            }
        });

        holder.imgShow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemLongClickListener != null) {
                    mOnItemLongClickListener.onLongClick(holder, position);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgUrlList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        return heights.get(position);
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }


    public interface OnItemClickListener {
        void onClick(RecyclerView.ViewHolder VH, int position);
    }

    interface OnItemLongClickListener {
        void onLongClick(RecyclerView.ViewHolder VH, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_show)
        ImageView imgShow;
        @BindView(R.id.img_id)
        TextView imgId;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}


