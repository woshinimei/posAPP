package com.example.onedream.flightapp.bean;

public class PosPayRefundInfo {
    private String transName;
    private String amount;
    private String orgTime;
    private String orgTraceNo;
    private String orgAuthCode;

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrgTime() {
        return orgTime;
    }

    public void setOrgTime(String orgTime) {
        this.orgTime = orgTime;
    }

    public String getOrgTraceNo() {
        return orgTraceNo;
    }

    public void setOrgTraceNo(String orgTraceNo) {
        this.orgTraceNo = orgTraceNo;
    }

    public String getOrgAuthCode() {
        return orgAuthCode;
    }

    public void setOrgAuthCode(String orgAuthCode) {
        this.orgAuthCode = orgAuthCode;
    }
}
