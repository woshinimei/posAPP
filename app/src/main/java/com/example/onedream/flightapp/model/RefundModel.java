package com.example.onedream.flightapp.model;

import android.content.Context;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.RefundRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class RefundModel extends BaseModel {
    public void getData(Context context, RefundRequest request, OnCallBack<String> callBack) {
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        request.setUserKey(key);
        String sign = SignUtils.getSign();
        request.setSign(sign);
        String json = GsonUtils.getJson(request);
        doRequest(context, true, BaseHttp.ORDER_REFUND_LPAY, json, callBack);
    }
}
