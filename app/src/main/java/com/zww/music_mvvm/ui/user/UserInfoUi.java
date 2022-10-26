package com.zww.music_mvvm.ui.user;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import java.io.Serializable;

public class UserInfoUi implements Serializable {

    public ObservableField<String> imageUrl;
    public ObservableField<String> nickname;//昵称
    public ObservableInt userId;
    public ObservableField<String> signature;//个签
    public ObservableField<String> follows;//关注
    public ObservableField<String> followeds;//粉丝

    public UserInfoUi(ObservableField<String> imageUrl, ObservableField<String> nickname, ObservableInt userId,ObservableField<String> signature, ObservableField<String> follows, ObservableField<String> followeds) {
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.userId = userId;
        this.signature = signature;
        this.follows = follows;
        this.followeds = followeds;
    }
}

