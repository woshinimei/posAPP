package com.example.onedream.flightapp.utils;




import android.text.TextUtils;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by sunc on 2017/3/20.
 */
public class RsaUtil {

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNmM0GTsYXf7TLA4vLghJd0wiRtelxDC8/IPskdBzYfP3F+LqNdnu722XXX4gzIz1g/LnU0WPIfVEa7rOjiv/z/R6PanDAgjicz5amZaQsw4FudNmhSn1bAwj1cyfPx9CR3kBPiqQPnFt3+DEK/V5yDlc50r30dvB3h4Q+0lJmKQIDAQAB";

    private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM2YzQZOxhd/tMsDi8uCEl3TCJG16XEMLz8g+yR0HNh8/cX4uo12e7vbZddfiDMjPWD8udTRY8h9URrus6OK//P9Ho9qcMCCOJzPlqZlpCzDgW502aFKfVsDCPVzJ8/H0JHeQE+KpA+cW3f4MQr9XnIOVznSvfR28HeHhD7SUmYpAgMBAAECgYAny1SbzPGAqOJIjTYovNNrP6af9XLqw639bRfPNX5D1OWVxQ/uw6ktckjjCAWnyEFgHWqmq6TBsKfbK6qvk/74VQ01eBTkclgp1b1QoEnRkZv8FVhvAB6BrZao3ZdZ9FI/k0tzY1G+vyPPS5bmE6yXJpXmAbqt3jiccZwmRzocgQJBAOVxHAWIz6kFHzkBQ6X/XXW+39leHEXO2GNrep4ERa3IiLJ37zy4YbimVu4gYmIXx+a3oOWHoRpO0fbAH61eUTECQQDlZRxD+6W1aEgCP3JBgGfTVDY6CWMkk/7/wIu4Ikb3DZZ4OqEHztvnu4m2NTGLnz52togVLXQ4Eso7APNNjOZ5AkEAhnbrfTLYwK2Hxti+1KH8G+1pMvK8jwzSNDHhAopua5KCylUPl/5XBug1Ogkwn1xggw5K9TmvaMOYuYuPBQOpgQJBANsOJeLJkSFdlr4Gxl3Ed+E3npznT/SjGzQxM3s/yFKteA4RtqqVICv3S3di7pAtHmIQxnyqrjvJvbKAotZggckCQEJ2hPfJo3RSoxdXnLZ6+8aqM3iWdrMBXr8VIJsXFw6nN4T/oFJKCJBEo/P9Xj++ZD+BfkA7G79W3oDAVYpAZxY=";


    private static char[] base64EncodeChars = new char[]
            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                    'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
                    '6', '7', '8', '9', '+', '/' };

    private static byte[] base64DecodeChars = new byte[]
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53,
                    54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                    12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29,
                    30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1,
                    -1, -1, -1 };

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
            byte[] dataByte = cipher.doFinal(decode(data));
//            return String.valueOf(dataByte);
            return new String(dataByte);
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
            byte[] buffer = decode(publicKeyStr);
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
            byte[] buffer = decode(privateKeyStr);
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

    /**
     * 加密
     *
     * @param data
     * @return
     */
    public static String encode(byte[] data)
    {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len)
        {
            b1 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }

    /**
     * 解密
     *
     * @param str
     * @return
     */
    public static byte[] decode(String str)
    {
        try
        {
            return decodePrivate(str);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    private static byte[] decodePrivate(String str) throws Exception
    {
        StringBuffer sb = new StringBuffer();
        byte[] data = null;
        data = str.getBytes("US-ASCII");
        int len = data.length;
        int i = 0;
        int b1, b2, b3, b4;
        while (i < len)
        {
            do
            {
                b1 = base64DecodeChars[data[i++]];
            } while (i < len && b1 == -1);
            if (b1 == -1)
                break;

            do
            {
                b2 = base64DecodeChars[data[i++]];
            } while (i < len && b2 == -1);
            if (b2 == -1)
                break;
            sb.append((char) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

            do
            {
                b3 = data[i++];
                if (b3 == 61)
                    return sb.toString().getBytes("iso8859-1");
                b3 = base64DecodeChars[b3];
            } while (i < len && b3 == -1);
            if (b3 == -1)
                break;
            sb.append((char) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

            do
            {
                b4 = data[i++];
                if (b4 == 61)
                    return sb.toString().getBytes("iso8859-1");
                b4 = base64DecodeChars[b4];
            } while (i < len && b4 == -1);
            if (b4 == -1)
                break;
            sb.append((char) (((b3 & 0x03) << 6) | b4));
        }
        return sb.toString().getBytes("iso8859-1");
    }
}
