package com.zww.music_mvvm.ui.login;

import static com.zww.music_mvvm.data.Config.Constant.KEY_LOGIN_UI;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.zww.music_mvvm.Base.BaseViewModel;
import com.zww.music_mvvm.data.bean.Login_Bean;
import com.zww.music_mvvm.data.retrofit.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class LoginViewModel extends BaseViewModel{
//ObservableField 不存在生命周期的监听，建议使用LiveData
    public MutableLiveData<String> username = new MutableLiveData<>("15797674853");
    public MutableLiveData<String> password = new MutableLiveData<>("NLXX0739");
    public MutableLiveData<Boolean> pswShow = new MutableLiveData<>(false);
//    public Disposable disposable;
    private SavedStateHandle state;

    public LoginViewModel(SavedStateHandle state) {
        this.state = state;
//       保存
        LoginUi ui = state.get(KEY_LOGIN_UI) == null?new LoginUi(new ObservableField<>(""),new ObservableField<>("")):state.get(KEY_LOGIN_UI);
    }

    public View.OnClickListener toggleShowPassword(){
        return v -> pswShow.postValue(!pswShow.getValue());
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
    }
    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        super.onDestroy(owner);

    }
    public Observable<Login_Bean> login() {
        return RetrofitUtils.getmApi().login(username.getValue(), password.getValue());
    }
}
