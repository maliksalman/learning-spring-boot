package com.example.learningspringboot;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class ErrorGenerator {

    public String generateErrorIfAny(int code) {
        if (code == 256) {
            throw new MyFavException("something went wrong", code);
        }
        return "no-error";
    }
}
