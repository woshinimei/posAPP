package com.example.onedream.flightapp.response;

import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.network.BaseResponse;

public class OrderDetailResponse extends BaseResponse {
   private OrderDetail orderDetail;
   private OrderDetail tfOrderDetail;//退废单详情

    public OrderDetail getTfOrderDetail() {
        return tfOrderDetail;
    }

    public void setTfOrderDetail(OrderDetail tfOrderDetail) {
        this.tfOrderDetail = tfOrderDetail;
    }

    public OrderDetail getDetail() {
        return orderDetail;
    }

    public void setDetail(OrderDetail detail) {
        this.orderDetail = detail;
    }
}
