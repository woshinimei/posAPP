package com.example.onedream.flightapp.model;

import android.content.Context;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.ControlRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class ControlModel  extends BaseModel {

    public void getData(Context context, int type, ControlRequest request,OnCallBack<String> callBack){
        String baseUrl = BaseHttp.CONTROL_ORDER_NORMA;
        switch (type){
            case 0:
                baseUrl = BaseHttp.CONTROL_ORDER_NORMA;
                break;
            case 1:
                baseUrl = BaseHttp.CONTROL_ORDER_REFUND;
                break;
            case 2:
                baseUrl = BaseHttp.CONTROL_ORDER_ENDORE;
                break;
        }
        String sign = SignUtils.getSign();
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        request.setUserKey(key);
        request.setSign(sign);
        String json = GsonUtils.getJson(request);
        doRequest(context,true,baseUrl,json,callBack);
    }
}
