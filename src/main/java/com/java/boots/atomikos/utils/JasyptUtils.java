package com.java.boots.atomikos.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.stereotype.Component;

@Component
public class JasyptUtils {

    /**
     *
     * @param jasyptPassword  密钥。加/解密必须使用同一个密钥
     * @param passWorld  加/解密的内容
     * @param isEncrypt  true 表示加密、false 表示解密
     * @return
     */
    public String decryptMsg(String jasyptPassword, String passWorld, boolean isEncrypt){
        PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
        pooledPBEStringEncryptor.setConfig(getSimpleStringPBEConfig(jasyptPassword));
        return isEncrypt ? pooledPBEStringEncryptor.encrypt(passWorld) : pooledPBEStringEncryptor.decrypt(passWorld);
    }


    /**
     *
     * @param secretKey
     * @return
     */
    private SimpleStringPBEConfig getSimpleStringPBEConfig(String secretKey) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(secretKey);
        config.setPoolSize("1");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        return config;
    }

}
