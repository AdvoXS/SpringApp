package com.gyper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebMvcConfiguration {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/student").setViewName("student");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/update").setViewName("update");
    }
}
