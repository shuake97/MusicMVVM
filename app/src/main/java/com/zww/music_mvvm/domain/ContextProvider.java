package com.zww.music_mvvm.domain;

import android.app.Application;
import android.content.Context;

import com.zww.music_mvvm.App;

public class ContextProvider {

    private static volatile ContextProvider instance;
    private final Context mContext;

    public ContextProvider(Context mContext) {
        this.mContext = mContext;
    }

    public static ContextProvider get(){
        if (instance == null){
            synchronized (ContextProvider.class){
                if (instance == null){
                    Context context = ApplicationContextProvider.context;
                    if (context == null) {
                        throw new IllegalStateException("context == null");
                    }
                    instance = new ContextProvider(context);
                }
            }
        }
        return instance;
    }

    public Context getContext(){
        return mContext;
    }

    public Application getApplication(){
        return (Application) mContext.getApplicationContext();
    }

}
