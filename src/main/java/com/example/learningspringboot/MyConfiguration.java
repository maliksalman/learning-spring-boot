package com.example.learningspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public MyDefaults myDefault() {
        return new MyDefaults(35, "chicago");
    }
}
