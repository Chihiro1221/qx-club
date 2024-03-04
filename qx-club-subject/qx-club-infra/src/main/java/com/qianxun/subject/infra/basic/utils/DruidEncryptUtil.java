package com.qianxun.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;

/**
 * druid加密类
 *
 * @author haonan
 */
public class DruidEncryptUtil {
    private static String publicKey;
    private static String privateKey;

    static{
        try {
            // 生成公钥和私钥
            String[] keys = ConfigTools.genKeyPair(512);
            privateKey = keys[0];
            System.out.println("privateKey: " + privateKey);
            publicKey = keys[1];
            System.out.println("publicKey: " + publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText){
        try {
            return ConfigTools.encrypt(privateKey, plainText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     * @param encryptText
     * @return
     */
    public static String decrypt(String encryptText){
        try {
            return ConfigTools.encrypt(privateKey, encryptText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //String key = encrypt();
        //System.out.println("key = " + key);
    }
}
