package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.network.BaseRequest;

public class ControlRequest extends BaseRequest {
    private String userKey;//用户唯一标识
    private String sign;//签
    private String ddbh;//订单编号
    private String pnr;//
    private String dsDept;//调度部门
    private String dsComp;//调度公司
    private String ddlx_dd;//订单调度类型
    private String dsdh;//调度单号
    private String confirmDate;//确定出票时间、年月日
    private String confirmTime;//确定出票时间、时分

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

    public String getDdbh() {
        return ddbh;
    }

    public void setDdbh(String ddbh) {
        this.ddbh = ddbh;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getDsDept() {
        return dsDept;
    }

    public void setDsDept(String dsDept) {
        this.dsDept = dsDept;
    }

    public String getDsComp() {
        return dsComp;
    }

    public void setDsComp(String dsComp) {
        this.dsComp = dsComp;
    }

    public String getDdlx_dd() {
        return ddlx_dd;
    }

    public void setDdlx_dd(String ddlx_dd) {
        this.ddlx_dd = ddlx_dd;
    }

    public String getDsdh() {
        return dsdh;
    }

    public void setDsdh(String dsdh) {
        this.dsdh = dsdh;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }
}
