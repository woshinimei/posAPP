package com.example.onedream.flightapp.model;

import android.content.Context;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.OrderDetailRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class OrderDetailModel extends BaseModel {
    public void getData(int type, String orderNo,Context context, OnCallBack<String> callBack){
        String baseUrl =BaseHttp.ORDERDETAIL_NORMAL;
        if (type==OrderType.NORMAL){
            baseUrl =BaseHttp.ORDERDETAIL_NORMAL;
        }else if (type==OrderType.REFUND){
            baseUrl =BaseHttp.ORDERDETAIL_REFUEND;
        }else {
            baseUrl =BaseHttp.ORDERDETAIL_ENDORE;
        }
        Shelper shelper =new Shelper(context);
        String key = shelper.getString(AppLocal.USERKEY);
        String sign =SignUtils.getSign();
        OrderDetailRequest request = new OrderDetailRequest();
        request.setOrderNo(orderNo);
        request.setSign(sign);
        request.setUserKey(key);
        String json =GsonUtils.getJson(request);
        doRequest( context,true,baseUrl,json,callBack);

    }
}
