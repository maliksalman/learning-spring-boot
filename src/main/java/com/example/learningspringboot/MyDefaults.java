package com.example.learningspringboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix="defaults")
public class MyDefaults {

    private int age;
    private String city;

}
