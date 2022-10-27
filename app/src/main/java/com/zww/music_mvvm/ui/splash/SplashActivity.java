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

import com.hjq.toast.ToastUtils;
import com.permissionx.guolindev.PermissionX;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.data.bean.BannerSQ;
import com.zww.music_mvvm.data.bean.RecommendSQ;
import com.zww.music_mvvm.ui.MainActivity;
import com.zww.music_mvvm.ui.login.LoginActivity;
import com.zww.music_mvvm.utils.SharePreferenceUtil;
import com.zww.music_mvvm.utils.StaticMethodUtils;

import org.litepal.LitePal;


public class SplashActivity extends BaseActivity {
    private final String TAG = "SplashActivity";

    //安卓倒计时  2000ms 没1000ms调用一次onTick方法
    private CountDownTimer countDownTimer;

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
        LitePal.getDatabase();  //对于用户信息的记录，采用LitePal框架，对数据库进行操作
//        在有网络存在的情况下删除数据库
        if (LitePal.findFirst(BannerSQ.class) != null || StaticMethodUtils.isNetWorkActive(getApplication())){
            LitePal.deleteAll(BannerSQ.class);
            LitePal.deleteAll(RecommendSQ.class);
            Log.e("LitePal","删除功能");
        }
        // 对权限的加载
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

    // 权限检查
    public boolean checkPermissionMethod(String permission){
        return ActivityCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_GRANTED;
    }


    private void startCountDown() {
        countDownTimer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                // 利用sharePreferenceUtils 存取部分用户信息，看后续改进
                String authToken = SharePreferenceUtil.getInstance(SplashActivity.this)
                        .getAuthToken("");
                //存储相关用户Token信息则直接进入首页，（这里需要修该，应该对用户的信息以及token的有效时间进行验证，进行验证）
                if (!TextUtils.isEmpty(authToken)){
                    //进入主界面
                    startActivity(new Intent(SplashActivity.this, MainActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);  // 动画
                    finish();
                    return;
                }

                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                // activity跳转动画
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
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