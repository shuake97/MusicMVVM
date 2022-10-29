package com.zww.music_mvvm.ui.user;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.tobery.livedata.call.livedatalib.Status;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.VipInfoBean;
import com.zww.music_mvvm.data.retrofit.RXHelper;
import com.zww.music_mvvm.databinding.FragmentMineBinding;
import com.zww.music_mvvm.ui.MainViewModel;
import com.zww.music_mvvm.ui.adapter.BindingAdapter;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

public class MineFragment extends Fragment {
    private FragmentMineBinding binding;

    private MainViewModel homeViewMode;  //在次创建了一个ViewModel，导致了构造函数调用了两次

    private MineFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMineBinding.inflate(inflater);
        //传入activity，使得和activity共用同一个ViewModel
        homeViewMode = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        viewModel = new ViewModelProvider(this).get(MineFragmentViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setVm(homeViewMode);
        homeViewMode.initUi();
        initWebView();
        initObserver();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        binding.webVip.getSettings().setJavaScriptEnabled(true);
    }

    private void initObserver() {

//        viewModel.getVipInfo().observe(getViewLifecycleOwner(), vipInfoEntityApiResponse -> {
//            if (vipInfoEntityApiResponse.getStatus() == Status.SUCCESS ){
//                  binding.webVip.loadDataWithBaseURL(null,changeImageUrl(vipInfoEntityApiResponse.getData().getData().getRedVipLevelIcon()),"text/html","utf-8",null);
//
////                binding.webVip.loadDataWithBaseURL(null,changeImageUrl(vipInfoEntityApiResponse.getData().getData().getRedVipDynamicIconUrl2()),"text/html", "utf-8", null);
//            }
//        });
        viewModel.getVipInfo().compose(RXHelper.observableIO2Main(getContext()))
                .subscribe(new StaticMethodUtils.OnCallback<VipInfoBean>(){
                    @Override
                    public void onNext(VipInfoBean vipInfoBean) {
                        super.onNext(vipInfoBean);
                        VipInfoBean ttt = vipInfoBean;
                        Log.e("信息显式VipBean",vipInfoBean.toString());
//                        binding.webVip.loadDataWithBaseURL(null,changeImageUrl(vipInfoBean.getData().getRedVipLevelIcon()),"text/html","utf-8",null);

                        BindingAdapter.loadUrl(binding.imageHead,homeViewMode.ui.imageUrl.toString(),R.mipmap.ic_dadad);
//                        RequestOptions options = new RequestOptions()
//                                .placeholder(R.mipmap.loading)
//                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                                .transform(new CenterCrop(),new RoundedCorners(10))
//                                .error(R.mipmap.ic_dadad);
//                        Glide.with(getContext())
//                                .load(homeViewMode.ui.imageUrl)
//                                .transition(new DrawableTransitionOptions().crossFade())
//                                .apply(options)
//                                .into(binding.imageHead);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

    private String changeImageUrl(String url) {
        Document doc = null;
        try {
            InputStream file = getResources().getAssets().open("web/vip.html");
            doc = Jsoup.parse(file, "UTF-8", url);
            Elements pngs = doc.select("img[src$=.png]");
            pngs.attr("src",url);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert doc != null;
        return doc.toString();
    }


}
/**
 *
 * .compose(RXHelper.observableIO2Main(getContext()))
 *                 .subscribe(new StaticMethodUtils.OnCallback<RecommendListBean>(){
 *
 *                     @SuppressLint("NotifyDataSetChanged")
 *                     @Override
 *                     public void onNext(RecommendListBean recommendListBean) {
 *                         super.onNext(recommendListBean);
 *                         if(recommendListBean.getCode() == 200){
 *                             list_recommend_sq = new ArrayList<>();
 *                             int size = recommendListBean.getRecommend().size();
 *                             for (int i=0;i<size;i++){
 *                                 RecommendSQ bean = new RecommendSQ();
 *                                 bean.setPicUrl(recommendListBean.getRecommend().get(i).getPicUrl());
 *                                 bean.setName(recommendListBean.getRecommend().get(i).getName());
 *                                 bean.setPlaycount(recommendListBean.getRecommend().get(i).getPlaycount());
 *                                 list_recommend_sq.add(bean);
 *                             }
 *                             adapter = new RecommendAdapter(getContext());
 *                             adapter.setDataList(list_recommend_sq);
 *                             adapter.notifyDataSetChanged();
 *                             binding.recommendRecycle.setAdapter(adapter);
 *                             //sqlite在使用前要调用LitePal.getDatabase();建议数据库表，但是我们待会会修改SplashActivity.java，所以此处不用添加
 *                             //通过这个方法可以判断数据是否存储成功
 *                             boolean result =  LitePal.saveAll(list_recommend_sq);
 *                             if (!result){
 *                                 Log.e("数据库内容","数据收藏存储失败");
 *                             }
 *
 *                         }
 *                     }
 *                     @Override
 *                     public void onError(Throwable e) {
 *                         super.onError(e);
 *                         //查询推荐歌单数据库表
 *                         queryRecommendDb();
 *                     }
 *
 *                 });
 */