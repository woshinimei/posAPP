package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.LoginModel;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.response.LoginResponse;
import com.example.onedream.flightapp.utils.DateUtils;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.OrderListFliterUtils;
import com.example.onedream.flightapp.utils.Shelper;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.ed_username)
    EditText edUsername;

    @BindView(R.id.ed_password_model_box)
    CheckBox edPasswordModelBox;

    @BindView(R.id.ed_password)
    EditText edPassword;


    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        Shelper shelper = new Shelper(getActivity());
//        edUsername.setText("SHGMADMIN");
//        edPassword.setText("aA123456");
        String userName = shelper.getString(AppLocal.USER_NAME);
        String pwd = shelper.getString(AppLocal.USER_PWD);
        if (!TextUtils.isEmpty(userName)) {
            edUsername.setText(userName);
        }
        if (!TextUtils.isEmpty(pwd)) {
            edPassword.setText(pwd);
        }
        edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        edPasswordModelBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    edPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }


    @OnClick({R.id.ll_password_model_box_layout, R.id.btn_submit, R.id.tv_forget, R.id.tv_person_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_password_model_box_layout:

                edPasswordModelBox.setChecked(!edPasswordModelBox.isChecked());
                break;

            case R.id.btn_submit:

                loginRequest();

                break;
            case R.id.tv_forget:
                break;
            case R.id.tv_person_login:
                break;
        }
    }

    //登录请求
    private void loginRequest() {

        LoginModel model = new LoginModel();
        String userName = edUsername.getText().toString();
        String pwd = edPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            showToast("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }

        model.setLogin(getActivity(), true, userName, pwd, new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                LoginResponse response = GsonUtils.fromJson(s, LoginResponse.class);
                if (response.isSuccess()) {
                    //重新设置订单列表初始请求数据
                    setOrderListRequest();
                    Shelper shelper = new Shelper(getActivity());
                    shelper.save(new Shelper.Contanvlues(AppLocal.USER_NAME, userName));
                    shelper.save(new Shelper.Contanvlues(AppLocal.USER_PWD, pwd));
                    String userKey = response.getUserKey();
                    Log.e("---userKey---", userKey + "----");
                    if (!TextUtils.isEmpty(userKey)) {
                        AppLocal.USERKEY = userKey;
                    }
                    startActivity(new Intent(getActivity(), OrderListActivity.class));
                    finish();
                }

            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });

    }

    private void setOrderListRequest() {
        //普通订单
        OrderListFliterUtils.resetData(0);
        //退废单
        OrderListFliterUtils.resetData(1);
        //改签单
        OrderListFliterUtils.resetData(2);
    }

//    private void getSign() {
//        String base ="123";
//        Log.e("--加密前--base---",base+"");
//        String encrypt = RsaUtil.publicEncrypt(base);
//        Log.e("--加密后--encrypt---",encrypt+"");
//        String decrypt = RsaUtil.privateDecrypt(encrypt);
//        Log.e("--解密后--decrypt---",decrypt+"");
//    }
//    private void setSign2(){
//        String base ="123";
//        Log.e("--加密前--base---",base+"");
//        String encrypt="";
//        try {
//            encrypt = RsaUtil.encrypt(base, Signature.PUBLIC_KEY);
//            Log.e("--加密后--encrypt---",encrypt+"");
//        } catch (Exception e) {
//            Log.e("----Exception--",e.toString()+"");
//            e.printStackTrace();
//        }
//        try {
//            Log.e("--加密后--encrypt---",encrypt+"");
//            String decrypt = RsaUtil.decrypt(encrypt, Signature.PRIVATE_KEY);
//            Log.e("--解密后--decrypt---",decrypt+"");
//        } catch (Exception e) {
//            Log.e("----Exception--",e.toString()+"");
//            e.printStackTrace();
//        }
//
//    }
//    private void setSign() {
//        String base = "123";
//        Log.e("--加密前--base---",base+"");
//        String enStr = RSAUtils.getSign(base);
//        Log.e("--加密后--enStr---",enStr+"");
//        String decrypt = RSAUtils.getDecrypt(enStr);
//        Log.e("--解密后--decrypt---",decrypt+"");
//    }

}
