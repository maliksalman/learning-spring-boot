package com.example.learningspringboot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final PersonRepository personRepository;

    @GetMapping("/greeting/{count}")
    public String greeting(
            @RequestParam(name="m", defaultValue="hello world!") String message,
            @PathVariable("count") int count) {
        return "message: " + message + ", count: " + count;
    }

    @GetMapping("/people/{name}")
    public Person findPerson(@PathVariable("name") String name) {
        return personRepository.findPerson(name);
    }
}
