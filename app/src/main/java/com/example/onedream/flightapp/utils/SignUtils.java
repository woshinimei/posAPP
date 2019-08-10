package com.example.onedream.flightapp.utils;
import android.util.Log;

import java.security.PublicKey;

public class SignUtils {
       //生成签名
    public static String getSign() {
        //公钥
        String key ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNmM0GTsYXf7TLA4vLghJd0wiRtelxDC8/IPskdBzYfP3F+LqNdnu722XXX4gzIz1g/LnU0WPIfVEa7rOjiv/z/R6PanDAgjicz5amZaQsw4FudNmhSn1bAwj1cyfPx9CR3kBPiqQPnFt3+DEK/V5yDlc50r30dvB3h4Q+0lJmKQIDAQAB";
        String sign ="SHGM"+"/"+System.currentTimeMillis();
        Log.e("------加密前--sign--",sign);
        PublicKey publicKey = RSAUtils.loadPublicKey(key);
        byte[] data = RSAUtils.encryptData(sign.getBytes(), publicKey);
        //base64 编码成字符串，便于查看
        sign = Base64Utils.encode(data);
        Log.e("-加密后-sign---",sign+"");
        return sign;
    }
}
