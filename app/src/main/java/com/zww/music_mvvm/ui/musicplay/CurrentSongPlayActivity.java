package com.zww.music_mvvm.ui.musicplay;

import static com.zww.music_mvvm.data.Config.Constant.MUSIC_INFO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.ViewModelProvider;
import androidx.palette.graphics.Palette;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.hjq.toast.ToastUtils;
import com.tobery.musicplay.MusicPlay;
import com.tobery.musicplay.OnMusicPlayProgressListener;
import com.tobery.musicplay.OnMusicPlayStateListener;
import com.tobery.musicplay.SpConstant;
import com.tobery.musicplay.entity.MusicInfo;
import com.tobery.musicplay.entity.PlayManger;
import com.tobery.musicplay.util.ViewExtensionKt;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.LyricBean;
import com.zww.music_mvvm.databinding.ActivityCurrentSongPlayBinding;
import com.zww.music_mvvm.utils.ClickUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;
import com.zww.music_mvvm.utils.StatusBarUtil;
import com.zww.music_mvvm.utils.TimeUtil;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class CurrentSongPlayActivity extends AppCompatActivity {

    private ActivityCurrentSongPlayBinding binding;
    private ObjectAnimator rotationAnim;
    private MusicInfo musicInfo;
    private SongPlayViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityCurrentSongPlayBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SongPlayViewModel.class);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);
        initView();
        initAnim();
        initObserver();
    }

    //获取歌词
    private void initObserver(){
        //加载歌词
        viewModel.getLyric().subscribe(new StaticMethodUtils.OnCallback<LyricBean>(){
            @Override
            public void onNext(LyricBean lyricBean) {  // 获取歌词
                super.onNext(lyricBean);
                ViewExtensionKt.printLog("当前");
                if (lyricBean.getLrc() != null){
                    if (lyricBean.getTlyric() != null){
                        binding.lrc.loadLrc(lyricBean.getLrc().getLyric(),lyricBean.getTlyric().getLyric());
                    } else {
                        binding.lrc.loadLrc(lyricBean.getLrc().getLyric(),"");
                    }
                }else {
                    binding.lrc.loadLrc("","");
                }
            }
            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }

    //获取视图，点击事件绑定
    private void initView(){
        musicInfo = getIntent().getParcelableExtra(MUSIC_INFO);
        initImageBg(musicInfo);
        initListener();
        binding.viewBody.setOnClickListener(view ->{
            if (ClickUtil.enableClick()){
                viewModel.isShowLrc = !viewModel.isShowLrc;
                showLyrics(viewModel.isShowLrc);
            }
        });
        //移动歌曲进度
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                MusicPlay.seekTo(seekBar.getProgress(),true);
                binding.lrc.updateTime(seekBar.getProgress());
            }
        });
        //修改模式
        binding.ivPlayMode.setOnClickListener(v->{
            if (ClickUtil.enableClick()){
                changeRepeatMode();
            }
        });
        binding.lrc.setListener(time -> {
            MusicPlay.seekTo(time,true);
            return true;
        });
        binding.lrc.setCoverChangeListener(()->{
            viewModel.isShowLrc = false;
            showLyrics(false);
        });
    }


    private void initImageBg(MusicInfo musicInfo){
        viewModel.currentSongUrl.set(musicInfo.getSongCover());
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .bitmapTransform(new BlurTransformation(25,30));
        viewModel.currentSongId.set(Long.parseLong(musicInfo.getSongId()));
        initObserver();
        Glide.with(this)
                .asBitmap()
                .load(musicInfo.getSongCover())  //音乐封面
                .transition(BitmapTransitionOptions.withCrossFade(1500))
                .apply(options)
                .into(new SimpleTarget<Bitmap>() {
                    @Override  //资源准备好了，
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        binding.imgBc.setImageBitmap(resource);   //设定Bitmap
                        // 状态栏设定为透明
                        StatusBarUtil.setTranslucentForImageView(CurrentSongPlayActivity.this,0,binding.viewTitleBg);
                        //这个函数的作用需要弄清楚 （调色板，用于利用提取图片颜色设定给状态栏，使得ui效果更加美观）
                        Palette.from(resource).setRegion(0,0,getScreenWidth(),getStatusBarHeight())
                                .maximumColorCount(6)
                                .generate(palette -> {
                                    Palette.Swatch mostPopularSwatch = null;
                                    for(Palette.Swatch swatch : palette.getSwatches()){
                                        if (mostPopularSwatch == null || swatch.getPopulation() > mostPopularSwatch.getPopulation()){
                                            mostPopularSwatch = swatch;
                                        }
                                    }
                                    if (mostPopularSwatch != null){
                                        double luminance = ColorUtils.calculateLuminance(mostPopularSwatch.getRgb());
                                        //当luminance小于0.5时，认为这是一个深色值，
                                        if (luminance < 0.5){
                                            setDarkStatusBar();
                                        }else {
                                            setLightStatusBar();
                                        }
                                    }
                                });
                    }
                });
        binding.tvTitle.setText(musicInfo.getSongName());
        binding.tvSinger.setText(musicInfo.getSongName());
    }

    private int getScreenWidth(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);  //
        return displayMetrics.widthPixels;
    }

    private int getStatusBarHeight(){
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0){
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void initListener(){
        MusicPlay.onPlayStateListener(this, new OnMusicPlayStateListener() {
            @Override
            public void onPlayState(@NonNull PlayManger playManger) {
                switch (playManger.getStage()){
                    case PlayManger.PAUSE:
                    case PlayManger.IDLE:
                        rotationAnim.pause();
                        binding.ivPlay.setImageResource(R.drawable.shape_play_white);
                        break;
                    case PlayManger.PLAYING:
//                        resumeRotateAnimation();
                        rotationAnim.start();  //动画开始
                        binding.ivPlay.setImageResource(R.drawable.shape_play_white);
                        break;
                    case PlayManger.BUFFERING:
                        ViewExtensionKt.printLog("缓冲");
                        break;
                    case PlayManger.SWITCH:
                        if (playManger.getSongInfo() != null){
                            initImageBg(playManger.getSongInfo());
                        }
                        break;
//                    case PlayManger.ERROR:
//                        MusicInfo musicInfo = playManger.getSongInfo();
//                        int index = MusicPlay.getNowPlayingIndex();
//                        ViewExtensionKt.printLog("当前下标" + index + "");
//                        viewModel.getSongInfo()
                }
            }
        });
        MusicPlay.onPlayProgressListener(new OnMusicPlayProgressListener() {
            @Override
            public void onPlayProgress(long curP, long duration) {
                if (binding.seekBar.getMax() != duration){
                    binding.seekBar.setMax((int) duration);
                    binding.tvTotalTime.setText(TimeUtil.getTimeNoYMDH(curP));
                    binding.lrc.updateTime(curP);
                    binding.seekBar.setProgress((int) curP);
                }
            }
        });
    }

    // 根据isShowLyrics来判断是否显示歌词
    private void showLyrics(boolean isShowLyrics) {
        binding.ivMusicCover.setVisibility(isShowLyrics ? View.GONE : View.VISIBLE);
        binding.lrc.setVisibility(isShowLyrics ? View.VISIBLE : View.GONE);
    }

    //使得状态栏图标黑
    private void setLightStatusBar(){
        binding.tvTitle.setTextColor(getColor(R.color.black80));
        binding.tvSinger.setTextColor(getColor(R.color.black70));
        int flag = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(flag | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void setDarkStatusBar(){
        binding.tvTitle.setTextColor(getColor(R.color.white));
        binding.tvSinger.setTextColor(getColor(R.color.white80));
        int flag = getWindow().getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        getWindow().getDecorView().setSystemUiVisibility(flag ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void changeRepeatMode(){  //更换播放模式
        int currentModel = MusicPlay.getRepeatMode();
        switch (currentModel){
            case SpConstant.REPEAT_MODE_NONE:
                MusicPlay.setRepeatMode(SpConstant.REPEAT_MODE_ONE,true);
                ToastUtils.show(getString(R.string.repeat_one));
                break;
            case SpConstant.REPEAT_MODE_ONE:
                MusicPlay.setRepeatMode(SpConstant.REPEAT_MODE_SHUFFLE,false);
                ToastUtils.show(getString(R.string.repeat_random));
                break;
            case SpConstant.REPEAT_MODE_SHUFFLE:
                MusicPlay.setRepeatMode(SpConstant.REPEAT_MODE_NONE,true);
                ToastUtils.show(getString(R.string.repeat_none));
                break;

        }
    }
    //动画初始化
    private void initAnim(){
        rotationAnim = ObjectAnimator.ofFloat(binding.ivMusicCover,"rotation",360f);
        rotationAnim.setDuration(25 * 1000);
        rotationAnim.setInterpolator(new LinearInterpolator());
        rotationAnim.setRepeatCount(100000);  //重复次数
        rotationAnim.setRepeatMode(ValueAnimator.RESTART); //重复模式
        rotationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                rotationAnim.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rotationAnim.cancel();
        rotationAnim.removeAllListeners();
        rotationAnim = null;
    }
}