package com.industry.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.industry.platform.dao.generator.IndbArticleMapper;
import com.industry.platform.dao.generator.IndbAttachmentMapper;
import com.industry.platform.dto.generator.*;
import com.industry.platform.service.NewsService;
import com.industry.platform.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NewsServiceImpl implements NewsService {

    @Autowired
    private IndbArticleMapper indbArticleMapper;

    @Autowired
    private IndbAttachmentMapper indbAttachmentMapper;

    @Override
    public PageInfo<IndbAttachment> getAttachmentList(PageInfo<IndbAttachment> pageResult) {
        PageHelper.startPage(pageResult.getPageNum(),pageResult.getPageSize(),true);
        IndbAttachmentExample example = new IndbAttachmentExample();
        List<IndbAttachment> indbAttachmentList = indbAttachmentMapper.selectByExample(example);
        pageResult = new PageInfo<>(indbAttachmentList);
        return pageResult;
    }

    @Override
    public IndbAttachment getAttahment(Integer id) {
        IndbAttachment indbAttachment = indbAttachmentMapper.selectByPrimaryKey(id);
        return indbAttachment;
    }

    @Override
    public IndbArticle getIntroduceByType(Integer type) {
        IndbArticleExample example = new IndbArticleExample();
        IndbArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        criteria.andIsUsedEqualTo(1);
        List<IndbArticle> indbArticleList = indbArticleMapper.selectByExample(example);
        IndbArticle indbArticle = null;
        if(CollectionUtils.isNotEmpty(indbArticleList)){
            indbArticle = indbArticleList.get(0);
        }
        return indbArticle;
    }

    @Override
    public IndbArticle excludeImg(IndbArticle article){
        String content = article.getContent();
        String pattern = "<img\\b[^>]*>";
        String newContent = content.replaceAll(pattern,"");
        article.setContent(newContent);
        return article;
    }

}
