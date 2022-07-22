package com.example.learningspringboot.heroes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hero {

    private Long id;
    private String name;
    private int age;
}
