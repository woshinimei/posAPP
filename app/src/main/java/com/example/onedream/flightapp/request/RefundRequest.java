package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.bean.AliPayInfo;
import com.example.onedream.flightapp.bean.PosPayInfo;
import com.example.onedream.flightapp.bean.QrCodePayInfo;
import com.example.onedream.flightapp.bean.WechatPayInfo;
import com.example.onedream.flightapp.network.BaseRequest;

public class RefundRequest extends BaseRequest {
    private String userKey;
    private String sign;
    private String refundType;//退款方式
    private String refundResult;//退款结果
    private String tkdh;//订单编号
    private String cldh;//处理编号
    private String jylsh;//交易流水号
    private PosPayInfo posRefundInfo;//
    private AliPayInfo aliRefundInfo;
    private WechatPayInfo wechatRefundInfo;
    QrCodePayInfo qrcodeRefundInfo;

    public PosPayInfo getPosRefundInfo() {
        return posRefundInfo;
    }

    public void setPosRefundInfo(PosPayInfo posRefundInfo) {
        this.posRefundInfo = posRefundInfo;
    }

    public AliPayInfo getAliRefundInfo() {
        return aliRefundInfo;
    }

    public void setAliRefundInfo(AliPayInfo aliRefundInfo) {
        this.aliRefundInfo = aliRefundInfo;
    }

    public WechatPayInfo getWechatRefundInfo() {
        return wechatRefundInfo;
    }

    public void setWechatRefundInfo(WechatPayInfo wechatRefundInfo) {
        this.wechatRefundInfo = wechatRefundInfo;
    }

    public QrCodePayInfo getQrcodeRefundInfo() {
        return qrcodeRefundInfo;
    }

    public void setQrcodeRefundInfo(QrCodePayInfo qrcodeRefundInfo) {
        this.qrcodeRefundInfo = qrcodeRefundInfo;
    }

    public PosPayInfo getPosPayInfo() {
        return posRefundInfo;
    }

    public void setPosPayInfo(PosPayInfo posPayInfo) {
        this.posRefundInfo = posPayInfo;
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

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getRefundResult() {
        return refundResult;
    }

    public void setRefundResult(String refundResult) {
        this.refundResult = refundResult;
    }

    public String getTkdh() {
        return tkdh;
    }

    public void setTkdh(String tkdh) {
        this.tkdh = tkdh;
    }

    public String getCldh() {
        return cldh;
    }

    public void setCldh(String cldh) {
        this.cldh = cldh;
    }

    public String getJylsh() {
        return jylsh;
    }

    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }
}
