package com.zww.music_mvvm.ui;

import static com.zww.music_mvvm.data.Config.Constant.KEY_MAIN_UI;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;

import com.google.gson.Gson;
import com.tobery.musicplay.entity.MusicInfo;
import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.Login_Bean;
import com.zww.music_mvvm.data.bean.RecentSongInfoBean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;
import com.zww.music_mvvm.domain.ContextProvider;
import com.zww.music_mvvm.ui.community.CommunityFragment;
import com.zww.music_mvvm.ui.home.HomeFragment;
import com.zww.music_mvvm.ui.mv.MvFragment;
import com.zww.music_mvvm.ui.user.MineFragment;
import com.zww.music_mvvm.ui.user.UserInfoUi;
import com.zww.music_mvvm.utils.SharePreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MainViewModel extends BaseViewModel {

    private SavedStateHandle state;

    public UserInfoUi ui;

    private String userInfo;

    public ObservableField<String> currentSongUrl = new ObservableField<>("");

    public ObservableField<String> currentSongName = new ObservableField<>("");

    public MusicInfo currentMusicInfo;

    public List<Fragment> mFragments;

    public Observable<RecentSongInfoBean> getRecentSong(){
        return RetrofitUtils.getmApi().getRecentSong(1);
    }

    public MainViewModel(SavedStateHandle state) {
        this.state = state;
        ui = state.get(KEY_MAIN_UI) == null ? new UserInfoUi(new ObservableField<>(""),new ObservableField<>(""), new ObservableInt(0),new ObservableField<>(""),new ObservableField<>(""),new ObservableField<>(""))
                :state.get(KEY_MAIN_UI);
        Log.d("VIEWMODE","construct");
    }

//    初始化UI
    public void initUi(){
        userInfo = SharePreferenceUtil.getInstance(ContextProvider.get().getContext())
                .getUserInfo();  //"null"
        Login_Bean data = new Gson().fromJson(userInfo,Login_Bean.class);
        if(data == null) return;
        if (data.getProfile() != null){
            ui.nickname.set(data.getProfile().getNickname());
            ui.imageUrl.set(data.getProfile().getAvatarUrl());
            ui.userId.set(data.getProfile().getUserId());
            ui.signature.set(data.getProfile().getSignature());
            ui.follows.set(data.getProfile().getFollows()+"关注");
            ui.followeds.set(data.getProfile().getFolloweds()+"粉丝");
        }
    }

    public void initFragments(){
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new MvFragment());
        mFragments.add(new CommunityFragment());
        mFragments.add(new MineFragment());
    }

    public List<Fragment> getmFragments(){
        if (mFragments == null){
            initFragments();
        }
        return mFragments;
    }

}
