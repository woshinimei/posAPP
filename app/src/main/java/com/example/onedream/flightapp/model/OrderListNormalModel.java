package com.example.onedream.flightapp.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.OrderListFliterUtils;
import com.example.onedream.flightapp.utils.Shelper;
import com.example.onedream.flightapp.utils.SignUtils;

public class OrderListNormalModel extends BaseModel {

    public void getData(Context context, boolean showDialog,   OrderListRequest request ,OnCallBack<String> callBack){
        Shelper shelper = new Shelper(context);
        String key = shelper.getString(AppLocal.USER_KEY);
        String sign  =SignUtils.getSign();
     OrderListFliterUtils. getCacheRequest(0,request);
        request.setUserKey(key);
        request.setSign(sign);
        String json =GsonUtils.getJson(request);
        Log.e("-----key---",request.getUserKey()+"---");
       doRequest(context,showDialog, BaseHttp.ORDERLIST_NORMAL, json,callBack);
    }

}
/**
 * dateType
 * 1:调度日期
    2:预订日期
    3:起飞日期
* */
/**
 * orderStatus
 * 0：申请中
 * 1：已订座
 * 2：已调度
 * 3：已出票
 * 4：配送中
 * 5：部分出票
 * 7：客户消
 * 8：已取消
 * 9：完成
 * */
