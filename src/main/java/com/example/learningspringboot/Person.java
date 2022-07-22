package com.example.learningspringboot;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String name;
    private int age;
    private String city;

}
