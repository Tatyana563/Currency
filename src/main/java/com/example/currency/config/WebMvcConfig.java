package com.example.currency.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*registry.addViewController("/currency/login").setViewName("login");
        registry.addViewController("/currency/registration").setViewName("registration");*/
        registry.addViewController("/login").setViewName("login");
        //registry.addViewController("/").setViewName("currency rates");
        registry.addViewController("/registration").setViewName("registration");
    }
}
