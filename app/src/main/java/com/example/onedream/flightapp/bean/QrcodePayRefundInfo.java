package com.example.onedream.flightapp.bean;

public class QrcodePayRefundInfo {
    private String transName;
    private String amount;
    private String oldUnionPayTrad;
    private String payCodeInfo;

    public String getPayCodeInfo() {
        return payCodeInfo;
    }

    public void setPayCodeInfo(String payCodeInfo) {
        this.payCodeInfo = payCodeInfo;
    }

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

    public String getOldUnionPayTrad() {
        return oldUnionPayTrad;
    }

    public void setOldUnionPayTrad(String oldUnionPayTrad) {
        this.oldUnionPayTrad = oldUnionPayTrad;
    }
}
