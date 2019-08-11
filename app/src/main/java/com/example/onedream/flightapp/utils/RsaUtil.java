package com.example.onedream.flightapp.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RsaUtil {
//    public static String  encrypt(String data, String publicKey) throws Exception {
//        byte[] decoded = Base64Utils.decode(publicKey);
////        byte[] decoded = Base64.decodeBase64(publicKey);
//        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("Rsa").generatePublic(new X509EncodedKeySpec(decoded));
//        //RSA加密
//        Cipher cipher = Cipher.getInstance("Rsa");
//        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
//        String outStr = Base64Utils.encode(cipher.doFinal(data.getBytes("UTF-8")));
////        String outStr = Base64.encodeBase64String(cipher.doFinal(data.getBytes("UTF-8")));
//        return outStr;
//    }
//
//    /**
//     * <P>
//     * 私钥解密
//     * </p>
//     *
//     * @param str 已加密数据
//     * @param privateKey    私钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static String  decrypt(String str, String privateKey) throws Exception {
//        //64位解码加密后的字符串
//        byte[] inputByte = Base64Utils.decode(str);
////        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
//        //base64编码的私钥
//        byte[] decoded = Base64Utils.decode(privateKey);
////        byte[] decoded = Base64.decodeBase64(privateKey);
//        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("Rsa").generatePrivate(new PKCS8EncodedKeySpec(decoded));
//        //RSA解密
//        Cipher cipher = Cipher.getInstance("Rsa");
//        cipher.init(Cipher.DECRYPT_MODE, priKey);
//        String outStr = new String(cipher.doFinal(inputByte));
//        return outStr;
//    }
    /**
     * 秘钥
     */
    public static final String CHARSET = "UTF-8";
    public static final String RSA_ALGORITHM = "Rsa";
    public static final String COMMON_RSA = "Rsa/ECB/PKCS1Padding";

    public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn5nFSQzr2QgHAGWQryvBVytV7a0o8RnZamTggvtqsL6K0IBzdpycTwlOs3COSLKAVblNDuWiUueRhyAb0XZ3ttLatyIvvroIKnSmrWXphRLs0vWvz8hUGC419Tt4asqew+Lri+urOZLMgBT2j8nd4zGrg+1MGXSQHFWJkw6a6WM6wfz8IP8Kh5Aq+i2B9zJHj+ep4dCMeu+doI0qHYZHAyBbGuoJDt5rkOhfbdwFHjEySnvuzw8qygvEHyv9Gs2ys9OMS1uURSC9BLXOwn976rjH99kaoFZJmnRxT3edJzTmd+rhudsejmd1Y5ruj7vT+hm7U9LS8YrIiGsSIw48YwIDAQAB";
    public static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCfmcVJDOvZCAcAZZCvK8FXK1XtrSjxGdlqZOCC+2qwvorQgHN2nJxPCU6zcI5IsoBVuU0O5aJS55GHIBvRdne20tq3Ii++uggqdKatZemFEuzS9a/PyFQYLjX1O3hqyp7D4uuL66s5ksyAFPaPyd3jMauD7UwZdJAcVYmTDprpYzrB/Pwg/wqHkCr6LYH3MkeP56nh0Ix6752gjSodhkcDIFsa6gkO3muQ6F9t3AUeMTJKe+7PDyrKC8QfK/0azbKz04xLW5RFIL0Etc7Cf3vquMf32RqgVkmadHFPd50nNOZ36uG52x6OZ3Vjmu6Pu9P6GbtT0tLxisiIaxIjDjxjAgMBAAECggEAB8adJw77GqradHl+UBqIo++XkynhmcWRoy5hBeCr9QqDht8LQRcmQm+IpxNvyzjvKb4KdBRaEUH5BCVbVZw4/u5M+6ktvFQh+7eNO1uAwhwG78xKkYwIFNmDhXwtRL60d4TBxyJnSDnPvtnGnYDPT7dmzNmt4HueXdMJDeIjSAWajjAxzmWIKVqzcROC2dPQOR1zkCpy+YVmkm2lAoT/+GBK/BUC+Z5vmgD50ksf7COf4r0/GjoRS29MyBEQJmtpA8I1wfNds2Gycje1GvcBrSMVmykKqqqFhP4dQB0h/6ZIJ49Ca7N/59umSjVjHPSUORSL0yN61pNQk/iZDaMN6QKBgQD2Dts7w7G0WSzW8xN4MJyiPDFkGPz8Cq/mQbRzITbbvZjhy5asRNngwCYDBzbzaZrLvkcTLLNWhhoBn4ksxZAdWCp9SUBvfbZAskRDKBmkz9YrSYIR758RSkF0sVFqybVult9XRQzMr0QZk73L/il4B3W3Ql4rBepnA0XFMjUajQKBgQCmDKCrZCuJvjvRcJ3Frf9koZahDgRMsVI6tiPiWOl6EurcxwcccBux/GiUGevYwn6Bnie4zNaJLlRbrzFEoPYcwr93Yjn1fufQRcN1a7oNnN5iIiQ3dLq7mW28YQZbrEmvsaDUOIU7O8a+hOz75Yo/RbiMZECfvPPAQ7VfrtrurwKBgGmCOVPJODwDOQz6slCJV8DhWrR3WpOg6YgsiHoNtf5HsHSx3ewEogCTpDkMMO3zTKMs9kEsm8HwQtqLVEDUflV25tFORckI+MuJJWg+m7BmRonNPW7/dw/s7WBiYG0QDTJck2xSeYiTZvootevxEksbt8hbNxHvuXFun85NFyRJAoGBAKV/4IPzCxH28VgGjroAepSqGZ/cgJyQAA1UjN+FDvAE+uGh3YySkIgNs44pZ9BbygsWvzCJuSpxatMXAlwMskBoOr2awXnWSuZjIjVeccovl9bngIFlbticS6t+aP/l8GuU91+OFfy7z5MEmc9XMTtvGkmTgnWztp7i3VvIw50xAoGASffYHhiYVmrhul0ElvQu4H/1jx+v0V1bHTjYnPuzY4hovCc1bf5LQh2Aw+rgRzw3ZZE5+/aA/+oEKlk1a0gO7tXwZCVf8htdI9MsklWCmCvJa6Zl+yul5I8lcCxoD/uSOTtIbEdcGdtfnm3WMm9uocR2ux7kfB9I0TG0onz7Ymw=";

    /**
     * 得到公钥
     *
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64Utils.decode(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * 得到私钥
     *
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64Utils.decode(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    /**
     * 公钥加密
     *
     * @param data
     * @return
     */
    public static String publicEncrypt(String data) {
        try {
            RSAPublicKey publicKey = getPublicKey(PUBLIC_KEY);
            Cipher cipher = Cipher.getInstance(COMMON_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64Utils.encode(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET),
                    publicKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * 私钥解密
     *
     * @param data
     * @return
     */
    public static String privateDecrypt(String data) {
        try {
            RSAPrivateKey privateKey = getPrivateKey(PRIVATE_KEY);
            Cipher cipher = Cipher.getInstance(COMMON_RSA);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64Utils.decode(data),
                    privateKey.getModulus().bitLength()), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) {
        int maxBlock = 0;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultDatas;
    }
}
