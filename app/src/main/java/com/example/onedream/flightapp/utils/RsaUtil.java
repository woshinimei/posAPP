package com.example.onedream.flightapp.utils;

//import sun.misc.BASE64Decoder;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.security.InvalidKeyException;
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//
//
//public class RsaUtil {
//
//    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmtR0eyQX84ZSoaiK/EY0KZmFvS3Bew5+IcHL+ZU/90Fh1I4EbSGOkgLa9rjsntZxvKepIovWTJLonx45FhpP+4DPmyGekkA7z443naGlQvmMKpqJ26Jpk0bUHBfvS5+9ZXtwI8k2hRcQIFeYRt8yKCnkKy6bwvmb9B6BPa3fdpQIDAQAB";
//
//    private static String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKa1HR7JBfzhlKhqIr8RjQpmYW9LcF7Dn4hwcv5lT/3QWHUjgRtIY6SAtr2uOye1nG8p6kii9ZMkuifHjkWGk/7gM+bIZ6SQDvPjjedoaVC+YwqmonbommTRtQcF+9Ln71le3AjyTaFFxAgV5hG3zIoKeQrLpvC+Zv0HoE9rd92lAgMBAAECgYA0WNzLBO6XaLJIbAN7IeS65kkkLHkdmKnoqv7A+Ukz9w8/wSVSTtnTFwPK7gHvRyzXDz9dDaa1TKwTv6riFA82UGXGfFYYDWzOTS6/ZVP9eO6cexiEG7a3o9HI4N5/imi5l7ErZ+nI5iiVRPTb2abplFHNlb5GuYRLb8Zghibp5QJBANyYwtJXIMOWAbs9vuTzG/tRU6lHSrYiHtBBxuP3TGs/eEZAodtMb1ozJ2DAIZd6Ac3PY9/7NWCu0griJeuXJZ8CQQDBdk63MttByDqFM3PJRPvpq0ehswIMS0YpI/maZ/CM7iDbkUzgxuRFcB5HOlquByGa7WA30SUrcx1jv0pYvI47AkAxOx5vluZHABlO0k7iBad/BP1oz/JKh37c93ENu0kgvj93XkFBEePf+36URwy4I5B3gAtIF2YoN5vEtgfEdiz9AkAphCoARnmm9EEatJ/0YUluK8ODf9bArKaxzXaTHBsTI0cJ13SYCBaUkCrvPiaXkhA0Hxy23bsMR/fWoAZkZJJhAkB7vA7adhjCnTOkN+QAMozb65FpBjGNG/z/f8FgHXtQWn+k9KdQvBf1xkMqKdgzMN3l+OArgcOm/STJLlQVPvFg";
//
//    private static String algorithm = "RSA"; //$NON-NLS-1$
//    private static final int MAX_ENCRYPT_BLOCK = 117;
//    private static final int MAX_DECRYPT_BLOCK = 128;
//
//    /**
//     * 加密
//     *
//     * @param data
//     * @return
//     * @throws NoSuchAlgorithmException
//     * @throws InvalidKeySpecException
//     * @throws NoSuchPaddingException
//     * @throws IllegalBlockSizeException
//     * @throws BadPaddingException
//     * @throws InvalidKeyException
//     * @throws IOException
//     */
//    public static String encrypt(String data) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, IOException {
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] decode = decoder.decodeBuffer(publicKey);
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decode);
//        KeyFactory kf = KeyFactory.getInstance(algorithm);
//        PrivateKey generatePrivate = kf.generatePrivate(pkcs8EncodedKeySpec);
//        Cipher ci = Cipher.getInstance(algorithm);
//        ci.init(Cipher.ENCRYPT_MODE, generatePrivate);
//
//        byte[] bytes = data.getBytes();
//        int inputLen = bytes.length;
//        int offLen = 0;//偏移量
//        int i = 0;
//        ByteArrayOutputStream bops = new ByteArrayOutputStream();
//        while (inputLen - offLen > 0) {
//            byte[] cache;
//            if (inputLen - offLen > 117) {
//                cache = ci.doFinal(bytes, offLen, 117);
//            } else {
//                cache = ci.doFinal(bytes, offLen, inputLen - offLen);
//            }
//            bops.write(cache);
//            i++;
//            offLen = 117 * i;
//        }
//        bops.close();
//        byte[] encryptedData = bops.toByteArray();
//        String encodeToString = new String(encryptedData, "utf-8");
//        return encodeToString;
//    }
//
//
//    /**
//     * 解密
//     *
//     * @param data
//     * @return
//     * @throws NoSuchAlgorithmException
//     * @throws InvalidKeyException
//     * @throws NoSuchPaddingException
//     * @throws InvalidKeySpecException
//     * @throws BadPaddingException
//     * @throws IllegalBlockSizeException
//     * @throws IOException
//     */
//    public static String decrypt(String data) throws Exception {
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] decode = decoder.decodeBuffer(privateKey);
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decode);
//        KeyFactory kf = KeyFactory.getInstance(algorithm);
//        PublicKey generatePublic = kf.generatePublic(x509EncodedKeySpec);
//        Cipher ci = Cipher.getInstance(algorithm);
//        ci.init(Cipher.DECRYPT_MODE, generatePublic);
//
//        byte[] bytes = decoder.decodeBuffer(data);
//        int inputLen = bytes.length;
//        int offLen = 0;
//        int i = 0;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        while (inputLen - offLen > 0) {
//            byte[] cache;
//            if (inputLen - offLen > 128) {
//                cache = ci.doFinal(bytes, offLen, 128);
//            } else {
//                cache = ci.doFinal(bytes, offLen, inputLen - offLen);
//            }
//            byteArrayOutputStream.write(cache);
//            i++;
//            offLen = 128 * i;
//
//        }
//        byteArrayOutputStream.close();
//        byte[] byteArray = byteArrayOutputStream.toByteArray();
//        return new String(byteArray);
//    }
//}
