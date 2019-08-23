package com.example.onedream.flightapp.bean;

import java.util.List;

public class OrderDetail {
    private String sffh;//是否可退款  1：是    其他：否
    private JbInfo jbxx;//基本信息
    private List<HbInfo> hdjh;//航程信息集合
    private List<PassengerInfo> cjrjh;//乘机人信息集合


    private List<PayInfo> zfxxjh;//支付集合
    private FlightPayInfo gjhcxx;//支付信息
    private TravelInfo clxx;//差旅信息
    private DeliveryAndInvoiceInfo fppsxx;//发票和配送信息对象
    private List<InterHbInfo> jgzcjh;//国际航班信息
    private List<CouponBean> coupon;//卡券信息
    private String couponCost;//优惠券金额
    private PosPayRefundInfo posInfo;//退废单退票（pos信息）
    private AliPayRefundInfo alipayInfo;//退废单退票（支付宝信息）
    private WechatRefundInfo wechatInfo;//退废单退票（微信信息）
    private QrcodePayRefundInfo qrcodeInfo;//退废单退票（二维码信息）

    public String getSffh() {
        return sffh;
    }

    public void setSffh(String sffh) {
        this.sffh = sffh;
    }

    public PosPayRefundInfo getPosInfo() {
        return posInfo;
    }

    public void setPosInfo(PosPayRefundInfo posInfo) {
        this.posInfo = posInfo;
    }

    public AliPayRefundInfo getAlipayInfo() {
        return alipayInfo;
    }

    public void setAlipayInfo(AliPayRefundInfo alipayInfo) {
        this.alipayInfo = alipayInfo;
    }

    public WechatRefundInfo getWechatInfo() {
        return wechatInfo;
    }

    public void setWechatInfo(WechatRefundInfo wechatInfo) {
        this.wechatInfo = wechatInfo;
    }

    public QrcodePayRefundInfo getQrcodeInfo() {
        return qrcodeInfo;
    }

    public void setQrcodeInfo(QrcodePayRefundInfo qrcodeInfo) {
        this.qrcodeInfo = qrcodeInfo;
    }

    public String getCouponCost() {
        return couponCost;
    }

    public void setCouponCost(String couponCost) {
        this.couponCost = couponCost;
    }

    public void setZfxxjh(List<PayInfo> zfxxjh) {
        this.zfxxjh = zfxxjh;
    }

    public List<PayInfo> getZfxxjh() {
        return zfxxjh;
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

    public List<CouponBean> getCoupon() {
        return coupon;
    }

    public void setCoupon(List<CouponBean> coupon) {
        this.coupon = coupon;
    }
}
