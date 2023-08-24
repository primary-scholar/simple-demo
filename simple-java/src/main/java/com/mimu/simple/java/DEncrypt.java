package com.mimu.simple.java;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author luyahui
 * @date 2023/8/24
 * @description jdk 加解密
 */
public class DEncrypt {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static final String AES_ALGORITHM = "AES";
    public static final String AES_KEY = "a96223f2526f416f";

    public String encryptByAES(String aesKey, String plainText) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(aesKey.getBytes(DEFAULT_CHARSET), AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes(DEFAULT_CHARSET));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decryptByAES(String aesKey, String cipherText) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(aesKey.getBytes(DEFAULT_CHARSET), AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
            return new String(plainText, DEFAULT_CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
