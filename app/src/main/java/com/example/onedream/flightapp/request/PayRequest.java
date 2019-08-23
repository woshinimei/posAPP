package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.bean.AliPayInfo;
import com.example.onedream.flightapp.bean.PosPayInfo;
import com.example.onedream.flightapp.bean.QrCodePayInfo;
import com.example.onedream.flightapp.bean.WechatPayInfo;
import com.example.onedream.flightapp.network.BaseRequest;

public class PayRequest extends BaseRequest {
    private String userKey;
    private String sign;
    private String payResult;//支付结果
    private String ddbh;//订单编号
    private String payType;//支付方式(pos支付,微信，支付宝和二维码)
    private PosPayInfo posPayInfo;//POS支付信息
    private AliPayInfo aliPayInfo;//支付宝支付信息
    private WechatPayInfo wechatPayInfo;//微信支付信息
    private QrCodePayInfo qrcodePayInfo;//二维码支付信息

    public AliPayInfo getAliPayInfo() {
        return aliPayInfo;
    }

    public void setAliPayInfo(AliPayInfo aliPayInfo) {
        this.aliPayInfo = aliPayInfo;
    }

    public WechatPayInfo getWechatPayInfo() {
        return wechatPayInfo;
    }

    public void setWechatPayInfo(WechatPayInfo wechatPayInfo) {
        this.wechatPayInfo = wechatPayInfo;
    }

    public QrCodePayInfo getQrcodePayInfo() {
        return qrcodePayInfo;
    }

    public void setQrcodePayInfo(QrCodePayInfo qrcodePayInfo) {
        this.qrcodePayInfo = qrcodePayInfo;
    }

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
