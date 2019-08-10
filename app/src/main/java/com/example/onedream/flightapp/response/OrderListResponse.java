package com.example.onedream.flightapp.response;

import com.example.onedream.flightapp.bean.OrderListBean;
import com.example.onedream.flightapp.network.BaseResponse;

import java.util.List;

public class OrderListResponse extends BaseResponse {
    List<OrderListBean> orderInfoList;

    public List<OrderListBean> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderListBean> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }
}
