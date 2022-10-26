package com.zww.music_mvvm.ui.adapter;

import static com.zww.music_mvvm.data.Config.Constant.MUSIC_INFO;
import static com.zww.music_mvvm.data.Config.Constant.SONG_URL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tobery.musicplay.MusicPlay;
import com.tobery.musicplay.entity.MusicInfo;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.data.bean.DailySongsBean;
import com.zww.music_mvvm.databinding.ItemDailySongBinding;
import com.zww.music_mvvm.ui.musicplay.CurrentSongPlayActivity;
import com.zww.music_mvvm.utils.ClickUtil;

import java.util.ArrayList;
import java.util.List;

public class DailySongsAdapter extends RecyclerView.Adapter<DailySongsViewHolder> {

    private final List<DailySongsBean.DataBean.SongsBean> dataList = new ArrayList<>();
    private final List<DailySongsBean.DataBean.RecommendReasonsBean> resonList = new ArrayList<>();

    private Context mContext;

    public DailySongsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setDataList(List<DailySongsBean.DataBean.SongsBean> data,List<DailySongsBean.DataBean.RecommendReasonsBean> reason) {
        dataList.clear();
        dataList.addAll(data);
        resonList.clear();
        resonList.addAll(reason);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DailySongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDailySongBinding binding = ItemDailySongBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new DailySongsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DailySongsViewHolder holder, int position) {
        DailySongsBean.DataBean.SongsBean bean = dataList.get(position);
        holder.tvSongName.setText(bean.getName());
        holder.tvSinger.setText(bean.getAr().get(0).getName()+"-"+bean.getAl().getName());
        BindingAdapter.loadRadiusImage(holder.imgSong,bean.getAl().getPicUrl());
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.setSongUrl(SONG_URL+bean.getId());
        musicInfo.setSongId(String.valueOf(bean.getId()));
        String songName = bean.getName();
        if (bean.getTns() != null){  //外语翻译歌名
            songName += "(" + bean.getTns().get(0)+")";
        }

        musicInfo.setSongName(songName);
        musicInfo.setArtist(bean.getAr().get(0).getName());
        musicInfo.setSongCover(bean.getAl().getPicUrl());
        for (DailySongsBean.DataBean.RecommendReasonsBean data: resonList){
            if (data.getSongId() == bean.getId()){
                holder.tvRecommend.setText(data.getReason());
            }
        }
        if (bean.getFee() == 1){ //1 表示vip
            holder.tvVip.setVisibility(View.VISIBLE);
        }
        if (bean.getSq() != null){  // 表面该歌曲有SQ版本
            holder.tvSq.setVisibility(View.VISIBLE);
        }
        if (bean.getHr() != null){
            holder.tvSq.setText(mContext.getString(R.string.music_type_hi));
            holder.tvSq.setVisibility(View.VISIBLE);
        }
        holder.itemView.setOnClickListener(view->{
            if (ClickUtil.enableClick()){
                MusicPlay.playMusicByInfo(musicInfo);
                mContext.startActivity(new Intent(mContext, CurrentSongPlayActivity.class).putExtra(MUSIC_INFO,musicInfo));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }
}
class DailySongsViewHolder extends RecyclerView.ViewHolder {
    TextView tvSongName,tvSinger,tvRecommend,tvVip,tvSq;
    ImageView imgSong;

    public DailySongsViewHolder(ItemDailySongBinding binding) {
        super(binding.getRoot());
        tvSongName = binding.tvSongName;
        tvSinger = binding.tvSinger;
        imgSong = binding.imgSong;
        tvRecommend = binding.tvRecommend;
        tvVip = binding.tvVipFlag;
        tvSq = binding.tvMusicSq;
    }
}
