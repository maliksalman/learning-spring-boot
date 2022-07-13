package com.example.learningspringboot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MyDefaults {

    private int age;
    private String city;

    public MyDefaults(
            @Value("${defaults.age}") int age,
            @Value("${defaults.city}") String city) {
        this.age = age;
        this.city = city;
    }
}
