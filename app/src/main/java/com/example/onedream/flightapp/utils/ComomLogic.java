package com.example.onedream.flightapp.utils;

import android.text.TextUtils;

import org.apache.commons.lang.StringUtils;

public class ComomLogic {
//    /**
//     * 设置证件号码   加密显示 为*
//     * 加密格式 前6 后2
//     * @param certNo
//     */
//    /**
//     * 设置手机号码加密   显示 为*
//     * @param phone
//     */
//    public static String formatPhonejiamiShow(String phone) {
//        if (StringUtils.isEmpty(phone)) {
//            return phone;
//        }
//        //如果是加密模式
//        if(CacheB2GData.getIsjiamshwoIDandPhone(4).equals("1")){
//            String phonetrim = phone.replace(" ", "").trim();
//            boolean checkPhone = CheckColumn.checkPhone(phonetrim);
//            if(!checkPhone){
//                return phone;
//            }else{
//                StringBuffer buffer  =new StringBuffer();
//
//                int len=phonetrim.length();
//                buffer.append(phonetrim.substring(0, 3));
//                for(int i=3;i<len-4;i++){
//                    buffer.append("*");
//                }
//                buffer.append(phonetrim.substring(len-4, len));
//                return buffer.toString();
//
//            }
//        }else {
//            return FormatUtils.formatPhoneShow(phone);
//        }
//    }
//    public static String formatIDjiamiShow(String certType,String certNo) {
//
//
//        if(MyTextUtil.isEmpty(certNo)){
//            return certNo;
//        }
//
//        String certNumber =certNo.replace(" ", "").trim();
//
//
//        if ("1003401".equals(certType)){
//            //身份证
//            String checkSFZ = CheckColumn.checkSFZ(certNumber);
//
//
//            if(!MyTextUtil.isEmpty(checkSFZ)){
//
//                return certNumber;
//            }else{
//
//                if (CacheB2GData.getIsjiamshwoIDandPhone(1).equals("1")) {    //是否开启加密模式
//
//                    StringBuffer buffer  =new StringBuffer();
//
//                    int len=certNumber.length();
//                    buffer.append(certNumber.substring(0, 6));//前6
//                    for(int i=6;i<len-2;i++){
//                        buffer.append("*");
//                    }
//                    buffer.append(certNumber.substring(len-2, len));//后2
//                    return buffer.toString();
//                }else {
//                    return FormatUtils.formatCardShow(certNumber);
//                }
//
//            }
//        }else if ("1003402".equals(certType)){
//            //护照
//            if (CacheB2GData.getIsjiamshwoIDandPhone(3).equals("1")) {
//
//                //是否开启加密模式
//                //组装加密显示数据
//                StringBuffer buffer  =new StringBuffer();
//
//                int len=certNumber.length();
//                if (len>4){
//                    buffer.append(certNumber.substring(0, len-4));
//                    for(int i=len-4;i<len;i++){
//                        buffer.append("*");
//                    }
//                    return buffer.toString();
//                }else {
//                    return certNumber;
//                }
//            }
//
//
//        }else {
//            return certNumber;
//        }
//
//
//
//
//        return certNumber;
//
//
//
//    }
}
