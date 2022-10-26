package com.zww.music_mvvm.ui.home;

import com.zww.music_mvvm.data.bean.BannerExtInfoEntity;
import com.zww.music_mvvm.data.bean.HomeDiscoverBean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;

import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;

public class DiscoverHomeFragmentViewModel {
    public String data = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "";
    public BannerExtInfoEntity bannerList;

    public List<HomeDiscoverBean.DataBean.BlocksBean.CreativesBean> recommendList;

    public List<HomeDiscoverBean.DataBean.BlocksBean.CreativesBean> selfMgcList;

    public Observable<HomeDiscoverBean> requireDiscover (Boolean refresh){
        return RetrofitUtils.getmApi().requireHomeDiscover(refresh);
    }
}
