package com.industry.platform.aop;

import com.industry.platform.dto.generator.IndbProperty;
import com.industry.platform.service.PropertyService;
import com.sun.xml.internal.ws.client.ResponseContext;
import com.sun.xml.internal.ws.client.ResponseContextReceiver;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class ControllerAspect {

    @Autowired
    private PropertyService propertyService;

    @Pointcut("execution(public * com.industry.platform.controller..*.*(..))")
    public void ControllerAspect(){

    }

    @Around("ControllerAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        Map<String, String[]> parameterMap = request.getParameterMap();
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        if(StringUtils.isEmpty(request.getHeader("x-requested-with")) || !request.getHeader("x-requested-with").equals("XMLHttpRequest")){
            ModelAndView mv = (ModelAndView)result;
            Map<String,String> properties = propertyService.getPropertyList();
            mv.addAllObjects(properties);
            result = mv;

        }
        return result;
    }


    @After("ControllerAspect()")
    public void doAfter(){

    }
}
