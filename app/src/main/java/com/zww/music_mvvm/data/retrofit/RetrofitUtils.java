package com.zww.music_mvvm.data.retrofit;

import static com.zww.music_mvvm.data.Config.BaseUrl;
import static com.zww.music_mvvm.data.Config.DEFAULT_TIME;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zww.music_mvvm.App;
import com.zww.music_mvvm.data.ApiService;
import com.zww.music_mvvm.data.retrofit.interceptor.LogInterceptor;
import com.zww.music_mvvm.domain.ContextProvider;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static ApiService apiService;

    public static ApiService getmApi(){
        if (apiService == null){
            synchronized (RetrofitUtils.class){
                apiService = new RetrofitUtils().getRetrofit();
            }
        }
        return apiService;
    }

    private ApiService getRetrofit() {
        ApiService apiService = initRetrofit(initClient()).create(ApiService.class);
        return apiService;
    }

    private OkHttpClient initClient() {
        File cacheDir = ContextProvider.get().getContext().getCacheDir();
        long cacheSize = 10L * 1024L * 1024L; // 10 MiB
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(),
                        new SharedPrefsCookiePersistor(App.getInstance()));
        return new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .retryOnConnectionFailure(true)
                .cache(new Cache(cacheDir,cacheSize))
                .cookieJar(cookieJar)
                .build();
    }

    /**
     * 初始化Retrofit
     */
    private Retrofit initRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
