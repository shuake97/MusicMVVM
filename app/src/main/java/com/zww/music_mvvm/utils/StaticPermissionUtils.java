package com.zww.music_mvvm.utils;

import android.Manifest;
import android.os.Build;

import java.util.ArrayList;

public class StaticPermissionUtils {
    public static final String[] ARR_NEED_PERMISSIONS = new ArrayList<String>(){
        {
//            add(Manifest.permission.CAMERA);
            add(Manifest.permission.READ_EXTERNAL_STORAGE);
            add(Manifest.permission.READ_PHONE_STATE);
            add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            add(Manifest.permission.RECORD_AUDIO);

        }
    }.toArray(new String[0]);
}
