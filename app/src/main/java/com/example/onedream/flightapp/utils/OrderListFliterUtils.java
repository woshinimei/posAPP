package com.example.onedream.flightapp.utils;

import android.text.TextUtils;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.request.OrderListRequest;

public class OrderListFliterUtils {
    public static void resetData(int type) {
        OrderListRequest request = new OrderListRequest();
        setTimeforRequest(request);
        if (type == 0) {
            AppLocal.normalRequest = request;
        } else if (type == 1) {
            AppLocal.refundRequest = request;
        } else {
            AppLocal.endoreRequest = request;
        }

    }
public static void setTimeforRequest(OrderListRequest request){
    String[] timeArr = DateUtils.getBeforeMonthTime(-1);
    String startTime = timeArr[0];
    String endTime = timeArr[1];
    request.setDateStart(startTime);
    request.setDateEnd(endTime);
}
    //从缓存中拿数据
    public  static void getCacheRequest(int type, OrderListRequest request) {
        OrderListRequest cacheRequest;
        if (type == 0) {
            cacheRequest = AppLocal.normalRequest;
        } else if (type == 1) {
            cacheRequest = AppLocal.refundRequest;
        } else {
            cacheRequest = AppLocal.endoreRequest;
        }
        if (cacheRequest != null) {
            String orderStatus = cacheRequest.getOrderStatus();
            if (!TextUtils.isEmpty(orderStatus)) {
                if (type!=1){
                    String[] statusContent = AppLocal.orderStatus;
                    String[] orderStatusType = AppLocal.orderStatusType;
                    for (int i = 0; i < statusContent.length; i++) {
                        String s = statusContent[i];
                        if (s.equals(orderStatus)){
                            request.setOrderStatus(orderStatusType[i]);
                        }
                    }
                }else {
                    String[] statusContent = AppLocal.orderStatusOfRefund;
                    String[] orderStatusType = AppLocal.orderStatusTypeOfRefund;
                    for (int i = 0; i < statusContent.length; i++) {
                        String s = statusContent[i];
                        if (s.equals(orderStatus)){
                            request.setOrderStatus(orderStatusType[i]);
                        }
                    }
                }



            }
            String dateStart = cacheRequest.getDateStart();
            if (!TextUtils.isEmpty(dateStart)) {
                request.setDateStart(dateStart);
            }
            String dateEnd = cacheRequest.getDateEnd();
            if (!TextUtils.isEmpty(dateEnd)) {
                request.setDateEnd(dateEnd);
            }
            String name = cacheRequest.getName();
            if (!TextUtils.isEmpty(name)) {
                request.setName(name);
            }
            String dateType = cacheRequest.getDateType();
            if (!TextUtils.isEmpty(dateType)){
                String[] orderTimeStatus = AppLocal.orderTimeStatus;
                String[] orderTimeStatusOfRefund = AppLocal.orderTimeStatusOfRefund;
                String[] orderTimeType = AppLocal.orderTimeType;
                if (type==1){
                    for (int i = 0; i < orderTimeStatusOfRefund.length; i++) {
                        String s = orderTimeStatusOfRefund[i];
                        if (dateType.equals(s)){
                            request.setDateType(orderTimeType[i]);
                        }
                    }
                }else {
                    for (int i = 0; i < orderTimeStatus.length; i++) {
                        String s = orderTimeStatus[i];
                        if (dateType.equals(s)){
                            request.setDateType(orderTimeType[i]);
                        }
                    }
                }

            }


        }
    }
}
