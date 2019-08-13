package com.example.onedream.flightapp.bean;

import java.io.Serializable;

/**
 * Created by xuechao.yang on 2017/1/22.
 */

public class PriceDetailedBen implements Serializable {
    /**
     * 火车票订单订单详情字段
     */
    private String tfwf  ="0";//服务费
    private String tbx   ="0";//保险
    private String tpj   ="0";//票价
    private String txpj  ="0";//新票价
    private String tgqfy ="0";//改签费用
    private String ttpsxf="0";//退票手续费
    private String tqt   ="0";//其他
    private String tsxf = "0";//手续费

    /**
     * 酒店
     * @return
     */

    private String jff  ="0";//房费
    private String jbx  ="0";//保险
    private String jfwf ="0";//服务费
    private String jkdf ="0";//快递费
    private String jytff="0";//已退房费

    /**
     * 门票
     */
    private String mpj ="0";//票价
    private String mbx ="0";//保险
    private String mfwf="0";//服务费
    private String msxf="0";//手续费
    private String mtpj="0";//退票费
    private String mpsf="0";//配送费

    /**
     * 旅游
     * @return
     */
    private String lycrpj="0";//成人票价
    private String lyetpj="0";//儿童票价
    private String lybx  ="0";//保险
    private String lyfwf ="0";//服务费
    private String lyttf ="0";//退团费用
    private String lysxf ="0";//退团手续费
    /**
     * 签证
     */
    private String qzyjf="0";//邮寄费
    private String qzf  ="0";//签证费
    private String qzfwf="0";//服务费
//    private String qzxsj="0";//销售价
    private String qzsxf="0";//手续费
    private String qzbxf="0";//签证保险
    private String qztkf="0";//签证退款费
    /**
     * 用车
     */
    private String ycf ="0"; //用车费
    private String ycbx ="0"; //用车保险
    private String ycfwf="0"; //用车服务费
    private String ycyjf="0"; //用车邮寄费

    /**
     * 机票退票订单详价格明细
     * @return
     */


 private   double  tjpxsj = 0;
    private  double tjpjpjl = 0;
    private double tjpjj = 0;
    private double tjpjec = 0;
    private double tjpsf = 0;
    private double tjpqtsx = 0;
    private double tjpsxf = 0;
    private double tjpsfwf = 0;
    private  double couponCost =0;//优惠券
    private  double     tjpbxje = 0;
    private double jpyhje =0;//机票优惠券


    /**
     * 机票改签订单详
     * @return
     */
    private String gqjpgqf = "0";     //改签机票改签费
    private String gqjpfwf = "0";    //改签机票服务费
    private String gqjpcj = "0";    //改签机票差价

    public double getCouponCost() {
        return couponCost;
    }

    public void setCouponCost(double couponCost) {
        this.couponCost = couponCost;
    }
    public String getQzbxf() {
        return qzbxf;
    }

    public void setQzbxf(String qzbxf) {
        this.qzbxf = qzbxf;
    }

    public String getQztkf() {
        return qztkf;
    }

    public void setQztkf(String qztkf) {
        this.qztkf = qztkf;
    }

    public String getYcf() {
        return ycf;
    }

    public void setYcf(String ycf) {
        this.ycf = ycf;
    }

    public String getYcbx() {
        return ycbx;
    }

    public void setYcbx(String ycbx) {
        this.ycbx = ycbx;
    }

    public String getYcfwf() {
        return ycfwf;
    }

    public void setYcfwf(String ycfwf) {
        this.ycfwf = ycfwf;
    }

    public String getYcyjf() {
        return ycyjf;
    }

    public void setYcyjf(String ycyjf) {
        this.ycyjf = ycyjf;
    }

    public String getQzyjf() {
        return qzyjf;
    }

    public void setQzyjf(String qzyjf) {
        this.qzyjf = qzyjf;
    }

    public String getQzf() {
        return qzf;
    }

    public void setQzf(String qzf) {
        this.qzf = qzf;
    }

    public String getQzfwf() {
        return qzfwf;
    }

    public void setQzfwf(String qzfwf) {
        this.qzfwf = qzfwf;
    }


    public String getQzsxf() {
        return qzsxf;
    }

    public void setQzsxf(String qzsxf) {
        this.qzsxf = qzsxf;
    }

    public String getLycrpj() {
        return lycrpj;
    }

    public void setLycrpj(String lycrpj) {
        this.lycrpj = lycrpj;
    }

    public String getLyetpj() {
        return lyetpj;
    }

    public void setLyetpj(String lyetpj) {
        this.lyetpj = lyetpj;
    }

    public String getLybx() {
        return lybx;
    }

    public void setLybx(String lybx) {
        this.lybx = lybx;
    }

    public String getLyfwf() {
        return lyfwf;
    }

    public void setLyfwf(String lyfwf) {
        this.lyfwf = lyfwf;
    }

    public String getLyttf() {
        return lyttf;
    }

    public void setLyttf(String lyttf) {
        this.lyttf = lyttf;
    }

    public String getLysxf() {
        return lysxf;
    }

    public void setLysxf(String lysxf) {
        this.lysxf = lysxf;
    }

    public String getMpj() {
        return mpj;
    }

    public void setMpj(String mpj) {
        this.mpj = mpj;
    }

    public String getMbx() {
        return mbx;
    }

    public void setMbx(String mbx) {
        this.mbx = mbx;
    }

    public String getMfwf() {
        return mfwf;
    }

    public void setMfwf(String mfwf) {
        this.mfwf = mfwf;
    }

    public String getMsxf() {
        return msxf;
    }

    public void setMsxf(String msxf) {
        this.msxf = msxf;
    }

    public String getMtpj() {
        return mtpj;
    }

    public void setMtpj(String mtpj) {
        this.mtpj = mtpj;
    }

    public void setTsxf(String tsxf) {
        this.tsxf = tsxf;
    }

    public String getJff() {
        return jff;
    }

    public void setJff(String jff) {
        this.jff = jff;
    }

    public String getJbx() {
        return jbx;
    }

    public void setJbx(String jbx) {
        this.jbx = jbx;
    }

    public String getJfwf() {
        return jfwf;
    }

    public void setJfwf(String jfwf) {
        this.jfwf = jfwf;
    }

    public String getJkdf() {
        return jkdf;
    }

    public void setJkdf(String jkdf) {
        this.jkdf = jkdf;
    }

    public String getJytff() {
        return jytff;
    }

    public void setJytff(String jytff) {
        this.jytff = jytff;
    }

    public String getTsxf() {
        return tsxf;
    }

    public String getTfwf() {
        return tfwf;
    }

    public void setTfwf(String tfwf) {
        this.tfwf = tfwf;
    }

    public String getTbx() {
        return tbx;
    }

    public void setTbx(String tbx) {
        this.tbx = tbx;
    }

    public String getTpj() {
        return tpj;
    }

    public void setTpj(String tpj) {
        this.tpj = tpj;
    }

    public String getTxpj() {
        return txpj;
    }

    public void setTxpj(String txpj) {
        this.txpj = txpj;
    }

    public String getTgqfy() {
        return tgqfy;
    }

    public void setTgqfy(String tgqfy) {
        this.tgqfy = tgqfy;
    }

    public String getTtpsxf() {
        return ttpsxf;
    }

    public void setTtpsxf(String ttpsxf) {
        this.ttpsxf = ttpsxf;
    }

    public String getTqt() {
        return tqt;
    }

    public void setTqt(String tqt) {
        this.tqt = tqt;
    }

    public String getMpsf() {
        return mpsf;
    }

    public void setMpsf(String mpsf) {
        this.mpsf = mpsf;
    }

    public double getTjpxsj() {
        return tjpxsj;
    }

    public void setTjpxsj(double tjpxsj) {
        this.tjpxsj = tjpxsj;
    }

    public double getTjpjpjl() {
        return tjpjpjl;
    }

    public void setTjpjpjl(double tjpjpjl) {
        this.tjpjpjl = tjpjpjl;
    }

    public double getTjpjj() {
        return tjpjj;
    }

    public void setTjpjj(double tjpjj) {
        this.tjpjj = tjpjj;
    }

    public double getTjpjec() {
        return tjpjec;
    }

    public void setTjpjec(double tjpjec) {
        this.tjpjec = tjpjec;
    }

    public double getTjpsf() {
        return tjpsf;
    }

    public void setTjpsf(double tjpsf) {
        this.tjpsf = tjpsf;
    }

    public double getTjpqtsx() {
        return tjpqtsx;
    }

    public void setTjpqtsx(double tjpqtsx) {
        this.tjpqtsx = tjpqtsx;
    }

    public double getTjpsxf() {
        return tjpsxf;
    }

    public void setTjpsxf(double tjpsxf) {
        this.tjpsxf = tjpsxf;
    }

    public double getTjpsfwf() {
        return tjpsfwf;
    }

    public void setTjpsfwf(double tjpsfwf) {
        this.tjpsfwf = tjpsfwf;
    }

    public double getTjpbxje() {
        return tjpbxje;
    }

    public void setTjpbxje(double tjpbxje) {
        this.tjpbxje = tjpbxje;
    }

    public String getGqjpgqf() {
        return gqjpgqf;
    }

    public void setGqjpgqf(String gqjpgqf) {
        this.gqjpgqf = gqjpgqf;
    }

    public String getGqjpfwf() {
        return gqjpfwf;
    }

    public void setGqjpfwf(String gqjpfwf) {
        this.gqjpfwf = gqjpfwf;
    }

    public String getGqjpcj() {
        return gqjpcj;
    }

    public void setGqjpcj(String gqjpcj) {
        this.gqjpcj = gqjpcj;
    }

    public double getJpyhje() {
        return jpyhje;
    }

    public void setJpyhje(double jpyhje) {
        this.jpyhje = jpyhje;
    }
}
