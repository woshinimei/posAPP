package com.example.onedream.flightapp.utils;

import java.math.BigDecimal;

public class MoneyUtils {
    //元转分  (12位字母格式)
    public static String changeY2F(String amount) {
        BigDecimal bigDecimal = new BigDecimal(amount).setScale(2);
        String s = bigDecimal.multiply(new BigDecimal(100)).toString();
        return s;
    }

}
