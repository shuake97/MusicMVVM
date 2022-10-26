package com.zww.music_mvvm.ui.user;

import androidx.lifecycle.LiveData;

import com.tobery.livedata.call.livedatalib.ApiResponse;
import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.VipInfoBean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;

import io.reactivex.Observable;

public class MineFragmentViewModel extends BaseViewModel {

    public Observable<VipInfoBean> getVipInfo(){
        return RetrofitUtils.getmApi().getVipInfo();
    }
}
