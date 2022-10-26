package com.zww.music_mvvm.ui.home;

import androidx.lifecycle.SavedStateHandle;

import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.DailySongsBean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;

import io.reactivex.Observable;

public class DailySongsViewModel extends BaseViewModel {
    private SavedStateHandle state;

    public DailySongsViewModel(SavedStateHandle state) {
        this.state = state;
    }

    public Observable<DailySongsBean> getDailySongs(){
        return RetrofitUtils.getmApi().getDailySongs();
    }
}
