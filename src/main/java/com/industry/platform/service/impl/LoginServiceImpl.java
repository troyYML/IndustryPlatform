package com.industry.platform.service.impl;

import com.industry.platform.dao.generator.IndbUserInfoMapper;
import com.industry.platform.dto.generator.IndbUserInfo;
import com.industry.platform.dto.generator.IndbUserInfoExample;
import com.industry.platform.service.LoginService;
import com.industry.platform.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private IndbUserInfoMapper indbUserInfoMapper;

    @Override
    public IndbUserInfo getUserInfo(Integer userId) {
        return indbUserInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Boolean checkLogin(String userName, String password) {
        IndbUserInfoExample example = new IndbUserInfoExample();
        IndbUserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        List<IndbUserInfo> indbUserInfo = indbUserInfoMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(indbUserInfo);
    }
}
