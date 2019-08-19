package com.example.onedream.flightapp.model;

import android.content.Context;
import android.util.Log;

import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.LoginRequest;
import com.example.onedream.flightapp.constant.Signature;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.utils.DesUtils;
import com.example.onedream.flightapp.utils.GsonUtils;

import com.example.onedream.flightapp.utils.SignUtils;

public class LoginModel extends BaseModel {
    public void setLogin(Context context,boolean showDialog,String username, String password, OnCallBack<String> callBack){

        String pwd  = DesUtils.encode(Signature.DSE_KEY,password);
//        Log.e("--pwd--",pwd+"");
        String sign =SignUtils.getSign();
        LoginRequest bean = new LoginRequest();
        bean.setUsername(username);
        bean.setPassword(pwd);
        bean.setSign(sign);
        String json= GsonUtils.getJson(bean);
        doRequest(context,showDialog,BaseHttp.LOGIN,json,callBack);

    }


}
