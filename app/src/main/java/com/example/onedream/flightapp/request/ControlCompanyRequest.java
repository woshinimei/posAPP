package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.network.BaseRequest;

public class ControlCompanyRequest extends BaseRequest {
    private String userKey;
    private String sign;

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
}
