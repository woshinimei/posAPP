package com.example.onedream.flightapp.utils;

import android.text.TextUtils;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTextUtil {
//    public static String clearNullText(String content) {
//        if (TextUtils.isEmpty(content)) {
//            return "";
//        } else {
//            return content;
//        }
//    }

    public static String clearNullText(String... values) {
        StringBuilder builder = new StringBuilder();
        if (values!=null) {
            for (String value : values) {
                if (!TextUtils.isEmpty(value)) {
                       builder.append(value);
                }
            }
        }
        return builder.toString();
    }
    public static String replaceBlank(String src) {
        String dest = "";
        if (src != null) {
            Pattern pattern = Pattern.compile("\t|\r|\n|\\s*");
            Matcher matcher = pattern.matcher(src);
            dest = matcher.replaceAll("");
        }
        return dest;
    }

}
