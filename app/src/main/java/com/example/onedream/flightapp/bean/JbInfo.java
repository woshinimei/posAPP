package com.example.onedream.flightapp.bean;

public class JbInfo {
    /*  ddzt	订单状态中文	jbxx	String	Y	订单状态中文
    zfzt	支付状态中文	jbxx	String	Y	支付状态中文
    ddlx	订单类型	jbxx	String	Y	订单类型，国内国际。1国内 0国际
    hclx	航程类型	dddx	String	Y	航程类型 1单程2 往返程3联程
    lxrxm	联系人姓名	jbxx	String	Y	联系人姓名
    lxrdh	联系人电话	jbxx	String	Y	联系人电话
    lxryx	联系人邮箱	jbxx	String	Y	联系人邮箱
    ddje	订单金额	jbxx	String	Y	订单金额
    yfje	应付金额	jbxx	String	Y	应付金额
    psf	    配送费	jbxx	String	Y	配送费
    yhje	优惠金额	jbxx	String	Y	优惠金额（返点）
    sfkzf	是否可支付	jbxx	StringY	是否可支付
    sfktp	是否可退票	jbxx	StringY	是否可退票
    sfkgq	是否可改签	jbxx	StringY	是否可改签
    sfkqx	是否可取消	jbxx	String Y	是否可取消

    cllx	cllx	差旅类型	jbxx	String	Y	差旅类型1因公2因私
    spzt	spzt	审批状态	jbxx	String	Y	审批状态中文
    spztdm	spztdm	审批状态代码	jbxx	String	Y	审批状态代码0未审批  1审批中  2已取消  3已通过 4已拒绝  5无需审批
    sfkss	sfkss	是否可送审	jbxx	StringY	是否可送审sfzcxyqk	sfzcxyqk	是否支持协议欠款支付	jbxx	StringY	是否支持协议支付
    sfwb	sfwb	是否违背	jbxx	StringY	是否违背

    */

    private String ddzt;
    private String zfzt;
    private String ddlx;
    private String hclx;
    private String lxrxm;
    private String lxrdh;
    private String lxryx;
    private String ddje;
    private String yfje;
    private double psf	 ;
    private String yhje;
    private String ytje;
    private String sfkzf;
    private String sfktp;
    private String sfkgq;
    private String sfkqx;
    private String ydsj;
    private String sqsj;
    //-------------------------------------B2G信息 专用字段
    private String  cllx;
    private String  spzt;
    private String  spztdm;
    private String sfkss ;
    private String sfwb ;
    //直加产品名称    zjcpmc
    //直加产品说明    zjcpsm
    private String zjcpmc;
    private String zjcpsm;
    private String jpyhje;
    private String cpfwf;//产品服务费
    private String wjf;//误机费
    private String gqf;
    private String cj;
    private String gqfwf;

    public String getGqfwf() {
        return gqfwf;
    }

    public void setGqfwf(String gqfwf) {
        this.gqfwf = gqfwf;
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    public String getGqf() {
        return gqf;
    }

    public void setGqf(String gqf) {
        this.gqf = gqf;
    }

    public String getWjf() {
        return wjf;
    }

    public void setWjf(String wjf) {
        this.wjf = wjf;
    }

    public String getCpfwf() {
        return cpfwf;
    }

    public void setCpfwf(String cpfwf) {
        this.cpfwf = cpfwf;
    }

    public String getJpyhje() {
        return jpyhje;
    }

    public void setJpyhje(String jpyhje) {
        this.jpyhje = jpyhje;
    }

    public String getYtje() {
        return ytje;
    }

    public void setYtje(String ytje) {
        this.ytje = ytje;
    }

    public String getSqsj() {
        return sqsj;
    }

    public void setSqsj(String sqsj) {
        this.sqsj = sqsj;
    }

    public String getDdzt() {
        return ddzt;
    }

    public void setDdzt(String ddzt) {
        this.ddzt = ddzt;
    }

    public String getZfzt() {
        return zfzt;
    }

    public void setZfzt(String zfzt) {
        this.zfzt = zfzt;
    }

    public String getDdlx() {
        return ddlx;
    }

    public void setDdlx(String ddlx) {
        this.ddlx = ddlx;
    }

    public String getHclx() {
        return hclx;
    }

    public void setHclx(String hclx) {
        this.hclx = hclx;
    }

    public String getLxrxm() {
        return lxrxm;
    }

    public void setLxrxm(String lxrxm) {
        this.lxrxm = lxrxm;
    }

    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh;
    }

    public String getLxryx() {
        return lxryx;
    }

    public void setLxryx(String lxryx) {
        this.lxryx = lxryx;
    }

    public String getDdje() {
        return ddje;
    }

    public void setDdje(String ddje) {
        this.ddje = ddje;
    }

    public String getYfje() {
        return yfje;
    }

    public void setYfje(String yfje) {
        this.yfje = yfje;
    }

    public double getPsf() {
        return psf;
    }

    public void setPsf(double psf) {
        this.psf = psf;
    }

    public String getYhje() {
        return yhje;
    }

    public void setYhje(String yhje) {
        this.yhje = yhje;
    }

    public String getSfkzf() {
        return sfkzf;
    }

    public void setSfkzf(String sfkzf) {
        this.sfkzf = sfkzf;
    }

    public String getSfktp() {
        return sfktp;
    }

    public void setSfktp(String sfktp) {
        this.sfktp = sfktp;
    }

    public String getSfkgq() {
        return sfkgq;
    }

    public void setSfkgq(String sfkgq) {
        this.sfkgq = sfkgq;
    }

    public String getSfkqx() {
        return sfkqx;
    }

    public void setSfkqx(String sfkqx) {
        this.sfkqx = sfkqx;
    }

    public String getYdsj() {
        return ydsj;
    }

    public void setYdsj(String ydsj) {
        this.ydsj = ydsj;
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx;
    }

    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt;
    }

    public String getSpztdm() {
        return spztdm;
    }

    public void setSpztdm(String spztdm) {
        this.spztdm = spztdm;
    }

    public String getSfkss() {
        return sfkss;
    }

    public void setSfkss(String sfkss) {
        this.sfkss = sfkss;
    }

    public String getSfwb() {
        return sfwb;
    }

    public void setSfwb(String sfwb) {
        this.sfwb = sfwb;
    }

    public String getZjcpmc() {
        return zjcpmc;
    }

    public void setZjcpmc(String zjcpmc) {
        this.zjcpmc = zjcpmc;
    }

    public String getZjcpsm() {
        return zjcpsm;
    }

    public void setZjcpsm(String zjcpsm) {
        this.zjcpsm = zjcpsm;
    }
}
