package com.industry.platform.service.impl;

import com.industry.platform.dao.generator.IndbPropertyMapper;
import com.industry.platform.dto.generator.IndbProperty;
import com.industry.platform.dto.generator.IndbPropertyExample;
import com.industry.platform.service.PropertyService;
import com.industry.platform.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private IndbPropertyMapper indbPropertyMapper;

    @Override
    public Map<String,String> getPropertyList() {
        IndbPropertyExample example = new IndbPropertyExample();
        IndbPropertyExample.Criteria criteria = example.createCriteria();
        criteria.andIsUsedEqualTo(1);
        List<IndbProperty> indbProperties = indbPropertyMapper.selectByExample(example);
        Map<String,String> map = convert2Map(indbProperties);
        return map;
    }

    private Map<String,String> convert2Map(List<IndbProperty> indbProperties){
        Map<String,String> map = new HashMap<>();
        if(CollectionUtils.isNotEmpty(indbProperties)){
            for(IndbProperty indbProperty:indbProperties){
                map.put(indbProperty.getName(),indbProperty.getContent());
            }
        }
        return map;
    }
}
