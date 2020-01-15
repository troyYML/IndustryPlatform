package com.industry.platform.controller.login;

import com.industry.platform.service.login.LoginService;
import com.industry.platform.utils.PasswordEncrypt;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        //String encodePassword = PasswordEncrypt.encodeByMd5(password);
        if (loginService.checkLogin("1", "encodePassword")) {
            return "Welcome back!";
        }
        return "You are not allowed!";
    }
}
