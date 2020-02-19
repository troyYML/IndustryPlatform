package com.industry.platform.controller;

import com.github.pagehelper.PageInfo;
import com.industry.platform.dto.generator.IndbProductDetail;
import com.industry.platform.dto.generator.SysMenu;
import com.industry.platform.service.ProductService;
import com.industry.platform.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/searchSelect",method = RequestMethod.GET)
    public ModelAndView searchSelect(@RequestParam String param,@RequestParam(required = false) Integer page,ModelAndView mv){
        if(page==null || page == 0){
            page = 1;
        }
        PageInfo<IndbProductDetail> pageInfo = new PageInfo<IndbProductDetail>();
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(Constants.PAGE_SIZE);
        pageInfo = productService.getProductByName(pageInfo,param);
        mv.addObject("productList",pageInfo);
        List<SysMenu> sysMenuList = productService.getMenuList();
        mv.addObject("menuList",sysMenuList);
        mv.addObject("title","查询结果 - ");
        mv.setViewName("freemarker/searchResult");
        return mv;
    }
}
