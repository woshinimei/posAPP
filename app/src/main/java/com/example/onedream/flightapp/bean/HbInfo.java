package com.example.onedream.flightapp.bean;

public class HbInfo {
    /**
     *     	hdid	航段id	hcdx	String	Y	的航段id
     *     cfjc	出发机场	hcdx	String	Y	出发机场三字码
     *     ddjc	到达机场	hcdx	String	Y	到达机场三字码
     *     cfsj	出发时间	hcdx	String	Y	出发时间：格式2017-01-12 15:30
     *     ddjs	到达时间	hcdx	String	Y	到达时间：格式2017-01-12 16:50
     *     hkgs	航空公司	hcdx	String	Y	航司二字码如：MU
     *     hbh		航班号	hcdx	String	Y	航班号，如：MU2556
     *     jx		机型	hcdx	String	Y	机型，如：738
     *     sfjt	是否经停	hcdx	String	Y	是否经停
     *     cs		餐食	hcdx	String	Y	餐食，正餐，小吃
     *     cwbh	仓位代号	hcdx	String	Y	仓位代号，如：V
     *     cwdj	仓位等级	hcdx	String	Y	仓位等级，如：经济舱，头等舱
     *     cwzk	仓位折扣	hcdx	String	Y	仓位折扣8.4折
     *     fxsc	飞行时间	hcdx	String	Y	飞行时间，格式：2:30不足一小时：0:35
     *     cfhzl	出发航站楼	hcdx	String	Y	出发航站楼T2
     *     ddhzl	到达航站楼	hcdx	String	Y	到达航站楼T2
     *     sfkzj	是否可值机	hcdx	String	Y	是否可值机1可以 0不可以
     *     sfgzhbdt	是否可关注航班动态	hcdx	String	Y	是否可关注航班动态1可以 0不可以
     *     tgqjh		hcdx	List	Y	退改签规定集合。包括退票规定、签转规定等
     */



    private String hdid	;
    private String cfjc	;
    private String ddjc	;
    private String cfsj	;
    private String ddsj	;
    private String hkgs	;
    private String hbh		;
    private String jx		;
    private String sfjt	;
    private String cs		;
    private String cwbh	;
    private String cwdj	;
    private String cwzk	;
    private String fxsc	;
    private String cfhzl	;
    private String ddhzl	;
    private String sfkzj	;
    private String sfgzhbdt;
    private String nextDay;//是否第二天
    private  String jj;      //是否可以 接机和送机
    private String cfcity;
    private String ddcity;
    private String sj;      //

    public String getCfcity() {
        return cfcity;
    }

    public void setCfcity(String cfcity) {
        this.cfcity = cfcity;
    }

    public String getDdcity() {
        return ddcity;
    }

    public void setDdcity(String ddcity) {
        this.ddcity = ddcity;
    }

    public String getHdid() {
        return hdid;
    }

    public void setHdid(String hdid) {
        this.hdid = hdid;
    }

    public String getCfjc() {
        return cfjc;
    }

    public void setCfjc(String cfjc) {
        this.cfjc = cfjc;
    }

    public String getDdjc() {
        return ddjc;
    }

    public void setDdjc(String ddjc) {
        this.ddjc = ddjc;
    }

    public String getCfsj() {
        return cfsj;
    }

    public void setCfsj(String cfsj) {
        this.cfsj = cfsj;
    }

    public String getDdsj() {
        return ddsj;
    }

    public void setDdsj(String ddsj) {
        this.ddsj = ddsj;
    }

    public String getHkgs() {
        return hkgs;
    }

    public void setHkgs(String hkgs) {
        this.hkgs = hkgs;
    }

    public String getHbh() {
        return hbh;
    }

    public void setHbh(String hbh) {
        this.hbh = hbh;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getSfjt() {
        return sfjt;
    }

    public void setSfjt(String sfjt) {
        this.sfjt = sfjt;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getCwbh() {
        return cwbh;
    }

    public void setCwbh(String cwbh) {
        this.cwbh = cwbh;
    }

    public String getCwdj() {
        return cwdj;
    }

    public void setCwdj(String cwdj) {
        this.cwdj = cwdj;
    }

    public String getCwzk() {
        return cwzk;
    }

    public void setCwzk(String cwzk) {
        this.cwzk = cwzk;
    }

    public String getFxsc() {
        return fxsc;
    }

    public void setFxsc(String fxsc) {
        this.fxsc = fxsc;
    }

    public String getCfhzl() {
        return cfhzl;
    }

    public void setCfhzl(String cfhzl) {
        this.cfhzl = cfhzl;
    }

    public String getDdhzl() {
        return ddhzl;
    }

    public void setDdhzl(String ddhzl) {
        this.ddhzl = ddhzl;
    }

    public String getSfkzj() {
        return sfkzj;
    }

    public void setSfkzj(String sfkzj) {
        this.sfkzj = sfkzj;
    }

    public String getSfgzhbdt() {
        return sfgzhbdt;
    }

    public void setSfgzhbdt(String sfgzhbdt) {
        this.sfgzhbdt = sfgzhbdt;
    }

    public String getNextDay() {
        return nextDay;
    }

    public void setNextDay(String nextDay) {
        this.nextDay = nextDay;
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }
}
