package com.industry.platform.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewsController {

    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public String news(ModelMap map){
        return "freemarker/news";
    }
}
