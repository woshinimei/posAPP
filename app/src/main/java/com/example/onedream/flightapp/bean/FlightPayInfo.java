package com.example.onedream.flightapp.bean;

public class FlightPayInfo {
    private String  ddbh;     //订单编号
    private String ddlx;   //订单类型
    private String ddje;  //订单金额

    public String getDdbh() {
        return ddbh;
    }

    public void setDdbh(String ddbh) {
        this.ddbh = ddbh;
    }

    public String getDdlx() {
        return ddlx;
    }

    public void setDdlx(String ddlx) {
        this.ddlx = ddlx;
    }

    public String getDdje() {
        return ddje;
    }

    public void setDdje(String ddje) {
        this.ddje = ddje;
    }
}
