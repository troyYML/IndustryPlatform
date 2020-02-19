package com.industry.platform.service.impl;

import com.industry.platform.dao.generator.IndbContractMapper;
import com.industry.platform.dto.generator.IndbContract;
import com.industry.platform.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private IndbContractMapper indbContractMapper;

    @Override
    public int addIndbContract(IndbContract indbContract) {
        return indbContractMapper.insert(indbContract);
    }
}
