package com.zww.music_mvvm.utils;

import static com.zww.music_mvvm.data.Config.PERERNCE_FILE_NAME;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.data.bean.Login_Bean;

public class SharePreferenceUtil {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    private static SharePreferenceUtil mInstance;

    private SharePreferenceUtil() {
    }
    private static void init(Context context){
        if (sp == null){
            sp = context.getSharedPreferences(PERERNCE_FILE_NAME,Context.MODE_PRIVATE);
        }
        editor = sp.edit();
    }
    public static SharePreferenceUtil getInstance(Context context){
        if (mInstance == null){
            synchronized (SharePreferenceUtil.class){
                if (mInstance == null){
                    init(context);
                    mInstance = new SharePreferenceUtil();
                }
            }
        }
        return mInstance;
    }

    public String getAuthToken(String defaultValue){
        Log.d("数据getAuthToken",getString(Config.SpKey.AUTH_TOKEN));

        return getString(Config.SpKey.AUTH_TOKEN);
    }

    private String getString(String key) {
        return sp.getString(key,"null");
    }

    public void saveUserInfo(Login_Bean bean, String phoneNumber){
        if (bean.getBindings().size() >= 1){
            saveAuthToken(bean.getBindings().get(0).getTokenJsonStr());
            Log.d("数据",bean.getBindings().get(0).getTokenJsonStr());
        }
        saveAccountNum(phoneNumber);
        saveString(Config.SpKey.USER_INFO, GsonUtil.toJson(bean));
    }
    public String getUserInfo() {
        return getString(Config.SpKey.USER_INFO);
    }

    private void saveAccountNum(String phoneNumber) {
        saveString(Config.SpKey.PHONE_NUMBER,phoneNumber);
    }

    private void saveAuthToken(String token) {
        saveString(Config.SpKey.AUTH_TOKEN,token);
    }

    private void saveString(String key, String value) {
        editor.putString(key,value).apply();
//        editor.commit();
    }

    public void savePermissionDeniedNum(String key,int value){
        saveInt(key, value);
    }

    public int getPermissionDeniedNum(String key){
        return getInt(key);
    }
    private int getInt(String key) {
        return sp.getInt(key,0);
    }

    private void saveInt(String key, int defaultValue) {
        editor.putInt(key,defaultValue).apply();
    }
}
