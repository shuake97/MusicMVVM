package com.zww.music_mvvm.ui.splash;

import static com.zww.music_mvvm.utils.StaticPermissionUtils.ARR_NEED_PERMISSIONS;

import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;
import com.permissionx.guolindev.PermissionX;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.data.bean.BannerSQ;
import com.zww.music_mvvm.data.bean.RecommendSQ;
import com.zww.music_mvvm.utils.SharePreferenceUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import org.litepal.LitePal;


@Route(path = Config.ROUTE_SPLASH)
public class SplashActivity extends BaseActivity {

    private CountDownTimer countDownTimer;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected View getDataBind() {
        return LayoutInflater.from(this).inflate(R.layout.activity_splash,null);
    }

    protected void initData() {
        //建立数据库
        LitePal.getDatabase();
        Log.e("数据库内容","删除");
        Log.d("数据库内容","string:"+StaticMethodUtils.isNetWorkActive(getApplication()));
//        在有网络存在的情况下删除数据库
        if (LitePal.findFirst(BannerSQ.class) != null || StaticMethodUtils.isNetWorkActive(getApplication())){
            LitePal.deleteAll(BannerSQ.class);
            LitePal.deleteAll(RecommendSQ.class);
            Log.e("数据库内容","删除功能");
        }
        PermissionX.init(this)
                .permissions(ARR_NEED_PERMISSIONS)
                .request((allGranted,grantedList,deniedList)->{
                    if (allGranted){
                        startCountDown();
                    }else {
                        ToastUtils.show("缺少如下权限"+deniedList);
//                        finish();
                        startCountDown();
                    }
                });
    }
//
    public boolean checkPermissionMethod(String permission){
        return ActivityCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_GRANTED;
    }


    private void startCountDown() {
        countDownTimer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("SplashActivity","onTick");
            }

            @Override
            public void onFinish() {
                Log.d("SplashActivity","onFinish");
                String authToken = SharePreferenceUtil.getInstance(SplashActivity.this)
                        .getAuthToken("");
                Log.e("数据",authToken);

//                if (!TextUtils.isEmpty(authToken)){
//                    //进入主界面
//                    ARouter.getInstance()
//                            .build(Config.ROUTE_HOME)//跳转到选择按钮页面
//                            .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                            .navigation(SplashActivity.this);
//                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);  // 动画
//                    finish();
//                    return;
//                }

                ARouter.getInstance()
                        .build(Config.ROUTE_LOGINSELECT)//跳转到选择按钮页面
                        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .navigation(SplashActivity.this);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();

//                //倒计时结束2s
//                ARouter.getInstance()
//                        .build(Config.ROUTE_LOGINSELECT)//跳转到选择按钮页面
//                        .navigation(SplashActivity.this);
//                  startActivity(LoginActivity.class);
            }
        };
        countDownTimer.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }
}