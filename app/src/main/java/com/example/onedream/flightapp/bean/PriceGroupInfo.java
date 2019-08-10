package com.example.onedream.flightapp.bean;

import java.util.List;

public class PriceGroupInfo {
    private String title;
    private double totalPrice;
    private List<PriceChildInfo> itemlist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTotalPrice() {

        if (itemlist!=null){
            double total=0;
            for (PriceChildInfo childInfo : itemlist) {
                double itemPrice = childInfo.getItemPrice();
                total+=itemPrice;
            }
            return total;
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PriceChildInfo> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<PriceChildInfo> itemlist) {
        this.itemlist = itemlist;
    }
}
