package com.zww.music_mvvm.data.bean;

public class LyricBean {

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LrcEntity lrc;
    private KlyricEntity klyric;
    private TlyricEntity tlyric;
    private RomalrcEntity romalrc;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LrcEntity getLrc() {
        return lrc;
    }

    public void setLrc(LrcEntity lrc) {
        this.lrc = lrc;
    }

    public KlyricEntity getKlyric() {
        return klyric;
    }

    public void setKlyric(KlyricEntity klyric) {
        this.klyric = klyric;
    }

    public TlyricEntity getTlyric() {
        return tlyric;
    }

    public void setTlyric(TlyricEntity tlyric) {
        this.tlyric = tlyric;
    }

    public RomalrcEntity getRomalrc() {
        return romalrc;
    }

    public void setRomalrc(RomalrcEntity romalrc) {
        this.romalrc = romalrc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LrcEntity {
            private int version;
            private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }


        public static class KlyricEntity {
            private int version;
            private String lyric;

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public String getLyric() {
                return lyric;
            }

            public void setLyric(String lyric) {
                this.lyric = lyric;
            }
        }


        public static class TlyricEntity {
            private int version;
            private String lyric;

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public String getLyric() {
                return lyric;
            }

            public void setLyric(String lyric) {
                this.lyric = lyric;
            }
        }


        public static class RomalrcEntity {
            private int version;
            private String lyric;

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public String getLyric() {
                return lyric;
            }

            public void setLyric(String lyric) {
                this.lyric = lyric;
            }
        }
    }
