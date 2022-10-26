package com.zww.music_mvvm.data.bean;

import java.util.List;

public class Login_Bean {


    /**
     * loginType : 1
     * code : 200
     * account : {"id":1644355014,"userName":"1_15797674853","type":1,"status":0,"whitelistAuthority":0,"createTime":1665753335713,"salt":"[B@58eae4b0","tokenVersion":1,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false,"uninitialized":false}
     * token : 62e41411c9dcf62cdd42f962de9cf69ab571ba4d2f33fb30c90365e284124797519e07624a9f005394a3ff5c46766603b3eb1fc2d7fe74f84725a358bd645c927ea9237a23d219277a561ba977ae766d
     * profile : {"followed":false,"backgroundUrl":"https://p2.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","userId":1644355014,"backgroundImgIdStr":"109951162868128395","avatarImgIdStr":"109951165647004069","userType":0,"avatarUrl":"https://p3.music.126.net/SUeqMM8HOIpHv9Nhl9qt9w==/109951165647004069.jpg","vipType":0,"authStatus":0,"djStatus":0,"detailDescription":"","experts":{},"expertTags":null,"accountStatus":0,"nickname":"银纱伴微风","birthday":-2209017600000,"gender":0,"province":0,"city":100,"avatarImgId":109951165647004060,"backgroundImgId":109951162868128400,"defaultAvatar":false,"mutual":false,"remarkName":null,"description":"","signature":"","authority":0,"avatarImgId_str":"109951165647004069","followeds":0,"follows":1,"eventCount":0,"avatarDetail":null,"playlistCount":1,"playlistBeSubscribedCount":0}
     * bindings : [{"userId":1644355014,"url":"","expired":false,"bindingTime":1665753335718,"refreshTime":1665753335,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"15797674853\",\"hasPassword\":true}","expiresIn":2147483647,"id":13643240588,"type":1}]
     * cookie : MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/wapi/clientlog;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/eapi/feedback;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/weapi/feedback;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/neapi/feedback;;MUSIC_U=62e41411c9dcf62cdd42f962de9cf69ab571ba4d2f33fb30c90365e284124797519e07624a9f005394a3ff5c46766603b3eb1fc2d7fe74f84725a358bd645c927ea9237a23d219277a561ba977ae766d; Max-Age=1296000; Expires=Sat, 29 Oct 2022 13:17:29 GMT; Path=/;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/neapi/clientlog;;__csrf=4d7517c470f74392e5b34b43a9240746; Max-Age=1296010; Expires=Sat, 29 Oct 2022 13:17:39 GMT; Path=/;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/openapi/clientlog;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/weapi/clientlog;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/api/feedback;;MUSIC_SNS=; Max-Age=0; Expires=Fri, 14 Oct 2022 13:17:29 GMT; Path=/;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/wapi/feedback;;__remember_me=true; Max-Age=1296000; Expires=Sat, 29 Oct 2022 13:17:29 GMT; Path=/;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/wapi/clientlog;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/eapi/clientlog;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/neapi/clientlog;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/eapi/clientlog;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/eapi/feedback;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/neapi/feedback;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/api/clientlog;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/wapi/feedback;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/api/feedback;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/weapi/clientlog;;MUSIC_A_T=1665753335713; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/weapi/feedback;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/api/clientlog;;MUSIC_R_T=1665753335912; Max-Age=2147483647; Expires=Wed, 01 Nov 2090 16:31:36 GMT; Path=/openapi/clientlog;
     */

    private int loginType;
    private int code;
    private AccountBean account;
    private String token;
    private ProfileBean profile;
    private String cookie;
    private List<BindingsBean> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 1644355014
         * userName : 1_15797674853
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1665753335713
         * salt : [B@58eae4b0
         * tokenVersion : 1
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         * uninitialized : false
         */

        private int id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private int viptypeVersion;
        private boolean anonimousUser;
        private boolean uninitialized;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }

        public boolean isUninitialized() {
            return uninitialized;
        }

        public void setUninitialized(boolean uninitialized) {
            this.uninitialized = uninitialized;
        }
    }

    public static class ProfileBean {
        /**
         * followed : false
         * backgroundUrl : https://p2.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg
         * userId : 1644355014
         * backgroundImgIdStr : 109951162868128395
         * avatarImgIdStr : 109951165647004069
         * userType : 0
         * avatarUrl : https://p3.music.126.net/SUeqMM8HOIpHv9Nhl9qt9w==/109951165647004069.jpg
         * vipType : 0
         * authStatus : 0
         * djStatus : 0
         * detailDescription :
         * experts : {}
         * expertTags : null
         * accountStatus : 0
         * nickname : 银纱伴微风
         * birthday : -2209017600000
         * gender : 0
         * province : 0
         * city : 100
         * avatarImgId : 109951165647004060
         * backgroundImgId : 109951162868128400
         * defaultAvatar : false
         * mutual : false
         * remarkName : null
         * description :
         * signature :
         * authority : 0
         * avatarImgId_str : 109951165647004069
         * followeds : 0
         * follows : 1
         * eventCount : 0
         * avatarDetail : null
         * playlistCount : 1
         * playlistBeSubscribedCount : 0
         */

        private boolean followed;
        private String backgroundUrl;
        private int userId;
        private String backgroundImgIdStr;
        private String avatarImgIdStr;
        private int userType;
        private String avatarUrl;
        private int vipType;
        private int authStatus;
        private int djStatus;
        private String detailDescription;
        private ExpertsBean experts;
        private Object expertTags;
        private int accountStatus;
        private String nickname;
        private long birthday;
        private int gender;
        private int province;
        private int city;
        private long avatarImgId;
        private long backgroundImgId;
        private boolean defaultAvatar;
        private boolean mutual;
        private Object remarkName;
        private String description;
        private String signature;
        private int authority;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int eventCount;
        private Object avatarDetail;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public Object getAvatarDetail() {
            return avatarDetail;
        }

        public void setAvatarDetail(Object avatarDetail) {
            this.avatarDetail = avatarDetail;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * userId : 1644355014
         * url :
         * expired : false
         * bindingTime : 1665753335718
         * refreshTime : 1665753335
         * tokenJsonStr : {"countrycode":"","cellphone":"15797674853","hasPassword":true}
         * expiresIn : 2147483647
         * id : 13643240588
         * type : 1
         */

        private int userId;
        private String url;
        private boolean expired;
        private long bindingTime;
        private int refreshTime;
        private String tokenJsonStr;
        private int expiresIn;
        private long id;
        private int type;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

}
