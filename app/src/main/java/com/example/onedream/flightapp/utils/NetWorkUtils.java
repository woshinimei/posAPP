package com.example.onedream.flightapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkUtils {
    //判断网络是否连接
    public static boolean IsNetWorkConnected(Context context) {
        boolean isNetConnected;
        //获得网络服务
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()){
            isNetConnected = true;
        }else {
            isNetConnected = false;
        }
        return isNetConnected;

    }
}

