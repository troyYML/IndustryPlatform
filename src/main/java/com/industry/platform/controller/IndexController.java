package com.industry.platform.controller;

import com.industry.platform.dto.generator.IndbArticle;
import com.industry.platform.dto.generator.IndbProductDetail;
import com.industry.platform.dto.generator.SysMenu;
import com.industry.platform.service.NewsService;
import com.industry.platform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){

        List<IndbProductDetail> productDetailList = productService.getIndexProduct();
        IndbArticle article = newsService.getIntroduceByType(1);
        IndbArticle articleIntroduce = newsService.getIntroduceByType(0);
        articleIntroduce = newsService.excludeImg(articleIntroduce);
        mv.addObject("productList",productDetailList);
        mv.addObject("articleIntroduce",articleIntroduce);
        mv.addObject("title","官方网站 - ");
        mv.addObject("introduce",article);
        mv.setViewName("freemarker/index");
        return mv;
    }

}
