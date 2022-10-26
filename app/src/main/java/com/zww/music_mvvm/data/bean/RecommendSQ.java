package com.zww.music_mvvm.data.bean;

import org.litepal.crud.LitePalSupport;

public class RecommendSQ extends LitePalSupport {
    private String picUrl;
    private long playcount;
    private String name;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getPlaycount() {
        return playcount;
    }

    public void setPlaycount(long playcount) {
        this.playcount = playcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

