package com.zww.music_mvvm.utils;

public class ClickUtil {
    private static final long MIN_CLICK_DELAY_TIME = 800L;
    private static long lastClickTime;

    public static boolean enableClick() {
        boolean isEnabled = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) > MIN_CLICK_DELAY_TIME) {
            isEnabled = true;
        }
        lastClickTime = curClickTime;
        return isEnabled;
    }
}
