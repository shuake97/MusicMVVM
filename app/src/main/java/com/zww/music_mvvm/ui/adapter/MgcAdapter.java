package com.zww.music_mvvm.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.HomeDiscoverBean;
import com.zww.music_mvvm.databinding.ItemRecommdBinding;

import java.util.ArrayList;
import java.util.List;

public class MgcAdapter extends RecyclerView.Adapter<MgcViewHolder> {

    private final List<HomeDiscoverBean.DataBean.BlocksBean.CreativesBean> dataList = new ArrayList<>();

    private Context mContext;

    private OnItemClick onItemClick;

    public MgcAdapter(Context mContext) {
        this.mContext = mContext;
//        dataList = new ArrayList<>();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setDataList(List<HomeDiscoverBean.DataBean.BlocksBean.CreativesBean> data) {
        dataList.clear();
        if(data != null)
            dataList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override  //保存组件id，会对组件id做缓存来提升速度
    public MgcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecommdBinding binding =
                ItemRecommdBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MgcViewHolder(binding);
    }


    @SuppressLint("SetTextI18n")
    @Override  // 将数据绑定在对应的组件位置。
    public void onBindViewHolder(@NonNull MgcViewHolder holder, int position) {
        HomeDiscoverBean.DataBean.BlocksBean.CreativesBean bean = dataList.get(position);
        holder.tvTitle.setText(bean.getUiElement().getMainTitle().getTitle());
        holder.tvCount.setText(bean.getResources().get(0).getResourceExtInfo().getPlayCount()+"");
        BindingAdapter.loadRadiusImage(holder.imRecommend,bean.getUiElement().getImage().getImageUrl());
//        RequestOptions options = new RequestOptions()
//                .placeholder(R.mipmap.loading)
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                .transform(new CenterCrop(),new RoundedCorners(10))
//                .error(R.mipmap.ic_launcher);
//        Glide.with(mContext)
//                .load(bean.getUiElement().getImage().getImageUrl())
//                .transition(new DrawableTransitionOptions().crossFade())
//                .apply(options)
//                .into(holder.imRecommend);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MgcViewHolder extends RecyclerView.ViewHolder{
    TextView tvTitle,tvCount;
    ImageView imRecommend;

    public MgcViewHolder(ItemRecommdBinding binding){
        super(binding.getRoot());
        tvTitle = binding.tvRecommlistName;
        imRecommend = binding.ivRecomm;
        tvCount = binding.tvPlaycount;
    }
}
