package com.zww.music_mvvm.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailySongsBean {

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<SongsBean> dailySongs;
        private List<?> orderSongs;
        private List<RecommendReasonsBean> recommendReasons;

        public List<SongsBean> getDailySongs() {
            return dailySongs;
        }

        public void setDailySongs(List<SongsBean> dailySongs) {
            this.dailySongs = dailySongs;
        }

        public List<?> getOrderSongs() {
            return orderSongs;
        }

        public void setOrderSongs(List<?> orderSongs) {
            this.orderSongs = orderSongs;
        }

        public List<RecommendReasonsBean> getRecommendReasons() {
            return recommendReasons;
        }

        public void setRecommendReasons(List<RecommendReasonsBean> recommendReasons) {
            this.recommendReasons = recommendReasons;
        }

        public static class SongsBean {
            private String name;
            private long id;
            private int pst;
            private int t;
            private List<ArBean> ar;
            private List<String> alia;
            private int pop;
            private int st;
            private String rt;
            private int fee;
            private int v;
            private Object crbt;
            private String cf;
            private AlBean al;
            private int dt;
            private HBean h;
            private MBean m;
            private LBean l;
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
            private int sId;
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
            private int rtype;
            private Object rurl;
            private int mst;
            private int cp;
            private int mv;
            private long publishTime;
            private String reason;
            private List<String> tns;
            private PrivilegeBean privilege;
            private String alg;
            private String sCtrp;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getId() {
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

            public List<ArBean> getAr() {
                return ar;
            }

            public void setAr(List<ArBean> ar) {
                this.ar = ar;
            }

            public List<?> getAlia() {
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

            public Object getRt() {
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

            public AlBean getAl() {
                return al;
            }

            public void setAl(AlBean al) {
                this.al = al;
            }

            public int getDt() {
                return dt;
            }

            public void setDt(int dt) {
                this.dt = dt;
            }

            public HBean getH() {
                return h;
            }

            public void setH(HBean h) {
                this.h = h;
            }

            public MBean getM() {
                return m;
            }

            public void setM(MBean m) {
                this.m = m;
            }

            public LBean getL() {
                return l;
            }

            public void setL(LBean l) {
                this.l = l;
            }

            public Object getSq() {
                return sq;
            }

            public void setSq(SqBean sq) {
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

            public int getSId() {
                return sId;
            }

            public void setSId(int sId) {
                this.sId = sId;
            }

            public long getMark() {
                return mark;
            }

            public void setMark(int mark) {
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

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public List<String> getTns() {
                return tns;
            }

            public void setTns(List<String> tns) {
                this.tns = tns;
            }

            public PrivilegeBean getPrivilege() {
                return privilege;
            }

            public void setPrivilege(PrivilegeBean privilege) {
                this.privilege = privilege;
            }

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public String getSCtrp() {
                return sCtrp;
            }

            public void setSCtrp(String sCtrp) {
                this.sCtrp = sCtrp;
            }

            public static class AlBean {
                private int id;
                private String name;
                private String picUrl;
                private List<?> tns;
                private String picStr;
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

                public String getPicStr() {
                    return picStr;
                }

                public void setPicStr(String picStr) {
                    this.picStr = picStr;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }
            }

            public static class HBean {
                private int br;
                private int fid;
                private int size;
                private double vd;
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

                public double getVd() {
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

            public static class MBean {
                private int br;
                private int fid;
                private int size;
                private double vd;
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

                public double getVd() {
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

            public static class LBean {
                private int br;
                private int fid;
                private int size;
                private double vd;
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

                public double getVd() {
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

            public static class SqBean {
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

            public static class PrivilegeBean {
                private int id;
                private int fee;
                private int payed;
                private int st;
                private int pl;
                private int dl;
                private int sp;
                private int cp;
                private int subp;
                private boolean cs;
                private int maxbr;
                private int fl;
                private boolean toast;
                private int flag;
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
                private FreeTrialPrivilegeBean freeTrialPrivilege;
                private List<ChargeInfoListBean> chargeInfoList;

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

                public FreeTrialPrivilegeBean getFreeTrialPrivilege() {
                    return freeTrialPrivilege;
                }

                public void setFreeTrialPrivilege(FreeTrialPrivilegeBean freeTrialPrivilege) {
                    this.freeTrialPrivilege = freeTrialPrivilege;
                }

                public List<ChargeInfoListBean> getChargeInfoList() {
                    return chargeInfoList;
                }

                public void setChargeInfoList(List<ChargeInfoListBean> chargeInfoList) {
                    this.chargeInfoList = chargeInfoList;
                }

                public static class FreeTrialPrivilegeBean {
                    @SerializedName("resConsumable")
                    private boolean resConsumable;
                    @SerializedName("userConsumable")
                    private boolean userConsumable;
                    @SerializedName("listenType")
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

                public static class ChargeInfoListBean {
                    @SerializedName("rate")
                    private int rate;
                    @SerializedName("chargeUrl")
                    private Object chargeUrl;
                    @SerializedName("chargeMessage")
                    private Object chargeMessage;
                    @SerializedName("chargeType")
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

            public static class ArBean {
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

        public static class RecommendReasonsBean {
            private int songId;
            private String reason;
            private String reasonId;
            private Object targetUrl;

            public int getSongId() {
                return songId;
            }

            public void setSongId(int songId) {
                this.songId = songId;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getReasonId() {
                return reasonId;
            }

            public void setReasonId(String reasonId) {
                this.reasonId = reasonId;
            }

            public Object getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(Object targetUrl) {
                this.targetUrl = targetUrl;
            }
        }
    }
}
