package com.example.onedream.flightapp.model;

import android.content.Context;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.CheckRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;


public class CheckModel extends BaseModel {
    public void checkPayOrRefund(Context context,int type, String  ddbh, String amount , OnCallBack<String> callback) {
        String baseUrl = BaseHttp.CHECK_NOMAR_PAY;
        if (type==0){
             baseUrl = BaseHttp.CHECK_NOMAR_PAY;
        }else if (type==1){
            baseUrl = BaseHttp.CHECK_REFUND;
        }else {
            baseUrl = BaseHttp.CHECK_ENDORE_PAY;
        }
        CheckRequest request = new CheckRequest();
        request.setDdbh(ddbh);
        request.setAmount(amount);
        String sign = SignUtils.getSign();
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        request.setUserKey(key);
        request.setSign(sign);
        String json = GsonUtils.getJson(request);
        doRequest(context,true,baseUrl,json,callback);
    }
}
