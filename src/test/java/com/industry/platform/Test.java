package com.industry.platform;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.boot.SpringApplication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Test {

    public static void main(String[] args) {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Base64.Encoder base64Encoder = Base64.getEncoder();
        // 加密字符串
        String encodePassword = "";
        try {
            encodePassword = base64Encoder.encodeToString(md5.digest("123456".getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encodePassword);
    }

}
