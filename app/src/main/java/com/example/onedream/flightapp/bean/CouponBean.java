package com.example.onedream.flightapp.bean;

public class CouponBean {

    /**
     * couponId : 1342
     * couponName : 出行秘书+快速安检券
     * detailH5Url : http://14.21.67.184:9999/AJ/H5/html/SecurityCheckV3.html?couponId=1342&code=SZX
     * couponNum : 1
     * couponPackageFlg : 0
     * couponPackageName : 溢价包优先级测试
     * couponPackageInfoUrl : http://14.21.67.184:9999/PREMIUMPACKAGE/H5/html/premiumGiftBag.html?packageId=315&code=SZX&couponId=1469-1342-1361-1360
     * activeIcon : http://14.21.67.184:9999/l8qbkN7DC9upTZ35/sleep20190528094850.png
     */

    private String couponId;
    private String couponName;
    private String detailH5Url;
    private String couponNum;
    private String couponPackageFlg;
    private String couponPackageName;
    private String couponPackageInfoUrl;
    private String activeIcon;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getDetailH5Url() {
        return detailH5Url;
    }

    public void setDetailH5Url(String detailH5Url) {
        this.detailH5Url = detailH5Url;
    }

    public String getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(String couponNum) {
        this.couponNum = couponNum;
    }

    public String getCouponPackageFlg() {
        return couponPackageFlg;
    }

    public void setCouponPackageFlg(String couponPackageFlg) {
        this.couponPackageFlg = couponPackageFlg;
    }

    public String getCouponPackageName() {
        return couponPackageName;
    }

    public void setCouponPackageName(String couponPackageName) {
        this.couponPackageName = couponPackageName;
    }

    public String getCouponPackageInfoUrl() {
        return couponPackageInfoUrl;
    }

    public void setCouponPackageInfoUrl(String couponPackageInfoUrl) {
        this.couponPackageInfoUrl = couponPackageInfoUrl;
    }

    public String getActiveIcon() {
        return activeIcon;
    }

    public void setActiveIcon(String activeIcon) {
        this.activeIcon = activeIcon;
    }
}
