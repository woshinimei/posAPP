package com.example.onedream.flightapp.utils;
import android.util.Log;

import java.security.PublicKey;

public class SignUtils {
       //生成签名
    public static String getSign() {
        String sign ="SHGM"+"/"+System.currentTimeMillis();
//        Log.e("--加密前--sign---",sign+"");
//
        String encrypt = RsaUtil.publicEncrypt(sign);
//        Log.e("--加密后--encrypt---",encrypt+"");
//        String str = "Gx1cBY+47iTMWJXpPoxk4rhxYeNySiJvlxdefuppVEzcs/07tVrz+NDVaLVIsW3ARi7gxcx63mfveddtKUXCrYpR2huObPFDdKcGh5UlMfP94QeWPQ9Mc+00JSORlnxbEzVjc+l4kDuM1D3Xpj5Uh6Im5UJy0qflrQ8nEjldlYglEnH+V8grna8uvgOyE9fcLCHaEzRYJhe2cBijxtNok9LncKwxxUIvefi2JvnvF6VX0ksJncc++Lwnaxt7ENEsu6nByiQlw5OcYNjzJKNAYEjmMBW0hBVBxlZHGP8k528bJ6nRXMoo75toGh2naBjlh7oPtYCa8OhjzRHx227lfw==";

//        String decrypt = RsaUtil.privateDecrypt(encrypt);
//        Log.e("--解密后--decrypt---",decrypt+"");
        return encrypt;
    }
}
