package com.industry.platform.service.login;


import com.industry.platform.dto.generator.IndbUserInfo;

public interface LoginService {

    public IndbUserInfo getUserInfo(Integer userId);

    public Boolean checkLogin(String userName,String password);
}
