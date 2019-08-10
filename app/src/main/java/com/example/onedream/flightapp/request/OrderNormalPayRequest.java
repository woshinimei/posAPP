package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.bean.PosPayInfo;
import com.example.onedream.flightapp.network.BaseRequest;

public class OrderNormalPayRequest extends BaseRequest {
    private String userKey;//用户唯一标识（必填）
    private String sign;
    private String payType;
    private String payResult;
    private PosPayInfo posPayInfo;//POS支付信息
    private String aliPayInfo;//支付宝支付信息
    private String wechatPayInfo;//微信支付信息
    private String prePayInfo;//预授权支付信息
    private String qrcodePayInfo;//二维码支付信息
    private String ddbh;//订单编号

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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public PosPayInfo getPosPayInfo() {
        return posPayInfo;
    }

    public void setPosPayInfo(PosPayInfo posPayInfo) {
        this.posPayInfo = posPayInfo;
    }

    public String getAliPayInfo() {
        return aliPayInfo;
    }

    public void setAliPayInfo(String aliPayInfo) {
        this.aliPayInfo = aliPayInfo;
    }

    public String getWechatPayInfo() {
        return wechatPayInfo;
    }

    public void setWechatPayInfo(String wechatPayInfo) {
        this.wechatPayInfo = wechatPayInfo;
    }

    public String getPrePayInfo() {
        return prePayInfo;
    }

    public void setPrePayInfo(String prePayInfo) {
        this.prePayInfo = prePayInfo;
    }

    public String getQrcodePayInfo() {
        return qrcodePayInfo;
    }

    public void setQrcodePayInfo(String qrcodePayInfo) {
        this.qrcodePayInfo = qrcodePayInfo;
    }

    public String getDdbh() {
        return ddbh;
    }

    public void setDdbh(String ddbh) {
        this.ddbh = ddbh;
    }
}
