package com.zww.music_mvvm;

import static android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.MessageQueue;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.multidex.MultiDex;

import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.BlackToastStyle;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;

import org.litepal.LitePal;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application {

    private static App instance;
//    多核优化冷启动
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2,Math.min(CPU_COUNT-1,4));

    private CountDownLatch mCountDownLatch = new CountDownLatch(1);
    public static boolean mIsInitTBSSuccess = false;

    // 单例模式获取唯一的Application实例
    public static Application getInstance(){
        return instance.getApplication();
    }
    public void initTBS() {
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);

        QbSdk.setDownloadWithoutWifi(true);
        QbSdk.setTbsListener(
                new TbsListener() {
                    @Override
                    public void onDownloadFinish(int i) {
                        //下载结束时的状态，下载成功时errorCode为100,其他均为失败，外部不需要关注具体的失败原因
                        Log.d("QbSdk", "onDownloadFinish -->下载X5内核完成：" + i);
                    }

                    @Override
                    public void onInstallFinish(int i) {
                        //安装结束时的状态，安装成功时errorCode为200,其他均为失败，外部不需要关注具体的失败原因
                        Log.d("QbSdk", "onInstallFinish -->安装X5内核进度：" + i);
                    }

                    @Override
                    public void onDownloadProgress(int i) {
                        //下载过程的通知，提供当前下载进度[0-100]
                        Log.d("QbSdk", "onDownloadProgress -->下载X5内核进度：" + i);
                    }
                });

        QbSdk.PreInitCallback cb =
                new QbSdk.PreInitCallback() {
                    @Override
                    public void onViewInitFinished(boolean arg0) {
                        // x5內核初始化完成的回调，true表x5内核加载成功，否则表加载失败，会自动切换到系统内核。
                        mIsInitTBSSuccess = arg0;
                        Log.d("QbSdk", " 内核加载 " + arg0);
                    }

                    @Override
                    public void onCoreInitFinished() {
                        //内核初始化完毕
                        Log.d("QbSdk", "内核初始化完毕");
                    }
                };
        QbSdk.reset(getApplicationContext());
        // x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
        Log.e("QbSdk", "下载: " + QbSdk.isX5Core());
        QbSdk.resumeDownload();
        //Log.i("QbSdk", "是否可以加载X5内核: " + QbSdk.canLoadX5(this));
        Log.e("QbSdk", "app是否主动禁用了X5内核: " + QbSdk.getIsSysWebViewForcedByOuter());
        Log.e("QbSdk", "是否可以加载X5内核: " + QbSdk.canLoadX5(this));
        Log.e("QbSdk", "帮助信息: " + QbSdk.getX5CoreLoadHelp(this));
        Log.e("QbSdk", "isX5Core: " + QbSdk. isX5Core ());
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ToastUtils.init(this, new BlackToastStyle());
        initTBS();
        //litepal初始化
        LitePal.initialize(instance);

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                //空闲时初始化
                return false;
            }
        });
        ExecutorService pool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                mCountDownLatch.countDown();
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
//                StarrySky.init(instance).apply();
            }
        });

        try {
            //如果await之前没有调用countDown那么就会一直阻塞在这里
            mCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                //activity创建的时候添加入栈
                WeakReference<Activity> weakReference = new WeakReference<>(activity);
                AppManager.getAppManager().addActivity(weakReference);
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                WeakReference<Activity> weakReference = new WeakReference<>(activity);
                AppManager.getAppManager().removeActivity(weakReference);
            }
        });
    }

    private Application getApplication() {
        return this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(base);
    }
}

