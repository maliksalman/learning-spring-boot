package com.example.learningspringboot;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    public Person findPerson(String name) {
        Person p = new Person();
        p.setAge(30);
        p.setCity("new-york");
        p.setName(name);
        return p;
    }
}
