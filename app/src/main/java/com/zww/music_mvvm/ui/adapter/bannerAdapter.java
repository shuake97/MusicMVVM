package com.zww.music_mvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.adapter.BannerAdapter;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.BannerSQ;
import com.zww.music_mvvm.ui.home.TitleHolder;

import java.util.List;

public class bannerAdapter extends BannerAdapter<BannerSQ, TitleHolder> {
    public Context mContext;

    public bannerAdapter(List<BannerSQ> datas) {
        super(datas);
//        mContext = fragment.getActivity();
    }

    @Override
    public TitleHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new TitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_title_image,parent,false));
    }

    @Override
    public void onBindView(TitleHolder holder, BannerSQ data, int position, int size) {
        Glide.with(holder.imageView)
                .load(data.getPic())
                .thumbnail(Glide.with(holder.itemView)
                        .load(R.mipmap.loading))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.imageView);
        holder.textView.setText(data.getTypeTitle());
//        holder.textView.setTextColor(data.getTitleColor().equals("red")?mContext.getResources().getColor(R.color.red):mContext.getResources().getColor(R.color.blue));
    }



}


