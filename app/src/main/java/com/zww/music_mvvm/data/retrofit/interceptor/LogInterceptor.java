package com.zww.music_mvvm.data.retrofit.interceptor;

import android.util.Log;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LogInterceptor implements Interceptor {
    private String TAG = "拦截器---->";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.d(TAG,"request:" + request.toString());
        long t1 = System.nanoTime();
//
        Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        Log.d(TAG,String.format(Locale.getDefault(),"Receive response for %s in %.1fms%n%s",
                response.request().url(),(t2 - t1) / 1e6d, response.headers()));
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Log.d(TAG,"response body:" + content);

        return response.newBuilder()
                .body(ResponseBody.create(mediaType,content)).build();
    }
}
