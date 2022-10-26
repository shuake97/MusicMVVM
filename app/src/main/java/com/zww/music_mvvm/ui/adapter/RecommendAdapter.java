package com.zww.music_mvvm.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.RecommendSQ;
import com.zww.music_mvvm.databinding.ItemRecommdBinding;
import com.zww.music_mvvm.ui.home.RecommdHolder;

import java.util.ArrayList;
import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommdHolder>{
    private final List<RecommendSQ> dataList = new ArrayList<>();
    private Context mContext;

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

    public RecommendAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecommdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecommdBinding binding = ItemRecommdBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecommdHolder(binding);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setDataList(List<RecommendSQ> data){
        dataList.clear();
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecommdHolder holder, int position) {
        RecommendSQ bean = dataList.get(position);
        holder.tvName.setText(bean.getName());
        holder.tvNum.setText(bean.getPlaycount()+"");
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.loading)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .transform(new CenterCrop(),new RoundedCorners(10))
                .error(R.mipmap.ic_launcher);
        Glide.with(mContext)
                .load(bean.getPicUrl())
                .transition(new DrawableTransitionOptions().crossFade())
                .apply(options)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

interface OnItemClick {
    void onClick();
}
