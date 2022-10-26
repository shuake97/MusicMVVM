package com.zww.music_mvvm.ui;

import static com.zww.music_mvvm.data.Config.Constant.SONG_URL;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.navigation.NavigationBarView;
import com.hjq.toast.ToastUtils;
import com.tobery.musicplay.MusicPlay;
import com.tobery.musicplay.OnMusicPlayStateListener;
import com.tobery.musicplay.entity.MusicInfo;
import com.tobery.musicplay.entity.PlayManger;
import com.tobery.musicplay.util.PermissionChecks;
import com.tobery.musicplay.util.ViewExtensionKt;
import com.zww.music_mvvm.AppManager;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.data.bean.RecentSongInfoBean;
import com.zww.music_mvvm.data.retrofit.RXHelper;
import com.zww.music_mvvm.databinding.ActivityMainBinding;
import com.zww.music_mvvm.ui.adapter.ViewPagerAdapterForNav;
import com.zww.music_mvvm.ui.community.CommunityFragment;
import com.zww.music_mvvm.ui.home.HomeFragment;
import com.zww.music_mvvm.ui.mv.MvFragment;
import com.zww.music_mvvm.ui.user.MineFragment;
import com.zww.music_mvvm.utils.ClickUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import java.util.ArrayList;
import java.util.List;
import android.Manifest;
@Route(path = Config.ROUTE_HOME)
public class MainActivity extends BaseActivity implements NavigationBarView.OnItemSelectedListener {

    private MainViewModel viewMode;
    private ActivityMainBinding binding;
    ViewPagerAdapterForNav pageAdapter;
    private List<Fragment> mFragments;
    PermissionChecks checks;  //音乐播放器权限检测
    private long firstTime = 0;

    private final String[] APP_PERMISSIONS = new ArrayList<String>(){
        {
            add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            add(Manifest.permission.READ_EXTERNAL_STORAGE);
            add(Manifest.permission.RECORD_AUDIO);
            add(Manifest.permission.READ_PHONE_STATE);
        }
    }.toArray(new String[0]);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        viewMode = new ViewModelProvider(this).get(MainViewModel.class);
//        binding.setLifecycleOwner(this);
        mlifecycle.addObserver(viewMode);
        checks = new PermissionChecks(this);
        initView();
        initBottomBar();
        initObserver();

    }

    private void initBottomBar() {
        viewMode.getRecentSong()//.compose(RXHelper.observableIO2Main(getApplicationContext()))
                .subscribe(new StaticMethodUtils.OnCallback<RecentSongInfoBean>(){
                    @Override
                    public void onNext(RecentSongInfoBean recentSongInfoBean) {
                        super.onNext(recentSongInfoBean);
                        RecentSongInfoBean.RecentDataEntity.ListBean.DataBean data =
                                recentSongInfoBean.getData().getList().get(0).getData();
                        viewMode.currentSongName.set(data.getName());
                        viewMode.currentSongUrl.set(data.getAl().getPicUrl());
                        MusicInfo musicInfo = new MusicInfo();
                        musicInfo.setArtist(data.getAr().get(0).getName());
                        musicInfo.setSongId(data.getId()+"");
                        musicInfo.setSongName(data.getName());
                        musicInfo.setSongCover(data.getAl().getPicUrl());
                        musicInfo.setSongUrl(SONG_URL+data.getId());
                        viewMode.currentMusicInfo = musicInfo;
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });

//        // 音乐播放器
//        MusicPlay.onPlayStateListener(this, new OnMusicPlayStateListener() {
//            @Override
//            public void onPlayState(@NonNull PlayManger playManger) {
//                viewMode.currentSongUrl.set(playManger.getSongInfo().getSongCover());
//                viewMode.currentSongName.set(playManger.getSongInfo().getSongName());
//                switch (playManger.getStage()){
//                    case PlayManger.PAUSE:
//                    case PlayManger.IDLE:
//                        binding.songBar.ivBottomPlay.setImageResource(R.drawable.shape_play);
//                        break;
//                    case PlayManger.PLAYING:
//                        binding.songBar.ivBottomPlay.setImageResource(R.drawable.shape_pause_black);
//                        viewMode.currentMusicInfo = playManger.getSongInfo();
//                        break;
//                    case PlayManger.BUFFERING:
//                        ViewExtensionKt.printLog("缓冲");
//                        break;
//                    case PlayManger.SWITCH:
//                        viewMode.currentMusicInfo = playManger.getSongInfo();
//                        break;
//                }
//            }
//        });

        binding.songBar.rootBottomBar.setOnClickListener(view ->{
            if (ClickUtil.enableClick() && viewMode.currentMusicInfo !=null){
                MusicPlay.playMusicByInfo(viewMode.currentMusicInfo);
                // 跳转到听歌activity
//                startActivity(new Intent(this));
            }
        });
        //播放音乐按钮
        binding.songBar.ivBottomPlay.setOnClickListener(view ->{
            if (MusicPlay.isPlaying()){
                MusicPlay.pauseMusic();
            }else if (MusicPlay.isPaused()){
                MusicPlay.restoreMusic();
            }else {
                MusicPlay.playMusicByInfo(viewMode.currentMusicInfo);
            }
        });

    }

    private void initView(){
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new MvFragment());
        mFragments.add(new CommunityFragment());
        mFragments.add(new MineFragment());

        binding.viewpage2.setUserInputEnabled(false); //禁止滑动
        pageAdapter = new ViewPagerAdapterForNav(getSupportFragmentManager(), mlifecycle, mFragments);
        binding.viewpage2.setAdapter(pageAdapter);
        binding.viewpage2.setOffscreenPageLimit(4);
        binding.botNav.setOnItemSelectedListener(this);
        binding.viewpage2.registerOnPageChangeCallback(onPageChange);
    }
    private ViewPager2.OnPageChangeCallback onPageChange = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            binding.botNav.getMenu().getItem(position).setChecked(true);
//            tonPageSelected(position);
        }
    };



    private void initObserver() {
    }

    @Override
    protected View getDataBind() {
        return binding.getRoot();
    }

    //    nav 的选择  名字不能重复tonPageSelected
    public void tonPageSelected(int position){
        switch (position){
            case 0:
                binding.botNav.setSelectedItemId(R.id.home);
                break;
            case 1:
                binding.botNav.setSelectedItemId(R.id.mv);
                break;
            case 2:
                binding.botNav.setSelectedItemId(R.id.community);
                break;
            case 3:
                binding.botNav.setSelectedItemId(R.id.mine);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                binding.viewpage2.setCurrentItem(0);
                break;
            case R.id.mv:
                binding.viewpage2.setCurrentItem(1);
                break;
            case R.id.community:
                binding.viewpage2.setCurrentItem(2);
                break;
            case R.id.mine:
                binding.viewpage2.setCurrentItem(3);
                break;
            default:
                break;
        }
        return true;
    }

    @SuppressLint("NewApi")   //？what's mean
    private void setDrawMenu(){
        binding.homeTopLeftBtn.setOnClickListener(v -> {
            if (ClickUtil.enableClick()){
                binding.homeDrawerMenu.openDrawer(GravityCompat.START);  //打开抽屉
            }
        });
//        抽屉锁定模式
        binding.homeDrawerMenu.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        binding.homeDrawerMenu.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                binding.homeDrawerMenu.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.viewpage2.unregisterOnPageChangeCallback(onPageChange);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(binding.homeDrawerMenu.isDrawerOpen(GravityCompat.START)){
            binding.homeDrawerMenu.closeDrawer(GravityCompat.START);
        }else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP){
//            long secondTime = System.currentTimeMillis();
//            if (secondTime - firstTime >2000){
//                ToastUtils.show("再按一次退出程序");
//                firstTime = secondTime;
//                return true;
//            }else {
//                AppManager.getAppManager().AppExit();
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}