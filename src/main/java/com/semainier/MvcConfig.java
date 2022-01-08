package com.semainier;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/eleves/**").setViewName("eleves");
        registry.addViewController("/taches/**").setViewName("taches");
        registry.addViewController("/rapport/**").setViewName("rapport");
        registry.addViewController("/login").setViewName("login");
    }
}
