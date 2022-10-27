package com.zww.music_mvvm.data;

public interface Config {
    String BaseUrl = "http://10.0.2.2:3000/";  //10.0.2.2 默认本地ip  http://10.0.2.2:3000/   192.168.137.1  10.162.32.135  192.168.42.1
    // 设置默认时间
    int DEFAULT_TIME = 6;

    String PERERNCE_FILE_NAME  = "Tobeyr1_sp";
    //router使用
    String ROUTE_LOGIN = "/app/login";

    String ROUTE_LOGINSELECT = "/app/selectLogin";

    String ROUTE_SPLASH = "/app/splash";

    String ROUTE_HOME = "/app/main";
    String ROUTE_WEB = "/app/web";

    interface SpKey{
        String TAG_LANGUAGE = "languageSelect";

        String AUTH_TOKEN = "authToken";

        String USER_INFO = "userInfo";

        String PHONE_NUMBER = "phoneNumber";

        String LATEST_SONG = "latestSong";

        String DAILY_UPDATE_TIME = "dailyUpdateTime";

        String DAILY_RECOMMEND = "dailyRecommend";

        String LIKE_LIST = "likeList";
    }

    interface Constant{
        public static final String SONG_URL = "http://music.163.com/song/media/outer/url?id=";

        public static final String KEY_LOGIN_UI = "KEY_LOGIN_UI";

        public static final String KEY_MAIN_UI = "KEY_MAIN_UI";

        public static final String BANNER_URI  = "BANNER_URI";

        public static final String APP_SHARED_SAVE = "APP_SHARED_SAVE";

        public static final String USER_INFO = "USER_INFO";

        public static final String AUTH_TOKEN = "AUTH_TOKEN";

        public static final String USER_PHONE = "USER_PHONE";

        public static final String DENIED_PERMISSION = "DENIED_PERMISSION";

        public static final String MUSIC_INFO = "MUSIC_INFO";

        public static final String PLAYLIST_ID = "PLAYLIST_ID";

        public static final String PLAY_NAME = "PLAY_NAME";


        //设置默认超时时间
        public static final int DEFAULT_TIME=6;

        public final static  String BaseUrl = "http://10.0.0.2:3030/";

    }
}
