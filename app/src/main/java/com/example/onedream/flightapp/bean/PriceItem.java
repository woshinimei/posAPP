package com.example.onedream.flightapp.bean;

public class PriceItem {

    /**
     * 费用类型
     * 1机票
     * 2.酒店
     * 3.火车票
     * 4.旅游
     */
    private int type;//费用类型
    private String name; //名称
    private int number;//数量,份数
    private int persionNum;//人数，目前 保险有用到
    private boolean isOrderInsurance;  //保险是否跟订单走 true是 false不是
    private boolean isTitle;//是否小标题
    private String unitPrice;//单价
    private boolean isPriceAbs;//是否对价格进行取整，显示（取整结果不参数计算）,true取整显示
    //-------
    private String explain;//价格说明 备用

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPersionNum() {
        return persionNum;
    }

    public void setPersionNum(int persionNum) {
        this.persionNum = persionNum;
    }

    public boolean isOrderInsurance() {
        return isOrderInsurance;
    }

    public void setOrderInsurance(boolean orderInsurance) {
        isOrderInsurance = orderInsurance;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isPriceAbs() {
        return isPriceAbs;
    }

    public void setPriceAbs(boolean priceAbs) {
        isPriceAbs = priceAbs;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
