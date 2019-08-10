package com.example.onedream.flightapp.bean;

public class DeliveryAndInvoiceInfo {
    /*  fptt	发票抬头	fppsxx	String	N	发票抬头 如：武汉市生胜意技（发票有）
        fplx	发票类型	fppsxx		N	发票类型 如：电子发票、纸质发票（发票有）
        fpmx	发票明细	fppsxx	String	N	发票明细  如：代办签证费（发票有）
        nsrsbh	纳税人识别号	fppsxx	String	N	纳税人识别号（发票有）
        sjr	    收件人	fppsxx	String	Y	收件人
        sjdz	收件地址	fppsxx	String	Y	收件地址
        sjrdh	收件人电话	fppsxx	String	Y	收件人电话
        psfs	配送方式	fppsxx	String	Y	配送方式  如：市内自取，市内配送、邮寄等
        kd	    快递公司	fppsxx	String	N	快递公司 如：EMS、顺丰
        yjpsf	邮寄或配送费	fppsxx	String	N	邮寄或配送费*/
    private String  fptt;
    private String  fplx;
    private String  fpmx;
    private String  nsrsb;
    private String  sjr	 ;
    private String  sjdz;
    private String  sjrdh;
    private String  psfs;
    private String  kd	 ;
    private String  yjpsf;

    public String getFptt() {
        return fptt;
    }

    public void setFptt(String fptt) {
        this.fptt = fptt;
    }

    public String getFplx() {
        return fplx;
    }

    public void setFplx(String fplx) {
        this.fplx = fplx;
    }

    public String getFpmx() {
        return fpmx;
    }

    public void setFpmx(String fpmx) {
        this.fpmx = fpmx;
    }

    public String getNsrsb() {
        return nsrsb;
    }

    public void setNsrsb(String nsrsb) {
        this.nsrsb = nsrsb;
    }

    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr;
    }

    public String getSjdz() {
        return sjdz;
    }

    public void setSjdz(String sjdz) {
        this.sjdz = sjdz;
    }

    public String getSjrdh() {
        return sjrdh;
    }

    public void setSjrdh(String sjrdh) {
        this.sjrdh = sjrdh;
    }

    public String getPsfs() {
        return psfs;
    }

    public void setPsfs(String psfs) {
        this.psfs = psfs;
    }

    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }

    public String getYjpsf() {
        return yjpsf;
    }

    public void setYjpsf(String yjpsf) {
        this.yjpsf = yjpsf;
    }
}
