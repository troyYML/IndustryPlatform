package com.industry.platform.controller;

import com.industry.platform.dto.generator.IndbArticle;
import com.industry.platform.dto.generator.IndbProductDetail;
import com.industry.platform.dto.generator.SysMenu;
import com.industry.platform.service.NewsService;
import com.industry.platform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public ModelAndView about(ModelAndView mv){
        IndbArticle article = newsService.getIntroduceByType(0);
        List<SysMenu> sysMenuList = productService.getMenuList();
        mv.addObject("menuList",sysMenuList);
        mv.addObject("article",article);
        mv.addObject("title","关于英唐 - ");
        mv.setViewName("freemarker/about");
        return mv;
    }

    private String getNav(){
        String nav = "关于英唐";
        nav += "  &gt; 公司简介";
        return nav;
    }
}
