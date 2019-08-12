package com.example.onedream.flightapp.response;

import com.example.onedream.flightapp.bean.CouponInfo;
import com.example.onedream.flightapp.bean.DeliveryAndInvoiceInfo;
import com.example.onedream.flightapp.bean.FlightPayInfo;
import com.example.onedream.flightapp.bean.HbInfo;
import com.example.onedream.flightapp.bean.InterHbInfo;
import com.example.onedream.flightapp.bean.JbInfo;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.bean.PayInfo;
import com.example.onedream.flightapp.bean.TravelInfo;
import com.example.onedream.flightapp.network.BaseResponse;

import java.util.List;

public class OrderDetailResponse extends BaseResponse {
   private OrderDetail orderDetail;

    public OrderDetail getDetail() {
        return orderDetail;
    }

    public void setDetail(OrderDetail detail) {
        this.orderDetail = detail;
    }
}
