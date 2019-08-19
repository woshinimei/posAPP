package com.example.onedream.flightapp.network;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.example.onedream.flightapp.activity.LoginActivity;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.view.ProgressDialog;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class BaseModel {
    ProgressDialog dialog;

    public void doRequest(Context context, boolean showLoading, String url,String json,OnCallBack callBack) {
        RequestParams entity = new RequestParams(url);
        if (entity != null) {
            //设置json请求
            entity.addHeader("Content-Type", "application/json"); //设置请求头部
            entity.setAsJsonContent(true);
            entity.setBodyContent(json);
            Log.e("请求地址: ", url + "");
            Log.e("请求参数: ", json);

        }


        //设置超时时间
        int timeOut = 60 * 1000;
        entity.setConnectTimeout(timeOut);
        if (showLoading) {
            dialog = new ProgressDialog(context);
            dialog.show();
        }
        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("返回成功：", result + "");
                if (!TextUtils.isEmpty(result)){
                    BaseResponse response = GsonUtils.fromJson(result,BaseResponse.class);
                    if (response.isSuccess()){
                        callBack.onSucess(result);
                    }else {
                        String message = response.getMessage();

                        if (!TextUtils.isEmpty(message)){
                            callBack.onError(message);
                        }else {
                            callBack.onError(response.getEmg());
                        }
                        isErrorKey(response,context);
                    }

                }else {
                    callBack.onError("result 为空");
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("请求失败：", ex.getMessage() + "");
                callBack.onError(ex.getMessage() + "");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("取消请求：", "----");
            }

            @Override
            public void onFinished() {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

    }

    //判断是否过期
    private void isErrorKey(BaseResponse response, Context context) {
        String rtnCode = response.getRtnCode();
                        if (!TextUtils.isEmpty(rtnCode)&&rtnCode.equals("E003")){//登录过期
                            context.startActivity(new Intent(context,LoginActivity.class));
//        if (!TextUtils.isEmpty(rtnCode)&&rtnCode.equals("I000")){//登录过期
//            MyDialog dialog = new MyDialog(context);
//            dialog.setContent("当前登录信息已经过期，是否重新登录？");
//            dialog.setLeftButtonClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.dismiss();
//                }
//            });
//            dialog.setRightButtonClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.dismiss();
//                    context.startActivity(new Intent(context,LoginActivity.class));
//                }
//            });
//
//            dialog.showPaddingScreen();

        }
    }
}
