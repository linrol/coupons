package com.huaan9527.mall.webapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @ClassName CrossConfig
 * @Author linrol
 * @date 2021年01月21日 19:10 Copyright (c) 2020, linrol@77hub.com All Rights Reserved.
 */
@Configuration
public class CrossConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
        .allowCredentials(true)
        .maxAge(3600)
        .allowedHeaders("*");
  }
}
