package com.industry.platform.controller;

import com.github.pagehelper.Constant;
import com.github.pagehelper.PageInfo;
import com.industry.platform.dto.generator.IndbProductDetail;
import com.industry.platform.dto.generator.SysMenu;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/products"},method = RequestMethod.GET)
    public ModelAndView products( @RequestParam(required = false)Integer menuId, @RequestParam(required = false)Integer page, ModelAndView mv){
        if(page==null || page == 0){
            page = 1;
        }
        PageInfo<IndbProductDetail> pageInfo = new PageInfo<IndbProductDetail>();
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(Constants.PAGE_SIZE);
        pageInfo = productService.getProductList(menuId,pageInfo);
        List<SysMenu> sysMenuList = productService.getMenuList();
        SysMenu nowMenu = productService.getMenuById(menuId);
        String nav = getNav(nowMenu,null);
        mv.addObject("menuList",sysMenuList);
        mv.addObject("menuId",menuId);
        mv.addObject("productList",pageInfo);
        mv.addObject("title",nowMenu.getMenuName()+" - ");
        mv.addObject("nav",nav);
        mv.setViewName("freemarker/products");
        return mv;
    }

    @RequestMapping(value = "/productDetail",method = RequestMethod.GET)
    public ModelAndView productDetail(@RequestParam Integer id, ModelAndView mv){
        List<SysMenu> sysMenuList = productService.getMenuList();
        mv.addObject("menuList",sysMenuList);
        IndbProductDetail productDetail = productService.getProductDetail(id);
        SysMenu nowMenu = productService.getMenuById(productDetail.getTagId());
        String nav = getNav(nowMenu,productDetail);
        mv.addObject("product",productDetail);
        mv.addObject("title","产品详情 - ");
        mv.addObject("nav",nav);
        mv.setViewName("freemarker/productDetail");
        return mv;
    }

    private String getNav(SysMenu menu,IndbProductDetail productDetail){
        String nav = "产品中心";
        if(menu != null){
            nav += "  &gt; "+menu.getMenuName();
            if(productDetail!=null){
                nav += "  &gt; "+productDetail.getName();
            }
        }
        return "";
    }
}
