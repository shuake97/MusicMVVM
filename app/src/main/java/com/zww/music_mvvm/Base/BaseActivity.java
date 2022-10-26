package com.zww.music_mvvm.Base;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseActivity extends AppCompatActivity {
    protected Lifecycle mlifecycle;
    protected ViewModelProvider.AndroidViewModelFactory viewModelFactoryInstance;
    private long lastClick = 0;
    // ViewMode 初始化，
    // 视图初始化
    //

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getDataBind());
        mlifecycle = getLifecycle();
        viewModelFactoryInstance = getViewModeFactory(getApplication());
//        透明化状态栏和标题栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);


    }

    protected ViewModelProvider.AndroidViewModelFactory getViewModeFactory(Application application){
        return ViewModelProvider.AndroidViewModelFactory.getInstance(application);
    }

    protected abstract View getDataBind();


    @Override
    protected void onDestroy() {
        System.gc();
        super.onDestroy();
    }

    /**
     * 页面跳转
     *
     * @param cls
     */
    public void  startActivity(Class<?> cls){
        startActivity(cls,null);
    }

    /**
     * 携带数据的页面跳转
     *
     * @param cls
     * @param bundle
     */
    public void startActivity(Class<?> cls,Bundle bundle){
        Intent intent = new Intent(this,cls);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 避免快速点击
     *
     * @return
     */
    public boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }
}
