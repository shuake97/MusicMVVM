package com.zww.music_mvvm.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    public static String toJson(Object obj){
        String js = createGson().toJson(obj);
        return js;
    }

    private static Gson createGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        return gsonBuilder.create();
    }

    public static <T> T fromjSON(String json, Class<T> cls){
        try {
            return createGson().fromJson(json, cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
