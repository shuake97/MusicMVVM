package com.zww.music_mvvm.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zww.music_mvvm.R;

public class TitleHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public TitleHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.bannerImage);
        textView = itemView.findViewById(R.id.bannerTitle);
    }
}
