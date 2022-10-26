package com.zww.music_mvvm.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.hjq.toast.ToastUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = CrashHandler.class.getSimpleName();
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static CrashHandler instance;
    private Context mContext;

    private Map<String,String> infos = new HashMap<>();

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private CrashHandler(){}

    public static CrashHandler getInstance(){
        if (instance == null){
            synchronized (CrashHandler.class){
                if (instance == null){
                    instance = new CrashHandler();
                }
            }
        }
        return instance;
    }

    public void init(Context context){
        mContext = context;
//        获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
//        设置该CrashHandler微程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    /**
     * @description 当UncaughtException发生时会转入该函数来处理
     * @return
     * @author 13115
     * @time 2022/2/16 10:40
     */
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        if (!handleException(e) && mDefaultHandler != null){
            //如果用户没有处理或者init则让系统默认的异常处理器处理
            mDefaultHandler.uncaughtException(t, e);
        }else {
            try {
//                错误处理
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //退出程序
            System.exit(1);
        }
    }

    /**
     * @description 自定义错误处理，收集错误信息，上传错误信息
     * @param ex
     * @return true:处理了该异常信息；false：未处理
     * @author 13115
     * @time 2022/2/16 11:22
     */
    private boolean handleException(final Throwable ex){
        if (ex == null) return false;
    //    收集设备参数
        collectDeviceInfo(mContext);
        //发送错误日志
        //crashReport
        new Thread(){
            @Override
            public void run() {
                Looper.prepare();
                ToastUtils.show(ex.toString());
                Looper.loop();
                Looper.myLooper().quit();
            }
        }.start();
        return true;
    }

    private void collectDeviceInfo(Context mContext) {
        try {
            PackageManager pm = mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(),
                    PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null"
                        : pi.versionName;
                String versionCode = pi.versionCode + "";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        infos.put("OS Version:", Build.VERSION.RELEASE);
        infos.put("-", Build.VERSION.SDK_INT+"");
        infos.put("Model:", Build.MODEL);
        infos.put("BRAND:", Build.BRAND);
    }

}
