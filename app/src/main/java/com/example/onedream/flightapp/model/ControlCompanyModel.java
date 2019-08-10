package com.example.onedream.flightapp.model;

import android.content.Context;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.ControlCompanyRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.SignUtils;

public class ControlCompanyModel extends BaseModel {

    public void getData(Context context, OnCallBack<String> callBack){
        ControlCompanyRequest request = new ControlCompanyRequest();
        request.setUserKey(AppLocal.USERKEY);
        String sign = SignUtils.getSign();
        request.setSign(sign);
        String json = GsonUtils.getJson(request);
        doRequest(context,true,BaseHttp.CONTROL_COMPANY_LIST,json,callBack);
    }
}
