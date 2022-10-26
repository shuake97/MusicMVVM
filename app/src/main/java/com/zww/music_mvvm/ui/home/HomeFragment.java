package com.zww.music_mvvm.ui.home;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.zww.music_mvvm.Base.BaseFragment;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.data.bean.BannerExtInfoEntity;
import com.zww.music_mvvm.data.bean.BannerSQ;
import com.zww.music_mvvm.data.bean.HomeDiscoverBean;
import com.zww.music_mvvm.data.bean.RecommendListBean;
import com.zww.music_mvvm.data.bean.RecommendSQ;
import com.zww.music_mvvm.data.bean.banner_bean;
import com.zww.music_mvvm.data.retrofit.RXHelper;
import com.zww.music_mvvm.databinding.FragmentHomeBinding;
import com.zww.music_mvvm.ui.MainActivity;
import com.zww.music_mvvm.ui.adapter.MgcAdapter;
import com.zww.music_mvvm.ui.adapter.bannerAdapter;
import com.zww.music_mvvm.ui.adapter.RecommendAdapter;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class HomeFragment extends BaseFragment {
    private FragmentHomeBinding binding;

    private HomeViewMode viewMode;

    private RecommendAdapter adapter;

    private MgcAdapter mgcAdapter;

    //    推荐歌单集合
    //修改为数据库实体类，方便数据库存储
    List<BannerSQ> list_banner_sq;
    List<RecommendSQ> list_recommend_sq;

    private static int position = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        viewMode = new ViewModelProvider(this).get(HomeViewMode.class);
        binding.setLifecycleOwner(this);
        binding.setVm(viewMode);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initObserver();
        initData();
    }

    private void initObserver() {
        viewMode.getBanner(2).compose(RXHelper.observableIO2Main(getContext()))
                .subscribe(new StaticMethodUtils.OnCallback<banner_bean>(){
                    @Override
                    public void onNext(banner_bean banner_bean) {
                        if (banner_bean.getCode() == 200){
                            updateBanner(banner_bean.getBanners());
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        queryDb();
                    }
                });
        viewMode.requireDiscover(false).compose(RXHelper.observableIO2Main(getContext()))
                .subscribe(new StaticMethodUtils.OnCallback<HomeDiscoverBean>(){
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                    }

                    @Override
                    public void onNext(HomeDiscoverBean homeDiscoverBean) {
                        super.onNext(homeDiscoverBean);
                        for (HomeDiscoverBean.DataBean.BlocksBean block : homeDiscoverBean.getData().getBlocks()){
                            switch (block.getBlockCode()) {
//                                case "HOMEPAGE_BANNER": //banner
//                                    String bannerJson = new Gson().toJson(block.getExtInfo());
//                                    viewMode.bannerList = new Gson().fromJson(bannerJson, BannerExtInfoEntity.class);
//                                    break;
//                                case "HOMEPAGE_BLOCK_PLAYLIST_RCMD": //推荐歌单
//                                    viewMode.recommendList = block.getCreatives();
//                                    break;
                                case "HOMEPAGE_BLOCK_PLAYLIST_RCMD"://雷达歌单
                                    viewMode.selfMgcList = block.getCreatives();
                                    binding.tvMgc.setText(block.getUiElement().getSubTitle().getTitle());
                                    binding.tvMgcMore.setText(block.getUiElement().getButton().getText());
                                    break;
                            }
                        }
//                        initData(viewMode.bannerList.getBanners());
//                        adapter.setDataList(viewMode.recommendList);
                        mgcAdapter.setDataList(viewMode.selfMgcList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });


    }


    private void initData() {
//        推荐歌单
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recommendRecycle.setLayoutManager(manager);  //水平线性
        //获取推荐歌单列表
        viewMode.getRecommendList()
                .compose(RXHelper.observableIO2Main(getContext()))
                .subscribe(new StaticMethodUtils.OnCallback<RecommendListBean>(){

                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onNext(RecommendListBean recommendListBean) {
                        super.onNext(recommendListBean);
                        if(recommendListBean.getCode() == 200){
                            list_recommend_sq = new ArrayList<>();
                            int size = recommendListBean.getRecommend().size();
                            for (int i=0;i<size;i++){
                                RecommendSQ bean = new RecommendSQ();
                                bean.setPicUrl(recommendListBean.getRecommend().get(i).getPicUrl());
                                bean.setName(recommendListBean.getRecommend().get(i).getName());
                                bean.setPlaycount(recommendListBean.getRecommend().get(i).getPlaycount());
                                list_recommend_sq.add(bean);
                            }
                            adapter = new RecommendAdapter(getContext());
                            adapter.setDataList(list_recommend_sq);
                            adapter.notifyDataSetChanged();
                            binding.recommendRecycle.setAdapter(adapter);
                            //sqlite在使用前要调用LitePal.getDatabase();建议数据库表，但是我们待会会修改SplashActivity.java，所以此处不用添加
                            //通过这个方法可以判断数据是否存储成功
                            boolean result =  LitePal.saveAll(list_recommend_sq);
                            if (!result){
                                Log.e("数据库内容","数据收藏存储失败");
                            }

                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        //查询推荐歌单数据库表
                        queryRecommendDb();
                    }

                });


        mgcAdapter = new MgcAdapter(getContext());
        LinearLayoutManager managerMgc = new LinearLayoutManager(getContext());
        managerMgc.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.mgcRecycle.setLayoutManager(managerMgc);
        binding.mgcRecycle.setHasFixedSize(true);
        binding.mgcRecycle.setAdapter(mgcAdapter);

        binding.ivDayRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DailySongsActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void queryRecommendDb() {
//        查询RecommendSQ表中第一条数据是否存在用于判空
        if (LitePal.findFirst(RecommendSQ.class)!=null){
            list_recommend_sq = LitePal.findAll(RecommendSQ.class);
            adapter = new RecommendAdapter(getContext());
            adapter.setDataList(list_recommend_sq);
            adapter.notifyDataSetChanged();
            binding.recommendRecycle.setAdapter(adapter);
        }

    }

    private void queryDb() {
        if(LitePal.findFirst(BannerSQ.class) != null){
            list_banner_sq = LitePal.findAll(BannerSQ.class);
            int size = list_banner_sq.size();
            binding.banner.setIndicator(new RectangleIndicator(getActivity()))
                    .setIndicatorHeight(5)
                    .setIndicatorWidth(6,6)
                    .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
                    .setAdapter(new bannerAdapter(list_banner_sq))
                    .addBannerLifecycleObserver(getActivity())
                    .setIntercept(true)
                    .setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(Object data, int position) {
                            // 点击事件
                            Log.e("OnBannerClick", list_banner_sq.get(position).getUrl());
                            ARouter.getInstance()
                                    .build(Config.ROUTE_WEB)
                                    .withString("url", list_banner_sq.get(position).getUrl())
                                    .navigation(getActivity());
                        }
                    })
                    .setBannerRound(10f);  // 设置圆角
        }
    }

    private void updateBanner(List<banner_bean.BannersBean> banners) {
        if(banners != null && banners.size()>0){
            int n = banners.size();
            list_banner_sq = new ArrayList<>();
            for(int i = 0; i < n; i++){
                BannerSQ bannersBean = new BannerSQ();
                    bannersBean.setUrl(banners.get(i).getUrl());
                    bannersBean.setPic(banners.get(i).getPic());
                    bannersBean.setTypeTitle(banners.get(i).getTypeTitle());
                    bannersBean.setTitleColor(banners.get(i).getTitleColor());
                    bannersBean.setIdName(i+1+"");
                    bannersBean.setSong(banners.get(i).getSong());
                    list_banner_sq.add(bannersBean);
            }

             binding.banner.setAdapter(new bannerAdapter(list_banner_sq))
                    .addBannerLifecycleObserver(getViewLifecycleOwner())
                    .setIntercept(false)
                    .setBannerRound(10f).setIndicator(new RectangleIndicator(getContext()))
                    .setIndicatorHeight(5)
                    .setIndicatorWidth(6, 6)
                    .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
                    .setOnBannerListener((data, position) -> {
                        //只有url不为空才表示有web网页可以加载
                        //出现的问题，存在一些url为null值。
                        Log.e("OnBannerClick",
                                list_banner_sq.get(position).getUrl()==null?"null":list_banner_sq.get(position).getUrl());
                        if (list_banner_sq.get(position).getUrl() != null) {
                            Log.e("OnBannerClick", list_banner_sq.get(position).getUrl());
                            ARouter.getInstance()
                                    .build(Config.ROUTE_WEB)
                                    .withString("url", list_banner_sq.get(position).getUrl())
                                    .navigation(getActivity());

                        }
                    });

//            banner.setIndicator(new RectangleIndicator(getActivity()))
//            .setIndicatorHeight(5)
//            .setIndicatorWidth(6,6)
//            .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
//            .setAdapter(new ImageTitleAdapter(list_banner_sq))
//                .addBannerLifecycleObserver(getActivity())
//                .setIntercept(true)
//                .setBannerRound(10f);  // 设置圆角
            insertBannerDb();
        }
    }

    private void insertBannerDb() {
        // 已经存在数据库中存在
        boolean result =  LitePal.saveAll(list_banner_sq);
        if (result){
            Log.e("数据库内容","数据存储成功");
            // ToastUtils.show("数据存储成功");
        }else {
            Log.e("数据库内容","数据存储失败");
            //  ToastUtils.show("数据存储失败");
        }
    }





    @Override
    public void onResume() {
        super.onResume();
        if(position !=0 && binding.banner != null){
            binding.banner.setStartPosition(position);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
//
        position = binding.banner.getViewPager2().getCurrentItem();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (list_recommend_sq != null){
            list_recommend_sq.clear();
            list_recommend_sq = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (list_banner_sq !=null){
            list_banner_sq.clear();
            list_banner_sq = null;
        }
    }

}
