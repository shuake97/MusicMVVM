package com.zww.music_mvvm.data.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class BannerSQ extends LitePalSupport {

    @Column(unique = true,defaultValue = "unKnow")
    private String idName;

    private String pic;

    private String titleColor;

    private String typeTitle;

    private String url;

    private Object song;

    public Object getSong() {
        return song;
    }

    public void setSong(Object song) {
        this.song = song;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public String getUrl() {
        return url;
    }
}


