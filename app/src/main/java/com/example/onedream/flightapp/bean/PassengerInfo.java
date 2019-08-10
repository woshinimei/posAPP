package com.example.onedream.flightapp.bean;

public class PassengerInfo {
    /*	cjrid	乘机人id	cjrdx	String	Y	乘机人id
	cjrxm	乘机人姓名	cjrdx	String	Y	乘机人姓名
	cjrlx	乘机人类型	cjrdx	String	Y	乘机人类型成人，儿童， 婴儿
	crlx	成人类型	cjrdx	String	Y	成人类型，枚举类型按后台数据字典返回
	zjlx	乘机人证件类型	cjrdx	String	Y	乘机人证件类型，按新证件返回如：1003401身份证，1003402护照
	zjhm	乘机人证件号码	cjrdx	String	Y	乘机人证件号码
	cjrsj	乘机人手机	cjrdx	String	Y	乘机人手机号
	ph		票号	cjrdx	String	Y	票号
	pj		票价	cjrdx	String	Y	票价
	ry		燃油	cjrdx	String	Y	燃油
	jj		机场建设税	cjrdx	String	Y	机场建设税
	bxdj	保险单价	cjrdx	String	Y	保险单价
	bxfs	保险份数	cjrdx	String	Y	保险份数
	fwf		服务费	cjrdx	String	Y	服务费
	qtfx	其它费用	cjrdx	String	Y	其它费用，保留字段

	wbsxdm	wbsxdm	违背事项代码	cjrdx	String	Y	违背事项代码，多个用逗号隔开
	wbsxsm	wbsxsm	违背事项说明	cjrdx	String	Y	违背事项代码多个用逗号隔开
	cbzxdm	cbzxdm	成本中心代号	cjrdx	String	Y	成本中心代号
	cbzxmc	cbzxmc	成本中心名称	cjrdx	String	Y	成本中心名称

	*/
    private String cjrid	;
    private String cjrxm	;
    private String cjrlx	;
    private String crlx	;
    private String zjlx	;
    private String zjhm	;
    private String cjrsj	;
    private String ph	;
    private double pj	;
    private double ry	;
    private double jj	;
    private double  bxdj	;
    private int bxfs	;
    private double fwf	;
    private String qtfx	;
    private String wbsxdm;
    private String wbsxsm;
    private String cbzxdm;
    private String cbzxmc;

    private String hccbzxdm;
    private String hccbzxmc;

    private String csrq;  //出生日期

    public String getCjrid() {
        return cjrid;
    }

    public void setCjrid(String cjrid) {
        this.cjrid = cjrid;
    }

    public String getCjrxm() {
        return cjrxm;
    }

    public void setCjrxm(String cjrxm) {
        this.cjrxm = cjrxm;
    }

    public String getCjrlx() {
        return cjrlx;
    }

    public void setCjrlx(String cjrlx) {
        this.cjrlx = cjrlx;
    }

    public String getCrlx() {
        return crlx;
    }

    public void setCrlx(String crlx) {
        this.crlx = crlx;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getCjrsj() {
        return cjrsj;
    }

    public void setCjrsj(String cjrsj) {
        this.cjrsj = cjrsj;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public double getPj() {
        return pj;
    }

    public void setPj(double pj) {
        this.pj = pj;
    }

    public double getRy() {
        return ry;
    }

    public void setRy(double ry) {
        this.ry = ry;
    }

    public double getJj() {
        return jj;
    }

    public void setJj(double jj) {
        this.jj = jj;
    }

    public double getBxdj() {
        return bxdj;
    }

    public void setBxdj(double bxdj) {
        this.bxdj = bxdj;
    }

    public int getBxfs() {
        return bxfs;
    }

    public void setBxfs(int bxfs) {
        this.bxfs = bxfs;
    }

    public double getFwf() {
        return fwf;
    }

    public void setFwf(double fwf) {
        this.fwf = fwf;
    }

    public String getQtfx() {
        return qtfx;
    }

    public void setQtfx(String qtfx) {
        this.qtfx = qtfx;
    }

    public String getWbsxdm() {
        return wbsxdm;
    }

    public void setWbsxdm(String wbsxdm) {
        this.wbsxdm = wbsxdm;
    }

    public String getWbsxsm() {
        return wbsxsm;
    }

    public void setWbsxsm(String wbsxsm) {
        this.wbsxsm = wbsxsm;
    }

    public String getCbzxdm() {
        return cbzxdm;
    }

    public void setCbzxdm(String cbzxdm) {
        this.cbzxdm = cbzxdm;
    }

    public String getCbzxmc() {
        return cbzxmc;
    }

    public void setCbzxmc(String cbzxmc) {
        this.cbzxmc = cbzxmc;
    }

    public String getHccbzxdm() {
        return hccbzxdm;
    }

    public void setHccbzxdm(String hccbzxdm) {
        this.hccbzxdm = hccbzxdm;
    }

    public String getHccbzxmc() {
        return hccbzxmc;
    }

    public void setHccbzxmc(String hccbzxmc) {
        this.hccbzxmc = hccbzxmc;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }
}
