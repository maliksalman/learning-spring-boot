package com.example.learningspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/greeting/{count}")
    public String greeting(
            @RequestParam(name="m", defaultValue="hello world!") String message,
            @PathVariable("count") int count) {
        return "message: " + message + ", count: " + count;
    }

}
