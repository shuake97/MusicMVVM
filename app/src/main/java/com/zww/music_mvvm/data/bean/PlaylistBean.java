package com.zww.music_mvvm.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaylistBean {
    private int code;
    private Object relatedVideos;
    private PlaylistEntity playlist;
    private Object urls;
    private List<PrivilegesEntity> privileges;
    private Object sharedPrivilege;
    private Object resEntrance;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getRelatedVideos() {
        return relatedVideos;
    }

    public void setRelatedVideos(Object relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

    public PlaylistEntity getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistEntity playlist) {
        this.playlist = playlist;
    }

    public Object getUrls() {
        return urls;
    }

    public void setUrls(Object urls) {
        this.urls = urls;
    }

    public List<PrivilegesEntity> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegesEntity> privileges) {
        this.privileges = privileges;
    }

    public Object getSharedPrivilege() {
        return sharedPrivilege;
    }

    public void setSharedPrivilege(Object sharedPrivilege) {
        this.sharedPrivilege = sharedPrivilege;
    }

    public Object getResEntrance() {
        return resEntrance;
    }

    public void setResEntrance(Object resEntrance) {
        this.resEntrance = resEntrance;
    }

    public static class PlaylistEntity {
        private long id;
        private String name;
        private long coverImgId;
        private String coverImgUrl;
        private String coverImgId_str;
        private int adType;
        private long userId;
        private long createTime;
        private int status;
        private boolean opRecommend;
        private boolean highQuality;
        private boolean newImported;
        private long updateTime;
        private int trackCount;
        private int specialType;
        private int privacy;
        private long trackUpdateTime;
        private String commentThreadId;
        private long playCount;
        private long trackNumberUpdateTime;
        private int subscribedCount;
        private int cloudTrackCount;
        private boolean ordered;
        private String description;
        private List<String> tags;
        private Object updateFrequency;
        private long backgroundCoverId;
        private Object backgroundCoverUrl;
        private long titleImage;
        private Object titleImageUrl;
        private Object englishTitle;
        private Object officialPlaylistType;
        private List<SubscribersEntity> subscribers;
        private boolean subscribed;
        private CreatorEntity creator;
        private List<TracksEntity> tracks;
        private Object videoIds;
        private Object videos;
        private List<TrackIdsEntity> trackIds;
        private int shareCount;
        private int commentCount;
        private Object remixVideo;
        private Object sharedUsers;
        private Object historySharedUsers;
        private String gradeStatus;
        private Object score;
        private Object algTags;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public String getCoverImgId_str() {
            return coverImgId_str;
        }

        public void setCoverImgId_str(String coverImgId_str) {
            this.coverImgId_str = coverImgId_str;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isOpRecommend() {
            return opRecommend;
        }

        public void setOpRecommend(boolean opRecommend) {
            this.opRecommend = opRecommend;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public Object getUpdateFrequency() {
            return updateFrequency;
        }

        public void setUpdateFrequency(Object updateFrequency) {
            this.updateFrequency = updateFrequency;
        }

        public long getBackgroundCoverId() {
            return backgroundCoverId;
        }

        public void setBackgroundCoverId(long backgroundCoverId) {
            this.backgroundCoverId = backgroundCoverId;
        }

        public Object getBackgroundCoverUrl() {
            return backgroundCoverUrl;
        }

        public void setBackgroundCoverUrl(Object backgroundCoverUrl) {
            this.backgroundCoverUrl = backgroundCoverUrl;
        }

        public long getTitleImage() {
            return titleImage;
        }

        public void setTitleImage(long titleImage) {
            this.titleImage = titleImage;
        }

        public Object getTitleImageUrl() {
            return titleImageUrl;
        }

        public void setTitleImageUrl(Object titleImageUrl) {
            this.titleImageUrl = titleImageUrl;
        }

        public Object getEnglishTitle() {
            return englishTitle;
        }

        public void setEnglishTitle(Object englishTitle) {
            this.englishTitle = englishTitle;
        }

        public Object getOfficialPlaylistType() {
            return officialPlaylistType;
        }

        public void setOfficialPlaylistType(Object officialPlaylistType) {
            this.officialPlaylistType = officialPlaylistType;
        }

        public List<SubscribersEntity> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<SubscribersEntity> subscribers) {
            this.subscribers = subscribers;
        }

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorEntity getCreator() {
            return creator;
        }

        public void setCreator(CreatorEntity creator) {
            this.creator = creator;
        }

        public List<TracksEntity> getTracks() {
            return tracks;
        }

        public void setTracks(List<TracksEntity> tracks) {
            this.tracks = tracks;
        }

        public Object getVideoIds() {
            return videoIds;
        }

        public void setVideoIds(Object videoIds) {
            this.videoIds = videoIds;
        }

        public Object getVideos() {
            return videos;
        }

        public void setVideos(Object videos) {
            this.videos = videos;
        }

        public List<TrackIdsEntity> getTrackIds() {
            return trackIds;
        }

        public void setTrackIds(List<TrackIdsEntity> trackIds) {
            this.trackIds = trackIds;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public Object getRemixVideo() {
            return remixVideo;
        }

        public void setRemixVideo(Object remixVideo) {
            this.remixVideo = remixVideo;
        }

        public Object getSharedUsers() {
            return sharedUsers;
        }

        public void setSharedUsers(Object sharedUsers) {
            this.sharedUsers = sharedUsers;
        }

        public Object getHistorySharedUsers() {
            return historySharedUsers;
        }

        public void setHistorySharedUsers(Object historySharedUsers) {
            this.historySharedUsers = historySharedUsers;
        }

        public String getGradeStatus() {
            return gradeStatus;
        }

        public void setGradeStatus(String gradeStatus) {
            this.gradeStatus = gradeStatus;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public Object getAlgTags() {
            return algTags;
        }

        public void setAlgTags(Object algTags) {
            this.algTags = algTags;
        }

        public static class CreatorEntity {
            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private int birthday;
            private long userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private List<String> expertTags;
            private ExpertsEntity experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private int authenticationTypes;
            private AvatarDetailEntity avatarDetail;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private boolean anchor;
            private String avatarImgId_str;

            public static class ExpertsEntity {
                @SerializedName("1")
                private String _$1;
                @SerializedName("2")
                private String _$2;
            }

            public static class AvatarDetailEntity {
                private int userType;
                private int identityLevel;
                private String identityIconUrl;
            }
        }

        public static class SubscribersEntity {
            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private int birthday;
            private long userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private int authenticationTypes;
            private Object avatarDetail;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private boolean anchor;
            private String avatarImgId_str;
        }

        public static class TracksEntity {
            private String name;
            private int id;
            private int pst;
            private int t;
            private List<ArEntity> ar;
            private List<String> alia;
            private int pop;
            private int st;
            private String rt;
            private int fee;
            private int v;
            private Object crbt;
            private String cf;
            private AlEntity al;
            private int dt;
            private HEntity h;
            private MEntity m;
            private LEntity l;
            private Object sq;
            private Object hr;
            private Object a;
            private String cd;
            private int no;
            private Object rtUrl;
            private int ftype;
            private List<?> rtUrls;
            private int djId;
            private int copyright;
            private int s_id;
            private long mark;
            private int originCoverType;
            private Object originSongSimpleData;
            private Object tagPicList;
            private boolean resourceState;
            private int version;
            private Object songJumpInfo;
            private Object entertainmentTags;
            private int single;
            private Object noCopyrightRcmd;
            private Object alg;
            private int mst;
            private int cp;
            private int mv;
            private int rtype;
            private Object rurl;
            private long publishTime;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPst() {
                return pst;
            }

            public void setPst(int pst) {
                this.pst = pst;
            }

            public int getT() {
                return t;
            }

            public void setT(int t) {
                this.t = t;
            }

            public List<ArEntity> getAr() {
                return ar;
            }

            public void setAr(List<ArEntity> ar) {
                this.ar = ar;
            }

            public List<String> getAlia() {
                return alia;
            }

            public void setAlia(List<String> alia) {
                this.alia = alia;
            }

            public int getPop() {
                return pop;
            }

            public void setPop(int pop) {
                this.pop = pop;
            }

            public int getSt() {
                return st;
            }

            public void setSt(int st) {
                this.st = st;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getV() {
                return v;
            }

            public void setV(int v) {
                this.v = v;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public String getCf() {
                return cf;
            }

            public void setCf(String cf) {
                this.cf = cf;
            }

            public AlEntity getAl() {
                return al;
            }

            public void setAl(AlEntity al) {
                this.al = al;
            }

            public int getDt() {
                return dt;
            }

            public void setDt(int dt) {
                this.dt = dt;
            }

            public HEntity getH() {
                return h;
            }

            public void setH(HEntity h) {
                this.h = h;
            }

            public MEntity getM() {
                return m;
            }

            public void setM(MEntity m) {
                this.m = m;
            }

            public LEntity getL() {
                return l;
            }

            public void setL(LEntity l) {
                this.l = l;
            }

            public Object getSq() {
                return sq;
            }

            public void setSq(Object sq) {
                this.sq = sq;
            }

            public Object getHr() {
                return hr;
            }

            public void setHr(Object hr) {
                this.hr = hr;
            }

            public Object getA() {
                return a;
            }

            public void setA(Object a) {
                this.a = a;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public int getDjId() {
                return djId;
            }

            public void setDjId(int djId) {
                this.djId = djId;
            }

            public int getCopyright() {
                return copyright;
            }

            public void setCopyright(int copyright) {
                this.copyright = copyright;
            }

            public int getS_id() {
                return s_id;
            }

            public void setS_id(int s_id) {
                this.s_id = s_id;
            }

            public long getMark() {
                return mark;
            }

            public void setMark(long mark) {
                this.mark = mark;
            }

            public int getOriginCoverType() {
                return originCoverType;
            }

            public void setOriginCoverType(int originCoverType) {
                this.originCoverType = originCoverType;
            }

            public Object getOriginSongSimpleData() {
                return originSongSimpleData;
            }

            public void setOriginSongSimpleData(Object originSongSimpleData) {
                this.originSongSimpleData = originSongSimpleData;
            }

            public Object getTagPicList() {
                return tagPicList;
            }

            public void setTagPicList(Object tagPicList) {
                this.tagPicList = tagPicList;
            }

            public boolean isResourceState() {
                return resourceState;
            }

            public void setResourceState(boolean resourceState) {
                this.resourceState = resourceState;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public Object getSongJumpInfo() {
                return songJumpInfo;
            }

            public void setSongJumpInfo(Object songJumpInfo) {
                this.songJumpInfo = songJumpInfo;
            }

            public Object getEntertainmentTags() {
                return entertainmentTags;
            }

            public void setEntertainmentTags(Object entertainmentTags) {
                this.entertainmentTags = entertainmentTags;
            }

            public int getSingle() {
                return single;
            }

            public void setSingle(int single) {
                this.single = single;
            }

            public Object getNoCopyrightRcmd() {
                return noCopyrightRcmd;
            }

            public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
                this.noCopyrightRcmd = noCopyrightRcmd;
            }

            public Object getAlg() {
                return alg;
            }

            public void setAlg(Object alg) {
                this.alg = alg;
            }

            public int getMst() {
                return mst;
            }

            public void setMst(int mst) {
                this.mst = mst;
            }

            public int getCp() {
                return cp;
            }

            public void setCp(int cp) {
                this.cp = cp;
            }

            public int getMv() {
                return mv;
            }

            public void setMv(int mv) {
                this.mv = mv;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public static class AlEntity {
                private int id;
                private String name;
                private String picUrl;
                private List<?> tns;
                private String pic_str;
                private long pic;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public String getPic_str() {
                    return pic_str;
                }

                public void setPic_str(String pic_str) {
                    this.pic_str = pic_str;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }
            }

            public static class HEntity {
                private int br;
                private int fid;
                private int size;
                private int vd;
                private int sr;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getVd() {
                    return vd;
                }

                public void setVd(int vd) {
                    this.vd = vd;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }
            }

            public static class MEntity {
                private int br;
                private int fid;
                private int size;
                private int vd;
                private int sr;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getVd() {
                    return vd;
                }

                public void setVd(int vd) {
                    this.vd = vd;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }
            }

            public static class LEntity {
                private int br;
                private int fid;
                private int size;
                private int vd;
                private int sr;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getVd() {
                    return vd;
                }

                public void setVd(int vd) {
                    this.vd = vd;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }
            }

            public static class ArEntity {
                private int id;
                private String name;
                private List<?> tns;
                private List<?> alias;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class TrackIdsEntity {
            private int id;
            private int v;
            private int t;
            private long at;
            private Object alg;
            private long uid;
            private String rcmdReason;
            private Object sc;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getV() {
                return v;
            }

            public void setV(int v) {
                this.v = v;
            }

            public int getT() {
                return t;
            }

            public void setT(int t) {
                this.t = t;
            }

            public long getAt() {
                return at;
            }

            public void setAt(long at) {
                this.at = at;
            }

            public Object getAlg() {
                return alg;
            }

            public void setAlg(Object alg) {
                this.alg = alg;
            }

            public long getUid() {
                return uid;
            }

            public void setUid(long uid) {
                this.uid = uid;
            }

            public String getRcmdReason() {
                return rcmdReason;
            }

            public void setRcmdReason(String rcmdReason) {
                this.rcmdReason = rcmdReason;
            }

            public Object getSc() {
                return sc;
            }

            public void setSc(Object sc) {
                this.sc = sc;
            }
        }
    }

    public static class PrivilegesEntity {
        private int id;
        private int fee;
        private int payed;
        private int realPayed;
        private int st;
        private int pl;
        private int dl;
        private int sp;
        private int cp;
        private int subp;
        private boolean cs;
        private int maxbr;
        private int fl;
        private Object pc;
        private boolean toast;
        private int flag;
        private boolean paidBigBang;
        private boolean preSell;
        private int playMaxbr;
        private int downloadMaxbr;
        private String maxBrLevel;
        private String playMaxBrLevel;
        private String downloadMaxBrLevel;
        private String plLevel;
        private String dlLevel;
        private String flLevel;
        private Object rscl;
        private FreeTrialPrivilegeEntity freeTrialPrivilege;
        private List<ChargeInfoListEntity> chargeInfoList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getRealPayed() {
            return realPayed;
        }

        public void setRealPayed(int realPayed) {
            this.realPayed = realPayed;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getPl() {
            return pl;
        }

        public void setPl(int pl) {
            this.pl = pl;
        }

        public int getDl() {
            return dl;
        }

        public void setDl(int dl) {
            this.dl = dl;
        }

        public int getSp() {
            return sp;
        }

        public void setSp(int sp) {
            this.sp = sp;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getSubp() {
            return subp;
        }

        public void setSubp(int subp) {
            this.subp = subp;
        }

        public boolean isCs() {
            return cs;
        }

        public void setCs(boolean cs) {
            this.cs = cs;
        }

        public int getMaxbr() {
            return maxbr;
        }

        public void setMaxbr(int maxbr) {
            this.maxbr = maxbr;
        }

        public int getFl() {
            return fl;
        }

        public void setFl(int fl) {
            this.fl = fl;
        }

        public Object getPc() {
            return pc;
        }

        public void setPc(Object pc) {
            this.pc = pc;
        }

        public boolean isToast() {
            return toast;
        }

        public void setToast(boolean toast) {
            this.toast = toast;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isPaidBigBang() {
            return paidBigBang;
        }

        public void setPaidBigBang(boolean paidBigBang) {
            this.paidBigBang = paidBigBang;
        }

        public boolean isPreSell() {
            return preSell;
        }

        public void setPreSell(boolean preSell) {
            this.preSell = preSell;
        }

        public int getPlayMaxbr() {
            return playMaxbr;
        }

        public void setPlayMaxbr(int playMaxbr) {
            this.playMaxbr = playMaxbr;
        }

        public int getDownloadMaxbr() {
            return downloadMaxbr;
        }

        public void setDownloadMaxbr(int downloadMaxbr) {
            this.downloadMaxbr = downloadMaxbr;
        }

        public String getMaxBrLevel() {
            return maxBrLevel;
        }

        public void setMaxBrLevel(String maxBrLevel) {
            this.maxBrLevel = maxBrLevel;
        }

        public String getPlayMaxBrLevel() {
            return playMaxBrLevel;
        }

        public void setPlayMaxBrLevel(String playMaxBrLevel) {
            this.playMaxBrLevel = playMaxBrLevel;
        }

        public String getDownloadMaxBrLevel() {
            return downloadMaxBrLevel;
        }

        public void setDownloadMaxBrLevel(String downloadMaxBrLevel) {
            this.downloadMaxBrLevel = downloadMaxBrLevel;
        }

        public String getPlLevel() {
            return plLevel;
        }

        public void setPlLevel(String plLevel) {
            this.plLevel = plLevel;
        }

        public String getDlLevel() {
            return dlLevel;
        }

        public void setDlLevel(String dlLevel) {
            this.dlLevel = dlLevel;
        }

        public String getFlLevel() {
            return flLevel;
        }

        public void setFlLevel(String flLevel) {
            this.flLevel = flLevel;
        }

        public Object getRscl() {
            return rscl;
        }

        public void setRscl(Object rscl) {
            this.rscl = rscl;
        }

        public FreeTrialPrivilegeEntity getFreeTrialPrivilege() {
            return freeTrialPrivilege;
        }

        public void setFreeTrialPrivilege(FreeTrialPrivilegeEntity freeTrialPrivilege) {
            this.freeTrialPrivilege = freeTrialPrivilege;
        }

        public List<ChargeInfoListEntity> getChargeInfoList() {
            return chargeInfoList;
        }

        public void setChargeInfoList(List<ChargeInfoListEntity> chargeInfoList) {
            this.chargeInfoList = chargeInfoList;
        }

        public static class FreeTrialPrivilegeEntity {
            private boolean resConsumable;
            private boolean userConsumable;
            private Object listenType;

            public boolean isResConsumable() {
                return resConsumable;
            }

            public void setResConsumable(boolean resConsumable) {
                this.resConsumable = resConsumable;
            }

            public boolean isUserConsumable() {
                return userConsumable;
            }

            public void setUserConsumable(boolean userConsumable) {
                this.userConsumable = userConsumable;
            }

            public Object getListenType() {
                return listenType;
            }

            public void setListenType(Object listenType) {
                this.listenType = listenType;
            }
        }

        public static class ChargeInfoListEntity {
            private int rate;
            private Object chargeUrl;
            private Object chargeMessage;
            private int chargeType;

            public int getRate() {
                return rate;
            }

            public void setRate(int rate) {
                this.rate = rate;
            }

            public Object getChargeUrl() {
                return chargeUrl;
            }

            public void setChargeUrl(Object chargeUrl) {
                this.chargeUrl = chargeUrl;
            }

            public Object getChargeMessage() {
                return chargeMessage;
            }

            public void setChargeMessage(Object chargeMessage) {
                this.chargeMessage = chargeMessage;
            }

            public int getChargeType() {
                return chargeType;
            }

            public void setChargeType(int chargeType) {
                this.chargeType = chargeType;
            }
        }
    }
}