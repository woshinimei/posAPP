package com.example.onedream.flightapp.bean;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class PriceInfo {
    private String name;//费用项名称
    private double totoalPrice;//费用项总价
    private String explain;//价格说明 服务费使用
    private List<PriceItem> fjjh;//费用明细集合
    private boolean isAdd;//flase
    //---------方便处理
    private boolean isShowExplain=true;
    private boolean isPriceAbs;//是否对价格进行取整，显示（取整结果不参数计算）,true取整显

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    public boolean isShowExplain() {
        return isShowExplain;
    }

    public void setShowExplain(boolean showExplain) {
        isShowExplain = showExplain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totoalPrice;
    }

    public void setTotalPrice(double totoalPrice) {
        this.totoalPrice = totoalPrice;
    }

    public List<PriceItem> getFjjh() {
        return fjjh;
    }

    public void setFjjh(ArrayList<PriceItem> fjjh) {
        this.fjjh = fjjh;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public boolean isPriceAbs() {
        return isPriceAbs;
    }

    public void setPriceAbs(boolean priceAbs) {
        isPriceAbs = priceAbs;
    }
}
