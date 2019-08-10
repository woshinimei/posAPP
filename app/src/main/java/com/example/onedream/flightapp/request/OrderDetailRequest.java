package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.network.BaseRequest;

public class OrderDetailRequest extends BaseRequest {
    private String userKey;//用户唯一标识（必传）
    private String sign;//签名（必传）
    private String orderNo;//订单编号（非必传）

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
