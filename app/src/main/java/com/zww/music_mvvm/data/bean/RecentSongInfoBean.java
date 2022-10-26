package com.zww.music_mvvm.data.bean;

import java.util.List;

public class RecentSongInfoBean {

    private int code;
    private RecentDataEntity data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RecentDataEntity getData() {
        return data;
    }

    public void setData(RecentDataEntity data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class RecentDataEntity {
        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String resourceId;
            private long playTime;
            private String resourceType;
            private DataBean data;
            private boolean banned;

            public String getResourceId() {
                return resourceId;
            }

            public void setResourceId(String resourceId) {
                this.resourceId = resourceId;
            }

            public long getPlayTime() {
                return playTime;
            }

            public void setPlayTime(long playTime) {
                this.playTime = playTime;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public boolean isBanned() {
                return banned;
            }

            public void setBanned(boolean banned) {
                this.banned = banned;
            }

            public static class DataBean {
                private String name;
                private int id;
                private int pst;
                private int t;
                private List<ArBean> ar;
                private List<?> alia;
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
                private Object a;
                private String cd;
                private int no;
                private Object rtUrl;
                private int ftype;
                private List<?> rtUrls;
                private int djId;
                private int copyright;
                private int s_id;
                private int mark;
                private int originCoverType;
                private Object originSongSimpleData;
                private int single;
                private Object noCopyrightRcmd;
                private int rtype;
                private Object rurl;
                private int mst;
                private int cp;
                private int mv;
                private long publishTime;
                private List<String> tns;

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

                public List<ArBean> getAr() {
                    return ar;
                }

                public void setAr(List<DataBean.ArBean> ar) {
                    this.ar = ar;
                }

                public List<?> getAlia() {
                    return alia;
                }

                public void setAlia(List<?> alia) {
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

                public List<String> getTns() {
                    return tns;
                }

                public void setTns(List<String> tns) {
                    this.tns = tns;
                }

                public static class AlBean {
                    private int id;
                    private String name;
                    private String picUrl;
                    private List<?> tns;
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
                    private int vd;

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
                }

                public static class MBean {
                    private int br;
                    private int fid;
                    private int size;
                    private int vd;

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
                }

                public static class LBean {
                    private int br;
                    private int fid;
                    private int size;
                    private int vd;

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
        }
    }
}
