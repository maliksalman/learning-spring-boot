package com.example.learningspringboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonRepository {

    private final MyDefaults defaults;

    public Person findPerson(String name) {
        return new Person(name, defaults.getAge(), defaults.getCity());
    }
}
