package com.example.onedream.flightapp.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.OrderListFliterUtils;
import com.example.onedream.flightapp.utils.SignUtils;

public class OrderListEndoreModel extends BaseModel {

    public void getData(Context context,boolean showDialog, OnCallBack<String> callBack){
        String key = AppLocal.USERKEY;
        String sign  =SignUtils.getSign();
        OrderListRequest request = new OrderListRequest();
        OrderListFliterUtils.getCacheRequest(2,request);
        request.setUserKey(key);
        request.setSign(sign);
        String json =GsonUtils.getJson(request);
       doRequest(context,showDialog, BaseHttp.ORDERLIST_ENDORE, json,callBack);
    }

}
