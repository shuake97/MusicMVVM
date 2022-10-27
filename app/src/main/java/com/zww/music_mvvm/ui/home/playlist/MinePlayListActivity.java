package com.zww.music_mvvm.ui.home.playlist;

import static com.zww.music_mvvm.data.Config.Constant.MUSIC_INFO;
import static com.zww.music_mvvm.data.Config.Constant.PLAYLIST_ID;
import static com.zww.music_mvvm.data.Config.Constant.PLAY_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tobery.musicplay.MusicPlay;
import com.tobery.musicplay.entity.MusicInfo;
import com.tobery.musicplay.util.ViewExtensionKt;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.PlaylistBean;
import com.zww.music_mvvm.data.retrofit.RXHelper;
import com.zww.music_mvvm.databinding.ActivityMinePlayListBinding;
import com.zww.music_mvvm.ui.adapter.PlayListAdapter;
import com.zww.music_mvvm.ui.musicplay.CurrentSongPlayActivity;
import com.zww.music_mvvm.utils.ClickUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import java.util.ArrayList;

public class MinePlayListActivity extends BaseActivity {
    private ActivityMinePlayListBinding binding;
    private MinePlayListViewModel viewModel;
    private PlayListAdapter adapter;
    private ArrayList<MusicInfo> songList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMinePlayListBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MinePlayListViewModel.class);
        viewModel.currentPlayId = getIntent().getLongExtra(PLAYLIST_ID,0L);
        loadGif();
        initRecycle();
        initObserver();
        initView();
    }

    private void initObserver() {
        viewModel.getPlayList().compose(RXHelper.observableIO2Main(this)).subscribe(new StaticMethodUtils.OnCallback<PlaylistBean>(){
            @Override
            public void onNext(PlaylistBean playlistBean) {
                super.onNext(playlistBean);
                binding.content.imgLoading.setVisibility(View.GONE); //图片加载中
                //将网络中得到的数据列表转化为MusicInfo并将其添加到songList中，

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }

    private void initRecycle() {
        adapter = new PlayListAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.content.rvPlayList.setLayoutManager(manager);
        binding.content.rvPlayList.setAdapter(adapter);
        binding.content.rvPlayList.setHasFixedSize(true);  //

    }

    private void initView() {
        binding.content.rvPlayTop.setOnClickListener(v->{
            if (ClickUtil.enableClick() && songList.size()!=0){
                MusicPlay.playMusicByList(songList,0);
                startActivity(new Intent(this, CurrentSongPlayActivity.class).putExtra(MUSIC_INFO,songList.get(0)));
            }
        });
        binding.title.ivBack.setOnClickListener(v->{
            if (ClickUtil.enableClick()){
                finish();
            }
        });
        binding.title.tvTitle.setText(getIntent().getStringExtra(PLAY_NAME));
    }

    private void loadGif() {
        Glide.with(this)
                .asGif()
                .load(R.drawable.play_list_loading)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(binding.content.imgLoading);
    }
    //状态栏图标白
    private void setDrakStatusBar(){
        int flag = getWindow().getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;;
        getWindow().getDecorView().setSystemUiVisibility(flag ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

//  状态栏图标黑
    private void setLightStatusBar(){
        int flag = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(flag | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

//    获得屏幕宽度
    private int getScreenWidth(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }


    @Override
    protected View getDataBind() {
        return binding.getRoot();
    }


}