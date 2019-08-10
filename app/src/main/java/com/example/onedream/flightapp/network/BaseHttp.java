package com.example.onedream.flightapp.network;

public class BaseHttp {
    //正式地址
//    private static String BASE ="http://tmc.shenzhenair.com/openapi/boc/";
    //测试地址
//    private static String BASE = "http://10.13.131.105:8099/openapi/boc/";
    private static String BASE = "http://10.21.89.40:8080/openapi/boc/";
    //登录接口
    public static String LOGIN = BASE + "login";

    //普通单列表接口
    public static String ORDERLIST_NORMAL = BASE + "getOrderList";
    //普通单详情接口
    public static String ORDERDETAIL_NORMAL = BASE + "getOrderDetail";
    //普通单支付接口
    public static String ORDER_NORMA_LPAY = BASE +"orderPay";


    //退废单列表接口
    public static String ORDERLIST_REFUEND = BASE + "getTfOrderList";
    //退废单详情接口
    public static String ORDERDETAIL_REFUEND = BASE + "getTfOrderDetail";
    //退废单退款
    public static String ORDER_REFUND_LPAY = BASE +"orderRefund";


    //改签单列表接口
    public static String ORDERLIST_ENDORE = BASE + "getGqdOrderList";
    //改签单详情接口
    public static String ORDERDETAIL_ENDORE = BASE + "getGqdOrderDetail";
    //改签单支付接口
    public static String ORDER_ENDORE_LPAY = BASE +"gqdOrderPay";

    /**
     * 调度接口用于出票，在支付后调用
     */
    //调度部门列表接口
    public static String CONTROL_COMPANY_LIST =BASE+"getDeptList";
    //普通单调度部门接口
    public static String ORDER_NORMA_SAVE =BASE +"saveDept";
    //退废单调度部门接口
    public static String ORDER_REFUND_SAVE =BASE +"saveTfDept";
    //改签单调度部门接口
    public static String ORDER_ENDORE_SAVE =BASE +"saveGqdDept";
}
