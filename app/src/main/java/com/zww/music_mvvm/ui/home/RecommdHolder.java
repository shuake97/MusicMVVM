package com.zww.music_mvvm.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zww.music_mvvm.R;
import com.zww.music_mvvm.databinding.ItemRecommdBinding;

public class RecommdHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView tvName,tvNum;

    public RecommdHolder(ItemRecommdBinding binding) {
        super(binding.getRoot());
        imageView = binding.ivRecomm;// itemView.findViewById(R.id.iv_recomm);
        tvName = binding.tvRecommlistName;//itemView.findViewById(R.id.tv_recommlist_name);
        tvNum = binding.tvPlaycount;//itemView.findViewById(R.id.tv_playcount);

    }
}
