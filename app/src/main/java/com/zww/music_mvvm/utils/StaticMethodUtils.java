package com.zww.music_mvvm.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

import com.hjq.toast.ToastUtils;
import com.zww.music_mvvm.App;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class StaticMethodUtils {

    public static boolean checkMobile(String str) {
        Pattern p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    @SuppressLint("ObsoleteSdkInt")
    public static boolean isNetWorkActive(Context context) {
        assert context != null;
        ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //获取网络属性
            NetworkCapabilities networkCapabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null){
                Log.e("Avalible","NetworkCapalbilities:"+networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED));
                return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
            }
        }else {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isConnected()){
                if (info.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }


    public static class OnCallback<T> implements Observer<T> {
        public OnCallback() {
            super();
        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(T t) {

        }

        @Override
        public void onError(Throwable e) {
            if (!isNetWorkActive(App.getInstance())){
                ToastUtils.show("网络不给力，请检查网络");
                return;
            }
            if(e instanceof ConnectException){
                ToastUtils.show("服务器连接失败，请稍后再试");

            }else if(e instanceof SocketTimeoutException){
                ToastUtils.show("服务器连接超时，请稍后再试");

            }else{
                ToastUtils.show("系统繁忙，请稍后再试");

            }
        }

        @Override
        public void onComplete() {

        }
    }


}