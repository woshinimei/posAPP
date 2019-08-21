package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.LoginModel;
import com.example.onedream.flightapp.response.LoginResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.OrderListFliterUtils;
import com.example.onedream.flightapp.utils.Shelper;


public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);

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
        Shelper shelper = new Shelper(getBaseContext());
//        shelper.clear();
        String userName = shelper.getString(AppLocal.USER_NAME);
        String pwd = shelper.getString(AppLocal.USER_PWD);
        //判断是否登录
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(pwd)) {
            //已经登录无需用户重新登录，但需要重新获取登录信息userKey
            LoginModel model = new LoginModel();
            model.setLogin(this, true, userName, pwd, new OnCallBack<String>() {
                @Override
                public void onSucess(String s) {
                    if (!isFinishing()) {
                        LoginResponse response = GsonUtils.fromJson(s, LoginResponse.class);
                        if (response.isSuccess()) {
                            Shelper shelper = new Shelper(getBaseContext());
                            shelper.save(new Shelper.Contanvlues(AppLocal.USER_NAME, userName));
                            shelper.save(new Shelper.Contanvlues(AppLocal.USER_PWD, pwd));
                            setOrderListRequest();
                            String userKey = response.getUserKey();
                            Log.e("---userKey---", userKey + "----");
                            if (!TextUtils.isEmpty(userKey)) {
                                shelper.save(new Shelper.Contanvlues(AppLocal.USER_KEY,userKey));
                            }
                            startActivity(new Intent(getBaseContext(), OrderListActivity.class));
                            finish();
                        }
                    }
                }

                @Override
                public void onError(String msg) {
                    if (!isFinishing()) {
                        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
                        startActivity(new Intent(getBaseContext(), LoginActivity.class));
                        finish();
                    }
                }
            });

        } else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }


    }

    private void setOrderListRequest() {
        //普通订单
        OrderListFliterUtils.resetData(0);
        //退废单
        OrderListFliterUtils.resetData(1);
        //改签单
        OrderListFliterUtils.resetData(2);
    }
}
