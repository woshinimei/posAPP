package com.example.onedream.flightapp.bean;

public class TravelInfo {
    /*  qysph	出差申请单号	clxx	String	N 出差申请单号
    xmdh	项目代号	clxx	String	N	项目代号
    xmmc	项目名称	clxx	String	N	项目名称
    wbyybh	违背原因编号	clxx	String	N	违背原因编号
    wbyysm	违背原因说明	clxx	String	N	违背原因说明
    ccsx	出差事由	clxx	String	N	出差事由*/
    private String qysph	;
    private String xmdh	;
    private String xmmc	;
    private String wbyybh	;
    private String wbyysm	;
    private String ccsx	;

    public String getQysph() {
        return qysph;
    }

    public void setQysph(String qysph) {
        this.qysph = qysph;
    }

    public String getXmdh() {
        return xmdh;
    }

    public void setXmdh(String xmdh) {
        this.xmdh = xmdh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getWbyybh() {
        return wbyybh;
    }

    public void setWbyybh(String wbyybh) {
        this.wbyybh = wbyybh;
    }

    public String getWbyysm() {
        return wbyysm;
    }

    public void setWbyysm(String wbyysm) {
        this.wbyysm = wbyysm;
    }

    public String getCcsx() {
        return ccsx;
    }

    public void setCcsx(String ccsx) {
        this.ccsx = ccsx;
    }
}
