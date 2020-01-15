package com.industry.platform.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DesignController {

    @RequestMapping(value = "/design",method = RequestMethod.GET)
    public String design(ModelMap map){
        return "freemarker/design";
    }
}
