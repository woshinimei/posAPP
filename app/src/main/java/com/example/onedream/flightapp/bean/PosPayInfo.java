package com.example.onedream.flightapp.bean;

public class PosPayInfo {
    private String amount;//金额
    private String traceNo;//流水号
    private String referenceNo;//参考号
    private String cardNo;//卡号
    private String type;//(卡类型，俩位数)01-中行借记卡,02-中行信用卡(分行),04-中行信用卡(总行),11-银联借记卡,21-VISA借记卡,22-VISA信用卡,31-MC借记卡,32-MC信用卡,42-运通卡,52-大来卡,62-JCB卡,72-南商信用卡
    private String issue;//发卡行
    private String batchNo;//批次号
    private String time;//交易时间
    private String date;//交易日期
    private String terminalId;//终端号
    private String merchantId;//商户号
    private String merchantName;//商户名称

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
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
}
