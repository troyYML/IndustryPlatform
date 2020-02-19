package com.industry.platform.service;

import com.github.pagehelper.PageInfo;
import com.industry.platform.dto.generator.IndbArticle;
import com.industry.platform.dto.generator.IndbAttachment;

import java.util.List;

public interface NewsService {

    public PageInfo<IndbAttachment> getAttachmentList(PageInfo<IndbAttachment> pageResult);

    public IndbAttachment getAttahment(Integer id);

    public IndbArticle getIntroduceByType(Integer type);

    public IndbArticle excludeImg(IndbArticle article);
}
