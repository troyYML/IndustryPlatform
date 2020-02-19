package com.industry.platform.controller;

import com.github.pagehelper.PageInfo;
import com.industry.platform.dto.generator.IndbAttachment;
import com.industry.platform.dto.generator.IndbProductDetail;
import com.industry.platform.dto.generator.SysMenu;
import com.industry.platform.service.NewsService;
import com.industry.platform.service.ProductService;
import com.industry.platform.utils.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public ModelAndView news(ModelAndView mv , @RequestParam(required = false)Integer page){
        mv.addObject("title","关于英唐 - ");
        if(page==null || page == 0){
            page = 1;
        }
        PageInfo<IndbAttachment> pageInfo = new PageInfo<IndbAttachment>();
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(Constants.PAGE_SIZE);
        PageInfo<IndbAttachment> indbAttachmentList = newsService.getAttachmentList(pageInfo);
        List<SysMenu> sysMenuList = productService.getMenuList();
        String nav = getNav();
        mv.addObject("menuList",sysMenuList);
        mv.addObject("newsList",indbAttachmentList);
        mv.addObject("nav",nav);
        mv.setViewName("freemarker/news");
        return mv;
    }

    @RequestMapping(value = "/newDetail",method = RequestMethod.GET)
    public ModelAndView newDetail(@RequestParam Integer id,ModelAndView mv){
        IndbAttachment attahment = newsService.getAttahment(id);
        mv.addObject("attachment",attahment);
        mv.setViewName("freemarker/newDetail");
        return mv;
    }

    private String getNav(){
        String nav = "关于英唐";
        nav += "  &gt; 新闻公告";
        return nav;
    }
}
