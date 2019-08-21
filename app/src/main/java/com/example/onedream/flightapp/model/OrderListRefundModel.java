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
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class OrderListRefundModel extends BaseModel {

    public void getData(Context context, boolean showDialog,OrderListRequest request,OnCallBack<String> callBack){
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        String sign  =SignUtils.getSign();
        OrderListFliterUtils.getCacheRequest(1,request);
        request.setUserKey(key);
        request.setSign(sign);
        String json =GsonUtils.getJson(request);
       doRequest(context,showDialog, BaseHttp.ORDERLIST_REFUEND, json,callBack);
    }

}
