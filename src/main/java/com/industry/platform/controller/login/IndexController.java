package com.industry.platform.controller.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String index(ModelMap map){
        return "freemarker/index";
    }

}
