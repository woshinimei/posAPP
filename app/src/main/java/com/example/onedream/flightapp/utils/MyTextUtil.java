package com.example.onedream.flightapp.utils;

public class MyTextUtil {
    public static String setNullText(String content){
        if (android.text.TextUtils.isEmpty(content)){
            return "";
        }else {
            return content;
        }
    }
}
