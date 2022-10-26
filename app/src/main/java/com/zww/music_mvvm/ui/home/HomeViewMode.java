package com.zww.music_mvvm.ui.home;

import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.BannerExtInfoEntity;
import com.zww.music_mvvm.data.bean.HomeDiscoverBean;
import com.zww.music_mvvm.data.bean.RecommendListBean;
import com.zww.music_mvvm.data.bean.banner_bean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;

import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;

public class HomeViewMode extends BaseViewModel {
    public String date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "";
    public BannerExtInfoEntity bannerList;
    public List<HomeDiscoverBean.DataBean.BlocksBean.CreativesBean> recommendList;
    public List<HomeDiscoverBean.DataBean.BlocksBean.CreativesBean> selfMgcList;


    public Observable<HomeDiscoverBean> requireDiscover (Boolean refresh){
        return RetrofitUtils.getmApi().requireHomeDiscover(refresh);
    }
    public Observable<banner_bean> getBanner(int type){
        return RetrofitUtils.getmApi().getBanner(type);
    }

    public Observable<RecommendListBean> getRecommendList(){
        return RetrofitUtils.getmApi().getRecommendPlayList();
    }
}
