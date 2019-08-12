package com.example.onedream.flightapp.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class OrderListEndoreModel extends BaseModel {

    public void getData(Context context, OnCallBack<String> callBack){
        String key = AppLocal.USERKEY;
        String sign  =SignUtils.getSign();
        OrderListRequest request = new OrderListRequest();
        getCacheRequest(request);
        request.setUserKey(key);
        request.setSign(sign);
        String json =GsonUtils.getJson(request);
       doRequest(context,true, BaseHttp.ORDERLIST_ENDORE, json,callBack);
    }
    //从缓存中拿数据
    private void getCacheRequest(OrderListRequest request) {
        if (AppLocal.listRequest!=null){
            OrderListRequest cacheRequest = AppLocal.listRequest;
            String orderStatus = cacheRequest.getOrderStatus();
            if (!TextUtils.isEmpty(orderStatus)){
                switch (orderStatus){
                    case "申请中":
                        request.setOrderStatus("0");
                        break;
                    case "已订座":
                        request.setOrderStatus("1");
                        break;
                    case "已调度":
                        request.setOrderStatus("2");
                        break;
                    case "已出票":
                        request.setOrderStatus("3");
                        break;
                    case "配送中":
                        request.setOrderStatus("4");
                        break;
                    case "部分出票":
                        request.setOrderStatus("5");
                        break;
                    case "客户消":
                        request.setOrderStatus("7");
                        break;
                    case "已取消":
                        request.setOrderStatus("8");
                        break;
                    case "完成":
                        request.setOrderStatus("9");
                        break;
                }

            }
            String dateStart = cacheRequest.getDateStart();
            if (!TextUtils.isEmpty(dateStart)){
                request.setDateStart(dateStart);
            }
            String dateEnd = cacheRequest.getDateEnd();
            if (!TextUtils.isEmpty(dateEnd)){
                request.setDateEnd(dateEnd);
            }
            String dateType = cacheRequest.getDateType();
            if (!TextUtils.isEmpty(dateType)){
                switch (dateType){
                    case "调度日期":
                        request.setDateType("1");
                        break;
                    case "预订日期":
                        request.setDateType("2");
                        break;
                    case "起飞日期":
                        request.setDateType("3");
                        break;
                }
            }

        }
    }
}
