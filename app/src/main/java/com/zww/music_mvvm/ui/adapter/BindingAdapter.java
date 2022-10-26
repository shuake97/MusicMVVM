package com.zww.music_mvvm.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.utils.ClickUtil;

import kotlin.jvm.functions.Function0;

public class BindingAdapter {
    @androidx.databinding.BindingAdapter({"imSrc", "error"})
    public static void loadUrl(ImageView view, @Nullable String url, @DrawableRes int error){
        if (url != null){
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .circleCrop();
            Glide.with(view.getContext())
                    .load(url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(error)
                    .apply(options)
                    .into(view);

        }
    }
    //加载圆角图片
    @androidx.databinding.BindingAdapter(value = "rectangleSrc")
    public static void loadRadiusImage(ImageView view,@Nullable String url){
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.loading)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .transform(new CenterCrop(),new RoundedCorners(10))
                .error(R.mipmap.ic_launcher);
        Glide.with(view.getContext())
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(options)
                .into(view);
    }

    @androidx.databinding.BindingAdapter(value = "onsingleclick")
    public static void onSingleClick(View view, final Function0 function){
        view.setOnClickListener(v -> {
            if (ClickUtil.enableClick()){
                function.invoke();
            }
        });
    }

}
