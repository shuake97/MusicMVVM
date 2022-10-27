package com.zww.music_mvvm.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.hjq.toast.ToastUtils;
import com.tobey.dialogloading.AlertDialogUtil;
import com.zww.music_mvvm.App;
import com.zww.music_mvvm.BR;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.ui.MainActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.bean.Login_Bean;
import com.zww.music_mvvm.data.retrofit.RXHelper;
import com.zww.music_mvvm.data.retrofit.RxExceptionUtil;
import com.zww.music_mvvm.databinding.ActivityLoginBinding;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.utils.ClickUtil;
import com.zww.music_mvvm.utils.SharePreferenceUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity {
    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setVmLogin(viewModel);
        binding.btnLogin.setOnClickListener(onLoginClick());
        binding.title.ivBack.setOnClickListener(view -> finish());

    }

    @Override
    protected View getDataBind() {
        return binding.getRoot();
    }

    private void onFailure(Throwable e, String exceptionHandler) {
        ToastUtils.show(exceptionHandler);
    }

    public void onLoginSuccess(Login_Bean bean) {
        // AlertDialog框关闭
        AlertDialogUtil.Companion.closeDialog(dialog);
        SharePreferenceUtil.getInstance(this).saveUserInfo(bean,viewModel.username.getValue());  //SharePreferenceUtil保存数据
        ToastUtils.show("登录成功");
        startActivity(new Intent(this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }


    public View.OnClickListener onLoginClick(){
        return v-> {
            if(TextUtils.isEmpty(viewModel.username.getValue())||TextUtils.isEmpty(viewModel.password.getValue())){
                ToastUtils.show("用户名或密码不能为空");
                return;
            }
            if (!StaticMethodUtils.checkMobile(viewModel.username.getValue())){
                ToastUtils.show("手机号码格式有误");
                return;
            }
            if (fastClick()){
                if (ClickUtil.enableClick()){
                    // 增加输入验证的方法
                    dialog = AlertDialogUtil.Companion.createLoading(this,"登录中");
                    viewModel.login()
                            .compose(RXHelper.observableIO2Main(App.getInstance())).subscribe(new Observer<Login_Bean>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                }

                                @Override
                                public void onNext(Login_Bean login_bean) {
                                    if(dialog!=null)
                                        AlertDialogUtil.Companion.closeDialog(dialog);

                                    if (login_bean.getCode() == 200){
//                            界面跳转
                                        onLoginSuccess(login_bean);
                                    }else if (login_bean.getCode() == 502){
                                        ToastUtils.show(R.string.msg_password_error);
                                    }else{
                                        ToastUtils.show(R.string.msg_user_error);
                                    }
                                }
                                @Override
                                public void onError(Throwable e) {
                                    if(dialog!=null)
                                        AlertDialogUtil.Companion.closeDialog(dialog);
                                    Log.e("error:",e.toString());
                                    onFailure(e, RxExceptionUtil.exceptionHandler(e));
                                }

                                @Override
                                public void onComplete() {
//
                                }
                            });
                }
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog!=null){
            dialog.dismiss();
            dialog = null;
        }
    }
}