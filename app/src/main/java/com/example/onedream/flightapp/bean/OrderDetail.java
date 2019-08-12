package com.example.onedream.flightapp.bean;

import java.util.List;

public class OrderDetail {
    JbInfo jbxx;//基本信息
    List<HbInfo> hdjh;//航程信息集合
    List<PassengerInfo> cjrjh;//乘机人信息集合
    List<PayInfo> zfxxjh;//支付集合
    FlightPayInfo gjhcxx;//支付信息
    TravelInfo clxx;//差旅信息
    DeliveryAndInvoiceInfo fppsxx;//发票和配送信息对象
    List<InterHbInfo> jgzcjh;//国际航班信息
    List<CouponInfo> coupon;//卡券信息

    public void setZfxxjh(List<PayInfo> zfxxjh) {
        this.zfxxjh = zfxxjh;
    }

    public FlightPayInfo getGjhcxx() {
        return gjhcxx;
    }

    public void setGjhcxx(FlightPayInfo gjhcxx) {
        this.gjhcxx = gjhcxx;
    }

    public JbInfo getJbxx() {
        return jbxx;
    }

    public void setJbxx(JbInfo jbxx) {
        this.jbxx = jbxx;
    }

    public List<HbInfo> getHdjh() {
        return hdjh;
    }

    public void setHdjh(List<HbInfo> hdjh) {
        this.hdjh = hdjh;
    }

    public List<PassengerInfo> getCjrjh() {
        return cjrjh;
    }

    public void setCjrjh(List<PassengerInfo> cjrjh) {
        this.cjrjh = cjrjh;
    }

    public TravelInfo getClxx() {
        return clxx;
    }

    public void setClxx(TravelInfo clxx) {
        this.clxx = clxx;
    }

    public DeliveryAndInvoiceInfo getFppsxx() {
        return fppsxx;
    }

    public void setFppsxx(DeliveryAndInvoiceInfo fppsxx) {
        this.fppsxx = fppsxx;
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
