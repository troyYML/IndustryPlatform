package com.industry.platform.controller;

import com.industry.platform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
