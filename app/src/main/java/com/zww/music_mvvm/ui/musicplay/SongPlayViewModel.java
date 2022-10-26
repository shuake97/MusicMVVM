package com.zww.music_mvvm.ui.musicplay;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.SavedStateHandle;

import com.tobery.musicplay.MusicPlay;
import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.LyricBean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;
import com.zww.music_mvvm.ui.user.UserInfoUi;

import io.reactivex.Observable;

public class SongPlayViewModel extends BaseViewModel {

    private SavedStateHandle state;

    public UserInfoUi ui;

    private String userInfo;

    public Boolean isShowLrc = false;

    public ObservableField<String> currentSongUrl = new ObservableField<>("");

    public ObservableLong currentSongId = new ObservableLong();

    public SongPlayViewModel(SavedStateHandle savedStateHandle) {
        this.state = savedStateHandle;
    }

    public Observable<LyricBean> getLyric(){
        return RetrofitUtils.getmApi().getLyric(currentSongId.get());
    }

    public void musicPlayOrPause(){
        if (MusicPlay.isPlaying()){
            MusicPlay.pauseMusic();
        }else {
            MusicPlay.restoreMusic();
        }
    }

    // 下一首
    public void next(){
        MusicPlay.skipToNext();
    }
    // 上一首
    public void previous(){
        MusicPlay.skipToPrevious();
    }

}
