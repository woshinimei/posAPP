package com.example.onedream.flightapp.constant;

import com.example.onedream.flightapp.request.OrderListRequest;

/**
 * app 相关常量
 * */
public class AppLocal {
    //用户缓存
    public static String USER = "user";
    //登录账号
    public static String USER_NAME = "user_name";
    //登录密码
    public static String USER_PWD = "user_pwd";
    //登录返回的userKey
    public static String USER_KEY ="user_key";



    //订单筛选条件（订单状态）    //0：申请中   1：已订座  2：已调度   3：已出票  4：配送中   5：部分出票 7：客户消   8：已取消  9：完成
    public static String[] orderStatus = {"全部","申请中","已订座","已调度","已出票","配送中","部分出票","客户消","已取消","完成"};
    public static String[] orderStatusType = {"","0","1","2","3","4","5","7","8","9"};

    //订单返回参数（退票订单列表）    // A：待审核0：待确认1：已申请2：已审核3：已调度4：配送中5：已完成 6：已打单7：已取消
    public static String[] orderStatusOfRefund = {"全部","待审核","待确认","已申请","已审核","已调度","配送中","已完成","已打单","已取消"};
    public static String[] orderStatusTypeOfRefund = {"","A","0","1","2","3","4","5","6","7"};

    //订单筛选条件（日期类型）//1:调度日期  2:预订日期 3：起飞日期(退废单：1：办理日期 2：采购办理日期 3：起飞日期)
    public static String [] orderTimeStatus = {"调度日期","预订日期","起飞日期"};
    public static String [] orderTimeStatusOfRefund = {"办理日期","采购办理日期","起飞日期"};
    public static String[] orderTimeType = {"1","2","3"};

    //订单筛选条件（支付状态）
    public static String[] payStatus = {"未付","已付","部分付","全部"};
    public static String[] payStatusType = {"0","1","2",""};

    //订单筛选条件（退款状态）
    public static String[] refundStatus = {"未退","已退","全部"};
    public static String[] refundStatusType = {"0","1",""};

    //订单列表筛选缓存
    public  static OrderListRequest normalRequest ;//（普通）
    public static OrderListRequest refundRequest ;//（退费）
    public static OrderListRequest endoreRequest ;//(改签)
}
