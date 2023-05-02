package com.ssafy.tripApp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan(basePackages = {"com.ssafy.tripApp.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer {

}
