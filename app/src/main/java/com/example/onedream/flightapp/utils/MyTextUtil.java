package com.example.onedream.flightapp.utils;

import android.text.TextUtils;

public class MyTextUtil {
    public static String clearNullText(String content){
        if (TextUtils.isEmpty(content)){
            return "";
        }else {
            return content;
        }
    }
}
