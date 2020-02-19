package com.industry.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通用配置
 * 
 * @author ruoyi
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer
{
    @Autowired
    private IndustryConfig industryConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        /** 文件上传路径 */
        registry.addResourceHandler("/profile/**").addResourceLocations("file:" + industryConfig.getProfile());
    }
}