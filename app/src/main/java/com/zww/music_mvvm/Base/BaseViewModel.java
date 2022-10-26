package com.zww.music_mvvm.Base;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel implements BaseActivityLifecycleAdapter {
    String TAG = "BaseView";
//    public static ViewDataBinding binding;
//    public static Activity mActivity;


//    public void setBinding(ViewDataBinding binding, Activity mActivity) {
//        //把binding和mainActivity都赋值给MainVM作为静态变量备用，因为很多绑定的控件都只能用静态方法
//        BaseViewModel.binding =binding;
//        BaseViewModel.mActivity =mActivity;
//    }


    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        BaseActivityLifecycleAdapter.super.onCreate(owner);
        Log.d(TAG,"--------onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        BaseActivityLifecycleAdapter.super.onStart(owner);
        Log.d(TAG,"--------onStart");

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        BaseActivityLifecycleAdapter.super.onResume(owner);
        Log.d(TAG,"--------onResume");

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        BaseActivityLifecycleAdapter.super.onPause(owner);
        Log.d(TAG,"--------onPause");

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        BaseActivityLifecycleAdapter.super.onStop(owner);
        Log.d(TAG,"--------onStop");

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        BaseActivityLifecycleAdapter.super.onDestroy(owner);
        Log.d(TAG,"--------onDestroy");

    }
}
