package com.lycoo.tweetengine.restdemo.auth.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("/index.html");
        registry.addViewController("/").setViewName("/index.html");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("/login.html");
        registry.addViewController("/registration").setViewName("/registration.html");
        registry.addViewController("/forgot").setViewName("/forgot.html");
        registry.addViewController("/reset").setViewName("/reset.html");
    }

}