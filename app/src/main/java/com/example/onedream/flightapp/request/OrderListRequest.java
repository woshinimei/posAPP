package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.network.BaseRequest;

import java.io.Serializable;

public class OrderListRequest extends BaseRequest implements Serializable {
    private String userKey;//用户唯一标识(必填)
    private String sign;//签名(必填)
    private String name;//乘客姓名
    private String dateType;//日期类型
    private String dateStart;//日期始 格式：yyyy-MM-dd
    private String dateEnd;//日期止  格式：yyyy-MM-dd
    private String orderStatus;//订单状态
    private String zfzt;//支付状态
    private String tkzt;//退款状态
    private int start =0;//起始页
    private int count;//每页数目

    public String getTkzt() {
        return tkzt;
    }

    public void setTkzt(String tkzt) {
        this.tkzt = tkzt;
    }

    public String getZfzt() {
        return zfzt;
    }

    public void setZfzt(String zfzt) {
        this.zfzt = zfzt;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
