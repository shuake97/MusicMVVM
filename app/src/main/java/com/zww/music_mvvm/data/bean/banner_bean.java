package com.zww.music_mvvm.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 首页轮播图bean
 * Created By Tobey on 2021/6/10
 */
public class banner_bean{


    private int code;
    private List<BannersBean> banners;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public static class BannersBean implements Serializable {
        /**
         * pic : http://p1.music.126.net/wtPhw_8mf71WE8Skz7laYA==/109951165299445032.jpg
         * targetId : 0
         * adid : null
         * targetType : 3000
         * titleColor : blue
         * typeTitle : 独家策划
         * url : https://music.163.com/m/at/5f4eff178c81c03a8f906e90
         * adurlV2 : null
         * exclusive : false
         * monitorImpress : null
         * monitorClick : null
         * monitorType : null
         * monitorImpressList : []
         * monitorClickList : []
         * monitorBlackList : null
         * extMonitor : null
         * extMonitorInfo : null
         * adSource : null
         * adLocation : null
         * encodeId : 0
         * program : null
         * event : null
         * video : null
         * dynamicVideoData : null
         * song : null
         * bannerId : 1599390761322724
         * alg : null
         * scm : 1.music-homepage.homepage_banner_force.banner.1010304.968363584.null
         * requestId :
         * showAdTag : true
         * pid : null
         * showContext : null
         * adDispatchJson : null
         */

        private String pic;
        private long targetId;
        private Object adid;
        private int targetType;
        private String titleColor;
        private String typeTitle;
        private String url;
        private Object adurlV2;
        private boolean exclusive;
        private Object monitorImpress;
        private Object monitorClick;
        private Object monitorType;
        private Object monitorBlackList;
        private Object extMonitor;
        private Object extMonitorInfo;
        private Object adSource;
        private Object adLocation;
        private String encodeId;
        private Object program;
        private Object event;
        private Object video;
        private Object dynamicVideoData;
        private Object song;
        private String bannerId;
        private Object alg;
        private String scm;
        private String requestId;
        private boolean showAdTag;
        private Object pid;
        private Object showContext;
        private Object adDispatchJson;
        private List<?> monitorImpressList;
        private List<?> monitorClickList;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public long getTargetId() {
            return targetId;
        }

        public void setTargetId(long targetId) {
            this.targetId = targetId;
        }

        public Object getAdid() {
            return adid;
        }

        public void setAdid(Object adid) {
            this.adid = adid;
        }

        public int getTargetType() {
            return targetType;
        }

        public void setTargetType(int targetType) {
            this.targetType = targetType;
        }

        public String getTitleColor() {
            return titleColor;
        }

        public void setTitleColor(String titleColor) {
            this.titleColor = titleColor;
        }

        public String getTypeTitle() {
            return typeTitle;
        }

        public void setTypeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getAdurlV2() {
            return adurlV2;
        }

        public void setAdurlV2(Object adurlV2) {
            this.adurlV2 = adurlV2;
        }

        public boolean isExclusive() {
            return exclusive;
        }

        public void setExclusive(boolean exclusive) {
            this.exclusive = exclusive;
        }

        public Object getMonitorImpress() {
            return monitorImpress;
        }

        public void setMonitorImpress(Object monitorImpress) {
            this.monitorImpress = monitorImpress;
        }

        public Object getMonitorClick() {
            return monitorClick;
        }

        public void setMonitorClick(Object monitorClick) {
            this.monitorClick = monitorClick;
        }

        public Object getMonitorType() {
            return monitorType;
        }

        public void setMonitorType(Object monitorType) {
            this.monitorType = monitorType;
        }

        public Object getMonitorBlackList() {
            return monitorBlackList;
        }

        public void setMonitorBlackList(Object monitorBlackList) {
            this.monitorBlackList = monitorBlackList;
        }

        public Object getExtMonitor() {
            return extMonitor;
        }

        public void setExtMonitor(Object extMonitor) {
            this.extMonitor = extMonitor;
        }

        public Object getExtMonitorInfo() {
            return extMonitorInfo;
        }

        public void setExtMonitorInfo(Object extMonitorInfo) {
            this.extMonitorInfo = extMonitorInfo;
        }

        public Object getAdSource() {
            return adSource;
        }

        public void setAdSource(Object adSource) {
            this.adSource = adSource;
        }

        public Object getAdLocation() {
            return adLocation;
        }

        public void setAdLocation(Object adLocation) {
            this.adLocation = adLocation;
        }

        public String getEncodeId() {
            return encodeId;
        }

        public void setEncodeId(String encodeId) {
            this.encodeId = encodeId;
        }

        public Object getProgram() {
            return program;
        }

        public void setProgram(Object program) {
            this.program = program;
        }

        public Object getEvent() {
            return event;
        }

        public void setEvent(Object event) {
            this.event = event;
        }

        public Object getVideo() {
            return video;
        }

        public void setVideo(Object video) {
            this.video = video;
        }

        public Object getDynamicVideoData() {
            return dynamicVideoData;
        }

        public void setDynamicVideoData(Object dynamicVideoData) {
            this.dynamicVideoData = dynamicVideoData;
        }

        public Object getSong() {
            return song;
        }

        public void setSong(Object song) {
            this.song = song;
        }

        public String getBannerId() {
            return bannerId;
        }

        public void setBannerId(String bannerId) {
            this.bannerId = bannerId;
        }

        public Object getAlg() {
            return alg;
        }

        public void setAlg(Object alg) {
            this.alg = alg;
        }

        public String getScm() {
            return scm;
        }

        public void setScm(String scm) {
            this.scm = scm;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public boolean isShowAdTag() {
            return showAdTag;
        }

        public void setShowAdTag(boolean showAdTag) {
            this.showAdTag = showAdTag;
        }

        public Object getPid() {
            return pid;
        }

        public void setPid(Object pid) {
            this.pid = pid;
        }

        public Object getShowContext() {
            return showContext;
        }

        public void setShowContext(Object showContext) {
            this.showContext = showContext;
        }

        public Object getAdDispatchJson() {
            return adDispatchJson;
        }

        public void setAdDispatchJson(Object adDispatchJson) {
            this.adDispatchJson = adDispatchJson;
        }

        public List<?> getMonitorImpressList() {
            return monitorImpressList;
        }

        public void setMonitorImpressList(List<?> monitorImpressList) {
            this.monitorImpressList = monitorImpressList;
        }

        public List<?> getMonitorClickList() {
            return monitorClickList;
        }

        public void setMonitorClickList(List<?> monitorClickList) {
            this.monitorClickList = monitorClickList;
        }
    }
}


