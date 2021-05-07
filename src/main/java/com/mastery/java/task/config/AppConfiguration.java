package com.mastery.java.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppConfiguration implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public AppConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
