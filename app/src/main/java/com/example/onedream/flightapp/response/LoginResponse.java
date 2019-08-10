package com.example.onedream.flightapp.response;

import com.example.onedream.flightapp.network.BaseResponse;

public class LoginResponse extends BaseResponse {
    private String userKey;//用户唯一标识

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
