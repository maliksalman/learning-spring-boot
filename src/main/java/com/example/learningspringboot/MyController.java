package com.example.learningspringboot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final PersonRepository personRepository;
    private final ErrorGenerator generator;

    @GetMapping("/greeting/{count}")
    public String greeting(
            @RequestParam(name="m", defaultValue="hello world!") String message,
            @PathVariable("count") int count) {
        return "message: " + message + ", count: " + count;
    }

    @GetMapping("/people/{name}")
    public PersonEntity findPerson(@PathVariable("name") String name) {
        return personRepository.findByName(name).get(0);
    }

    @GetMapping("/error/{code}")
    public String generateError(@PathVariable("code") int code) {
        return generator.generateErrorIfAny(code);
    }
}
