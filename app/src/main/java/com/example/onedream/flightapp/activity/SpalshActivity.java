package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.LoginModel;
import com.example.onedream.flightapp.utils.Shelper;


public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AutoLogin();
            }
        }, 1000);
    }


    private void AutoLogin() {
        initData();

    }

    private void initData() {
        Shelper shelper =new Shelper(this);
        shelper.clear();
        String userName = shelper.getString(AppLocal.USER_NAME);
        String pwd = shelper.getString(AppLocal.USER_PWD);
        Log.e("------userName-----",userName+"");
        Log.e("------pwd-----",pwd+"");
        //判断是否登录
        if (!TextUtils.isEmpty(userName)&&!TextUtils.isEmpty(pwd)){
            //已经登录无需用户重新登录，但需要重新获取登录信息userKey
            LoginModel model = new LoginModel();
            model.setLogin(getBaseContext(), userName, pwd, new OnCallBack<String>() {
                @Override
                public void onSucess(String s) {
                    startActivity(new Intent(getBaseContext(), OrderListActivity.class));
                    finish();
                }

                @Override
                public void onError(String msg) {
                    Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT);
                }
            });

        }else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }



    }


}
