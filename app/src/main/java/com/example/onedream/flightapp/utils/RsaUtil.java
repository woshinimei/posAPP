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
//     * @param data
     * @return
     */
//    public static String privateDecrypt(String data) {
//        try {
//            RSAPrivateKey privateKey = getPrivateKey(PRIVATE_KEY);
//            Cipher cipher = Cipher.getInstance(COMMON_RSA);
//            cipher.init(Cipher.DECRYPT_MODE, privateKey);
//            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64Utils.decode(data),
//                    privateKey.getModulus().bitLength()), CHARSET);
//        } catch (Exception e) {
//            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
//        }
//    }

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
