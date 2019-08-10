package com.example.onedream.flightapp.bean;

public class PayInfo {
    /*  zffs	支付方式	zfxxdx	String	Y	支付方式
    zfzh	支付账户	zfxxdx	String	Y	支付账户
    zfje	支付金额	zfxxdx	String	Y	支付金额
    zfsj	支付时间	zfxxdx	String	Y	支付时间*/
    private String  zffs ;
    private String  zfzh ;
    private String  zfje ;
    private String  zfsj ;

    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }

    public String getZfzh() {
        return zfzh;
    }

    public void setZfzh(String zfzh) {
        this.zfzh = zfzh;
    }

    public String getZfje() {
        return zfje;
    }

    public void setZfje(String zfje) {
        this.zfje = zfje;
    }

    public String getZfsj() {
        return zfsj;
    }

    public void setZfsj(String zfsj) {
        this.zfsj = zfsj;
    }

}
