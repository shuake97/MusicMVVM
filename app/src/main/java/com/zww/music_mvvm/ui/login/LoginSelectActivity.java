package com.zww.music_mvvm.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;
import com.zww.music_mvvm.AppManager;
import com.zww.music_mvvm.BR;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.databinding.ActivityLoginSelectBinding;
import com.zww.music_mvvm.data.Config;

@Route(path = Config.ROUTE_LOGINSELECT)
public class LoginSelectActivity extends BaseActivity {
    private long firstTime = 0;
    private ActivityLoginSelectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLoginSelectBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        binding.setVariable(BR.loginSelect,onLoginSelectClick());

    }

    @Override
    protected View getDataBind() {
        return binding.getRoot();
    }

    public View.OnClickListener onLoginSelectClick(){
        return v -> {
            ARouter.getInstance()
                    .build(Config.ROUTE_LOGIN)//跳转到login页面
                    .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK)
                    .navigation(LoginSelectActivity.this);

        };
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP){
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime>2000){
                ToastUtils.show("再按一次退出程序");
                firstTime = secondTime;
                return true;
            }else {
                AppManager.getAppManager().AppExit();  //退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}