package com.example.onedream.flightapp.utils;
import android.util.Log;

import java.security.PublicKey;

public class SignUtils {
       //生成签名
    public static String getSign() {
        String sign ="SHGM"+"/"+System.currentTimeMillis();
        Log.e("--加密前--sign---",sign+"");
        String encrypt = RsaUtil.publicEncrypt(sign);
//        Log.e("--加密后--encrypt---",encrypt+"");
//        String decrypt = RsaUtil.privateDecrypt(encrypt);
//        Log.e("--解密后--decrypt---",decrypt+"");
        return encrypt;
    }
}
