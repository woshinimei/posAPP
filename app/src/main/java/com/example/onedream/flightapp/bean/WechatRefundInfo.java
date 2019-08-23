package com.example.onedream.flightapp.bean;

public class WechatRefundInfo {
    private String amount;
    private String transName;
    private String oldOrderNo;
    private String oldScanData;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getOldOrderNo() {
        return oldOrderNo;
    }

    public void setOldOrderNo(String oldOrderNo) {
        this.oldOrderNo = oldOrderNo;
    }

    public String getOldScanData() {
        return oldScanData;
    }

    public void setOldScanData(String oldScanData) {
        this.oldScanData = oldScanData;
    }
}
