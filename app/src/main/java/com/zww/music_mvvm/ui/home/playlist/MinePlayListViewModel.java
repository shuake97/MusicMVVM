package com.zww.music_mvvm.ui.home.playlist;

import androidx.lifecycle.SavedStateHandle;

import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.PlaylistBean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;

import io.reactivex.Observable;

public class MinePlayListViewModel extends BaseViewModel {

    private SavedStateHandle state;

    public Long currentPlayId = 0L;

    public MinePlayListViewModel(SavedStateHandle state) {
        this.state = state;
    }

    public Observable<PlaylistBean> getPlayList(){
        return RetrofitUtils.getmApi().getPlayList(currentPlayId);
    }
}
