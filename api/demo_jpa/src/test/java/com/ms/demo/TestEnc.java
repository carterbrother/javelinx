package com.ms.demo;

import org.jasypt.util.text.AES256TextEncryptor;
import org.junit.jupiter.api.Test;

public class TestEnc {

    @Test
    public void enc(){
        // 创建一个加密器
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();

        // 设置加密密码
        String encryptionPassword = "3435454Love#4"; // 请替换为你的密码
        textEncryptor.setPassword(encryptionPassword);

        // 要加密的敏感信息
//        String sensitiveData = "jdbc:mysql://47.119.173.229:43306/db_user?allowPublicKeyRetrieval=true&useSSL=false"; // 需要加密的值
//        String sensitiveData = "Carter123!Abc2024"; // 需要加密的值
        String sensitiveData = "redis_kfdmSPCarter"; // 需要加密的值

        // 加密
        String encryptedData = textEncryptor.encrypt(sensitiveData);
        System.out.println("Encrypted Data: " + encryptedData);

        // 解密
        String decryptedData = textEncryptor.decrypt(encryptedData);
        System.out.println("Decrypted Data: " + decryptedData);


    }

}
