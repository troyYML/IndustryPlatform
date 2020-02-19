package com.industry.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DesignController {

    @RequestMapping(value = "/design",method = RequestMethod.GET)
    public ModelAndView design(ModelAndView mv){
        mv.setViewName("redirect:/products");
        return mv;
    }
}
