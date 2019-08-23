package com.example.onedream.flightapp.utils;

import android.text.TextUtils;
import android.util.Log;

import java.math.BigDecimal;

public class MoneyUtils {
    //元转分  (12位字母格式)
    public static String changeY2F(String amount) {
        //将负改为正
        if (!TextUtils.isEmpty(amount) && amount.startsWith("-")) {
           amount = amount.replace("-","");
        }
        //最终返回的金额
        String count = "";
        try {
            //步骤1：先转成分
            BigDecimal bigDecimal = new BigDecimal(amount);//保留2位小数，再转分
            BigDecimal multiply = bigDecimal.multiply(new BigDecimal(100));
//            Log.e("----multiply---", multiply.toString() + "");
            String s = multiply.setScale(0, BigDecimal.ROUND_CEILING).toString();
//            Log.e("----s---", s + "");
            //步骤2：再补充前面的0，直到总共12位为止
            if (!TextUtils.isEmpty(s) && s.length() < 12) {
                int len = 12 - s.length();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    builder.append("0");
                }
                String zero = builder.toString();
                count = zero + s;
            }
        } catch (Exception e) {
            Log.e("-----Exception---", e.toString() + "");
        }


        return count;
    }

}
