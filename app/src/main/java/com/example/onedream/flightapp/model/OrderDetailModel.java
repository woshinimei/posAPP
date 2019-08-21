package com.example.onedream.flightapp.model;

import android.content.Context;
import android.util.Log;

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
        OrderDetailRequest request = new OrderDetailRequest();
        String baseUrl =BaseHttp.ORDERDETAIL_NORMAL;
        if (type==OrderType.NORMAL){
            request.setDdbh(orderNo);
            request.setOrderNo(orderNo);
            baseUrl =BaseHttp.ORDERDETAIL_NORMAL;
        }else if (type==OrderType.REFUND){
            baseUrl =BaseHttp.ORDERDETAIL_REFUEND;
            request.setOrderNo(orderNo);
            request.setDdbh(orderNo);
        }else {
            request.setOrderNo(orderNo);
            request.setDdbh(orderNo);
            baseUrl =BaseHttp.ORDERDETAIL_ENDORE;
        }
//        Log.e("--type---",type+"");
//        Log.e("--orderNo---",orderNo+"");
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        String sign =SignUtils.getSign();


        request.setSign(sign);
        request.setUserKey(key);
        String json =GsonUtils.getJson(request);
        doRequest( context,true,baseUrl,json,callBack);

    }
}
