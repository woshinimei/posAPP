package com.example.onedream.flightapp.bean;

public class QrCodePayInfo {
    private String amount;//金额
    private String traceNo;//流水号
    private String referenceNo;//参考号
    private String cardNo;//卡号
    private String authorizationCode;//授权码
    private String batchNo;//批次号
    private String time;//交易时间
    private String date;//交易日期
    private String terminalId;//终端号
    private String merchantId;//商户号
    private String merchantName;//商户名称
    private String payCodInfo;//付款码信息
    private String unionPayTradeNo;//付款凭证号（用于撤销/退货）
    private String promotionCode;//优惠产品码（如:DD01-随机立减            CP01-满额立减）（优惠时返)
    private String realAmount;//实际金额，如000000001000（优惠时返）
    private String promotionAmount;//优惠金额，如000000001000（优惠时返）

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPayCodInfo() {
        return payCodInfo;
    }

    public void setPayCodInfo(String payCodInfo) {
        this.payCodInfo = payCodInfo;
    }

    public String getUnionPayTradeNo() {
        return unionPayTradeNo;
    }

    public void setUnionPayTradeNo(String unionPayTradeNo) {
        this.unionPayTradeNo = unionPayTradeNo;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(String realAmount) {
        this.realAmount = realAmount;
    }

    public String getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(String promotionAmount) {
        this.promotionAmount = promotionAmount;
    }
}
