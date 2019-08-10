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
import com.example.onedream.flightapp.response.LoginResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
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
        edUsername.setText("SHGMADMIN");
        edPassword.setText("aA123456");
        edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        edPasswordModelBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    edPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
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
        if (TextUtils.isEmpty(userName)){
            showToast("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }
        model.setLogin(getActivity(),userName, pwd,  new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                LoginResponse response =GsonUtils.fromJson(s,LoginResponse.class);
                if (response.isSuccess()){
                    startActivity(new Intent(getActivity(),OrderListActivity.class));
                    Shelper shelper = new Shelper(getActivity());
                   shelper.save(new Shelper.Contanvlues(AppLocal.USER_NAME,userName));
                   shelper.save(new Shelper.Contanvlues(AppLocal.USER_PWD,pwd));
                  if (TextUtils.isEmpty(response.getUserKey())){
                      AppLocal.USERKEY = response.getUserKey();
                  }
                }

            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });

    }


}
