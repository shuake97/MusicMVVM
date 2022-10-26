package com.zww.music_mvvm.ui.home;

import static com.zww.music_mvvm.data.Config.Constant.MUSIC_INFO;
import static com.zww.music_mvvm.data.Config.Constant.SONG_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tobery.musicplay.MusicPlay;
import com.tobery.musicplay.entity.MusicInfo;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.DailySongsBean;
import com.zww.music_mvvm.data.retrofit.RXHelper;
import com.zww.music_mvvm.databinding.ActivityDailySongsBinding;
import com.zww.music_mvvm.ui.adapter.DailySongsAdapter;
import com.zww.music_mvvm.ui.musicplay.CurrentSongPlayActivity;
import com.zww.music_mvvm.utils.ClickUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;
import com.zww.music_mvvm.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DailySongsActivity extends BaseActivity {

    private ActivityDailySongsBinding binding;

    private DailySongsViewModel viewModel;

    private DailySongsAdapter adapter;

    private ArrayList<MusicInfo> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityDailySongsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DailySongsViewModel.class);
        initRecycle();
        initView();
        initObserver();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorPrimary,null),0);
        binding.tvDay.setText(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + " ");
        binding.tvMonth.setText("/"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"");
        binding.title.ivBack.setOnClickListener(view ->{
            if (ClickUtil.enableClick()){
                finish();
            }
        });
        binding.rvPlayTop.setOnClickListener(v->{
            if (ClickUtil.enableClick()){    // 播放全部
                //   空数据处理
                MusicPlay.playMusicByList(songList,0);
                startActivity(new Intent(this, CurrentSongPlayActivity.class).putExtra(MUSIC_INFO,songList.get(0)));
            }
        });
    }

    private void initRecycle() {
        adapter = new DailySongsAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvDaily.setLayoutManager(manager);
        binding.rvDaily.setAdapter(adapter);
        binding.rvDaily.setHasFixedSize(true);
    }

    private void initObserver() {
        viewModel.getDailySongs().subscribe(new StaticMethodUtils.OnCallback<DailySongsBean>(){
            @Override
            public void onNext(DailySongsBean dailySongsBean) {
                super.onNext(dailySongsBean);
                adapter.setDataList(dailySongsBean.getData().getDailySongs(),dailySongsBean.getData().getRecommendReasons());
                for (DailySongsBean.DataBean.SongsBean data : dailySongsBean.getData().getDailySongs()){
                    MusicInfo musicInfo = new MusicInfo();
                    musicInfo.setSongUrl(SONG_URL+data.getId());
                    musicInfo.setSongId(String.valueOf(data.getId()));
                    String songName = data.getName();
                    if (data.getTns() != null){
                        songName += "(" + data.getTns().get(0)+")";
                    }
                    musicInfo.setSongName(songName);
                    musicInfo.setArtist(data.getAr().get(0).getName());
                    musicInfo.setSongCover(data.getAl().getPicUrl());
                    songList.add(musicInfo);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }



    @Override
    protected View getDataBind() {
        return binding.getRoot();
    }
}