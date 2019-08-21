package com.example.onedream.flightapp.model;

import android.content.Context;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.PayRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class PayModel extends BaseModel {
    public void getData(Context context, int type, PayRequest request,OnCallBack<String> callBack) {
        String baseUrl  =BaseHttp.ORDER_NORMA_LPAY;
        switch (type){
            case 0:
                baseUrl  =BaseHttp.ORDER_NORMA_LPAY;
                break;
            case 2:
                baseUrl  =BaseHttp.ORDER_ENDORE_LPAY;
                break;
        }
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        request.setUserKey(key);
        String sign = SignUtils.getSign();
        request.setSign(sign);
        String json =GsonUtils.getJson(request);
        doRequest(context,true,baseUrl,json,callBack);
    }
}
