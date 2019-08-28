package com.example.onedream.flightapp.utils;

import android.text.TextUtils;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.request.OrderListRequest;

public class OrderListFliterUtils {
    public static void resetData(int type) {
        OrderListRequest request = new OrderListRequest();


        if (type == 0) {
            setTimeforRequest(request);
            setPayRequest(request);
            AppLocal.normalRequest = request;
        } else if (type == 1) {
            setRefundTimeRequest(request);
            setRufundRequest(request);
            AppLocal.refundRequest = request;
        } else {
            setTimeforRequest(request);
            setPayRequest(request);
            AppLocal.endoreRequest = request;
        }

    }

    public static void setTimeforRequest(OrderListRequest request) {
        String startTime = DateUtils.getNowTime();
        String endTime = DateUtils.getNowTime();
        request.setDateStart(startTime);
        request.setDateEnd(endTime);
    }
    public static void setRefundTimeRequest(OrderListRequest request) {
        String startTime = DateUtils.getBeforeOfTime(-3);
        String endTime = DateUtils.getNowTime();
        request.setDateStart(startTime);
        request.setDateEnd(endTime);
    }

    public static void setPayRequest(OrderListRequest request) {
        String[] payStatus = AppLocal.payStatus;
        request.setZfzt(payStatus[0]);
    }
    public static void setRufundRequest(OrderListRequest request) {
        String[] refundStatus = AppLocal.refundStatus;
        request.setTkzt(refundStatus[0]);
    }

    //从缓存中拿数据
    public static void getCacheRequest(int type, OrderListRequest request) {
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
                if (type != 1) {
                    String[] statusContent = AppLocal.orderStatus;
                    String[] orderStatusType = AppLocal.orderStatusType;
                    for (int i = 0; i < statusContent.length; i++) {
                        String s = statusContent[i];
                        if (s.equals(orderStatus)) {
                            request.setOrderStatus(orderStatusType[i]);
                        }
                    }
                } else {
                    String[] statusContent = AppLocal.orderStatusOfRefund;
                    String[] orderStatusType = AppLocal.orderStatusTypeOfRefund;
                    for (int i = 0; i < statusContent.length; i++) {
                        String s = statusContent[i];
                        if (s.equals(orderStatus)) {
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
            if (!TextUtils.isEmpty(dateType)) {
                String[] orderTimeStatus = AppLocal.orderTimeStatus;
                String[] orderTimeStatusOfRefund = AppLocal.orderTimeStatusOfRefund;
                String[] orderTimeType = AppLocal.orderTimeType;
                if (type == 1) {
                    for (int i = 0; i < orderTimeStatusOfRefund.length; i++) {
                        String s = orderTimeStatusOfRefund[i];
                        if (dateType.equals(s)) {
                            request.setDateType(orderTimeType[i]);
                        }
                    }
                } else {
                    for (int i = 0; i < orderTimeStatus.length; i++) {
                        String s = orderTimeStatus[i];
                        if (dateType.equals(s)) {
                            request.setDateType(orderTimeType[i]);
                        }
                    }
                }

            }

            if (type != 1) {
                String zfzt = cacheRequest.getZfzt();
                if (!TextUtils.isEmpty(zfzt)) {
                    String[] payStatusType = AppLocal.payStatusType;
                    String[] payStatus = AppLocal.payStatus;
                    for (int i = 0; i < payStatus.length; i++) {
                        String status = payStatus[i];
                        if (status.equals(zfzt)) {
                            request.setZfzt(payStatusType[i]);
                        }
                    }
                }
            } else {
                String tkzt = cacheRequest.getTkzt();
                if (!TextUtils.isEmpty(tkzt)) {
                    String[] refundStatus = AppLocal.refundStatus;
                    String[] refundStatusType = AppLocal.refundStatusType;
                    for (int i = 0; i < refundStatus.length; i++) {
                        String status = refundStatus[i];
                        if (status.equals(tkzt)) {
                            request.setTkzt(refundStatusType[i]);
                        }
                    }
                }
            }


        }
    }
}
