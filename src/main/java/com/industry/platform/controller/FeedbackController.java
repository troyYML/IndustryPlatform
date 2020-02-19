package com.industry.platform.controller;

import com.industry.platform.dto.generator.IndbContract;
import com.industry.platform.service.FeedbackService;
import com.industry.platform.service.impl.FeedbackServiceImpl;
import com.industry.platform.utils.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class FeedbackController {
    private final Logger logger = LoggerFactory.getLogger(FeedbackController.class);
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/feedback",method = RequestMethod.GET)
    public ModelAndView feedback(ModelAndView mv){
        mv.addObject("title","联络我们 - ");
        mv.setViewName("freemarker/feedback");
        return mv;
    }

    @RequestMapping(value = "/onlineContract",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult onlineContract(@RequestBody IndbContract indbContract){
        AjaxResult ajaxResult = new AjaxResult();
        indbContract.setCreateTime(new Date());
        indbContract.setUpdateTime(new Date());
        indbContract.setIsReply(0);
        int res = 0;
        try{
            res = feedbackService.addIndbContract(indbContract);
            if(res>0){
                ajaxResult = AjaxResult.success("提交成功！");
            }else{
                ajaxResult = AjaxResult.error("提交失败，请稍后重试！");
            }
        }catch(Exception e){
            logger.error("插入数据失败");
            ajaxResult = AjaxResult.error("提交失败，请稍后重试！");
        }
        return ajaxResult;
    }
}
