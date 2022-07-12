package com.example.learningspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="m", defaultValue="hello world!") String message) {
        return "message: " + message;
    }


}
