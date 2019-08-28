package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.network.BaseRequest;

public class CheckRefundRequest extends BaseRequest {
    private String userKey;
    private String sign;
    private String ddbh;//订单编号
    private String amount;//退款金额

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

    public String getDdbh() {
        return ddbh;
    }

    public void setDdbh(String ddbh) {
        this.ddbh = ddbh;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
