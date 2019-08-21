package com.example.onedream.flightapp.response;

import com.example.onedream.flightapp.bean.OrderListBean;
import com.example.onedream.flightapp.network.BaseResponse;

import java.util.List;

public class OrderListResponse extends BaseResponse {
    private List<OrderListBean> orderInfoList;
    private String totalCount;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<OrderListBean> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderListBean> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }
}
