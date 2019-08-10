package com.example.onedream.flightapp.model;

import android.content.Context;
import android.util.Log;

import com.example.onedream.flightapp.network.BaseHttp;
import com.example.onedream.flightapp.network.BaseModel;
import com.example.onedream.flightapp.request.LoginRequest;
import com.example.onedream.flightapp.constant.Signature;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.utils.Base64Utils;
import com.example.onedream.flightapp.utils.DesUtils;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.RSAUtils;
import com.example.onedream.flightapp.utils.Rs;
import com.example.onedream.flightapp.utils.RsaUtil;
import com.example.onedream.flightapp.utils.SignUtils;
import com.google.gson.Gson;

import java.security.PrivateKey;
import java.security.PublicKey;

public class LoginModel extends BaseModel {
    public void setLogin(Context context,String username, String password, OnCallBack<String> callBack){

        String pwd  = DesUtils.encode(Signature.DSE_KEY,password);
        Log.e("--pwd--",pwd+"");
        String sign =SignUtils.getSign();
        LoginRequest bean = new LoginRequest();
        bean.setUsername(username);
        bean.setPassword(pwd);
        bean.setSign(sign);

        String json= GsonUtils.getJson(bean);
//                try {
//                    String base  ="AyPxCrul3x23577LHfix2imDAdF39rn6mIfhLD2dk6Xucem7NcaenCSv93K3Q/Tau0IrX4sOHymk/8JPKjwtiwgGh/p89zJiYU1ydxP4Z+lNzko16BsCqYUHOi+7wNcF5ur+IScL1zkrqCqagC3iMFpsSXiijbKCiUOYx4KCqJs=";
//            //base64 解密字符串
//            byte[] decode = Base64Utils.decode(base);
//            PrivateKey privateKey = RSAUtils.loadPrivateKey(Signature.skey);
//            byte[] bytes = RSAUtils.decryptData(decode, privateKey);
//            String decryptStr = new String(bytes);
//            Log.e("---解密后--sign-11-",decryptStr);
//                    String decrypt = Rs.decrypt(base);
//                    Log.e("---解密后--sign-11-",decrypt);
//                } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("----e-----",e.getMessage()+"");
//        }
        String decrypt = RsaUtil.decrypt(sign);
//        String decrypt = Rs.decrypt(sign);
        Log.e("---解密后--sign-22-",decrypt);
//        json = "{\n" +
//                " \"username\":\"SHGMADMIN\",\"password\":\"aA123456\",\"sign\":\"SHGM/ASMIN\"\n" +
//                "}";
        doRequest(context,true,BaseHttp.LOGIN,json,callBack);

    }


}
