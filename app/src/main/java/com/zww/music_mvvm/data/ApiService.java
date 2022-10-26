package com.zww.music_mvvm.data;


import androidx.lifecycle.LiveData;

import com.tobery.livedata.call.livedatalib.ApiResponse;
import com.zww.music_mvvm.data.bean.DailySongsBean;
import com.zww.music_mvvm.data.bean.HomeDiscoverBean;
import com.zww.music_mvvm.data.bean.Login_Bean;
import com.zww.music_mvvm.data.bean.LyricBean;
import com.zww.music_mvvm.data.bean.RecentSongInfoBean;
import com.zww.music_mvvm.data.bean.RecommendListBean;
import com.zww.music_mvvm.data.bean.VipInfoBean;
import com.zww.music_mvvm.data.bean.banner_bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("login/cellphone")
    Observable<Login_Bean> login(@Query("phone")String phone, @Query("password")String password);
    /**
     * 轮播图*/
    @GET("banner")
    Observable<banner_bean> getBanner(@Query("type") int type);
    /**
     * 每日推荐歌单
     */
    @GET("recommend/resource")
    Observable<RecommendListBean> getRecommendPlayList();

    @GET("homepage/block/page")  //首页发现
    Observable<HomeDiscoverBean> requireHomeDiscover(@Query("refresh") Boolean start);

    @GET("vip/info")//vip信息
    Observable<VipInfoBean> getVipInfo();

    @GET("record/recent/song")// 最近播放音乐
    Observable<RecentSongInfoBean> getRecentSong(@Query("limit") int limit);

    @GET("recommend/songs")  // 每日推荐
    Observable<DailySongsBean> getDailySongs();

    @GET("lyric") //获取歌词
    Observable<LyricBean> getLyric(@Query("id") long songId);

}
