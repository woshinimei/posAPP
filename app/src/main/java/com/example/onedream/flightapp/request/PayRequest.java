package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.bean.PosPayInfo;
import com.example.onedream.flightapp.network.BaseRequest;

public class PayRequest extends BaseRequest {
    private String userKey;
    private String sign;
    private String payResult;//支付结果
    private String ddbh;//订单编号
    private String payType;//支付方式
    private PosPayInfo posPayInfo;//

    public PosPayInfo getPosPayInfo() {
        return posPayInfo;
    }

    public void setPosPayInfo(PosPayInfo posPayInfo) {
        this.posPayInfo = posPayInfo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getDdbh() {
        return ddbh;
    }

    public void setDdbh(String ddbh) {
        this.ddbh = ddbh;
    }
}
