package com.industry.platform.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FeedbackController {

    @RequestMapping(value = "/feedback",method = RequestMethod.GET)
    public String feedback(ModelMap map){
        return "freemarker/feedback";
    }

    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contact(ModelMap map){
        return "freemarker/feedback";
    }
}
