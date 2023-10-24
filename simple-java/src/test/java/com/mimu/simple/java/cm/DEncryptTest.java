package com.mimu.simple.java.cm;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * author: mimu
 * date: 2019/9/10
 */
public class DEncryptTest {
    private String aesKey = "a96223f2526f416f";
    /**
     * 这里是所有的参数
     * @param productKey
     * @param deviceId
     * @param bleLockVersion
     * @param time
     * @return
     */
    public String sign(String productKey, String deviceId, Integer bleLockVersion, Long time) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("productKey", productKey);
        paramMap.put("deviceId", deviceId);
        // 把必填的参数(非空的)都 放进去
        paramMap.put("bleLockVersion", bleLockVersion);
        // 把请求的时间戳 也放进去
        paramMap.put("time", time);

        List<String> paramKey = paramMap.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder paramBuilder = new StringBuilder();
        for (String param : paramKey) {
            Object obj = paramMap.get(param);
            if (Objects.nonNull(obj)) {
                paramBuilder.append(param).append(obj);
            }
        }
        // 使用 aesKey 进行签名
        return encryptByAES(aesKey, paramBuilder.toString());
    }

    /**
     * 对称加密 生产签名
     * @param key
     * @param plainText
     * @return
     */
    private String encryptByAES(String key, String plainText) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
