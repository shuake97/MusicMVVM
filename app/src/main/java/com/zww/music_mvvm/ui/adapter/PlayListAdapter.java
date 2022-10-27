package com.zww.music_mvvm.ui.adapter;

import static com.zww.music_mvvm.data.Config.Constant.MUSIC_INFO;
import static com.zww.music_mvvm.data.Config.Constant.SONG_URL;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tobery.musicplay.MusicPlay;
import com.tobery.musicplay.entity.MusicInfo;
import com.zww.music_mvvm.data.bean.PlaylistBean;
import com.zww.music_mvvm.data.bean.RecommendListBean;
import com.zww.music_mvvm.databinding.ItemMinePlayListBinding;
import com.zww.music_mvvm.ui.home.RecommdHolder;
import com.zww.music_mvvm.ui.home.playlist.MinePlayListViewModel;
import com.zww.music_mvvm.ui.musicplay.CurrentSongPlayActivity;
import com.zww.music_mvvm.utils.ClickUtil;

public class PlayListAdapter extends ListAdapter<PlaylistBean.PlaylistEntity.TracksEntity,PlayListViewHolder> {
    private final Context mContext;

    public PlayListAdapter(Context mContext) {
        super(new playItemCallback());
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public PlayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMinePlayListBinding binding = ItemMinePlayListBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlayListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayListViewHolder holder, int position) {
        PlaylistBean.PlaylistEntity.TracksEntity bean = getItem(position);
        holder.tvSongName.setText(bean.getName());
        String singerName = bean.getAr().get(0).getName()+"-"+bean.getAl().getName();
        holder.tvSinger.setText(singerName);
        holder.tvNum.setText(String.valueOf(position+1));
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.setSongUrl(SONG_URL+bean.getId());
        musicInfo.setSongId(String.valueOf(bean.getId()));
        musicInfo.setSongName(bean.getName());
        musicInfo.setArtist(bean.getAr().get(0).getName());
        musicInfo.setSongCover(bean.getAl().getPicUrl());
        if (bean.getAlia() != null && bean.getAlia().size() != 0){
            String alias = "(" + bean.getAlia().get(0)+")";
            holder.tvAlias.setText(alias);
        }
        if (bean.getFee() == 1){//1表示vip歌曲

        }
        if (bean.getSq() != null){//表示该歌曲有SQ版本

        }
        if (bean.getHr() != null){//表示有hi版

        }
        holder.itemView.setOnClickListener(view->{
            if (ClickUtil.enableClick()){
                MusicPlay.playMusicByInfo(musicInfo);
                mContext.startActivity(new Intent(
                        mContext, CurrentSongPlayActivity.class
                ).putExtra(MUSIC_INFO,musicInfo));
            }
        });
    }



}
class PlayListViewHolder extends RecyclerView.ViewHolder {
    TextView tvSongName,tvSinger,tvNum,tvAlias;
    public PlayListViewHolder( ItemMinePlayListBinding binding) {
        super(binding.getRoot());
        tvSongName = binding.tvSongName;
        tvSinger = binding.tvSinger;
        tvNum = binding.tvNumber;
        tvAlias = binding.tvAlias;
    }
}

class playItemCallback extends DiffUtil.ItemCallback<PlaylistBean.PlaylistEntity.TracksEntity>{

    @Override
    public boolean areItemsTheSame(@NonNull PlaylistBean.PlaylistEntity.TracksEntity oldItem, @NonNull PlaylistBean.PlaylistEntity.TracksEntity newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull PlaylistBean.PlaylistEntity.TracksEntity oldItem, @NonNull PlaylistBean.PlaylistEntity.TracksEntity newItem) {
        return oldItem.getId() == newItem.getId();
    }


}

