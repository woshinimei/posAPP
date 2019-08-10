package com.example.onedream.flightapp.bean;

import java.util.List;

public class ControlBean {
    private String bh;//编号
    private String gs;//所属公司
    private String mc;//部门名称
    private String lxr;//联系人
    List<PayInfo> zfxxjh;//支付集合
    TravelInfo clxx;//差旅信息
    FlightPayInfo gjhcxx;//支付信息
    List<InterHbInfo> jgzcjh;//国际航班信息
    List<CouponInfo> coupon;//卡券信息

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public List<PayInfo> getZfxxjh() {
        return zfxxjh;
    }

    public void setZfxxjh(List<PayInfo> zfxxjh) {
        this.zfxxjh = zfxxjh;
    }

    public TravelInfo getClxx() {
        return clxx;
    }

    public void setClxx(TravelInfo clxx) {
        this.clxx = clxx;
    }

    public FlightPayInfo getGjhcxx() {
        return gjhcxx;
    }

    public void setGjhcxx(FlightPayInfo gjhcxx) {
        this.gjhcxx = gjhcxx;
    }

    public List<InterHbInfo> getJgzcjh() {
        return jgzcjh;
    }

    public void setJgzcjh(List<InterHbInfo> jgzcjh) {
        this.jgzcjh = jgzcjh;
    }

    public List<CouponInfo> getCoupon() {
        return coupon;
    }

    public void setCoupon(List<CouponInfo> coupon) {
        this.coupon = coupon;
    }
}
