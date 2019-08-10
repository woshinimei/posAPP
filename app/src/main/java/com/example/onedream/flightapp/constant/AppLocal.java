package com.example.onedream.flightapp.constant;

import com.example.onedream.flightapp.request.OrderDetailRequest;
import com.example.onedream.flightapp.request.OrderListRequest;

/**
 * app 相关常量
 * */
public class AppLocal {
    //用户缓存
    public static String USER = "user";
    //登录状态
    public static String USER_LOGIN="user_login_status";
    //登录账号
    public static String USER_NAME = "user_name";
    //登录密码
    public static String USER_PWD = "user_pwd";
    //登录返回的userKey
    public static String USERKEY ="";
    //订单列表筛选缓存
    public  static OrderListRequest listRequest;
}
