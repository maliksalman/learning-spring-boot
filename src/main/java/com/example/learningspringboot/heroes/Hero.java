package com.example.learningspringboot.heroes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hero {

    private Long id;
    private String name;
    private int age;
}
