package com.zww.music_mvvm.data.bean;


public class VipInfoBean {

    private String message;
    private DataBean data;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        private String redVipLevelIcon;
        private AssociatorBean associator;
        private MusicPackageBean musicPackage;
        private RedplusBean redplus;

        public AssociatorBean getAssociator() {
            return associator;
        }

        public void setAssociator(AssociatorBean associator) {
            this.associator = associator;
        }

        public MusicPackageBean getMusicPackage() {
            return musicPackage;
        }

        public void setMusicPackage(MusicPackageBean musicPackage) {
            this.musicPackage = musicPackage;
        }

        public String getRedVipLevelIcon() {
            return redVipLevelIcon;
        }

        public void setRedVipLevelIcon(String redVipLevelIcon) {
            this.redVipLevelIcon = redVipLevelIcon;
        }

        public RedplusBean getRedplus() {
            return redplus;
        }

        public void setRedplus(RedplusBean redplus) {
            this.redplus = redplus;
        }

        public static class AssociatorBean {
            private int vipCode;
            private long expireTime;
            private String iconUrl;
            private String dynamicIconUrl;
            private int vipLevel;
            private boolean isSign;
            private boolean isSignIapDeduct;
            private boolean isSignDeduct;
            private boolean isSignIap;

            public int getVipCode() {
                return vipCode;
            }

            public void setVipCode(int vipCode) {
                this.vipCode = vipCode;
            }

            public long getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(int expireTime) {
                this.expireTime = expireTime;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public Object getDynamicIconUrl() {
                return dynamicIconUrl;
            }

            public void setDynamicIconUrl(String dynamicIconUrl) {
                this.dynamicIconUrl = dynamicIconUrl;
            }

            public int getVipLevel() {
                return vipLevel;
            }

            public void setVipLevel(int vipLevel) {
                this.vipLevel = vipLevel;
            }

            public boolean isIsSign() {
                return isSign;
            }

            public void setIsSign(boolean isSign) {
                this.isSign = isSign;
            }

            public boolean isIsSignIapDeduct() {
                return isSignIapDeduct;
            }

            public void setIsSignIapDeduct(boolean isSignIapDeduct) {
                this.isSignIapDeduct = isSignIapDeduct;
            }

            public boolean isIsSignDeduct() {
                return isSignDeduct;
            }

            public void setIsSignDeduct(boolean isSignDeduct) {
                this.isSignDeduct = isSignDeduct;
            }

            public boolean isIsSignIap() {
                return isSignIap;
            }

            public void setIsSignIap(boolean isSignIap) {
                this.isSignIap = isSignIap;
            }
        }

        public static class MusicPackageBean {
            private int vipCode;
            private long expireTime;
            private String iconUrl;
            private String dynamicIconUrl;
            private int vipLevel;
            private boolean isSign;
            private boolean isSignIapDeduct;
            private boolean isSignDeduct;
            private boolean isSignIap;

            public int getVipCode() {
                return vipCode;
            }

            public void setVipCode(int vipCode) {
                this.vipCode = vipCode;
            }

            public long getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(int expireTime) {
                this.expireTime = expireTime;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public Object getDynamicIconUrl() {
                return dynamicIconUrl;
            }

            public void setDynamicIconUrl(String dynamicIconUrl) {
                this.dynamicIconUrl = dynamicIconUrl;
            }

            public int getVipLevel() {
                return vipLevel;
            }

            public void setVipLevel(int vipLevel) {
                this.vipLevel = vipLevel;
            }

            public boolean isIsSign() {
                return isSign;
            }

            public void setIsSign(boolean isSign) {
                this.isSign = isSign;
            }

            public boolean isIsSignIapDeduct() {
                return isSignIapDeduct;
            }

            public void setIsSignIapDeduct(boolean isSignIapDeduct) {
                this.isSignIapDeduct = isSignIapDeduct;
            }

            public boolean isIsSignDeduct() {
                return isSignDeduct;
            }

            public void setIsSignDeduct(boolean isSignDeduct) {
                this.isSignDeduct = isSignDeduct;
            }

            public boolean isIsSignIap() {
                return isSignIap;
            }

            public void setIsSignIap(boolean isSignIap) {
                this.isSignIap = isSignIap;
            }
        }

        public static class RedplusBean {
            private int vipCode;
            private int expireTime;
            private String iconUrl;
            private String dynamicIconUrl;
            private int vipLevel;
            private boolean isSign;
            private boolean isSignIapDeduct;
            private boolean isSignDeduct;
            private boolean isSignIap;

            public int getVipCode() {
                return vipCode;
            }

            public void setVipCode(int vipCode) {
                this.vipCode = vipCode;
            }

            public int getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(int expireTime) {
                this.expireTime = expireTime;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public Object getDynamicIconUrl() {
                return dynamicIconUrl;
            }

            public void setDynamicIconUrl(String dynamicIconUrl) {
                this.dynamicIconUrl = dynamicIconUrl;
            }

            public int getVipLevel() {
                return vipLevel;
            }

            public void setVipLevel(int vipLevel) {
                this.vipLevel = vipLevel;
            }

            public boolean isIsSign() {
                return isSign;
            }

            public void setIsSign(boolean isSign) {
                this.isSign = isSign;
            }

            public boolean isIsSignIapDeduct() {
                return isSignIapDeduct;
            }

            public void setIsSignIapDeduct(boolean isSignIapDeduct) {
                this.isSignIapDeduct = isSignIapDeduct;
            }

            public boolean isIsSignDeduct() {
                return isSignDeduct;
            }

            public void setIsSignDeduct(boolean isSignDeduct) {
                this.isSignDeduct = isSignDeduct;
            }

            public boolean isIsSignIap() {
                return isSignIap;
            }

            public void setIsSignIap(boolean isSignIap) {
                this.isSignIap = isSignIap;
            }
        }
    }
}
