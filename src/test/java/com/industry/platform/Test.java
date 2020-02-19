package com.industry.platform;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.boot.SpringApplication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        String pattern = "<img>.*</img>";
        String s = "aaaaaaaa<img>asdasdasads</img>ccccccc".replaceAll(pattern,"");
        System.out.println(s);
    }
}
