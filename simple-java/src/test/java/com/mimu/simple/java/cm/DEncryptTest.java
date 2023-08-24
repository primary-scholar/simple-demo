package com.mimu.simple.java.cm;

import com.mimu.simple.java.DEncrypt;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * author: mimu
 * date: 2019/9/10
 */
public class DEncryptTest {
    public static final String AES_ALGORITHM = "AES";
    private static String encryptKey = "a";
    private Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    @Test
    public void deCode() {

        DEncrypt dEncrypt = new DEncrypt();
        String encrypt = dEncrypt.encryptByAES(DEncrypt.AES_KEY, "abc");
        String decrypt = dEncrypt.decryptByAES(DEncrypt.AES_KEY, encrypt);
        System.out.println(encrypt);
        System.out.println(decrypt);
    }


}
