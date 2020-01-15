package com.industry.platform.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public String products(ModelMap map){
        return "freemarker/products";
    }

    @RequestMapping(value = "/productDetail",method = RequestMethod.GET)
    public String productDetail(ModelMap map){
        return "freemarker/productDetail";
    }

}
