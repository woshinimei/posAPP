package com.example.onedream.flightapp.utils;

import android.text.TextUtils;
import android.util.Log;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class Rs {

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNmM0GTsYXf7TLA4vLghJd0wiRtelxDC8/IPskdBzYfP3F+LqNdnu722XXX4gzIz1g/LnU0WPIfVEa7rOjiv/z/R6PanDAgjicz5amZaQsw4FudNmhSn1bAwj1cyfPx9CR3kBPiqQPnFt3+DEK/V5yDlc50r30dvB3h4Q+0lJmKQIDAQAB";

    private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM2YzQZOxhd/tMsDi8uCEl3TCJG16XEMLz8g+yR0HNh8/cX4uo12e7vbZddfiDMjPWD8udTRY8h9URrus6OK//P9Ho9qcMCCOJzPlqZlpCzDgW502aFKfVsDCPVzJ8/H0JHeQE+KpA+cW3f4MQr9XnIOVznSvfR28HeHhD7SUmYpAgMBAAECgYAny1SbzPGAqOJIjTYovNNrP6af9XLqw639bRfPNX5D1OWVxQ/uw6ktckjjCAWnyEFgHWqmq6TBsKfbK6qvk/74VQ01eBTkclgp1b1QoEnRkZv8FVhvAB6BrZao3ZdZ9FI/k0tzY1G+vyPPS5bmE6yXJpXmAbqt3jiccZwmRzocgQJBAOVxHAWIz6kFHzkBQ6X/XXW+39leHEXO2GNrep4ERa3IiLJ37zy4YbimVu4gYmIXx+a3oOWHoRpO0fbAH61eUTECQQDlZRxD+6W1aEgCP3JBgGfTVDY6CWMkk/7/wIu4Ikb3DZZ4OqEHztvnu4m2NTGLnz52togVLXQ4Eso7APNNjOZ5AkEAhnbrfTLYwK2Hxti+1KH8G+1pMvK8jwzSNDHhAopua5KCylUPl/5XBug1Ogkwn1xggw5K9TmvaMOYuYuPBQOpgQJBANsOJeLJkSFdlr4Gxl3Ed+E3npznT/SjGzQxM3s/yFKteA4RtqqVICv3S3di7pAtHmIQxnyqrjvJvbKAotZggckCQEJ2hPfJo3RSoxdXnLZ6+8aqM3iWdrMBXr8VIJsXFw6nN4T/oFJKCJBEo/P9Xj++ZD+BfkA7G79W3oDAVYpAZxY=";

    /**
     * 用公钥加密 <br>
     * 每次加密的字节数，不能超过密钥的长度值减去11
     *
     * @param data     需加密数据的byte数据
     * @param //pubKey 公钥
     * @return 加密后的byte型数据
     */
    public static byte[] encrypt(String data) {
        try {
            if (TextUtils.isEmpty(data)) {
                data = "";
            }
            Cipher cipher = Cipher.getInstance("RSA");
            // 编码前设定编码方式及密钥
            cipher.init(Cipher.ENCRYPT_MODE, loadPublicKey(publicKey));
            // 传入编码数据并返回编码结果
            return cipher.doFinal(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用私钥解密
     *
     * @param data 经过encryptedData()加密返回的byte数据
     * @return
     */
    public static String decrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, loadPrivateKey(privateKey));
            byte[] decode = Base64Utils.decode(data);
            for (byte b : decode) {
                Log.e("--------",b+"");
            }

            byte[] bytes = cipher.doFinal(decode);
            return new String(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public static PublicKey loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = Base64Utils.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 从字符串中加载私钥<br>
     * 加载时使用的是PKCS8EncodedKeySpec（PKCS#8编码的Key指令）。
     *
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    public static PrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = Base64Utils.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }

}
